package Models;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;

import java.util.List;

@JsonSerializable
public class Person {
    @JsonProperty(Name = "secondName")
    public String SecondName;

    @JsonProperty(Name = "person")
    public Person Person;

    @JsonProperty(Name = "age")
    private int Age;

//    @JsonProperty(Name = "list")
    public List<String> Names = List.of("Hello", "Hello1");

//    @JsonProperty(Name = "list2")
    public int[] Ages = new int[] {1, 3, 4};

    public void setAge(int age) {
        Age = age;
    }
}
