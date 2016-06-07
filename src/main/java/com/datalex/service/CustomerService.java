package com.datalex.service;

import com.datalex.bean.Customer;
import com.datalex.bean.Customers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/CustomerService")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class CustomerService {

    @GET
    @Path("/customers")
    public Response getCustomers(){
        Customers customers =  new Customers();
        customers.getCustomerList().add(new Customer("nick", "12@2", "222555"));
        customers.getCustomerList().add(new Customer("nick", "12@2", "222555"));
        return Response.ok(customers).build();
    }

    @GET
    @Path("{customerId}")
    public Response getCustomerById(@PathParam("customerId") Long customerId){
        System.out.println("get");
        System.out.println(customerId);
        return Response.ok(new Customer("nick","12@2","222555")).build();
    }

    @DELETE
    @Path("{customerId}")

    public Response deleteCustomer(@PathParam("customerId") Long customerId){
        System.out.println("delete");
        System.out.println(customerId);
        return Response.noContent().build();
    }

    @POST
    public Response createCustomer(Customer customer){
        System.out.println("create");
        System.out.println(customer);
       return Response.ok().build();
    }

}
