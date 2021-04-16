package Lesson7;

import Lesson7.Lesson8.GeoObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJson {
    @JsonProperty("fact")
    Fact FactObject;
    @JsonProperty("geo_object")
    GeoObject GeoObjectObject;

    public Fact getFactObject() {
        return FactObject;
    }

    public void setFactObject(Fact factObject) {
        FactObject = factObject;
    }

    public GeoObject getGeoObjectObject() {
        return GeoObjectObject;
    }

    public void setGeoObjectObject(GeoObject geoObjectObject) {
        GeoObjectObject = geoObjectObject;
    }
}
