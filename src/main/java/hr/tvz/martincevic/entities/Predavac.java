package hr.tvz.martincevic.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.rest.core.annotation.RestResource;

import hr.tvz.martincevic.enums.PozicijaPredavaca;
import lombok.Data;

@Data
@Entity
@RestResource(path="predavanje", rel="predavanja")
public class Predavac implements Serializable
{
	private static final long serialVersionUID = 7388584374339059766L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	Date datumUpisa;
	
	@Size(min = 1, max = 20, message = "{validation.ime.length}")
	@NotEmpty(message = "{validation.ime.notEmpty}")
	public String ime;
	public String prezime;
	
	@NotNull(message = "{validation.pozicija.notSelected}")
	@Enumerated(EnumType.STRING)
	public PozicijaPredavaca pozicija;
	
	public Predavac() {}
	
	public void parseName()
	{
		String[] split = ime.split("\\s+");
		ime=split[0];
		if(split.length == 1) prezime="";
		else prezime=split[1];
	}

	public Predavac(Long id, Date datumUpisa,
			@Size(min = 1, max = 20, message = "{validation.ime.length}") @NotEmpty(message = "{validation.ime.notEmpty}") String ime,
			String prezime, @NotNull(message = "{validation.pozicija.notSelected}") PozicijaPredavaca pozicija)
	{
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.ime = ime;
		this.prezime = prezime;
		this.pozicija = pozicija;
	}
	
	public Predavac(@Size(min = 1, max = 20, message = "{validation.ime.length}") @NotEmpty(message = "{validation.ime.notEmpty}") String ime,
			String prezime, @NotNull(message = "{validation.pozicija.notSelected}") PozicijaPredavaca pozicija)
	{
		super();
		datumUpisa = new Date();
		this.ime = ime;
		this.prezime = prezime;
		this.pozicija = pozicija;
	}
}