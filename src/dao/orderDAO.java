package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.order;
import bean.phoneform;

import javax.servlet.http.HttpServletRequest;

public class orderDAO {

    public orderDAO() {
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

    public int getTotal(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from orderform where loginname = '" + userName + "';";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(phoneform phoneform, HttpServletRequest request) {
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String userName = (String) request.getSession().getAttribute("userName");
            String sql = "insert into orderform values(" +
                    "null,'" +
                    userName + "','" +
                    phoneform.phone_version + "','" +
                    phoneform.phone_price +
                    "');";
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(HttpServletRequest request, int id) {
        String userName = (String) request.getSession().getAttribute("userName");
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = null;
            if (id == 0) {
                sql = "delete from orderform where loginname='"
                        + userName + "';";
            } else {
                sql = "delete from orderform where loginname='"
                        + userName + "' and id='" + id
                        + "';";
            }
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<order> list(int start, int count, HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        List<order> orders = new ArrayList<order>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from orderform where loginname = '"
                    + userName
                    + "' order by id desc limit "
                    + start + ","
                    + count + ";";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                order order = new order();
                int id = rs.getInt("id");
                String loginname = rs.getString("loginname");
                String goods = rs.getString("goods");
                int sum = rs.getInt("sum");
                order.id = id;
                order.loginname = loginname;
                order.goods = goods;
                order.sum = sum;
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public int sum(int start, int count, HttpServletRequest request) {
        int sum = 0;
        String userName = (String) request.getSession().getAttribute("userName");
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select sum(sum) from (select * from orderform where loginname='"
                    + userName
                    + "' order by id desc limit "
                    + start + ","
                    + count + ")a;";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                sum = rs.getInt("sum(sum)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}