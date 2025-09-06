<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Telecom Equipment Catalog</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    <style>
        body { background: #f9f9f9; }
        .equipment-card {
            transition: transform 0.2s ease-in-out;
            border-radius: 10px;
        }
        .equipment-card:hover { transform: scale(1.03); }
        .equipment-img {
            height: 200px;
            object-fit: contain;
            padding: 15px;
            background: #fff;
            border-bottom: 1px solid #eee;
        }
    </style>
</head>
<body>
<div class="container py-5">
    <h2 class="mb-4 text-center">📡 Telecom Equipment Catalog</h2>

    <div class="row">
        <c:forEach var="item" items="${equipmentList}">
            <div class="col-md-4 mb-4">
                <div class="card equipment-card shadow-sm">
                    <img src="${pageContext.request.contextPath}/uploads/${item.imageUrl}" 
                         alt="${item.name}" class="equipment-img card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text text-muted">Type: ${item.type}</p>
                        <p class="fw-bold">Quantity: ${item.quantity}</p>
                        <p><span class="badge bg-secondary">Location: ${item.location}</span></p>
                        <a href="addToCart?id=${item.equipmentId}" class="btn btn-primary btn-sm">Add to Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <c:if test="${empty equipmentList}">
        <div class="alert alert-warning text-center">
            No equipment available. Please add some items.
        </div>
    </c:if>
</div>
</body>
</html>
