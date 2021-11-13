/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Machine;
import co.usa.ciclo3.ciclo3.service.MachineService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MATEO
 */
@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class MachineController {

   @Autowired
   private MachineService Servicio;
  
   
   @GetMapping("/all")
   public List<Machine> getMachine(){
       return Servicio.getAll();
   }
   @GetMapping("/{id}")
   public Optional<Machine> getMachine(@PathVariable("id") int machineid){
       return Servicio.getMachine(machineid);
   }
   
   @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine) {
        return Servicio.save(machine);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return Servicio.update(machine);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return Servicio.deleteMachine(machineId);
    }
    
   
}
