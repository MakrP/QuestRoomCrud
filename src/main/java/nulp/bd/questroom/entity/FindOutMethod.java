package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "findoutmethod")
public class FindOutMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "findOutMethod", cascade = CascadeType.ALL)
    private List<Client> makeClients;



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
        return "Findoutmethod{" +
                "id=" + id + '\'' +
                "title=" + title + '\'' +
                '}';
    }

    public List<Client> getMakeClients() {
        return makeClients;
    }

    public void setMakeClients(List<Client> makeClients) {
        this.makeClients = makeClients;
    }
}
