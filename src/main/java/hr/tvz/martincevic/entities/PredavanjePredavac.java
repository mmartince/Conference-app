package hr.tvz.martincevic.entities;

import java.util.Date;

import hr.tvz.martincevic.enums.PozicijaPredavaca;
import hr.tvz.martincevic.enums.VrstaPredavanja;

public class PredavanjePredavac
{
	Long idPredavanje;
	Date datumUpisaPredavanje;
	Long idPredavac;
	Date datumUpisaPredavac;
	
	public String tema;
	public String sadrzaj;
	public VrstaPredavanja vrsta;
	public Boolean objavljeno;
	
	public String ime;
	public String prezime;
	public PozicijaPredavaca pozicija;
	
	public Predavanje predavanje;
	
	public PredavanjePredavac(Predavanje predavanjeInc, Predavac predavacInc)
	{
		idPredavac=predavanjeInc.getId();
		datumUpisaPredavanje=predavanjeInc.getDatumUpisa();
		tema=predavanjeInc.getTema();
		sadrzaj=predavanjeInc.getSadrzaj();
		vrsta=predavanjeInc.getVrstaPredavanja();
		objavljeno=predavanjeInc.getObjavljeno();
		
		idPredavac=predavacInc.getId();
		datumUpisaPredavac=predavacInc.getDatumUpisa();
		ime=predavacInc.getIme();
		prezime=predavacInc.getPrezime();
		pozicija=predavacInc.getPozicija();
	}
	
	public PredavanjePredavac() {};
	
	public void load()
	{
		
	}
}
