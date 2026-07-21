/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DatabaseConnection;
import model.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class ImageDAO {
    public boolean insert(Image image) throws SQLException {
        String sql = "INSERT INTO images (category_id, title, description, image_path) "
                   + "VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, image.getCategoryId());
            ps.setString(2, image.getTitle());
            ps.setString(3, image.getDescription());
            ps.setString(4, image.getImagePath());
            return ps.executeUpdate() > 0;
        }
    }
    

    public List<Image> findAll() throws SQLException {
        return findByCategoryId(0);
    }
    
    public boolean update(Image image) throws SQLException {
        String sql = "UPDATE images SET category_id = ?, title = ?, description = ?, "
                   + "image_path = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, image.getCategoryId());
            ps.setString(2, image.getTitle());
            ps.setString(3, image.getDescription());
            ps.setString(4, image.getImagePath());
            ps.setInt(5, image.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Image> findByCategoryId(int categoryId) throws SQLException {
        List<Image> list = new ArrayList<>();

        String sql = "SELECT i.id, i.category_id, c.name AS category_name, "
                   + "       i.title, i.description, i.image_path, i.created_at "
                   + "FROM images i "
                   + "JOIN categories c ON i.category_id = c.id "
                   + (categoryId > 0 ? "WHERE i.category_id = ? " : "")
                   + "ORDER BY i.created_at DESC";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            if (categoryId > 0) ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Image img = new Image();
                    img.setId(rs.getInt("id"));
                    img.setCategoryId(rs.getInt("category_id"));
                    img.setCategoryName(rs.getString("category_name"));
                    img.setTitle(rs.getString("title"));
                    img.setDescription(rs.getString("description"));
                    img.setImagePath(rs.getString("image_path"));
                    img.setCreatedAt(rs.getTimestamp("created_at"));
                    list.add(img);
                }
            }
        }
        return list;
    }

    public Image findById(int id) throws SQLException {
        String sql = "SELECT i.id, i.category_id, c.name AS category_name, "
                   + "       i.title, i.description, i.image_path, i.created_at "
                   + "FROM images i "
                   + "JOIN categories c ON i.category_id = c.id "
                   + "WHERE i.id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Image img = new Image();
                    img.setId(rs.getInt("id"));
                    img.setCategoryId(rs.getInt("category_id"));
                    img.setCategoryName(rs.getString("category_name"));
                    img.setTitle(rs.getString("title"));
                    img.setDescription(rs.getString("description"));
                    img.setImagePath(rs.getString("image_path"));
                    img.setCreatedAt(rs.getTimestamp("created_at"));
                    return img;
                }
            }
        }
        return null;
    }
    
        public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM images WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
        
    public List<Image> search(String keyword, int categoryId) throws SQLException {
        List<Image> list = new ArrayList<>();

        String sql = "SELECT i.id, i.category_id, c.name AS category_name, "
                   + "i.title, i.description, i.image_path, i.created_at "
                   + "FROM images i "
                   + "JOIN categories c ON i.category_id = c.id "
                   + "WHERE i.title LIKE ? ";

        if (categoryId > 0) {
            sql += "AND i.category_id = ? ";
        }

        sql += "ORDER BY i.created_at DESC";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            if (categoryId > 0) {
                ps.setInt(2, categoryId);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Image img = new Image();
                    img.setId(rs.getInt("id"));
                    img.setCategoryId(rs.getInt("category_id"));
                    img.setCategoryName(rs.getString("category_name"));
                    img.setTitle(rs.getString("title"));
                    img.setDescription(rs.getString("description"));
                    img.setImagePath(rs.getString("image_path"));
                    img.setCreatedAt(rs.getTimestamp("created_at"));
                    list.add(img);
                }
            }
        }

        return list;
    }
}
