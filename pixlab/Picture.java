import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroRed() {
      Pixel[][] image = this.getPixels2D();
      for (Pixel[] row : image) {
          for(Pixel p : row) {
              int red = p.getRed();
              p.setRed(0);
            }
        }
    }
    
  public void zeroGreen() {
      Pixel[][] imagu = this.getPixels2D();
      for (Pixel[] row : imagu) {
          for(Pixel pix : row) {
              int green = pix.getGreen();
              pix.setGreen(0);
            }
        }
    }
    
  public void keepOnlyBlue() {
        zeroRed();
        zeroGreen();
    }
    
  public void negate() {
      Pixel[][] image = this.getPixels2D();
      for (Pixel[] row : image) {
          for (Pixel nignogs : row) {
            nignogs.setRed(255-nignogs.getRed());
            nignogs.setGreen(255-nignogs.getGreen());
            nignogs.setBlue(255-nignogs.getBlue());
            }
        }
    }
    
  public void grayscale() {
      Pixel[][] image = this.getPixels2D();
      for (Pixel[] row : image) {
          for (Pixel dingdongs : row) {
            int average = ((dingdongs.getRed() + dingdongs.getBlue() + dingdongs.getGreen())/3);
            dingdongs.setRed(average);
            dingdongs.setGreen(average);
            dingdongs.setBlue(average);
            }
        }
    }
  
  public void fixUnderwater() {
      Pixel[][] pixels  = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
        for (Pixel p : rowArray)
            p.setRed(p.getRed()*9);
    }
    
  public void mirrorVerticalRightToLeft() {
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for(int row = 0; row <pixels.length; row++) {
          for (int col = 0; col <width/2; col++) {
              rightPixel = pixels[row][col];
              leftPixel = pixels[row][width - col - 1];
              leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
    
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
        for (int col = 0; col < pixels[0].length; col++){
            topPixel = pixels[row][col];
            bottomPixel = pixels[height - 1 - row][col];
            topPixel.setColor(bottomPixel.getColor());
        }
 }
  
 public void mirrorDiagonal() {
     Pixel[][]pixels = this.getPixels2D();
     Pixel leftPixel = null;
     Pixel rightPixel = null;
     int max = pixels.length;

     if (pixels[0].length > max) {
         max = pixels.length;
        }
     for (int row = 0; row < max; row++) {
         for( int col = 0; col <row; col ++) {
             leftPixel = pixels[row][col];
             rightPixel = pixels[col][row];
             rightPixel.setColor(leftPixel.getColor());
            }
        }
}
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
  }
  
  public void mirrorArms() {
      Pixel topPixel = null;
      Pixel botPixel = null;
      Pixel[][] pixels = this.getPixels2D();

      // loop through the rows
      for (int row = 155; row < 191; row++) {
          // loop through the columns
          for (int col = 98; col < 169; col++) {
              topPixel = pixels[row][col];
              botPixel = pixels[191-row+191][col];
              botPixel.setColor(topPixel.getColor());
          }
      }
    }
    
  public void mirrorGull() {
     int mirrorPoint = 350;
     Pixel leftPixel = null;
     Pixel rightPixel = null;
     Pixel[][] pixels = this.getPixels2D();

     // loop through the rows
     for (int row = 225; row < 332; row++)
     {
         // loop from 13 to just before the mirror point
         for (int col = 219; col < mirrorPoint; col++)
         { 
             leftPixel = pixels[row][col];
             rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
             rightPixel.setColor(leftPixel.getColor());
         }
     }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic,int startRow, int startCol) {
      //start row and col are where we are copying on the collage
    Pixel fromPixel = null; //from the picture
    Pixel toPixel = null; //to the collage
    
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length &&
         toRow < toPixels.length; fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length 
      && toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
}
  
    public void copy(Picture fromPic,int startRow, int startCol,int fSR,int fSC,
    int fER,int fEC) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    //from variables are from pixture; to variables are to collage
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fSR, toRow = startRow; fromRow < fER && 
    toRow < toPixels.length; fromRow++, toRow++) {
      for (int fromCol = fSC, toCol = startCol; fromCol < fEC &&
      toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
   }

  /** Method to create a collage of several pictures */
  public void createCollage() {
    Picture mareep = new Picture("mareep.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(mareep,100,50,50,100,200,300);
    this.copy(mareep,350,100,50,100,200,300);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    
    this.mirrorVertical();
    //this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
