package hr.tvz.martincevic.configs;

import java.util.Locale;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/login");
	}

	// Enables h2 console
	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	ServletRegistrationBean h2servletRegistration()
	{
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		Locale locale = new Locale("hr");
		localeResolver.setDefaultLocale(locale);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("language");
		return lci;
	}

	@Bean
	public MessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

}
