<%@ page import="java.util.List" %>
<%@ page import="com.example.ceylonestate.model.Property" %>

<!DOCTYPE html>
<html>
<head>
    <title>Property List</title>
</head>
<body>

<h2>Property Management</h2>

<a href="property-add.jsp">Add New Property</a>

<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Location</th>
        <th>Type</th>
        <th>Price</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>

    <%
        List<Property> properties =
                (List<Property>) request.getAttribute("properties");

        if (properties != null) {
            for (Property property : properties) {
    %>

    <tr>
        <td><%= property.getPropertyId() %></td>
        <td><%= property.getPropertyName() %></td>
        <td><%= property.getLocation() %></td>
        <td><%= property.getPropertyType() %></td>
        <td><%= property.getPrice() %></td>
        <td><%= property.getStatus() %></td>

        <td>
            <a href="properties?action=edit&id=<%= property.getPropertyId() %>">
                Edit
            </a>

            |

            <a href="properties?action=delete&id=<%= property.getPropertyId() %>"
               onclick="return confirm('Are you sure you want to delete this property?');">
                Delete
            </a>
        </td>
    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>