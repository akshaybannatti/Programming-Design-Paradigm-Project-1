package document;

import static java.lang.Math.max;

/**
 * This class implements the TextDocument interface and uses the least common subsequence for diff
 * and least substring for commonSubText.
 */
public class TextDocumentImpl implements TextDocument {
  private final String text;

  /**
   * I created a constructor.
   *
   * @param insertText input string
   */
  public TextDocumentImpl(String insertText) {
    this.text = insertText;
  }

  @Override
  public String getText() {
    return this.text;
  }

  /**
   * To get the word count I am splitting the text and getting the length.
   *
   * @return count of text.
   */
  @Override
  public int getWordCount() {
    return this.text.split("\\s+").length;
  }

  /**
   * Getting the word count.
   *
   * @param str1 String 1
   * @param str2 String 2
   * @return word count.
   */
  private int[][] lcsTable(String str1, String str2) {

    int[][] lcsTable = new int[str1.length() + 1][str2.length() + 1];

    for (int row = 1; row <= str1.length(); row++) {


      for (int col = 1; col <= str2.length(); col++) {


        if (str1.charAt(row - 1) == str2.charAt(col - 1)) {


          lcsTable[row][col] = lcsTable[row - 1][col - 1] + 1;


        } else {


          lcsTable[row][col] = Math.max(lcsTable[row - 1][col], lcsTable[row][col - 1]);
        }
      }
    }
    return lcsTable;
  }


  @Override
  public String minusDiff(TextDocument other) {

    String str1 = this.getText();

    String str2 = other.getText();

    StringBuilder removedChars = new StringBuilder();

    int[][] lcsMatrix = lcsTable(str1, str2);

    int row = str1.length();

    int col = str2.length();

    while (row > 0 && col > 0) {

      if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
        row--;
        col--;
      } else if (lcsMatrix[row - 1][col] >= lcsMatrix[row][col - 1]) {
        removedChars.append(str1.charAt(row - 1));
        row--;
      } else {
        col--;
      }
    }

    while (row > 0) {
      removedChars.append(str1.charAt(row - 1));
      row--;
    }

    return removedChars.reverse().toString();
  }

  @Override
public String plusDiff(TextDocument other) {

    String str1 = this.getText();

    String str2 = other.getText();

    StringBuilder addChars = new StringBuilder();

    int[][] lcsMatrix = lcsTable(str1, str2);

    int row = str1.length();

    int col = str2.length();

    while (row > 0 && col > 0) {

      if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
        row--;
        col--;
      } else if (lcsMatrix[row - 1][col] >= lcsMatrix[row][col - 1]) {
        row--;
      } else {
        addChars.append(str2.charAt(col - 1));

        col--;
      }
    }

    while (col > 0) {
      addChars.append(str1.charAt(col - 1));
      col--;
    }

    return addChars.reverse().toString();
  }
}

