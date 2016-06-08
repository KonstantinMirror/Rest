package com.datalex.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(namespace = "com.datalex.entity")
@XmlSeeAlso(Customer.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {

    private List<Customer> customerList;

    public Customers() {
        customerList = new ArrayList<Customer>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
