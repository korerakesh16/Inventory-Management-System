package com.telecominv.dao;

import com.telecominv.model.User;
import com.telecominv.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Validate user login (only username + password)
    public User validateUser(String username, String password) {
        User user = null;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT user_id, username, password, full_name, email " +
                         "FROM users WHERE username = ? AND active = 1";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");

                // Plain text check (replace with BCrypt later)
                if (dbPassword.equals(password)) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(dbPassword);
                    user.setFullName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
