package in.indigenous.common.jpa.repository.pm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.indigenous.common.jpa.entity.pm.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findByName(String name);
}
