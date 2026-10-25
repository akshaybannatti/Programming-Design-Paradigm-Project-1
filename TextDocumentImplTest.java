import static java.awt.SystemColor.text;
import static org.junit.Assert.assertEquals;

import document.TextDocumentImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the tests for @code TextDocumentImpl.
 */



public class TextDocumentImplTest {
  private TextDocumentImpl directory1;
  private TextDocumentImpl directory2;


  /**
   * created text directory before every text used.
    */


  @Before
  public void setUp() {
    directory1 = new TextDocumentImpl("Hi Akshay");
    directory2 = new TextDocumentImpl("Hello Akshay");
  }



  @Test
  public void testGetText() {
    assertEquals("Hi Akshay", directory1.getText());
  }

  @Test
  public void testWordCount() {
    assertEquals(2, directory1.getWordCount());
  }

  @Test
  public void testminusDiff() {
    assertEquals("i", directory1.minusDiff(directory2));
  }


  @Test
  public void testplusDiff() {
    assertEquals("ello", directory1.plusDiff(directory2));
  }

  @Test
  public void testEmptyStringtext() {
    TextDocumentImpl emptyText = new Text = new TextDocumentImpl("");
    assertEquals("", emptyText.getText());
    assertEquals(0, emptyText.getWordCount());
  }

  @Test
  public void testEmptyStringDiff() {
    TextDocumentImpl emptyText1 = new TextDocumentImpl("");
    TextDocumentImpl emptyText2 = new TextDocumentImpl("");
    assertEquals("", emptyText1.minusDiff(emptyText2));
    assertEquals("", emptyText1.plusDiff(emptyText2));

  }

  @Test
  public void testOneEmptyStringMinusDiff() {
    TextDocumentImpl emptyText = new TextDocumentImpl("");
    TextDocumentImpl text2 = new TextDocumentImpl("");
    assertEquals("Hello", emptyText.minusDiff(text));
  }

  @Test
  public void testOneEmptyStringPlusDiff() {
    TextDocumentImpl emptyText = new TextDocumentImpl("");
    TextDocumentImpl text = new TextDocumentImpl("Hello");
    assertEquals("Hello", emptyText.plusDiff(text));
  }

  @Test
  public void testIdenticalStringMinusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello Akshay");
    TextDocumentImpl text2 = new TextDocumentImpl("Hello Akshay");
    assertEquals("", text.MinusDiff(text2));
  }

  @Test
  public void testIdenticalStringsPlusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello Akshay");
    TextDocumentImpl text2 = new TextDocumentImpl("Hello Akshay");
    assertEquals("", text1.plusDiff(text2));
  }

  @Test
  public void testNoCommonSubsequenceMinusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Peach");
    TextDocumentImpl text2 = new TextDocumentImpl("Pineapple");
    assertEquals("Peach", text1.minusDiff(text2));
  }

  @Test
  public void testNoCommonSubsequencePlusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Peach");
    TextDocumentImpl text2 = new TextDocumentImpl("Pineapple");
    assertEquals("Peach", text1.plusDiff(text2));
  }

  @Test
  public void testDifferentLengthMinusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hi, Akshay");
    TextDocumentImpl text2 = new TextDocumentImpl("Hi");
    assertEquals("Akshay", text1.minusDiff(text2));
  }

  @Test
  public void testDifferentLengthPlusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hi");
    TextDocumentImpl text2 = new TextDocumentImpl("Hi Akshay");
  }

  @Test
  public void testLargeInputStringsMinusDiff() {
    String largeText1 = "A".repeat(10000);
    String largeText2 = "A".repeat(5000) + "B".repeat(5000);
    TextDocumentImpl text1 = new TextDocumentImpl(LargeText1);
    TextDocumentImpl text2 = new TextDocumentImpl(largeText2);
    assertEquals("A".repeat(5000), text1.minusDiff(text2));
  }

  @Test
  public void testLargeInputStringsPlusDiff() {
    String largeText1 = "A".repeat(5000);
    String largeText2 = "A".repeat(10000);
    TextDocumentImpl text1 = new TextDocumentImpl(largeText1);
    TextDocumentImpl text2 = new TextDocumentImpl(largeText2);
    assertEquals("A".repeat(5000), text1.plusDiff(text2));
  }

  @Test
  public void testDifferentCharactersMinusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello");
    TextDocumentImpl text2 = new TextDocumentImpl("Hillo");
    assertEquals("e", text1.minusDiff(text2));
  }

  @Test
  public void testDifferentCharactersPlusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello");
    TextDocumentImpl text2 = new TextDocumentImpl("Hillo");
    assertEquals("i", text1.plusDiff(text2));
  }

  @Test
  public void testSingleCharacterMutationMinusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello");
    TextDocumentImpl text2 = new TextDocumentImpl("Hullo");
    assertEquals("e", text1.minusDiff(text2));
  }

  @Test
  public void testSingleCharacterMutationPlusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello");
    TextDocumentImpl text2 = new TextDocumentImpl("Hullo");
    assertEquals("u", text1.plusDiff(text2));
  }

  @Test
  public void testNoMatchingCharactersMinusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello");
    TextDocumentImpl text2 = new TextDocumentImpl("Hillo");
    assertEquals("e", text1.minusDiff(text2));
  }

  @Test
  public void testNoMatchingCharactersPlusDiff() {
    TextDocumentImpl text1 = new TextDocumentImpl("Hello");
    TextDocumentImpl text2 = new TextDocumentImpl("Hillo");
    assertEquals("i", text1.plusDiff(text2));
  }

}

