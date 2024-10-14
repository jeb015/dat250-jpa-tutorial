package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private Collection<CreditCard> creditCards;

    @ManyToMany
    private Collection<Address> addresses;

    public Customer(String name) {
        this.name = name;
        this.creditCards = new ArrayList<CreditCard>();
        this.addresses = new ArrayList<Address>();
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
}
