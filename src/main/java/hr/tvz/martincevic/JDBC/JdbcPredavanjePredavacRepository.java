package hr.tvz.martincevic.JDBC;

/*@Repository
public class JdbcPredavanjePredavacRepository
{
	public JdbcPredavanjeRepository predavanjeRepo;
	public JdbcPredavacRepository predavacRepo;
	
	private SimpleJdbcInsert predavanjePredavacInserter;
	
	@Autowired
	public JdbcPredavanjePredavacRepository(JdbcTemplate jdbcTemplate)
	{
		this.predavanjePredavacInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Predavanje_Predavac");
		predavanjeRepo = new JdbcPredavanjeRepository(jdbcTemplate);
		predavacRepo = new JdbcPredavacRepository(jdbcTemplate);
	}
	
	public List<Predavanje> findAll()
	{
		List<Predavanje> listaPredavanja = predavanjeRepo.findAll();
		return listaPredavanja;
	}
	
	//public List<Predavanje> findAll()
	//{
	//	return jdbcTemplate.query("select id, ime, pozicija from Predavac", this::mapRowToPredavac);
	//}
	
	public void save(Predavanje predavanje, Predavac predavac)
	{
		Map<String, Object> values = new HashMap<>();
		values.put("predavanje", predavanje.getId());
		values.put("predavac", predavac.getId());
		predavanjePredavacInserter.execute(values);
	}
	
	public void save(Predavanje predavanje)
	{
		Map<String, Object> values = new HashMap<>();
		values.put("predavanje", predavanje.getId());
		values.put("predavac", predavanje.getPredavac().getId());
		predavanjePredavacInserter.execute(values);
	}
}*/
