import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        int nr1, nr2, var1;
        System.out.println("listening...");
        try(ServerSocket s1=new ServerSocket(1080);
            Socket ss = s1.accept()) {
            System.out.println("Client connected!");
            Scanner sc = new Scanner(ss.getInputStream());
            nr1 = sc.nextInt();
            nr2 = sc.nextInt();
            var1 = nr1 + nr2;

            PrintStream p = new PrintStream(ss.getOutputStream());
            p.println(var1);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}