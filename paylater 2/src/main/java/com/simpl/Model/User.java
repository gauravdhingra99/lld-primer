package com.simpl.Model;
/**
 * @author gauravdhingra
 */
public class User {

    Contact contactDetails;
    Double creditLimit;
    Double dues;

    public User() {
    }

    public User(Contact contactDetails, Double creditLimit) {
        this.contactDetails = contactDetails;
        this.creditLimit = creditLimit;
        this.dues = 0d;
    }

    public Double getDues() {
        return dues;
    }

    public void setDues(Double dues) {
        this.dues = dues;
    }

    public Contact getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

}
