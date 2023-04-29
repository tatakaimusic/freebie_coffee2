package ru.test.freebie_coffee2;

import ru.test.freebie_coffee2.models.Person;

import java.util.List;

public class PersonTestData {
    public static final MatcherFactory.Matcher<Person> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator("registered", "password");

    public static final Integer ADMIN_iD = 100000;

    public static final Integer USER_ID = ADMIN_iD + 1;

    public static final Integer NOT_FOUND = ADMIN_iD + 10;

    public static final Person ADMIN = new Person(ADMIN_iD, "admin", "nikitamasslennikov@mail.ru", "asdfg", "ROLE_ADMIN");

    public static final Person USER = new Person(USER_ID, "user", "gal.117@yandex.ru", "asdfg", "ROLE_USER");

    public static Person getNew() {
        return new Person(null, "new", "new@mail.ru", "newPass");
    }

    public static Person getUpdated() {
        Person person = new Person();
        person.setId(ADMIN.getId());
        person.setName(ADMIN.getName());
        person.setEmail(ADMIN.getEmail());
        person.setPassword(ADMIN.getPassword());
        person.setRole(ADMIN.getRole());
        return person;
    }

    public static List<Person> allPerson = List.of(ADMIN, USER);

}
