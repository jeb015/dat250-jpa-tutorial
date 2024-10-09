package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.PERSIST)
    private Collection<CreditCard> creditCards;

    public Bank() {
        this.creditCards = new ArrayList<CreditCard>();
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

    public Collection<CreditCard> getOwnedCards() {
        return creditCards;
    }

    public void setOwnedCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
