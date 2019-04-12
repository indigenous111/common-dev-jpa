package in.indigenous.common.jpa.repository.qa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.indigenous.common.jpa.entity.qa.TicketStatus;

/**
 * Repository for artifact status.
 * 
 * @author sarkh
 *
 */
@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long>{

	/**
	 * Find by status.
	 * 
	 * @param status
	 * @return
	 */
	TicketStatus findByStatus(String status);
}
