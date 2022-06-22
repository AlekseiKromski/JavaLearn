package space.alekseikromski.springcourse.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import space.alekseikromski.springcourse.models.Person;

@Component
@ComponentScan("space.alekseikromski")
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return this.jdbcTemplate.query("SELECT * FROM Person",
                new BeanPropertyRowMapper<>(Person.class));

    }

    public Person show(int id ){
       return this.jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
               new Object[]{id},
               new BeanPropertyRowMapper<>(Person.class))
               .stream().findAny().orElse(null);

    }

    public void save(Person person) {
        this.jdbcTemplate.update("INSERT INTO Person VALUES (1, ?, ?, ?)",
            person.getName(), person.getAge(), person.getEmail());

    }

    public void edit(int id, Person person) {
       this.jdbcTemplate.update("UPDATE Person SET name=?, email=?, age=? WHERE id=?",
                person.getName(), person.getEmail(), person.getAge(), id);

    }

    public void delete(int id) {
        this.jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

    }

}
