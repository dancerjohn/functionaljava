package org;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class PersonService {
	private PersonDao dao;

	private Supplier<List<Person>> getter;

	private Function<String, Person> getByName;

	private void myMethod(){
		dao.getByName("SomeName");
		getByName.apply("SomeName");
	}
}
