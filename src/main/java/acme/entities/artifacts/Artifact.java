package acme.entities.artifacts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Artifact extends AbstractEntity{

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@NotBlank
	@Length(max = 100)
	protected String			name;
	
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String			code;
	
	@NotBlank
	@Length(max = 100)
	protected String			technology;
	
	@NotBlank
	@Length(max = 255)
	protected String			description;
	
	@Min(0)
	@NotNull
	protected Integer			retailPrice;
	
	@NotNull
	protected ArtifactType		artifactType;
	
	@URL
	protected String			link;
	
	@ManyToOne(optional = true)
	@Valid
	@NotNull
	protected Toolkit			toolkit;

	
}
