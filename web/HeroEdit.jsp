<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Hero hero = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?" +
                        "serverTimezone=GMT%2B8&" +
                        "useUnicode=true&" +
                        "characterEncoding=UTF-8&" +
                        "zeroDateTimeBehavior=convertToNull",
                "root",
                "root");

        Statement s = c.createStatement();

        String sql = "select * from hero where id = " + id;

        ResultSet rs = s.executeQuery(sql);

        if (rs.next()) {
            hero = new Hero();
            String name = rs.getString(2);
            float hp = rs.getFloat("hp");
            int damage = rs.getInt(4);
            hero.name = name;
            hero.hp = hp;
            hero.damage = damage;
            hero.id = id;
        }

        s.close();

        c.close();

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

%>
<form action='updateHero' method='post'>
    名字 ： <input type='text' name='name' value='<%=hero.getName()%>'> <br>
    血量 ：<input type='text' name='hp' value='<%=hero.getHp()%>'> <br>
    伤害： <input type='text' name='damage' value='<%=hero.getDamage()%>'> <br>
    <input type='hidden' name='id' value='<%=hero.getId()%>'>
    <input type='submit' value='更新'>
</form>
</body>
</html>
