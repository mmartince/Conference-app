package hr.tvz.martincevic.JDBC;

/*@Repository
public class JdbcPredavacRepository// implements PredavacRepository
{
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert predavacInserter;

	@Autowired
	public JdbcPredavacRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
		this.predavacInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Predavac")
				.usingGeneratedKeyColumns("id");
	}

	//@Override
	public List<Predavac> findAll()
	{
		return jdbcTemplate.query("select id, ime, pozicija from Predavac", this::mapRowToPredavac);
	}

	//@Override
	public Predavac findOne(Long id)
	{
		return jdbcTemplate.queryForObject("select id, ime, pozicija from Predavac where id = ?",
				this::mapRowToPredavac, id);
	}

	//@Override
	public Predavac save(Predavac predavac)
	{
		predavac.setDatumUpisa(new Date());
		predavac.setId(savePredavacDetails(predavac));
		return predavac;
	}

	private long savePredavacDetails(Predavac predavac)
	{
		Map<String, Object> values = new HashMap<>();
		values.put("ime", predavac.getIme());
		values.put("pozicija", predavac.getPozicija());
		values.put("datumUpisa", predavac.getDatumUpisa());
		return predavacInserter.executeAndReturnKey(values).longValue();
	}

	private Predavac mapRowToPredavac(ResultSet rs, int rowNum) throws SQLException
	{
		Predavac predavac = new Predavac();
		predavac.setId(rs.getLong("id"));
		predavac.setIme(rs.getString("ime"));
		predavac.setPozicija(PozicijaPredavaca.valueOf(rs.getString("pozicija")));
		return predavac;
	}

	//@Override
	public void delete(Long id)
	{
		// TODO Auto-generated method stub

	}

	//@Override
	public Predavac update(Predavac predavac)
	{
		// TODO Auto-generated method stub
		return null;
	}

}*/
