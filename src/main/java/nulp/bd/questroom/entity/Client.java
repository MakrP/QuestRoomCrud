package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "visits_number", nullable = false)
    private Integer visitsNumber;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "findoutmethod_id", referencedColumnName = "id")
    private FindOutMethod findOutMethod;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setVisitsNumber(Integer visitsNumber) {
        this.visitsNumber = visitsNumber;
    }

    public Integer getVisitsNumber() {
        return visitsNumber;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                "surname=" + surname + '\'' +
                "email=" + email + '\'' +
                "birthDate=" + birthDate + '\'' +
                "visitsNumber=" + visitsNumber + '\'' +
                '}';
    }

    public FindOutMethod getFindOutMethod() {
        return findOutMethod;
    }

    public void setFindOutMethod(FindOutMethod findOutMethod) {
        this.findOutMethod = findOutMethod;
    }
}
