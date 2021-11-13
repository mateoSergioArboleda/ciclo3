/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;


import co.usa.ciclo3.ciclo3.interfaces.ClienteIntefaces;
import co.usa.ciclo3.ciclo3.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MATEO
 */
@Repository
public class ClienteRepository {
    
    @Autowired
    private ClienteIntefaces crud1;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();       
    }
    
    public Optional <Cliente> getCliente(int id){
        return crud1.findById(id);
    }
    
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
     public void delete(Cliente cliente){
        crud1.delete(cliente);
    } 
    
}
