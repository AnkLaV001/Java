package Lesson7.Lesson8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoObject {
    @JsonProperty("locality")
    Locality LocalityObject;

    public Locality getLocalityObject() {
        return LocalityObject;
    }

    public void setLocalityObject(Locality localityObject) {
        LocalityObject = localityObject;
    }
}
