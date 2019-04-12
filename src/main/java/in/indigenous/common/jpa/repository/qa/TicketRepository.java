package in.indigenous.common.jpa.repository.qa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.indigenous.common.jpa.entity.qa.Ticket;

/**
 * Repository for artifact.
 * 
 * @author sarkh
 *
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
