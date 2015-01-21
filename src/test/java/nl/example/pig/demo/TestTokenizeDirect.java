package nl.example.pig.demo;

import nl.example.pig.demo.myudf.Tokenize;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.junit.Test;

import java.util.Iterator;

import static org.apache.pig.builtin.mock.Storage.tuple;
import static org.junit.Assert.assertEquals;

public class TestTokenizeDirect {

  /**
   * Basic example on how to test a UDF directly.
   * @throws Exception
   */
  @Test
  public void testTokenizeUsingDirectMethod() throws Exception {
    Tokenize tokenizer = new Tokenize();

    Tuple input = TupleFactory.getInstance().newTuple(1);
    input.set(0, "one two three");
    DataBag out = tokenizer.exec(input);

    assertEquals("Wrong output size", 3, out.size());

    // Check the results
    Iterator<Tuple> outIter = out.iterator();
    assertEquals("Missing One",   tuple("one"),   outIter.next());
    assertEquals("Missing Two",   tuple("two"),   outIter.next());
    assertEquals("Missing Three", tuple("three"), outIter.next());
  }

}
