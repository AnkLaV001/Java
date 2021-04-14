package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fact {
    private int temp;
    private String condition;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getCondition() {
        switch (this.condition){
            case "overcast":
                condition = "пасмурно";
                break;
            case "clear":
                condition = "ясно";
                break;
            case "rain":
                condition = "rain";
                break;
            default:
                break;
        }
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
