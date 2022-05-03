package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    Reservation save(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(long id);
    Reservation updateReservation(Reservation reservation,long id);
    void deleteById(long id);
    List<Reservation> getReservationByReference(String reference);
    List<Reservation> getReservationByDate(Date date);
    List<Reservation> getReservationByClientId(long id);
    List<Reservation> getReservationByTerrainId(long id);
}
