package hr.tvz.martincevic.hibernate.repositories;

/*import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.martincevic.entities.Predavac;
import hr.tvz.martincevic.entities.repositories.PredavacRepository;

@Primary
@Repository
@Transactional
public class HibernatePredavacRepository implements PredavacRepository
{
	private SessionFactory sessionFactory;

	@Autowired
	public HibernatePredavacRepository(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Predavac> findAll()
	{
		return sessionFactory.getCurrentSession().createQuery("SELECT p FROM Predavac p", Predavac.class).getResultList();
	}

	@Override
	public Predavac findOne(Long id)
	{
		return sessionFactory.getCurrentSession().find(Predavac.class, id);
	}

	@Override
	public Predavac save(Predavac predavac)
	{
		predavac.setDatumUpisa(new Date());
		Serializable id = sessionFactory.getCurrentSession().save(predavac);
		predavac.setId((Long) id);
		return predavac;
	}

	@Override
	public void delete(Long id)
	{
		Session session = sessionFactory.getCurrentSession();
		Predavac predavac = session.load(Predavac.class, id);
		session.delete(predavac);
		session.flush();
	}

	@Override
	public Predavac update(Predavac predavac)
	{
		sessionFactory.getCurrentSession().update(predavac);
		return predavac;
	}
}*/
