package in.indigenous.common.jpa.repository.pm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.indigenous.common.jpa.entity.pm.Organisation;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long>{

}
