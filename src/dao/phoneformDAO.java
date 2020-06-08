package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.phoneform;

public class phoneformDAO {
    public phoneformDAO() {
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

    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from phoneform;";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public phoneform get(String key, String str) {
        phoneform phoneform = null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from phoneform where " +
                    key + " = '" + str + "';";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                phoneform = new phoneform();
                String phone_version = rs.getString(1);
                String phone_name = rs.getString(2);
                String phone_made = rs.getString(3);
                int phone_price = rs.getInt(4);
                String phone_feature = rs.getString(5);
                String phone_pic = rs.getString(6);
                int classify = rs.getInt(7);
                phoneform.phone_version = phone_version;
                phoneform.phone_name = phone_name;
                phoneform.phone_made = phone_made;
                phoneform.phone_price = phone_price;
                phoneform.phone_feature = phone_feature;
                phoneform.phone_pic = phone_pic;
                phoneform.classify = classify;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneform;
    }

    public List<phoneform> search(String key, String str) {
        List<phoneform> phoneforms = new ArrayList<phoneform>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from phoneform where " +
                    key + " like '%" + str + "%';";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                phoneform phoneform = new phoneform();
                String phone_version = rs.getString(1);
                String phone_name = rs.getString(2);
                String phone_made = rs.getString(3);
                int phone_price = rs.getInt(4);
                String phone_feature = rs.getString(5);
                String phone_pic = rs.getString(6);
                int classify = rs.getInt(7);
                phoneform.phone_version = phone_version;
                phoneform.phone_name = phone_name;
                phoneform.phone_made = phone_made;
                phoneform.phone_price = phone_price;
                phoneform.phone_feature = phone_feature;
                phoneform.phone_pic = phone_pic;
                phoneform.classify = classify;
                phoneforms.add(phoneform);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneforms;
    }

    public List<phoneform> list(int start, int count) {
        List<phoneform> phoneforms = new ArrayList<phoneform>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from phoneform order by phone_version desc limit "
                    + start + ","
                    + count + ";";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                phoneform phoneform = new phoneform();
                String phone_version = rs.getString(1);
                String phone_name = rs.getString(2);
                String phone_made = rs.getString(3);
                int phone_price = rs.getInt(4);
                String phone_feature = rs.getString(5);
                String phone_pic = rs.getString(6);
                int classify = rs.getInt(7);
                phoneform.phone_version = phone_version;
                phoneform.phone_name = phone_name;
                phoneform.phone_made = phone_made;
                phoneform.phone_price = phone_price;
                phoneform.phone_feature = phone_feature;
                phoneform.phone_pic = phone_pic;
                phoneform.classify = classify;
                phoneforms.add(phoneform);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneforms;
    }
}
