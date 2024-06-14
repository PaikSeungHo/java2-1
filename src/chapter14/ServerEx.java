package chapter14;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx{
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket= null;
        Scanner scanner= new Scanner(System.in); 
        try {

            listener = new ServerSocket(9999); 
            System.out.println("연결을기다리고있습니다.....");
            socket = listener.accept(); 
            System.out.println("연결되었습니다.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String inputMessage= in.readLine();
                if (inputMessage.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트에서bye로연결을종료하였음");
                    break; 
                }
                System.out.println("클라이언트: " + inputMessage);
                System.out.print("보내기>>"); 
                String outputMessage= scanner.nextLine(); 
                out.write(outputMessage+ "\n"); 
                out.flush(); 
            }
        } catch (IOException e) { System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close(); 
                socket.close(); 
                listener.close(); 
            } catch (IOException e) { System.out.println("클라이언트와채팅중오류가발생했습니다."); }
        }
    }
}
