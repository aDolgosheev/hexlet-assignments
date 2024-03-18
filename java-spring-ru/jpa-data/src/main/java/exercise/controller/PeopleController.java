package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person show(@PathVariable long id) {
        return personRepository.findById(id).get();
    }

    // BEGIN

    @GetMapping
    public List<Person> showList() {
        return personRepository.findAll();
    }

    @PostMapping
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable long id) {
        personRepository.deleteById(id);
    }
    // END
}
