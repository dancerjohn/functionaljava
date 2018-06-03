package org;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;

public class PersonTestSupplier {

    public static Person john(){
        return Person.builder()
                .firstName("John")
                .lastName("Doe")
                .address(Person.Address.builder()
                        .street1("915 some street")
                        .city("Baltimore")
                        .state(Person.State.MD)
                        .zip("89123")
                        .build())
                .build();
    }

    public static Person jean(){
        return Person.builder()
                .firstName("Jean")
                .lastName("Due")
                .address(Person.Address.builder()
                        .street1("Rue St Denise")
                        .city("Paris")
                        .state(Person.State.PARIS)
                        .build())
                .build();
    }

    public static Person rich(){
        return Person.builder()
                .firstName("Richy")
                .lastName("Rich")
                .address(Person.Address.builder()
                        .street1("10 Downing St.")
                        .city("London")
                        .state(Person.State.LONDON)
                        .build())
                .address(Person.Address.builder()
                        .street1("The Strip")
                        .city("Las Vegas")
                        .state(Person.State.NV)
                        .build())
                .build();
    }

    public static List<Person> people(){
        return Lists.newArrayList(john(), jean(), rich());
    }
}
