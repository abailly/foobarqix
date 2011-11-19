public class Wrapper {

  static int BUFFER_SIZE = 1 << 13;

  public static void main(String[] args) throws Exception {
    Process p = Runtime.getRuntime().exec("runhaskell haskell/Tests.hs");
    java.io.InputStream input = p.getInputStream();
    byte[] buf = new byte[BUFFER_SIZE];
    int ln= 0;
    while((ln = input.read(buf,0,BUFFER_SIZE)) >= 0) 
      System.out.write(buf,0,ln);
    p.waitFor();
  }
}
