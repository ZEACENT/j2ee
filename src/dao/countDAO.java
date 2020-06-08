package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.count;

import javax.servlet.http.HttpServletRequest;

public class countDAO {

    public countDAO() {
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
            String sql = "select count(*) from countform where loginname = '" + userName + "';";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(HttpServletRequest request, String goods, int sum) {
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String userName = (String) request.getSession().getAttribute("userName");
            String sql = "insert into countform values(null,'"
                    + userName + "','"
                    + goods + "','"
                    + sum + "');";
            System.out.println(sql);
            s.execute(sql);
            System.out.println("sqlOK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<count> list(int start, int count, HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        List<count> counts = new ArrayList<count>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from countform where loginname = '"
                    + userName
                    + "' order by id desc limit "
                    + start + ","
                    + count + ";";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                count cou = new count();
                int id = rs.getInt("id");
                String loginname = rs.getString("loginname");
                String goods = rs.getString("goods");
                int sum = rs.getInt("sum");
                cou.id = id;
                cou.loginname = loginname;
                cou.goods = goods;
                cou.sum = sum;
                counts.add(cou);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counts;
    }
}