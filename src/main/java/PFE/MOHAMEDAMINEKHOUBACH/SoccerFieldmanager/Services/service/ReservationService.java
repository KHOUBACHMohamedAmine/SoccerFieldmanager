package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    Reservation save(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(long id);
    Reservation updateReservation(long id,Reservation reservation);
    Reservation deleteById(long id);
    List<Reservation> getReservationByReference(String reference);
    List<Reservation> getReservationByDate(Date date);
    List<Reservation> getReservationByClientId(long id);
    List<Reservation> getReservationByTerrainId(long id);
    List<Reservation> getReservationByDateAndTerrainId(Date date,long id );
    List<Reservation> getReservationByStatus(int status);
    Reservation confirmerReservation(Reservation reservation);

    List<Reservation> getReservationNonArchived();
}
