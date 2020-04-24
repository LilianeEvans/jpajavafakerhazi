package person;

import com.github.javafaker.Faker;
import java.time.ZoneId;

public class Main {

    public static Person randomPerson()
    {
        Faker faker = new Faker();

        Person person = new Person();
        Address address = new Address();

        java.util.Date date;
        date = faker.date().birthday();
        java.time.LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        address = Address.builder()
                .country(faker.address().country())
                .state(faker.address().state())
                .city(faker.address().city())
                .streetAddress(faker.address().streetAddress())
                .zip(faker.address().zipCode())
                .build();

        person = Person.builder()
                .profession(faker.company().profession())
                .dob(localDate)
                .email(faker.internet().emailAddress())
                .name(faker.name().fullName())
                .address(address)
                .gender(faker.options().option(Person.Gender.class))
                .build();

        return person;
    }

    public static void main(String[] args) {


        for(int i=0; i < 10; i++)
        {
            System.out.println(Main.randomPerson());
        }




    }
}
