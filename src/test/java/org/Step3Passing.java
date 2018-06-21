package org;

import java.util.function.Function;

import org.Person.Animal;
import org.Person.Cat;
import org.Person.Dog;
import org.junit.jupiter.api.Test;

public class Step3Passing {


	public Animal adopt(Function<String, Animal> creator){
		return creator.apply("Fluffy");
	}

	@Test
	public void testCat(){
		System.out.println(adopt(Cat::new));
	}

	@Test
	public void testDog(){
		System.out.println(adopt(Dog::new));
	}
}
