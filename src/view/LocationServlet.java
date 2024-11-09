package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LocationDAO;
import model.Location;
import model.LocationType;

@WebServlet(urlPatterns = "/createLocation")
public class LocationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createLocation(request, response);
    }

    private void createLocation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String locationCode = request.getParameter("locationCode");
        String locationName = request.getParameter("locationName");
        String locationType = request.getParameter("locationType");
        String parentCode = request.getParameter("parentId");

        // Validate mandatory fields
        if (locationCode == null || locationCode.isEmpty() || locationName == null || locationName.isEmpty() || locationType == null || locationType.isEmpty()) {
            request.setAttribute("errorMessage", "Location code, name, and type are required.");
            request.getRequestDispatcher("/location.jsp").forward(request, response);
            return;
        }

        Location location = new Location();
        location.setLocationCode(locationCode);
        location.setLocationName(locationName);

        try {
            // Convert location type to uppercase for case-insensitive comparison
            location.setLocationType(LocationType.valueOf(locationType.toUpperCase()));
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Invalid location type.");
            request.getRequestDispatcher("/location.jsp").forward(request, response);
            return;
        }

        // Check if the location type is PROVINCE
        if (location.getLocationType() == LocationType.PROVINCE) {
            // If it's a province, set parent to null
            location.setParent(null);
        } else {
            // If it's not a province, the parent code must be provided
            if (parentCode == null || parentCode.isEmpty()) {
                request.setAttribute("errorMessage", "Parent code must be provided for non-province locations.");
                request.getRequestDispatcher("/location.jsp").forward(request, response);
                return;
            }

            // Retrieve the parent location using the parent code
            Location parent = LocationDAO.getLocationByCode(parentCode);
            if (parent != null) {
                location.setParent(parent);
            } else {
                request.setAttribute("errorMessage", "Parent location not found.");
                request.getRequestDispatcher("/location.jsp").forward(request, response);
                return;
            }
        }

        // Save the location to the database
        LocationDAO.saveLocation(location);

        // Set the ID of the newly created location to be displayed
        request.setAttribute("locationId", location.getLocationId());
        request.setAttribute("successMessage", "Location created successfully! Use this UUID as parent code: " + location.getLocationId());

        // Forward to the location page to display the UUID
        request.getRequestDispatcher("/location.jsp").forward(request, response);
    }
}