package com.jpaappj3.jpa_app;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jpaappj3.jpa_app.entities.Person;
import com.jpaappj3.jpa_app.repositories.PersonRepository;


@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner{
	
	@Autowired
	private PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create();
		// method 1: search only by the  programming languange
		// List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguage("java");
		// persons.stream().forEach(person -> System.out.println(person));
		// method 2: search by programming languange and name
		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguage("java","os");
		persons.stream().forEach(person -> System.out.println("finded: "+ person));
	}

	@Transactional
	public void create(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the name: ");
		String name = scanner.next();
		System.out.println("Type the lastname:");
		String lastname = scanner.next();
		System.out.println("Type the programming language");
		String programmingLanguange = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguange);

		Person newPerson = personRepository.save(person);
		System.out.println(newPerson);

		personRepository.findById(newPerson.getId()).ifPresent(System.out::println);
	} 

}
