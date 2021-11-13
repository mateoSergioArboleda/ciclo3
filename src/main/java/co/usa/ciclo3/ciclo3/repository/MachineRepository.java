/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.interfaces.MachineInterfaces;
import co.usa.ciclo3.ciclo3.model.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MATEO
 */


@Repository

public class MachineRepository {
 

    @Autowired
    private MachineInterfaces crud;
    

    public List<Machine> getAll(){
        return (List<Machine>) crud.findAll();       
    }
    
    public Optional <Machine> getMachine(int id){
        return crud.findById(id);
    }
    
    public Machine save(Machine machine){
        return crud.save(machine);
    }
      public void delete(Machine machine){
        crud.delete(machine);
    }

   
    
    
}
