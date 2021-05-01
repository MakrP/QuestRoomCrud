package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "person_count", nullable = false)
    private Integer personCount;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "reservation_time", nullable = false)
    private String reservationTime;

    @ManyToOne
    @JoinColumn(name = "Room_id",referencedColumnName = "id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "Client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "institution_id",referencedColumnName = "id")
    private Institution institution;



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getReservationTime() {
        return reservationTime;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id + '\'' +
                "personCount=" + personCount + '\'' +
                "registrationDate=" + registrationDate + '\'' +
                '}';
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
