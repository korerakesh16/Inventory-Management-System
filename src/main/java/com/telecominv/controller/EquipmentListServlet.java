package com.telecominv.controller;

import com.telecominv.dao.EquipmentDAO;
import com.telecominv.model.Equipment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listEquipment")
public class EquipmentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EquipmentDAO dao = new EquipmentDAO();
        List<Equipment> equipmentList = dao.getAllEquipment();

        request.setAttribute("equipmentList", equipmentList);
        request.getRequestDispatcher("views/equipment-list.jsp").forward(request, response);
    }
}
