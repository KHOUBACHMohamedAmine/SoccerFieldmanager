package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Assurance;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.ReservationRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private  final ReservationRepo reservationRepo;
    private final AssuranceServiceImpl assuranceServiceImpl;
    private final TerrainServiceImpl terrainServiceImpl;
                        // status : pending 0 / confirmed 1 / rejected 2


    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo, AssuranceServiceImpl assuranceServiceImpl,TerrainServiceImpl terrainServiceImpl) {
        this.reservationRepo = reservationRepo;
        this.assuranceServiceImpl = assuranceServiceImpl;
        this.terrainServiceImpl= terrainServiceImpl;
    }
    @Override
    public Reservation save(Reservation reservation) {
        Assurance assurance=assuranceServiceImpl.getAssuranceByClient_Cin(reservation.getClient().getCin());
            if (assuranceServiceImpl.verifierValabilite(assurance.getDate_expiration(),reservation.getDate())){
                if (assuranceServiceImpl.verifierAssuranceByClient_Cin(reservation.getClient().getCin())){
                    reservation.setStatus(0);
                    return reservationRepo.save(reservation);
                }
            }
            else throw new RessourceNotFound("Assurance","Client avec l'ID",reservation.getClient().getId());

        return null;
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
    public Reservation updateReservation(long id ,Reservation reservation) {
        Reservation existingReservation = reservationRepo.findById(id).orElseThrow(
                () -> new RessourceNotFound("Reservation", "Id", id));
        if (existingReservation.getStatus() == 0) existingReservation.setStatus(reservation.getStatus());
        else throw new RuntimeException("Reservation is already confirmed , cannot be updated !!");
        existingReservation.setDate(reservation.getDate());
        existingReservation.setReference(reservation.getReference());
        existingReservation.setHour(reservation.getHour());
        reservationRepo.save(existingReservation);
        return existingReservation;
    }
    @Transactional
    @Override
    public Reservation deleteById(long id) {
        Reservation reservation = reservationRepo.findById(id).orElseThrow(() ->
                new RessourceNotFound("Reservation", "Id", id));
        reservationRepo.deleteById(id);

        return reservation;
    }

    @Override
    public List<Reservation> getReservationByReference(String reference) {
        List<Reservation> reservationsfounded=reservationRepo.findByReference(reference);
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Reference",reference);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByDate(Date date) {
        List<Reservation> reservationsfounded=reservationRepo.findByDate(date);
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Date",date);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByClientId(long id) {
        List<Reservation> reservationsfounded=reservationRepo.findByClient_Id(id);
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Client_ID",id);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByTerrainId(long id) {
        List<Reservation> reservationsfounded=reservationRepo.findByTerrain_Id(id);
        if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Terrain_ID",id);
        else return reservationsfounded ;
    }

    @Override
    public List<Reservation> getReservationByDateAndTerrainId(Date date, long id) {
         Terrain terrainfounded=terrainServiceImpl.getTerrainById(id);
         if (terrainfounded!=null) {
             List<Reservation> reservationsfounded = reservationRepo.findByDateAndTerrain_Id(date, id);
             if (reservationsfounded.isEmpty()) throw new RessourceNotFound("Reservation","Reservation_Date",date);
             else return reservationsfounded;
             }
                 else throw new RessourceNotFound("Terrain","Id",id);
    }

    @Override
    public List<Reservation> getReservationByStatus(int status) {
        return reservationRepo.findByStatusEquals(status);
    }

    @Transactional
    @Override
    public Reservation confirmerReservation(Reservation reservation) {
         Reservation founded = reservationRepo.findById(reservation.getId()).orElseThrow(()-> new RessourceNotFound("Reservation","Id",reservation.getId()));
         founded.setStatus(1);
         List<Reservation> reservationsfounded=reservationRepo.findByDateAndTerrain_IdAndHour(reservation.getDate(),reservation.getTerrain().getId(),reservation.getHour());
        for ( Reservation r:reservationsfounded) {
            if (r.getId()!=reservation.getId()){
                r.setStatus(2) ;
                reservationRepo.save(r);
            }
            }
         return  reservationRepo.save(founded);
         }

    @Override
    public List<Reservation> getReservationNonArchived() {
        return reservationRepo.findByStatusIsNot(2);
    }


}
