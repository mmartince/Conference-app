package hr.tvz.martincevic.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.martincevic.entities.Predavac;

public interface PredavacRepository extends JpaRepository<Predavac, Long>
{
	
	
	/*public List<Predavac> findAll();
	public Predavac findOne(Long id);
	public Predavac save(Predavac predavac);
	public Predavac update(Predavac predavac);
	public void delete(Long id);*/
}
