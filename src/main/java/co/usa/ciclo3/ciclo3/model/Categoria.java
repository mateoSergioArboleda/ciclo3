package co.usa.ciclo3.ciclo3.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MATEO
 */
@Entity
@Table(name = "category")
public class Categoria {
     @Id
     @GeneratedValue
     private Integer id;
     private String name;
     private String description;
     
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
     @JsonIgnoreProperties({"category","message"})
     private List<Machine> machine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Machine> getMachine() {
        return machine;
    }

    public void setMachine(List<Machine> machine) {
        this.machine = machine;
    }
    
     
}

/**
 *
 * @author MATEO
 */

