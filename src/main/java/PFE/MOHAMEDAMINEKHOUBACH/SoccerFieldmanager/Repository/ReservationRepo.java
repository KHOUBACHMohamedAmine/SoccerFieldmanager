package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByDate(Date date_reservation);
    List<Reservation> findByReference(String reference);
    List<Reservation> findByClient_Id(long id);
    List<Reservation> findByTerrain_Id(long id);
    List<Reservation> findByStatusEquals(int status);
    List<Reservation> findByDateAndTerrain_Id(Date date, long id);

}
