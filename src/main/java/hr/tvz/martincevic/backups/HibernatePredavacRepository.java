package hr.tvz.martincevic.backups;

/*@Primary
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

}
*/