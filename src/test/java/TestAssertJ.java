import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAssertJ {

    private static final HashMap<String, Integer> DEMO_MAP = new HashMap<>();
    private static final List<String> DEMO_LIST = new ArrayList<>();

    @Test
    public void testMap(){
        DEMO_MAP.put("startingFrom", 175000000);
        DEMO_MAP.put("minDownPayment", 15000);
        DEMO_MAP.put("MinMonthlyPayment", 1599);

        DEMO_LIST.add(0,"startingFrom");
        DEMO_LIST.add(1,"minDownPayment");
        DEMO_LIST.add(2,"MinMonthlyPayment");

        Assertions.assertThat(DEMO_MAP)
                .containsEntry("startingFrom",175000000)
                .containsEntry("minDownPayment",15000)
                .containsEntry("MinMonthlyPayment",1599);

        Assertions.assertThat(DEMO_MAP)
                .containsValue(15000)
                .containsValue(1599);

        Assertions.assertThat(DEMO_LIST)
                .contains("startingFrom", Index.atIndex(0))
                .contains("minDownPayment", Index.atIndex(1))
                .contains("MinMonthlyPayment", Index.atIndex(2));

        Assertions.assertThat(DEMO_LIST)
                .contains("startingFrom")
                .contains("minDownPayment")
                .contains("MinMonthlyPayment");
    }
}
