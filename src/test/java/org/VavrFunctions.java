package org;

import java.util.UUID;
import java.util.function.Function;

import com.google.common.collect.Lists;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function4;
import io.vavr.collection.List;
import org.Person.Address;
import org.Person.Car;
import org.Person.Make;
import org.junit.jupiter.api.Test;

public class VavrFunctions {

	public static String getANewUuid(String input){
		return UUID.randomUUID().toString();
	}

	@Test
	public void testMemoize(){
		Function1<String, String> myFunc = Function1.of(VavrFunctions::getANewUuid)
				.memoized();

		List.of(myFunc.apply("A"),
				myFunc.apply("A"),
				myFunc.apply("A"),
				myFunc.apply("B"),
				myFunc.apply("A"))
				.forEach(System.out::println);
	}

	@Test
	public void test2(){
		Function4<String, String, java.util.List<Address>, Car, Person> f4 = Function4.of(Person::new);
		Function1<Car, Person> f1 = f4.apply("John", "Butler", Lists.newArrayList());

		List.of(f1.apply(new Car(Make.BMW, "X5", 54900)),
				f1.apply(new Car(Make.FORD, "F150", 125000)))
				.forEach(System.out::println);
	}

	private Function<Car, Person> iKnowYou(String first, String last, java.util.List<Address> add){
		return p -> new Person(first, last, add, p);
	}
}
