package hr.tvz.martincevic.jpa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;
import hr.tvz.martincevic.wrappers.ThString;
import hr.tvz.martincevic.wrappers.ThTypes;
import lombok.Data;

@Data
public class JPAParser
{
	PredavanjeRepository predavanjeRepository;
	List<String> classMembers = new ArrayList<>();
	List<String> classMethods = new ArrayList<>();

	public JPAParser(PredavanjeRepository repo)
	{
		predavanjeRepository = repo;
		//setMembers();
		//setMethods();
	}
	
	public List<Predavanje> parseAndReturn(ThTypes type, ThString searchValue)
	{
		String typeString = type.getTypes().toString();
		String searchString = searchValue.getStr();
		if(typeString.equals("TEMA")) return predavanjeRepository.findByTema(searchString);
		if(typeString.equals("SADRZAJ")) return predavanjeRepository.findBySadrzaj(searchString);
		if (typeString.equals("ID"))
		{
			Predavanje p = predavanjeRepository.findById(Long.parseLong(searchString, 10)).get();
			List<Predavanje> list = new ArrayList<Predavanje>();
			list.add(p);
			return list;
		}
		return null;
	}

	@SuppressWarnings("unused")
	public List<Predavanje> findBySelectedParam(String param)
	{
		param = param.toLowerCase();
		List<Predavanje> predavanje = new ArrayList<>();
		Integer memberId, methodId;
		if ((memberId = memberExists(param)) != -1)
		{
			methodId = methodExists(classMembers.get(memberId));
			for (String members : classMembers)
			{
				
			}
			return predavanje;
		}
		else return null;
	}

	private Integer memberExists(String param)
	{
		for (Integer i = 0; i < classMembers.size(); i++)
		{
			if(classMembers.get(i).contains(param)) return i;
		}
		return -1;
	}

	private Integer methodExists(String param)
	{
		for (Integer i = 0; i < classMethods.size(); i++)
		{
			if(classMethods.get(i).contains(param)) return i;
		}
		return -1;
	}

	@SuppressWarnings("unused")
	private void setMembers()
	{
		Field[] fields = Predavanje.class.getFields();
		for (Field field : fields)
		{
			classMembers.add(field.getName().toLowerCase());
		}
	}
	
	@SuppressWarnings("unused")
	private void setMethods()
	{
		Method[] methods = JpaRepository.class.getDeclaredMethods();
		/*for (Method method : methods)
		{
			if (methodExists(method.getName().toLowerCase()) != -1
					|| isPrunable(method.getName())) continue;
			classMethods.add(method.getName().toLowerCase());
		}*/
		methods = PredavanjeRepository.class.getDeclaredMethods();
		for (Method method : methods)
		{
			classMethods.add(method.getName().toLowerCase());
		}
	}
}
