package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

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
    Customer customer = new Customer("Max Mustermann");

    Address address = new Address("Inndalsveien", 28);
    address.getOwners().add(customer);
    customer.getAddresses().add(address);

    Bank bank = new Bank("Pengebank");

    Pincode pincode = new Pincode("123", 1);

    CreditCard creditCard1 = new CreditCard(12345, -10000, -5000, customer, bank, pincode);
    CreditCard creditCard2 = new CreditCard(123, 2000, 1, customer, bank, pincode);
    customer.getCreditCards().add(creditCard1);
    customer.getCreditCards().add(creditCard2);
    bank.getOwnedCards().add(creditCard1);
    bank.getOwnedCards().add(creditCard2);


    em.persist(customer);
    em.persist(address);
    em.persist(bank);
    em.persist(pincode);
    em.persist(creditCard1);
    em.persist(creditCard2);
  }
}
