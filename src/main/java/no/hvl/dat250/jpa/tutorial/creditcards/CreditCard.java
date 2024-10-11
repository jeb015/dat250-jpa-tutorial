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

    public CreditCard(Integer number, Integer creditLimit, Integer balance, Customer customer, Bank bank) {
        this.number = number;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.customer = customer;
        this.bank = bank;
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
}
