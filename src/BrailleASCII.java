
import java.io.PrintWriter;
public class BrailleASCII {
public static void main(String[] args){
  PrintWriter pen = new PrintWriter(System.out, true);
  
    try{
      String test = args[1];
    }catch(Exception e)
    {
      pen.println("please input both a command and something to translate");
    }//try/catch

  String command = args[0];
  String translate = args[1];
  pen.println(translate);


  if(command.equals("braille")){
    for(int i = 0; i < translate.length(); i++){
    pen.print(" " + BrailleASCIITables.toBraille(translate.charAt(i)));
    pen.flush();
    }
  } else if (command.equals("ASCII")){
    pen.println(BrailleASCIITables.toASCII(translate));
  } else if (command.equals("Unicode")){
    pen.println((char) Integer.parseInt(BrailleASCIITables.toUnicode(translate), 16));
  } else{
    pen.println("please input a valid command ");
  }
   
  
  }//main
  
}
