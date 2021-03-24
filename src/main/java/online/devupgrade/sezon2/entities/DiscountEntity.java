package online.devupgrade.sezon2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class DiscountEntity implements Serializable {

    @Id
    @GeneratedValue
    Integer id;

    Long value;

    @ManyToMany
    List<Product> included;

    @ManyToMany
    List<Product> excluded;

    public DiscountEntity() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setIncluded(List<Product> included) {
        this.included = included;
    }

    public void setExcluded(List<Product> excluded) {
        this.excluded = excluded;
    }

    public Integer getId() {
        return id;
    }

    public Long getValue() {
        return value;
    }

    public List<Product> getIncluded() {
        return included;
    }

    public List<Product> getExcluded() {
        return excluded;
    }
}
