/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.reportes.StatusReservas;
import co.usa.ciclo3.ciclo3.model.Reservacion;
import co.usa.ciclo3.ciclo3.reportes.ContadorClientes;
import co.usa.ciclo3.ciclo3.repository.ReservacionRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MATEO
 */
@Service
public class ReservacionService {
         @Autowired
    private ReservacionRepository metodosCrud;
    
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservation(reservacion.getIdReservation());
            if(!e.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
	
    public StatusReservas getReservationsStatusReport(){
        List<Reservacion>completed= metodosCrud.getReservacionByStatus("completed");
        List<Reservacion>cancelled= metodosCrud.getReservacionByStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    public List<Reservacion> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date aDate = new Date();
        Date bDate = new Date();
        
        try{
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(aDate.before(bDate)){
            return metodosCrud.getReservationPeriod(aDate, aDate);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ContadorClientes> getTopClients(){
        return metodosCrud.getTopClients();
    }

}
