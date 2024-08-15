package hellojpa;

import jakarta.persistence.Embeddable;

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

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipzode() {
        return zipzode;
    }

    public void setZipzode(String zipzode) {
        this.zipzode = zipzode;
    }
}
