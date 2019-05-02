package hr.tvz.martincevic.backups;

/*@Primary
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
