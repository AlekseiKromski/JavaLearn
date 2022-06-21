package space.alekseikromski.springcourse.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import space.alekseikromski.springcourse.models.Person;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index(){
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

    public Person show(int id ){
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Person VALUES (" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() +",'" + person.getEmail() +"')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void edit(int id, Person person) {

    }

    public void delete(int id) {
    }
}
