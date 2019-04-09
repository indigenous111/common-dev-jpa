package in.indigenous.common.jpa.repository.pm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.indigenous.common.jpa.entity.pm.ProjectStatus;

@Repository
public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long> {

	ProjectStatus findByStatus(String status);
}
