package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis" +
                        "?characterEncoding=utf8&useSSL=true&serverTimezone=GMT",
                "root", "Wusd123..");
        String sql = "select * from user where id = ?";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + "  " +
                    resultSet.getString("username"));
        }
    }
}
