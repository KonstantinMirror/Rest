package com.datalex.dao.db;


import com.datalex.bean.Customer;
import com.datalex.bean.Customers;
import com.datalex.dao.ICustomerDAO;
import com.datalex.logging.bean.User;

import java.sql.*;


public class DbDao implements ICustomerDAO {

    @Override
    public Customer getCustomerById(Long id) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = DButility.getConnection();
            statement = con.prepareStatement("SELECT  * FROM flight.customers WHERE id = ?");
            result = statement.executeQuery();
            Customer customer = new Customer();
            if (result.next()) {
                customer.setID(result.getLong("id"));
                customer.setName(result.getString("name"));
                customer.setEmail(result.getString("email"));
                customer.setPhone(result.getString("phone"));
            }
            return customer;
        } catch (SQLException e) {
            throw new IllegalStateException("Problem with DB", e);
        } finally {
            DButility.closeResultSet(result);
            DButility.closeStatement(statement);
            DButility.closeConnection(con);
        }
    }

    @Override
    public Customer updateCustomerById(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DButility.getConnection();
            statement = con.prepareStatement("DELETE  FROM flight.customers WHERE id = ?");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Problem with DB", e);
        } finally {
            DButility.closeStatement(statement);
            DButility.closeConnection(con);
        }
    }

    @Override
    public Customers getAllCustomers() {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = DButility.getConnection();
            statement = con.prepareStatement("SELECT  * FROM flight.customers ");
            result = statement.executeQuery();
            Customers customersList = new Customers();
            while (result.next()) {
                Customer customer = new Customer();
                customer.setID(result.getLong("id"));
                customer.setName(result.getString("name"));
                customer.setEmail(result.getString("email"));
                customer.setPhone(result.getString("phone"));
                customersList.getCustomerList().add(customer);
            }
            return customersList;
        } catch (SQLException e) {
            throw new IllegalStateException("Problem with DB", e);
        } finally {
            DButility.closeResultSet(result);
            DButility.closeStatement(statement);
            DButility.closeConnection(con);
        }
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = DButility.getConnection();
            statement = con.prepareStatement("INSERT INTO  flight.customers( name, email, phone)" +
                    " VALUES (?,?,?) ");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            result = statement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException("Problem with DB", e);
        } finally {
            DButility.closeResultSet(result);
            DButility.closeStatement(statement);
            DButility.closeConnection(con);
        }
    }
    return null;
}

    private Long getId(Connection connection) {



    }
