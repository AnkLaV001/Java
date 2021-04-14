package Lesson6_Anna;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class JsonForecast {
    Headline HeadlineObject;
    ArrayList< Object > DailyForecasts = new ArrayList < Object > ();


    // Getter Methods
    @JsonProperty("HeadLine")
    public Headline getHeadline() {
        return HeadlineObject;
    }

    // Setter Methods
    @JsonProperty("HeadLine")
    public void setHeadline(Headline HeadlineObject) {
        this.HeadlineObject = HeadlineObject;
    }
}
