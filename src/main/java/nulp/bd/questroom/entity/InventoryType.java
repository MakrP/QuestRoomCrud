package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inverntorytype")
public class InventoryType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

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
        return "Inverntorytype{" +
                "id=" + id + '\'' +
                "title=" + title + '\'' +
                '}';
    }
}
