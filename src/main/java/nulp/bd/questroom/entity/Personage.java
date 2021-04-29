package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "personage")
public class Personage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "payment", nullable = false)
    private Integer payment;



    @ManyToMany
    @JoinTable(
            name = "actor_personage",
            joinColumns = @JoinColumn(name = "Personage_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Employee_id", referencedColumnName = "id")
    )
    private List<Employee> playedEmployee;


    @ManyToOne
    @JoinColumn(name = "Room_id", referencedColumnName = "id")
    private Room room;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getPayment() {
        return payment;
    }



    @Override
    public String toString() {
        return "Cheracter{" +
                "id=" + id + '\'' +
                "title=" + title + '\'' +
                "paymant=" + payment + '\'' +
                '}';
    }


    public List<Employee> getPlayedEmployee() {
        return playedEmployee;
    }

    public void setPlayedEmployee(List<Employee> playedEmployee) {
        this.playedEmployee = playedEmployee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
