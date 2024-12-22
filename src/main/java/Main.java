import Models.Person;

public class Main {
    public static void main(String[] args) {
        var person = new Person();
        person.SecondName = "FirstName";
        person.Person = new Person();
        person.Person.SecondName = "Second-SecondName";
        person.setAge(20);
        person.Person.setAge(90);

        System.out.println(JsonSerializer.Serialize(person));
    }
}
