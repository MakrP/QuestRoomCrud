package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "actor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "salary", nullable = false)
    private Integer salary;



    @ManyToOne
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    private Institution institution;

    @ManyToMany
    @JoinTable(
            name = "actor_character",
            joinColumns = @JoinColumn(name = "Actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Personage_id", referencedColumnName = "id")
    )
    private List<Personage> playedPersonages;

    @ManyToMany
    @JoinTable(
            name = "reservation_actor",
            joinColumns = @JoinColumn(name = "Actor_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Reservation_id",referencedColumnName = "id"))
    private List<Reservation> reservations;




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

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Personage> getPlayedCharacters() {
        return playedPersonages;
    }

    public void setPlayedCharacters(List<Personage> playedPersonages) {
        this.playedPersonages = playedPersonages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                "surname=" + surname + '\'' +
                "age=" + age + '\'' +
                "email=" + email + '\'' +
                "salary=" + salary + '\'' +
                '}';
    }
}
