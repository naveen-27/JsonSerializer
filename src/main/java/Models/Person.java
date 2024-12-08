package Models;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;

@JsonSerializable
public class Person {
    @JsonProperty(Name = "secondName")
    public String SecondName;

    @JsonProperty(Name = "person")
    public Person Person;

    @JsonProperty(Name = "age")
    private int Age;
}
