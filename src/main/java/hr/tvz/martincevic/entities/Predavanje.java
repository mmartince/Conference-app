package hr.tvz.martincevic.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;

import hr.tvz.martincevic.enums.VrstaPredavanja;
import lombok.Data;

@Data
@Entity
@RestResource(path="predavac", rel="predavaci")
public class Predavanje implements Serializable
{
	private static final long serialVersionUID = 3066197837604619856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@CreationTimestamp
	Date datumUpisa;
	
	@Valid
	@OneToOne(targetEntity=Predavac.class, cascade=CascadeType.ALL)
	@JoinTable(name = "Predavanje_Predavac",
			   joinColumns = @JoinColumn(name = "Predavanje"),
			   inverseJoinColumns = @JoinColumn(name = "Predavac"))
	private Predavac predavac;
	
	@Size(min = 1, max= 50 , message= "{validation.tema.length}")
	@NotEmpty(message = "{validation.tema.empty}")
	public String tema;
	
	@Size(min = 1, max= 100, message= "{validation.content.length}")
	@NotEmpty(message= "{validation.tema.empty}")
	public String sadrzaj;
	
	@NotNull(message= "{validation.type.notSelected}")
	@Enumerated(EnumType.STRING)
	public VrstaPredavanja vrsta;
	
	public Boolean objavljeno;
	//public Integer nekaj;
	//public boolean pratnja;
	//public String gender;
	
	public Predavanje(Predavanje predavanje, Predavac predavac)
	{
		this.predavac=predavac;
		id=predavac.getId();
		datumUpisa=predavanje.getDatumUpisa();
		tema=predavanje.getTema();
		sadrzaj=predavanje.getSadrzaj();
		vrsta=predavanje.getVrstaPredavanja();
		objavljeno=predavanje.getObjavljeno();
	}
	
	public Predavanje() {}
	
	public VrstaPredavanja getVrstaPredavanja()
	{
		return vrsta;
	}

	public Predavanje(Long id, Date datumUpisa, @Valid Predavac predavac,
			@Size(min = 1, max = 50, message = "{validation.tema.length}") @NotEmpty(message = "{validation.tema.empty}") String tema,
			@Size(min = 1, max = 100, message = "{validation.content.length}") @NotEmpty(message = "{validation.tema.empty}") String sadrzaj,
			@NotNull(message = "{validation.type.notSelected}") VrstaPredavanja vrsta, Boolean objavljeno)
	{
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.predavac = predavac;
		this.tema = tema;
		this.sadrzaj = sadrzaj;
		this.vrsta = vrsta;
		this.objavljeno = objavljeno;
	}
	
	public Predavanje(@Valid Predavac predavac,
			@Size(min = 1, max = 50, message = "{validation.tema.length}") @NotEmpty(message = "{validation.tema.empty}") String tema,
			@Size(min = 1, max = 100, message = "{validation.content.length}") @NotEmpty(message = "{validation.tema.empty}") String sadrzaj,
			@NotNull(message = "{validation.type.notSelected}") VrstaPredavanja vrsta, Boolean objavljeno)
	{
		super();
		datumUpisa = new Date();
		this.predavac = predavac;
		this.tema = tema;
		this.sadrzaj = sadrzaj;
		this.vrsta = vrsta;
		this.objavljeno = objavljeno;
	}
}