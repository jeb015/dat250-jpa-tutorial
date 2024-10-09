package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private Set<CreditCard> creditCards;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Address> addresses;

    public Customer() {
        creditCards = new ArrayList<CreditCard>();
        addresses = new ArrayList<Address>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddress(Collection<Address> addresses) {
        this.addresses = addresses;
    }
}
