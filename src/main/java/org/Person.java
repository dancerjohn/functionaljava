package org;

import com.sun.istack.internal.Nullable;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Person {

    @Getter
    public enum Continent{
        NORTH_AMERICA, EUROPE, ASIA
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public enum Country{
        USA(Continent.NORTH_AMERICA),
        UK(Continent.EUROPE),
        FRANCE(Continent.EUROPE),
        INDIA(Continent.ASIA);

        private final Continent continent;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public enum State{
        MD(Country.USA),
        NV(Country.USA),
        LONDON(Country.UK),
        PARIS(Country.FRANCE);

        private final Country country;
    }

    @Data
    @Builder
    public static class Address{
        @NonNull
        private final String street1, city;
        @NonNull
        private final State state;
        @Nullable
        private final String zip;
    }

    public enum Make{
        VW, BMW, FORD
    }

    @Data
    @Builder
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    public static class Car{
        private final Make make;
        private final String color;
        private final int mileage;
    }

    public static abstract class Animal{}

    @Data
    @Builder
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    public static class Cat extends Animal{
        private final String name;
    }

    @Data
    @Builder
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    public static class Dog extends Animal{
        private final String name;
    }

    @NonNull
    private final String firstName, lastName;

    @NonNull
    @Singular
    private final List<Address> addresses;

    @Nullable
    private final Car car;
}

