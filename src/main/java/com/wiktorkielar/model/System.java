package com.wiktorkielar.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static com.wiktorkielar.constants.ValidationConstants.*;

@Entity
@Table(name = "system")
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String name;

    @Column(name = "description")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String description;

    @Column(name = "technologies")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String technologies;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "system")
    private List<Contract> contracts;

    public System() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        System system = (System) o;

        if (id != system.id) return false;
        if (name != null ? !name.equals(system.name) : system.name != null) return false;
        if (description != null ? !description.equals(system.description) : system.description != null) return false;
        if (technologies != null ? !technologies.equals(system.technologies) : system.technologies != null)
            return false;
        if (customer != null ? !customer.equals(system.customer) : system.customer != null) return false;
        return contracts != null ? contracts.equals(system.contracts) : system.contracts == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (technologies != null ? technologies.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (contracts != null ? contracts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", technologies='" + technologies + '\'' +
                ", customer=" + customer +
                ", contracts=" + contracts +
                '}';
    }
}
