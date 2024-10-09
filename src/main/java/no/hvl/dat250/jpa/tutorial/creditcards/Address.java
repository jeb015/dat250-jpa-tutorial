package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    public Address() {
    }

    @ManyToMany(mappedBy ="addresses", cascade = CascadeType.PERSIST)
    private Collection<Customer> owners;

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Collection<Customer> getOwners() {
        return owners;
    }

    public void setOwners(Collection<Customer> owners) {
        this.owners = owners;
    }
}
