package com.simpl.Service;
/**
 * @author gauravdhingra
 */
public interface PaymentService {

    void newUser(String userName, String email, Double creditLimit);

    void newMerchant(String merchantName, String email, Double discountPercent);

    void newTransaction(String userName, String merchantName,Double transactionAmount);

    void updateMerchant(String merchantName, String newdiscountPercent);

    void payBack(String userName, Double payBackAmount);

    void reportDiscount(String merchantName);

    void reportDues(String userName);

    void reportUsersAtCreditLimit();

    void reportTotalDues();

}
