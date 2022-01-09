import java.util.Arrays;

public class Tannenbaum {


  public String zeichnen(int maxHeight) {
    StringBuilder tannenbaum = new StringBuilder();
    int maxWidth = 2 * maxHeight - 1;
    char[][] canvas = new char[maxHeight][maxWidth];
    String lineSeperator = System.lineSeparator();
    for(char[] row: canvas){
      Arrays.fill(row, ' ');
    }
    canvas[0][maxWidth/2] = 'X';

    for(int currentHeight = 0; currentHeight < maxHeight; currentHeight++){
      for(int currentWidth = 0; currentWidth < maxWidth; currentWidth++) {
        if(canvas[currentHeight][currentWidth] == 'X'){
          if(currentHeight != maxHeight - 1) {
            canvas[currentHeight + 1][currentWidth] = 'X';
            canvas[currentHeight + 1][currentWidth - 1] = 'X';
            canvas[currentHeight + 1][currentWidth + 1] = 'X';
          }
        }
      }
    }


    for(char[] row: canvas){
      tannenbaum.append(Arrays.toString(row)).append(lineSeperator);
    }
    return tannenbaum.toString().replaceAll("[^0-9a-zA-Z:\\s]+", "");
  }

}
