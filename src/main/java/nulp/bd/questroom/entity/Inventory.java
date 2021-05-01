package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @ManyToOne
    @JoinColumn(name = "Institution_id",referencedColumnName = "id")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "Room_id",referencedColumnName = "id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "State_id",referencedColumnName = "id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "InventoyType_id",referencedColumnName = "id")
    private InventoryType type;



    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id + '\'' +
                '}';
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public InventoryType getType() {
        return type;
    }

    public void setType(InventoryType type) {
        this.type = type;
    }
}
