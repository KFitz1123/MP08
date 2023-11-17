
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class BitTree {
int depth;
BitTreeNode root;
BitTreeNode current;
  public BitTree(int depth){
    this.depth = depth;
    this.root = new BitTreeNode(null, null);
    this.current = root;
  }



  public void set(String bits, String value) throws Exception {
    this.current = this.root;

    for(int i = 0; i < depth; i++){
      char bit = bits.charAt(i);
      if(bit == '0'){
        if (i >= depth - 1){
          if(this.current.left == null){
          this.current.left = new BitTreeNode(bits, value);
        }else{
          this.current.left.value = value;
        }
        } else if(this.current.left == null){
          this.current.left = new BitTreeNode(bits.substring(0,i+1), null);
          this.current = this.current.left;
          } else{
          this.current = this.current.left;
            } 
      }else if(bit == '1'){
        if (i >= depth - 1){
          if(this.current.right == null){
            this.current.right = new BitTreeNode(bits, value);
          }else{
            this.current.right.value = value;
            }
        } else if(this.current.right == null){
          this.current.right = new BitTreeNode(bits.substring(0,i+1), null);
          this.current = this.current.right;
        }  else{
          this.current = this.current.right;
              }
      }
        else {

          this.current = this.root;
          throw new Exception("Invalid bit input");
        }
    }//for 
    this.current = this.root;
  }//set

  public String get(String bits) throws Exception{

    this.current = this.root;
    for(int i = 0; i < depth; i++){
      char bit = bits.charAt(i);
      if(bit == '0'){
        if (i >= depth - 1){
         return this.current.left.value;
        } else{
          this.current = this.current.left;
            } 
      }else if(bit == '1'){
        if (i >= depth - 1){
          return this.current.right.value;
        } else{
          this.current = this.current.right;
              }
      }
        else {
          throw new Exception("Invalid bit input");
          
        }
       
    }//for 
   return "worse than null";
  }//get
  public void dump(PrintWriter pen, String bits, BitTreeNode node){
    
      if(bits.length() != this.depth)
      {
        
        BitTreeNode right = node.right;
        BitTreeNode left = node.left;
        if(left != null)
          this.dump(pen, bits + "0", left);
        if(right != null)
          this.dump(pen, bits + "1", right);

      }else{
        pen.println(node.value);
      }//else
  }//dump
public void load(InputStream source){
Scanner eye = new Scanner(source);
String next;
String path;
String data;
int cut;
 
  while(eye.hasNext()){
    next = eye.nextLine();
    cut = next.lastIndexOf(',');
    path = next.substring(0,cut);
    data = next.substring(cut + 1, next.length());
    try{
      this.set(path, data);
    }catch(Exception e){
      System.out.println("source is invalid");
    }
  }
  eye.close();
}//load
} // class BitTree

