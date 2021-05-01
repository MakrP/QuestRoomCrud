package nulp.bd.questroom.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SecondaryTable(name = "promouter",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Promouter extends Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "clients_count", nullable = false)
    private Integer clientsCount;


    @ManyToOne
    @JoinColumn(name = "Region_id",referencedColumnName = "id")
    private Region region;

    public void setClientsCount(Integer clientsCount) {
        this.clientsCount = clientsCount;
    }

    public Integer getClientsCount() {
        return clientsCount;
    }


    @Override
    public String toString() {
        return "Promouter{" +
                "clientsCount=" + clientsCount + '\'';
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
