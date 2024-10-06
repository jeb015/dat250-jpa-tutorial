package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Collection;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // Create a customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    // Create an address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    // Set the address for the customer
    customer.setAddress((Collection<Address>) address);

    // Create a bank
    Bank bank = new Bank();
    bank.setName("Pengebank");

    // Create a pincode
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    // Create the first credit card
    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(10000);
    card1.setCustomer(customer);  // Associate with customer
    card1.setPincode(pincode);    // Associate with pincode
    card1.setBank(bank);          // Associate with bank

    // Create the second credit card
    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    card2.setCustomer(customer);  // Associate with customer
    card2.setPincode(pincode);    // Associate with the same pincode
    card2.setBank(bank);          // Associate with bank

    // Persist all objects
    em.persist(customer);  // Customer is the owner of the address and cards
    em.persist(address);
    em.persist(bank);
    em.persist(pincode);
    em.persist(card1);
    em.persist(card2);
  }
}
