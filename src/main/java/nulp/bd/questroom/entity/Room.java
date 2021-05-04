package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "max_person", nullable = false)
    private Integer maxPerson;

    @Column(name = "min_age", nullable = false)
    private Integer minAge;

    @Column(name = "actor_count", nullable = false)
    private Integer actorCount;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="institution_room",
            joinColumns = @JoinColumn(name ="Room_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name ="Institution_id",referencedColumnName = "id"))
    private List<Institution> institutionsInclude;


    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Personage> personages;


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

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setMaxPerson(Integer maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Integer getMaxPerson() {
        return maxPerson;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setActorCount(Integer actorCount) {
        this.actorCount = actorCount;
    }

    public Integer getActorCount() {
        return actorCount;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }



    @Override
    public String toString() {
        return "Room{" +
                "id=" + id + '\'' +
                "title=" + title + '\'' +
                "price=" + price + '\'' +
                "maxPerson=" + maxPerson + '\'' +
                "minAge=" + minAge + '\'' +
                "actorCount=" + actorCount + '\'' +
                "duration=" + duration + '\'' +
                '}';
    }

    public List<Institution> getInstitutionsInclude() {
        return institutionsInclude;
    }

    public void setInstitutionsInclude(List<Institution> institutionsInclude) {
        this.institutionsInclude = institutionsInclude;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Personage> getPersonages() {
        return personages;
    }

    public void setPersonages(List<Personage> personages) {
        this.personages = personages;
    }
}
