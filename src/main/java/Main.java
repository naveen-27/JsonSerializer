import Models.Person;

public class Main {
    public static void main(String[] args) {
        var person = new Person();
        var person2 = new Person();
        person2.SecondName = "Person2";
        person2.setAge(23);

        person.SecondName = "FirstName";
        person.Person = new Person();
        person.People = new Person[] {person2, person2};
        person.Person.SecondName = "Second-SecondName";
        person.setAge(20);
        person.Person.setAge(90);

        System.out.println(JsonSerializer.Serialize(person));
    }
}
