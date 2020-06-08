package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.user;

public class userDAO {

    public userDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/phonemall?" +
                        "serverTimezone=GMT%2B8&" +
                        "useUnicode=true&" +
                        "characterEncoding=UTF-8&" +
                        "zeroDateTimeBehavior=convertToNull",
                "root",
                "root");
    }

    public void add(user user) {
        String sql = "insert into user values(?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, user.loginname);
            ps.setString(2, user.password);
            ps.setString(3, user.phone);
            ps.setString(4, user.address);
            ps.setString(5, user.nickname);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public user get(String loginname) {
        user user = null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from user where loginname = '" + loginname + "';";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                user = new user();
                String name = rs.getString(1);
                String password = rs.getString(2);
                String phone = rs.getString(3);
                String address = rs.getString(4);
                String nickname = rs.getString(5);
                user.loginname = name;
                user.password = password;
                user.phone = phone;
                user.address = address;
                user.nickname = nickname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}