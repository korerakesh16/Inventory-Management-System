package com.telecominv.controller;

import com.telecominv.dao.EquipmentDAO;
import com.telecominv.model.Equipment;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/addEquipment")
@MultipartConfig
public class AddEquipmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String location = request.getParameter("location");

        // Handle image upload
        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Save relative path for DB
        String imageUrl = "uploads/" + fileName;

        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setType(type);
        equipment.setQuantity(quantity);
        equipment.setLocation(location);
        equipment.setImageUrl(imageUrl);

        EquipmentDAO dao = new EquipmentDAO();
        boolean isAdded = dao.addEquipment(equipment);

        if (isAdded) {
            response.sendRedirect("views/equipment-list.jsp");
        } else {
            response.sendRedirect("views/add-equipment.jsp?error=1");
        }
    }
}
