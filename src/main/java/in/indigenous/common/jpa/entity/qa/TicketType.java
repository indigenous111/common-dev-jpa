package in.indigenous.common.jpa.entity.qa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ticket_type_master")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TicketType implements Serializable {

	/**
	 * Generated serial version UId.
	 */
	private static final long serialVersionUID = -9053923174172689164L;

	@Id
	@Column
	private Long id;

	@Column
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
