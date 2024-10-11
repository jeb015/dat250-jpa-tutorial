package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private Collection<CreditCard> creditCards;

    @ManyToMany
    private Collection<Address> addresses;

    public Customer(String name, Collection<CreditCard> creditCards, Collection<Address> addresses) {
        this.name = name;
        this.creditCards = creditCards;
        this.addresses = addresses;
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
}
