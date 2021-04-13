package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJson {
    @JsonProperty("fact")
    Fact FactObject;

    public Fact getFactObject() {
        return FactObject;
    }

    public void setFactObject(Fact factObject) {
        FactObject = factObject;
    }
}
