package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.ReservationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8090"})
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private ReservationServiceImpl reservationServiceImpl;

    public ReservationController( ReservationServiceImpl reservationServiceImpl) {
        super();
        this.reservationServiceImpl = reservationServiceImpl;
    }
    @PostMapping("/")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<Reservation>(reservationServiceImpl.save(reservation), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<Reservation> getAllReservations(){
        return  reservationServiceImpl.getAllReservations();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Terrain> getReservationById(@PathVariable("id") Long id){

        try{
            return new ResponseEntity(reservationServiceImpl.getReservationById(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/date/{date}")
    public ResponseEntity getReservationByDate(@PathVariable("date") Date date){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByDate(date),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/reference/{reference}")
    public ResponseEntity getReservationByReference(@PathVariable("reference") String reference){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByReference(reference),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/client/id/{id}")
    public ResponseEntity getReservationByClientId(@PathVariable("id") long id){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByClientId(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/terrain/id/{id}")
    public ResponseEntity getReservationByTerrainId(@PathVariable("id") long id){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByTerrainId(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity updateReservation(@PathVariable("id") long id,@RequestBody Reservation reservation){
        try {
            reservationServiceImpl.updateReservation(reservation,id);
            return new ResponseEntity(reservation,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteReservationById(@PathVariable("id") Long id){
        try {
            reservationServiceImpl.deleteById(id);
            return new ResponseEntity<String>("Reservation deleted Succesfully",HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}

