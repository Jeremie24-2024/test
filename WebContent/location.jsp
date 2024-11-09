<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Create Location</h2>

<% String successMessage = (String) request.getAttribute("successMessage"); %>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>

<% if (successMessage != null) { %>
    <div style="color: green;"><%= successMessage %></div>
<% } %>

<% if (errorMessage != null) { %>
    <div style="color: red;"><%= errorMessage %></div>
<% } %>

<form action="createLocation" method="post">
    <label for="locationCode">Location Code:</label><br>
    <input type="text" id="locationCode" name="locationCode"><br>

    <label for="locationName">Location Name:</label><br>
    <input type="text" id="locationName" name="locationName"><br>

    <label for="locationType">Location Type:</label><br>
    <select id="locationType" name="locationType" >
        <option value="PROVINCE">Province</option>
        <option value="DISTRICT">District</option>
        <option value="SECTOR">Sector</option>
        <option value="CELL">Cell</option>
        <option value="VILLAGE">Village</option>
    </select><br>

    <label for="parentId">Parent Location (optional):</label><br>
    <input type="text" id="parentId" name="parentId"><br>

    <input type="submit" value="Create Location">
</form>
 

</body>
</html>