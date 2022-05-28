package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.ReservationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private ReservationServiceImpl reservationServiceImpl;

    public ReservationController( ReservationServiceImpl reservationServiceImpl) {
        super();
        this.reservationServiceImpl = reservationServiceImpl;
    }
    @PostMapping("/")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation){
        return new ResponseEntity<Reservation>(reservationServiceImpl.save(reservation), HttpStatus.CREATED);
    }
    @GetMapping("/nonArchived")
    public List<Reservation> getReservationsNonArchived(){
        return reservationServiceImpl.getReservationNonArchived();
    }
 //   @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/")
    public List<Reservation> getAllReservations(){
        return  reservationServiceImpl.getAllReservations();
    }
  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/id/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){

        try{
            return new ResponseEntity(reservationServiceImpl.getReservationById(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

 //   @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/date/{date}")
    public ResponseEntity getReservationByDate(@PathVariable("date") Date date){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByDate(date),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reference/{reference}")
    public ResponseEntity getReservationByReference(@PathVariable("reference") String reference){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByReference(reference),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
 //   @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/client/id/{id}")
    public ResponseEntity getReservationByClientId(@PathVariable("id") long id){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByClientId(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/terrain/id/{id}")
    public ResponseEntity getReservationByTerrainId(@PathVariable("id") long id){
        try{
            return new ResponseEntity(reservationServiceImpl.getReservationByTerrainId(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
 //   @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/id/{id}")
    public ResponseEntity updateReservation(@PathVariable("id") long id,@RequestBody Reservation reservation){
        try {
            Reservation reservationfounded= reservationServiceImpl.updateReservation(id,reservation);
            return new ResponseEntity(reservationfounded,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }

 //   @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteReservationById(@PathVariable("id") Long id){
        try {
            Reservation reservation =reservationServiceImpl.deleteById(id);
            return new ResponseEntity<>(reservation,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/status/{status}")
    public ResponseEntity getReservationByStatus(@PathVariable int status) {
        return new ResponseEntity(reservationServiceImpl.getReservationByStatus(status), HttpStatus.OK);
    }

    @Transactional
   // @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/confirm")
    public ResponseEntity confirmerReservation( @RequestBody Reservation reservation) {
        try{
            return new ResponseEntity(reservationServiceImpl.confirmerReservation(reservation), HttpStatus.OK);
        }catch (RessourceNotFound r)
        {
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}

