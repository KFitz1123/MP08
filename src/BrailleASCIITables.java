import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;


public class BrailleASCIITables {
  static PrintWriter pen = new PrintWriter(System.out, true);


  public static String toBraille(char letter){

String ASCII = "0" + Integer.toBinaryString((int) 'h');
BitTree AtoB = new BitTree(8);
File Atobee = new File("src/AtoB.txt");
String braille = null;
try{
InputStream A2B = new FileInputStream(Atobee); 
AtoB.load(A2B);
braille = AtoB.get(ASCII);
}catch (Exception e){
 return "File is invalid";
}
return braille;


  }//toBraille

  public static String toASCII(String bits){

BitTree toA = new BitTree(8);
File toAy = new File("src/BtoA.txt");
String ski = null;
try{
InputStream A2B = new FileInputStream(toAy); 
toA.load(A2B);
ski = toA.get(bits);
}catch (Exception e){
 return "File is invalid";
}
return ski;
  }//toASCII


  public static String toUnicode(String bits) {

    BitTree toU = new BitTree(8);
    File toYu = new File("src/BtoU.txt");
    String Yuen = null;
    try{
    InputStream A2B = new FileInputStream(toYu); 
    toU.load(A2B);
    Yuen = toU.get(bits);
    }catch (Exception e){
     return "File is invalid";
    }
    return Yuen;
      }//toASCII

}