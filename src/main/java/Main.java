import Models.Person;

public class Main {
    public static void main(String[] args) {
        var person = new Person();
        person.SecondName = "Kumar";
        person.Person = new Person();
        person.Person.SecondName = "Second-SecondName";

        System.out.println(JsonSerializer.Serialize(person));
    }
}
