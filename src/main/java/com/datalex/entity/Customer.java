package com.datalex.entity;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "customer", namespace = "com.datalex.entity")
public class Customer  implements Serializable{
    private Long ID;
    private String name;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String phone) {
        this.ID = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
