import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws UnknownHostException {
        Integer[] numar=new Integer[2];
        int nr1, nr2, var1;
        Scanner sc=new Scanner(System.in);
       try(Socket s=new Socket("127.0.0.1",1080)) {
           Scanner sc1 = new Scanner(s.getInputStream());
           System.out.println("Introduceti numerele:");
           System.out.print("nr1 = ");
           nr1 = sc.nextInt();
           System.out.print("nr2 = ");
           nr2 = sc.nextInt();
           PrintStream p = new PrintStream(s.getOutputStream());
           p.println(nr1);
           p.println(nr2);

           var1 = sc1.nextInt();
           System.out.println(var1);
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }
}