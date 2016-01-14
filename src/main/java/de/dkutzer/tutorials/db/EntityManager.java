package de.dkutzer.tutorials.db;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.eclipse.jetty.util.ConcurrentHashSet;

import de.dkutzer.tutorials.api.Person;

public final class EntityManager {

    private static Collection<Person> persons = new ConcurrentHashSet<>();

    public static Person getPersonById(final int id) {
        final Optional<Person> findFirst = persons.stream().filter(p -> {
            return p.getId() == id;
        }).findFirst();
        return findFirst.get();
    }

    public static void create(final Person p) {
        persons.add(p);
    }

    public static void update(final Person p) {
        final Person personById = getPersonById(p.getId());
        if (personById != null) {
            persons.remove(personById);
        }
        persons.add(p);
    }


    public static Collection<Person> findAll() {
        return new HashSet<>(persons);
    }

}
