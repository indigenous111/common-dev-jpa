package in.indigenous.common.jpa.repository.qa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.indigenous.common.jpa.entity.qa.TicketType;

/**
 * Repository for Artifact Type.
 * 
 * @author sarkh
 *
 */
@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

	/**
	 * Find by type.
	 * 
	 * @param type
	 * @return
	 */
	TicketType findByType(String type);
}
