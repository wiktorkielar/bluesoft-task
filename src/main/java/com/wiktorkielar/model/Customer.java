package com.wiktorkielar.model;

import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static com.wiktorkielar.constants.ValidationConstants.FIELD_CANNOT_BE_EMPTY_PL;
import static com.wiktorkielar.constants.ValidationConstants.FIELD_HAS_TO_BE_VALID_NIP_PL;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String name;

    @Column(name = "nip")
    @NIP(message = FIELD_HAS_TO_BE_VALID_NIP_PL)
    private String nip;

    @Column(name = "street_name")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String streetName;

    @Column(name = "postal_code")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String postalCode;

    @Column(name = "city")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String city;

    @Column(name = "country")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String country;

    @OneToMany(mappedBy = "customer")
    private List<System> systems;

    public Customer() {
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<System> getSystems() {
        return systems;
    }

    public void setSystems(List<System> systems) {
        this.systems = systems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (nip != null ? !nip.equals(customer.nip) : customer.nip != null) return false;
        if (streetName != null ? !streetName.equals(customer.streetName) : customer.streetName != null) return false;
        if (postalCode != null ? !postalCode.equals(customer.postalCode) : customer.postalCode != null) return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (country != null ? !country.equals(customer.country) : customer.country != null) return false;
        return systems != null ? systems.equals(customer.systems) : customer.systems == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nip != null ? nip.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (systems != null ? systems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", systems=" + systems +
                '}';
    }
}
