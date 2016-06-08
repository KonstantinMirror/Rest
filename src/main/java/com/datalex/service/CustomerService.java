package com.datalex.service;

import com.datalex.entity.Customer;
import com.datalex.entity.Customers;
import com.datalex.dao.ICustomerDAO;
import com.datalex.dao.db.DbDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/CustomerService")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class CustomerService {
    ICustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new DbDao();
    }

    @GET
    @Path("/customers")
    public Response getCustomers(){
       Customers customers = customerDAO.getAllCustomers();
        return Response.ok(customers).build();
    }

    @GET
    @Path("{customerId}")
    public Response getCustomerById(@PathParam("customerId") Long customerId){
        Customer customer = customerDAO.getCustomerById(customerId);
        return Response.ok(customer).build();
    }

    @DELETE
    @Path("{customerId}" )
    public Response deleteCustomer(@PathParam("customerId") Long customerId){
        customerDAO.deleteCustomer(customerId);
        return Response.noContent().build();
    }

    @PUT
    @Path("{customerId}" )
    public Response updateCustomer(@PathParam("customerId") Long customerId,Customer customer){
        customer.setID(customerId);
        customerDAO.updateCustomerById(customer);
        return Response.ok(customer).build();
    }

    @POST
    public Response createCustomer(Customer customer){
        customer = customerDAO.createCustomer(customer);
       return Response.ok(customer).build();
    }

}
