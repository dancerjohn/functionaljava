package org;

import java.util.List;

public interface PersonDao {

	List<Person> getPeople();

	void update(Person p);

	Person getByName(String name);
}
