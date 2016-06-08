package com.datalex.dao.db;

import java.sql.*;
import java.util.Properties;

public final class DButility {


    public static Connection getConnection() throws SQLException {
        Properties properties =new Properties();
        properties.setProperty("user","jse");
        properties.setProperty("password","jse");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Problem with connect");
        }
        Connection connection = DriverManager.getConnection(URL + BASE_NAME, properties);
        return connection;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String BASE_NAME = "flight";



    public static void closeResultSet(ResultSet... resultSets) {
        for (ResultSet rs : resultSets) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
        }
    }

    public static void closeStatement(Statement... statement) {
        for (Statement st : statement) {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                printSQLException(ex);
            }
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " +
                        ((SQLException) e).getSQLState());
                System.err.println("Error Code: " +
                        ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
