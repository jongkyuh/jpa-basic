package hellojpa;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipzode;



    public Address(String city, String street, String zipzode) {
        this.city = city;
        this.street = street;
        this.zipzode = zipzode;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getZipzode() {
        return zipzode;
    }

    private void setZipzode(String zipzode) {
        this.zipzode = zipzode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipzode, address.zipzode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipzode);
    }
}
