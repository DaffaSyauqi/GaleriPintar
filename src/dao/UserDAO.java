/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DatabaseConnection;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class UserDAO {

    public boolean insert(User user) throws SQLException {
        String sql = "INSERT INTO users (name, division, phone, email) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getDivision());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());

            return ps.executeUpdate() > 0;
        }
    }

    public List<User> findAll() throws SQLException {

        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM users ORDER BY name ASC";

        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("division"),
                        rs.getString("phone"),
                        rs.getString("email")
                ));

            }

        }

        return list;
    }

    public User findById(int id) throws SQLException {

        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("division"),
                            rs.getString("phone"),
                            rs.getString("email")
                    );

                }

            }

        }

        return null;
    }

    public boolean update(User user) throws SQLException {

        String sql = "UPDATE users SET name = ?, division = ?, phone = ?, email = ? WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getDivision());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {

        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean nameExists(String name, int excludeId) throws SQLException {

        String sql = "SELECT id FROM users WHERE name = ? AND id != ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, excludeId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        }
    }

}
