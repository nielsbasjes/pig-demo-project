package pigtests;

import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;
import org.apache.pig.pigunit.PigTest;

import java.io.IOException;

public class TestPigDemo_PigUnit {

  @Test
  public void testPigScriptInCodeInput() throws IOException, ParseException {
    String[] input = {
            "One\tTwo\tThree Four"
    };
    String[] arguments = {
    };

    String[] argumentFiles = {
            "src/main/resources/AccessLogs.properties"
    };

    PigTest test = new PigTest("src/main/pig/demo.pig", arguments, argumentFiles);
    String[] output = {
            "(One,Two,Three)",
            "(One,Two,Four)",
    };
    test.assertOutput("Clicks", input, "Stuff", output);
  }


  @Test
  public void testPigScriptIncludingLoader() throws IOException, ParseException {
    String[] arguments = {
            "ACCESS_LOGFORMAT='%h %l %u %t \"%r\" %>s %b \"%{Referer}i\" \"%{User-Agent}i\"'",
            "ACCESS_LOGPATH='src/test/resources/'"
    };

    PigTest test = new PigTest("src/main/pig/demo.pig", arguments);
    String[] output = {
            "(/1-500e-KWh?FoO=bAr%20BaR,PowerTick,bAr)",
            "(/1-500e-KWh?FoO=bAr%20BaR,PowerTick,BaR)",
    };

    test.assertOutput("Stuff", output);
  }

}
