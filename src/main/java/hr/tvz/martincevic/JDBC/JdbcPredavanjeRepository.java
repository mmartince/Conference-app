package hr.tvz.martincevic.JDBC;

/*@Repository
public class JdbcPredavanjeRepository// implements PredavanjeRepository
{

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert predavanjeInserter;

	@Autowired
	public JdbcPredavanjeRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
		this.predavanjeInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Predavanje")
				.usingGeneratedKeyColumns("id");
	}

	//@Override
	public List<Predavanje> findAll()
	{
		return jdbcTemplate.query(
				"select Predavanje.id, Predavanje.tema, Predavanje.sadrzaj, Predavanje.vrsta, Predavanje.objavljeno,"
						+ " Predavanje.datumUpisa, Predavac.id, Predavac.ime, Predavac.pozicija, Predavac.datumUpisa from Predavanje"
						+ " join Predavanje_Predavac on Predavanje.id = Predavanje_Predavac.predavanje"
						+ " join Predavac on Predavanje_predavac.predavac = Predavac.id",
				this::mapRowToPredavanje);
	}

	//@Override
	public Predavanje findOne(Long id)
	{
		return jdbcTemplate.queryForObject("select id, tema, sadrzaj, vrsta, objavljeno from Predavanje where id = ?",
				this::mapRowToPredavanje, id);
	}

	//@Override
	public Predavanje save(Predavanje predavanje)
	{
		predavanje.setDatumUpisa(new Date());
		predavanje.setId(savePredavanjeDetails(predavanje));

		return predavanje;
	}

	private long savePredavanjeDetails(Predavanje predavanje)
	{
		Map<String, Object> values = new HashMap<>();
		values.put("tema", predavanje.getTema());
		values.put("sadrzaj", predavanje.getSadrzaj());
		values.put("vrsta", predavanje.getVrsta());
		values.put("objavljeno", predavanje.getObjavljeno());
		values.put("datumUpisa", predavanje.getDatumUpisa());
		return predavanjeInserter.executeAndReturnKey(values).longValue();
	}

	private Predavanje mapRowToPredavanje(ResultSet rs, int rowNum) throws SQLException
	{
		Predavanje predavanje = new Predavanje();
		Predavac predavac = new Predavac();

		predavanje.setId(rs.getLong("Predavanje.id"));
		predavanje.setTema(rs.getString("Predavanje.tema"));
		predavanje.setSadrzaj(rs.getString("Predavanje.sadrzaj"));
		predavanje.setVrsta(VrstaPredavanja.valueOf(rs.getString("Predavanje.vrsta")));
		predavanje.setObjavljeno(rs.getBoolean("Predavanje.objavljeno"));
		predavanje.setDatumUpisa(rs.getDate("Predavanje.datumUpisa"));

		predavac.setId(rs.getLong("Predavac.id"));
		predavac.setIme(rs.getString("Predavac.ime"));
		predavac.setPozicija(PozicijaPredavaca.valueOf(rs.getString("Predavac.pozicija")));
		predavac.setDatumUpisa(rs.getDate("Predavac.datumUpisa"));

		predavanje.setPredavac(predavac);


		return predavanje;
	}

	//@Override
	public void delete(Long id)
	{

	}

	//@Override
	public Predavanje update(Predavanje predavanje)
	{
		return null;
	}

}*/
