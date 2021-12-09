package Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TriangleAreaTest {
    @Test
    //@DisplayedName ("") При добавлении пишет "Cannot resolve symbol 'DisplayedName'"
    void calculateAreaWenAllNumberIsNotNull(){
        System.out.println("");
        Assertions.assertEquals(TriangleArea.formulaTriangleArea(3, 4, 5), 6.0);
    }

}
