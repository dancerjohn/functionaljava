package org;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class LambdaExamples {
	// From http://www.baeldung.com/java-8-lambda-expressions-tips

	@Test
	public void myLambdaExamples(){
		// Don't use parameter types
		BiFunction<String, String, String > f1 = (a, b) -> a.toLowerCase() + b.toLowerCase();
		// Not
		BiFunction<String, String, String > f2 = (String a, String b) -> a.toLowerCase() + b.toLowerCase();

		// Don't put params around single arg
		Function<String, String > f3 = a -> a.toLowerCase();
		// Not
		Function<String, String > f4 = (a) -> a.toLowerCase();

		// Don't put return statement or braces
		Function<String, String > f5 = a -> a.toLowerCase();
		// Not
		Function<String, String > f6 = a -> {return a.toLowerCase();};

		// User method references
		Function<String, String > f7 = String::toLowerCase;
		// Not
		Function<String, String > f8 = a -> a.toLowerCase();

		// effectively final
		String ag = "asfsdf";
		String aa = "sahsafs";
		aa = aa.toUpperCase();
		Function<String, String > f9 = a -> {
			return ag.toLowerCase(); // OK
			// aa.toLowerCase(); // Not OK
		};

		// Don't change state / mutate
	}
}
