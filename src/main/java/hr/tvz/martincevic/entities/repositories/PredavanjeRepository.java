package hr.tvz.martincevic.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.martincevic.entities.Predavanje;

public interface PredavanjeRepository extends JpaRepository<Predavanje, Long>
{
	List<Predavanje> findByTema(String tema);
	List<Predavanje> findBySadrzaj(String sadrzaj);
	
	/*public List<Predavanje> findAll();
	public Predavanje findOne(Long id);
	public Predavanje save(Predavanje predavanje);
	public Predavanje update(Predavanje predavanje);
	public void delete(Long id);*/
}
