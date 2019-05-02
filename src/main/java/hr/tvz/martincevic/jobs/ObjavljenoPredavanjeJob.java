package hr.tvz.martincevic.jobs;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;

public class ObjavljenoPredavanjeJob extends QuartzJobBean
{
	@Autowired
	PredavanjeRepository predavanjeRepository;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		List<Predavanje> predavanja = predavanjeRepository.findAll();
		
		StreamSupport.stream(predavanja.spliterator(), false)
			.filter(ObjavljenoPredavanjeJob::isNovoObjavljenoPredavanje)
			.collect(Collectors.toList())
			.forEach(ObjavljenoPredavanjeJob::objaviPredavanje);
	}
	
	private static boolean isNovoObjavljenoPredavanje(Predavanje predavanje)
	{
		return predavanje.getObjavljeno() && predavanje.getDatumUpisa().after(createDatePlusSeconds(new Date(), -10));
	}
	
	private static void objaviPredavanje(Predavanje predavanje)
	{
		System.out.println("Objavljeno predavanje: " + predavanje.getTema() );
	}
	
	private static Date createDatePlusSeconds(Date date, Integer seconds) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.SECOND, seconds);
	    return cal.getTime();
	  }

}
