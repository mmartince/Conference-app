package hr.tvz.martincevic.configs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hr.tvz.martincevic.jobs.ObjavljenoPredavanjeJob;
import hr.tvz.martincevic.jobs.ZastarjeloPredavanjeJob;

@Configuration
public class SchedulerConfig
{
	@Bean
	public JobDetail objavljenoPredavanjeJobJobDetail()
	{
		return JobBuilder.newJob(ObjavljenoPredavanjeJob.class).withIdentity("objavljenoPredavanjeJob").storeDurably().build();
	}

	@Bean
	public Trigger objavljenoPredavanjeJobTrigger()
	{
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(objavljenoPredavanjeJobJobDetail()).withIdentity("objavljenoPredavanjeTrigger")
				.withSchedule(scheduleBuilder).build();
	}
	
	@Bean
	public JobDetail zastarjeloPredavanjeJobJobDetail()
	{
		return JobBuilder.newJob(ZastarjeloPredavanjeJob.class).withIdentity("zastarjeloPredavanjeJob").storeDurably().build();
	}

	@Bean
	public Trigger zastarjeloPredavanjeJobTrigger()
	{
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(zastarjeloPredavanjeJobJobDetail()).withIdentity("zastarjeloPredavanjeTrigger")
				.withSchedule(scheduleBuilder).build();
	}
}
