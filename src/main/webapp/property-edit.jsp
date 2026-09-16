<%@ page import="com.example.ceylonestate.model.Property" %>

<%
    Property property = (Property) request.getAttribute("property");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Property</title>
</head>
<body>

<h2>Edit Property</h2>

<form action="properties" method="post">

    <input type="hidden" name="action" value="update">

    <label>Property ID:</label><br>
    <input type="number"
           name="propertyId"
           value="<%= property.getPropertyId() %>"
           readonly>
    <br><br>

    <label>Property Name:</label><br>
    <input type="text"
           name="propertyName"
           value="<%= property.getPropertyName() %>"
           required>
    <br><br>

    <label>Location:</label><br>
    <input type="text"
           name="location"
           value="<%= property.getLocation() %>"
           required>
    <br><br>

    <label>Property Type:</label><br>
    <select name="propertyType" required>
        <option value="House"
                <%= "House".equals(property.getPropertyType()) ? "selected" : "" %>>
            House
        </option>

        <option value="Apartment"
                <%= "Apartment".equals(property.getPropertyType()) ? "selected" : "" %>>
            Apartment
        </option>

        <option value="Land"
                <%= "Land".equals(property.getPropertyType()) ? "selected" : "" %>>
            Land
        </option>

        <option value="Commercial"
                <%= "Commercial".equals(property.getPropertyType()) ? "selected" : "" %>>
            Commercial
        </option>
    </select>
    <br><br>

    <label>Price:</label><br>
    <input type="number"
           step="0.01"
           name="price"
           value="<%= property.getPrice() %>"
           required>
    <br><br>

    <label>Status:</label><br>
    <select name="status" required>
        <option value="Available"
                <%= "Available".equals(property.getStatus()) ? "selected" : "" %>>
            Available
        </option>

        <option value="Sold"
                <%= "Sold".equals(property.getStatus()) ? "selected" : "" %>>
            Sold
        </option>

        <option value="Reserved"
                <%= "Reserved".equals(property.getStatus()) ? "selected" : "" %>>
            Reserved
        </option>
    </select>
    <br><br>

    <button type="submit">Update Property</button>

</form>

<br>

<a href="properties">Back to Property List</a>

</body>
</html>