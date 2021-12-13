package com.simpl.Service;

import com.simpl.Model.Merchant;
import com.simpl.Model.User;
import com.simpl.Repository.IPaymentRepository;
import com.simpl.Repository.PaymentRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author gauravdhingra
 */
public class PaymentServiceImpl implements PaymentService {

    IPaymentRepository paymentRepository =new PaymentRepositoryImpl();

    @Override
    public void newUser(String userName, String email, Double creditLimit) {
        User user = paymentRepository.newUser(userName, email, creditLimit);
        if(user==null) return;
        System.out.println(user.getContactDetails().getName() + " (" + user.getCreditLimit() + ")");
    }

    @Override
    public void newMerchant(String merchantName, String email, Double discountPercent) {
        Merchant merchant = paymentRepository.addMerchant(merchantName, email, discountPercent);
        if(merchant==null) return;
        System.out.println(merchant.getContactDetails().getName() + " (" + merchant.getDiscountPercent() + "%)");
    }

    @Override
    public void newTransaction(String userName, String merchantName, Double transactionAmount) {
    System.out.println(paymentRepository.newTransaction(userName, merchantName, transactionAmount));
    }

    @Override
    public void updateMerchant(String merchantName, String newdiscountPercent) {
    String newDiscount= paymentRepository.updateMerchant(merchantName,Double.valueOf(newdiscountPercent));
    System.out.println("interest-rate: " + newDiscount +"%");
    }

    @Override
    public void payBack(String userName, Double payBackAmount) {
        User user= paymentRepository.payBack(userName,payBackAmount);
        if(user==null) return;
        System.out.println(user.getContactDetails().getName() + "(dues: " +user.getDues() + ")" );
    }

    @Override
    public void reportDiscount(String merchantName) {
        System.out.println(paymentRepository.reportDiscount(merchantName));
    }

    @Override
    public void reportDues(String userName) {
    System.out.println(paymentRepository.reportDues(userName));
    }

    @Override
    public void reportUsersAtCreditLimit() {
        List<String> usersAtCreditLimit= paymentRepository.reportUsersAtCreditLimit();
        System.out.println(String.join("\n", usersAtCreditLimit));
    }

    @Override
    public void reportTotalDues() {
        List<User>users= paymentRepository.reportTotalDues();
        printTotalDues(users);

    }

    private void printTotalDues(List<User>users){
        Double total=0D;
        for(User user:users)
        {
            System.out.println(user.getContactDetails().getName() + ": " + user.getDues());
            total+=user.getDues();
        }
        System.out.println("total: "+ total);
    }
}
