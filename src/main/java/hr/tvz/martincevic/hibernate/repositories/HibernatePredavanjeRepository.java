package hr.tvz.martincevic.hibernate.repositories;

/*import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;

@Primary
@Repository
@Transactional
public class HibernatePredavanjeRepository implements PredavanjeRepository
{
	private SessionFactory sessionFactory;

	@Autowired
	public HibernatePredavanjeRepository(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Predavanje> findAll()
	{
		return sessionFactory.getCurrentSession().createQuery("SELECT p FROM Predavanje p", Predavanje.class)
				.getResultList();
	}

	@Override
	public Predavanje findOne(Long id)
	{
		return sessionFactory.getCurrentSession().find(Predavanje.class, id);
	}

	@Override
	public Predavanje save(Predavanje predavanje)
	{
		predavanje.setDatumUpisa(new Date());
		predavanje.getPredavac().setDatumUpisa(new Date());
		Serializable id = sessionFactory.getCurrentSession().save(predavanje);
		predavanje.setId((Long) id);
		return predavanje;
	}

	@Override
	public void delete(Long id)
	{
		Session session = sessionFactory.getCurrentSession();
		Predavanje predavanje = session.load(Predavanje.class, id);
		session.delete(predavanje);
		session.flush();
	}

	@Override
	public Predavanje update(Predavanje predavanje)
	{
		sessionFactory.getCurrentSession().update(predavanje);
		return predavanje;
	}

}*/
