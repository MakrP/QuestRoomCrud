package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Institution {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;
    @Basic
    @Column(name = "street", nullable = false, length = 45)
    private String street;
    @Basic
    @Column(name = "number", nullable = false)
    private int number;

    @OneToMany(mappedBy = "institution")
    private List<Employee> employees;

    @ManyToMany
    @JoinTable(
            name="institution_room",
            joinColumns = @JoinColumn(name ="Institution_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name ="Room_id", referencedColumnName = "id"))
    private List<Room> includeRooms;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Institution that = (Institution) o;

        if (id != that.id) return false;
        if (number != that.number) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }


    public List<Room> getIncludeRooms() {
        return includeRooms;
    }
}
