package com.example.esercitazione.database;

import java.sql.*;

public class DatabaseManager {

    public DatabaseManager() {
    }

    public ResultSet queryCustomerByName(String customerName) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = null;
        String url = "jdbc:mariadb://localhost:3306/classicmodels?user=root&password=";
        try (Connection connection = DriverManager.getConnection(url)) {
            String query = "SELECT customerName, customerNumber, phone FROM customers WHERE customerName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerName);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()) {
                // no data
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
