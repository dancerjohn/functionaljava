package org;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.PersonTestSupplier.*;

public class PersonTest {

    @Test
    public void consumer(){
        people().forEach(
                p -> System.out.println(p.getFirstName())
        );

        System.out.println(
                Lists.transform(people(), Person::getFirstName)
        );
    }


    @Test
    public void predicate(){
      List<Person.Address> addresses = people().stream()
                .flatMap(p -> p.getAddresses().stream())
                .collect(Collectors.toList());

      Iterables.filter(addresses, p -> p.getState().getCountry() == Person.Country.FRANCE);
    }
}