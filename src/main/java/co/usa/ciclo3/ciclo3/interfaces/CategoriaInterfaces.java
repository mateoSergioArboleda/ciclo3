/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo3.ciclo3.interfaces;

import co.usa.ciclo3.ciclo3.model.Categoria;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author MATEO
 */
public interface CategoriaInterfaces extends CrudRepository<Categoria,Integer> {
    
}
