package com.example.springboot_hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot_hibernate.entity.AadhaarCard;
import com.example.springboot_hibernate.entity.Flight;
import com.example.springboot_hibernate.entity.IndigoFlight;
import com.example.springboot_hibernate.entity.Person;
import com.example.springboot_hibernate.entity.Pilot;
import com.example.springboot_hibernate.entity.School;
import com.example.springboot_hibernate.entity.Student;
import com.example.springboot_hibernate.repository.AadhaarCardRepository;
import com.example.springboot_hibernate.repository.FlightRepository;
import com.example.springboot_hibernate.repository.IndigoFlightRepository;
import com.example.springboot_hibernate.repository.PersonRepository;
import com.example.springboot_hibernate.repository.SchoolRepository;

@SpringBootApplication
public class SpringbootHibernateApplication implements CommandLineRunner {
	
	@Autowired
	private FlightRepository repo;
	@Autowired
	private IndigoFlightRepository indigoRepo;
	
	@Autowired
	private AadhaarCardRepository acRepo;
	@Autowired
	private PersonRepository pRepo;
	
	@Autowired
	private SchoolRepository schoolRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addFlights();
		addOneToOneDemo();
		addOneToManyDemo();
	}
	
	private void addOneToManyDemo(){
		Student s1 = new Student();
		Student s2 = new Student();
		
		School school = new School();
		
		s1.setId(01);
		s1.setName("Aviral");
		s1.setSchool(school);
		
		s2.setId(02);
		s2.setName("Someone");
		s2.setSchool(school);
		
		school.setSchoolId(270);
		school.setSchoolName("DPSG, Gurgaon");
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		school.setListOfStudents(students);
		
		schoolRepo.save(school);
	}
	
	private void addOneToOneDemo() {
		AadhaarCard ac = new AadhaarCard();
		Person p = new Person();
		
		ac.setAadhaarNum(12456L);
		ac.setAddress("Pune");
		ac.setP(p);
		
		p.setId(69);
		p.setAc(ac);
		p.setAge(25);
		p.setName("Aviral");
		
		acRepo.save(ac);
		pRepo.save(p);
	}
	
	private void addFlights() {
		Pilot p = new Pilot();
		p.setName("Aviral");
		p.setAge(29);
		
		Flight f = new Flight();
		f.setId(123);
		f.setPrice(5000);
		f.setSource("U.S.A");
		f.setDestination("India");
		f.setAvailableSeats(80);
		f.setPilot(p);
		
		repo.save(f);
		
		Pilot p1 = new Pilot();
		p1.setName("Bro");
		p1.setAge(20);
		Pilot p2 = new Pilot();
		p2.setName("Aviral");
		p2.setAge(29);
		
		IndigoFlight indigoFlight = new IndigoFlight();
		indigoFlight.setId(123);
		indigoFlight.setPrice(5000);
		indigoFlight.setSource("U.S.A");
		indigoFlight.setDestination("India");
		indigoFlight.setP1(p1);
		indigoFlight.setP2(p2);
		
		indigoRepo.save(indigoFlight);
	}

}
