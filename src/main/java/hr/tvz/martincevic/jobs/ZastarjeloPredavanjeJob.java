package hr.tvz.martincevic.jobs;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;

public class ZastarjeloPredavanjeJob extends QuartzJobBean
{
	@Autowired
	PredavanjeRepository predavanjeRepository;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		List<Predavanje> predavanja = predavanjeRepository.findAll();

		for (Predavanje predavanje : predavanja)
		{
			if (isZastarjeloPredavanje(predavanje))
			{
				izbrisiPredavanje(predavanje);
				System.out.println("Izbrisano zastarjelo predavanje: " + predavanje.getTema());
			}
		}
	}

	private boolean isZastarjeloPredavanje(Predavanje predavanje)
	{
		return predavanje.getDatumUpisa().before(createDatePlusSeconds(new Date(), -30));
	}

	private void izbrisiPredavanje(Predavanje predavanje)
	{
		predavanjeRepository.delete(predavanje);
	}

	private static Date createDatePlusSeconds(Date date, Integer seconds)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, seconds);
		return cal.getTime();
	}

}
