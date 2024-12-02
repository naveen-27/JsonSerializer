package Models;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;

@JsonSerializable
public class Person {
    @JsonProperty(Name = "secondName")
    public int SecondName;

    @JsonProperty(Name = "person")
    public Person Person;
}
