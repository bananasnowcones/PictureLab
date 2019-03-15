/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("beach.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("sspe.jpg");
    sspe.edgeDetection(10);
    sspe.explore();
  }
  
  public static void testKeepOnlyBlue() {
      Picture beach = new Picture("beach.jpg");
      beach.keepOnlyBlue();
      beach.explore();
    }
    
  public static void testNegate(){
      Picture beach = new Picture("beach.jpg");
      beach.negate();
      beach.explore();
    }
    
  public static void testGrayscale() {
      Picture beach = new Picture("beach.jpg");
      beach.grayscale();
      beach.explore();
  }
  
  public static void testFixUnderwater() {
      Picture water = new Picture("water.jpg");
      water.fixUnderwater();
      water.explore();
    }
    
  public static void testMirrorVerticalRightToLeft() {
      Picture caterpillar = new Picture("caterpillar.jpg");
      caterpillar.mirrorVerticalRightToLeft();
      caterpillar.explore();
    }
  
  public static void testMirrorHorizontalBotToTop() {
    Picture temple = new Picture("temple.jpg");
    temple.mirrorHorizontalBotToTop();
    temple.explore();
    }
  
  public static void testMirrorDiagonal() {
    Picture beach = new Picture("beach.jpg");
    beach.mirrorDiagonal();
    beach.explore();
    }
    
  public static void testCopy(){
      Picture beach = new Picture("beach.jpg");
      Picture mareep = new Picture("mareep.jpg");
      beach.copy(mareep,100,50,50,100,200,300);
      beach.explore();
    }
 
    
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    testNegate();
    testGrayscale();
    testFixUnderwater();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontalBotToTop();
    testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    testMirrorDiagonal();
    testCollage();
    testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}