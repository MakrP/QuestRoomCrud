package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "status")
    private List<Reservation> reservationsWithStatus;


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

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id + '\'' +
                "title=" + title + '\'' +
                '}';
    }

    public List<Reservation> getReservationsWithStatus() {
        return reservationsWithStatus;
    }

    public void setReservationsWithStatus(List<Reservation> reservationsWithStatus) {
        this.reservationsWithStatus = reservationsWithStatus;
    }
}
