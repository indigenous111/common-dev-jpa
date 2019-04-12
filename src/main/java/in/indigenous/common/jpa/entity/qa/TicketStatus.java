package in.indigenous.common.jpa.entity.qa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ticket_status_master")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TicketStatus implements Serializable {

	/**
	 * Generated serial version UId.
	 */
	private static final long serialVersionUID = -8089223018748636472L;

	@Id
	@Column
	private Long id;

	@Column
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
