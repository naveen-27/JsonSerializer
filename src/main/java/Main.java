import Models.Person;

public class Main {
    public static void main(String[] args) {
        var person = new Person();
        person.SecondName = 13;
        person.Person = new Person();
        person.Person.SecondName = 34;

        System.out.println(JsonSerializer.Serialize(person));
    }
}
