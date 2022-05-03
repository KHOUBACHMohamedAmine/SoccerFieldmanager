package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Assurance;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.ReservationRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private  final ReservationRepo reservationRepo;
    private final AssuranceServiceImpl assuranceServiceImpl;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo, AssuranceServiceImpl assuranceServiceImpl) {
        this.reservationRepo = reservationRepo;
        this.assuranceServiceImpl = assuranceServiceImpl;
    }
    @Override
    public Reservation save(Reservation reservation) {

            Assurance assurancefounded= assuranceServiceImpl.getAssuranceByClient_Id(reservation.getClient().getId()) ;
            if (assuranceServiceImpl.verifierValabilite(assurancefounded) || assurancefounded!=null ) return reservationRepo.save(reservation);
            else throw new RuntimeException("veuillez régler votre assurance : assurance éxpirée ou client non assuré");
     }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation getReservationById(long id) {
        return reservationRepo.findById(id).orElseThrow(()->new RessourceNotFound("Reservation","Id",id));
    }

    @Override
    public Reservation updateReservation(Reservation reservation, long id) {
        Reservation existingReservation = reservationRepo.findById(id).orElseThrow(
                () -> new RessourceNotFound("Reservation", "Id", id));

        existingReservation.setDate(reservation.getDate());
        existingReservation.setReference(reservation.getReference());
        reservationRepo.save(existingReservation);
        return existingReservation;
    }

    @Override
    public void deleteById(long id) {
        reservationRepo.findById(id).orElseThrow(() ->
                new RessourceNotFound("Reservation", "Id", id));
        reservationRepo.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationByReference(String reference) {
        List<Reservation> reservationsfounded=new ArrayList<Reservation>(reservationRepo.findByReference(reference));
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Reference",reference);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByDate(Date date) {
        List<Reservation> reservationsfounded=new ArrayList<Reservation>(reservationRepo.findByDate(date));
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Date",date);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByClientId(long id) {
        List<Reservation> reservationsfounded=new ArrayList<Reservation>(reservationRepo.findByClient_Id(id));
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Client_ID",id);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByTerrainId(long id) {
        List<Reservation> reservationsfounded=new ArrayList<Reservation>(reservationRepo.findByTerrain_Id(id));
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Terrain_ID",id);
        else return reservationsfounded ;
    }
}
