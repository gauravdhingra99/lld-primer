package com.simpl.Model;
/**
 * @author gauravdhingra
 */
public class Merchant {

    Contact contactDetails;
    Double discountPercent;
    Double transactionAmount;
    Double totalEarned;

    public Merchant() {
    }

    public Merchant(Contact contactDetails, Double discountPercent) {
        this.contactDetails = contactDetails;
        this.discountPercent = discountPercent;
        this.transactionAmount = 0d;
        this.totalEarned = 0d;
    }



    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Contact getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Double getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(Double totalEarned) {
        this.totalEarned = totalEarned;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
