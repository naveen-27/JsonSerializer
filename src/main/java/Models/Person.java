package Models;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;

@JsonSerializable
public class Person {
    @JsonProperty(Name = "secondName")
    public String SecondName;

    @JsonProperty(Name = "person", IgnoreIfNull = true)
    public Person Person;

    @JsonProperty(Name = "age")
    private int Age;

    @JsonProperty(Name = "list")
    public String[] Names = new String[] {"Hello", "Hello1"};

    @JsonProperty(Name = "list2")
    public int[] Ages = new int[] {1, 3, 4};

    @JsonProperty(Name = "People")
    public Person[] People;

    public void setAge(int age) {
        Age = age;
    }
}
