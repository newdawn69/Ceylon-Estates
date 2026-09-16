<!DOCTYPE html>
<html>
<head>
    <title>Add Property</title>
</head>
<body>

<h2>Add New Property</h2>

<form action="properties" method="post">

    <input type="hidden" name="action" value="add">

    <label>Property ID:</label><br>
    <input type="number" name="propertyId" required><br><br>

    <label>Property Name:</label><br>
    <input type="text" name="propertyName" required><br><br>

    <label>Location:</label><br>
    <input type="text" name="location" required><br><br>

    <label>Property Type:</label><br>
    <select name="propertyType" required>
        <option value="House">House</option>
        <option value="Apartment">Apartment</option>
        <option value="Land">Land</option>
        <option value="Commercial">Commercial</option>
    </select><br><br>

    <label>Price:</label><br>
    <input type="number" step="0.01" name="price" required><br><br>

    <label>Status:</label><br>
    <select name="status" required>
        <option value="Available">Available</option>
        <option value="Sold">Sold</option>
        <option value="Reserved">Reserved</option>
    </select><br><br>

    <button type="submit">Add Property</button>

</form>

</body>
</html>