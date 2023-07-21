package org.example.api.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    // gerando banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User clientUser;

    public Order() {
    }

    public Order(Long id, Instant momentDate, User clientUser) {
        this.id = id;
        this.momentDate = momentDate;
        this.clientUser = clientUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentDate() {
        return momentDate;
    }

    public void setMomentDate(Instant momentDate) {
        this.momentDate = momentDate;
    }

    public User getClientUser() {
        return clientUser;
    }

    public void setClientUser(User clientUser) {
        this.clientUser = clientUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
