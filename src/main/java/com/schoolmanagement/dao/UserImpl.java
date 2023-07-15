package com.schoolmanagement.dao;

import com.schoolmanagement.bean.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, email, mobile, profilePicture, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getMobile(), user.getProfilePicture(), encryptPassword(user.getPassword()));
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
    }

    @Override
    public User getByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, new UserMapper());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, mobile = ?, profilePicture = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getMobile(), user.getProfilePicture(), encryptPassword(user.getPassword()), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean validateUser(String email, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email, encryptPassword(password)}, Integer.class);
        return count != null && count > 0;
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert the hashed bytes to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception as desired
            return null; // or throw an exception
        }
    }
}

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setMobile(rs.getString("mobile"));
        user.setProfilePicture(rs.getString("profilePicture"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
