<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Equipment</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { width: 400px; margin: auto; border: 1px solid #ccc; padding: 20px; }
        input, select { width: 100%; margin: 10px 0; padding: 8px; }
        button { width: 100%; padding: 10px; background: #4CAF50; color: white; border: none; }
    </style>
</head>
<body>
    <h2 align="center">Add New Telecom Equipment</h2>

    <form action="../addEquipment" method="post" enctype="multipart/form-data">
        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Type:</label>
        <select name="type" required>
            <option value="Router">Router</option>
            <option value="Switch">Switch</option>
            <option value="SIM Card">SIM Card</option>
            <option value="Tower">Tower</option>
        </select>

        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" required>

        <label>Location:</label>
        <input type="text" name="location">

        <label>Upload Image:</label>
        <input type="file" name="image" accept="image/*" required>

        <button type="submit">Add Equipment</button>
    </form>
</body>
</html>
