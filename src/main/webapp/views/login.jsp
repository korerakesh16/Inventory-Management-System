<!DOCTYPE html>
<html>
<head>
    <title>Login - Telecom Inventory</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        form { width: 300px; margin: auto; padding: 20px; border: 1px solid #ccc; }
        input { width: 100%; padding: 8px; margin: 8px 0; }
        button { width: 100%; padding: 10px; background: #4CAF50; color: white; border: none; }
        p.error { color: red; }
    </style>
</head>
<body>
    <h2 align="center">Telecom Inventory - Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>
        
        <label>Password:</label>
        <input type="password" name="password" required>
        
        <button type="submit">Login</button>
        
        <p class="error">${errorMsg}</p>
    </form>
</body>
</html>
