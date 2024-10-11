package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer creditLimit;
    private Integer balance;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Bank bank;

    public CreditCard(Integer number, Integer creditLimit, Integer balance, Customer customer, Bank bank, Pincode pincode) {
        this.number = number;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.customer = customer;
        this.bank = bank;
        this.pincode = pincode;
    }

    public CreditCard() {

    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return bank;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


}
