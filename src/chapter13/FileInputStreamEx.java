package chapter13;

import java.io.*;

public class FileInputStreamEx{
    public static void main(String[] args) {
        byte b[] = new byte [6]; 
        try {
            FileInputStream fin = 
                new FileInputStream("c:\\Temp\\test.out");
            int n=0, c;
            while((c = fin.read())!= -1) {
                b[n] = (byte)c; 
                n++;
            }
            
            System.out.println(
             "c:\\Temp\\test.out에서읽은배열을출력합니다.");
            for(int i=0; i<b.length; i++)
                System.out.print(b[i]+" ");
            System.out.println();
 
            fin.close();
        } catch(IOException e) { }
    }
 }
