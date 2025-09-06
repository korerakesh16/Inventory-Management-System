package com.telecominv.dao;

import com.telecominv.model.Equipment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/telecomdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    public EquipmentDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Add Equipment
    public boolean addEquipment(Equipment equipment) {
        String sql = "INSERT INTO equipment (name, type, quantity, location, image_url) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, equipment.getName());
            ps.setString(2, equipment.getType());
            ps.setInt(3, equipment.getQuantity());
            ps.setString(4, equipment.getLocation());
            ps.setString(5, equipment.getImageUrl());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // List Equipment
    public List<Equipment> getAllEquipment() {
        List<Equipment> list = new ArrayList<>();
        String sql = "SELECT * FROM equipment";

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipment eq = new Equipment();
                eq.setEquipmentId(rs.getInt("equipment_id"));
                eq.setName(rs.getString("name"));
                eq.setType(rs.getString("type"));
                eq.setQuantity(rs.getInt("quantity"));
                eq.setLocation(rs.getString("location"));
                eq.setImageUrl(rs.getString("image_url"));
                list.add(eq);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
