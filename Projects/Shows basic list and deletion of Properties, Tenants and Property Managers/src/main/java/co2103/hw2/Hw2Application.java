package co2103.hw2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co2103.hw2.model.Property;
import co2103.hw2.model.PropertyManager;
import co2103.hw2.model.Tenant;
import co2103.hw2.repo.PropertyManagerRepository;
import co2103.hw2.repo.PropertyRepository;
import co2103.hw2.repo.TenantRepository;

@SpringBootApplication
public class Hw2Application implements ApplicationRunner {

		@Autowired
		private PropertyRepository repop;
		
		@Autowired
		private PropertyManagerRepository repopm;
		
		@Autowired
		private TenantRepository repot;
		
	public static void main(String[] args) {
		SpringApplication.run(Hw2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Property p1 = new Property();
		p1.setName("House");
		
		p1 = repop.save(p1);
		
		Property p2 = new Property();
		p2.setName("Apartment");
		
		p2 = repop.save(p2);
		
		Property p3 = new Property();
		p3.setName("House");
		p3 = repop.save(p3);
		
		Tenant t1 = new Tenant();
		t1.setName("James Brown");
		t1.setLivesAt(p1);
		t1 = repot.save(t1);
		
		Tenant t2 = new Tenant();
		t2.setName("Kate Bratham");
		t2.setLivesAt(p2);
		t2 = repot.save(t2);
		
		Tenant t3 = new Tenant();
		t3.setName("Ben Poole");
		t3.setLivesAt(p3);
		t3 = repot.save(t3);
		
		Tenant t4 = new Tenant();
		t4.setName("Bethany Clarke");
		t4.setLivesAt(p3);
		t4 = repot.save(t4);
		
		p1.setHeadTenant(t1);
		p1 = repop.save(p1);
		
		p2.setHeadTenant(t2);
		p2 = repop.save(p2);
		
		PropertyManager pm1 = new PropertyManager();
		pm1.setExtension(901);
		pm1.setName("Steve Cooke");
		pm1 = repopm.save(pm1);
		
		
		pm1.setManages(new ArrayList<>());
		pm1.getManages().add(p1);
		pm1.getManages().add(p2);
		pm1 = repopm.save(pm1);
		
		pm1.setTenants(new ArrayList<>());
		pm1.getTenants().add(t1);
		pm1.getTenants().add(t2);
		pm1 = repopm.save(pm1);
		
		
		pm1.setProperty(new ArrayList<>());
		pm1.getProperty().add(p1);
		pm1.getProperty().add(p2);
		pm1 = repopm.save(pm1);
	}

}
