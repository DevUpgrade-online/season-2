package online.devupgrade.sezon2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class DiscountEntity implements Serializable {

    @Id
    @GeneratedValue
    Integer id;

    Long value;

    @ElementCollection
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "role")
    private List<String> roles;

    @ManyToMany
    List<Product> included;

    @ManyToMany
    List<Product> excluded;

    public DiscountEntity() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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
