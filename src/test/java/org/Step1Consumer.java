package org;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.PersonTestSupplier.*;

public class Step1Consumer {

	@DisplayName("Try using a consumer")
	@Test
	public void consumer() {
		// void accept()
		Consumer<Person> con = p -> System.out.println(p.getFirstName());

		people().forEach(con);

		people().forEach(p -> System.out.println(p.getFirstName()));
	}

	@DisplayName("Try using a consumer")
	@Test
	public void consumer2() {
		people().forEach(
				System.out::println);
	}

	/////////////////////////////////////////
	// Predicate

	@Test
	public void tryThis() {
		// boolean test(T input)
		Predicate<Person> pred = p -> p.getFirstName().startsWith("J");

		people()
				.stream()
				.filter(pred)
				.forEach(System.out::println);
	}

	/////////////////////////////////////////
	// Function

	@Test
	public void tryThis2() {
		// R apply(T input)
		Function<Person, String> func = p -> p.getFirstName();
		func = Person::getFirstName;

		people()
				.stream()
				.map(func)
				.forEach(System.out::println);

		// via method reference
		people()
				.stream()
				.map(Person::getFirstName)
				.forEach(System.out::println);
	}

	/////////////////////////////////////////
	// Supplier

	@Test
	public void tryThis3() {
		// T get()
		Supplier<Double> s = () -> Math.random();
		s = Math::random;

		for (int i=1; i < 5; i++){
			System.out.println(s.get());
		}
	}

	/////////////////////////////////////////
	// BiFunction

	@Test
	public void tryThisBiFunction() {
		BiFunction<Person, Person, String> bi =
				(x,y) -> x.getFirstName() + y.getFirstName();

		System.out.println(bi.apply(john(), rich()));
	}

	/////////////////////////////////////////
	// BiOperator

	@Test
	public void tryThisBinaryOperator() {
		// T apply (T first, T second)
		BinaryOperator<String> bi = (a,b) -> a + b;
		bi = String::concat;

		Optional<String> result = people()
				.stream()
				.map(Person::getFirstName)
				.reduce(bi);
		System.out.println(result.get());
	}
}
