package org;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.vavr.Function1;
import io.vavr.Function2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.PersonTestSupplier.*;

public class Step2AndThen {

	/**
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">Function</a>
	 */
	@Test
	public void functions() {
		Function<Person, String> toName = Person::getFirstName;
		Function<Person, Integer> toNameLength = toName
				.andThen(String::length);

		people()
				.stream()
				.map(toNameLength)
				.forEach(System.out::println);
	}

	/**
	 * @see <a href="https://static.javadoc.io/io.vavr/vavr/0.9.2/index.html?io/vavr/Function0.html">Function0</a>
	 */
	@Test
	public void functionsVavrTease() {
		Function1<Person, Integer> toNameLength = Function1.of(Person::getFirstName)
				.andThen(String::length);

		people()
				.stream()
				.map(toNameLength)
				.forEach(System.out::println);
	}

	@Test
	public void predicates() {
		Predicate<Person> startsWithJOrB = firstNameStartsWithPred("J")
				.or(firstNameStartsWithPred("L"));

		Predicate<Person> startsWithJAndB = firstNameStartsWithPred("J")
				.and(firstNameStartsWithPred("L"));

		Predicate<Person> doesNotStartsWithJorB = startsWithJAndB
				.negate();
	}

	private Predicate<Person> firstNameStartsWithPred(String prefix){
		return p -> firstNameStartsWith(p, prefix);
	}

	private boolean firstNameStartsWith(Person p, String prefix){
		return p.getFirstName().startsWith(prefix);
	}
}
