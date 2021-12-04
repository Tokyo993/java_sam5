package task5;

import java.io.File;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        String file = "C:/Users/nikit/Desktop/java.txt";
        Path path = Paths.get(file);
        Scanner read;
        List<Double> a= new ArrayList<Double>();
        List<Double> b= new ArrayList<Double>();

        try {//считывание
            read = new Scanner(path);
            while(read.hasNext()) {
                double num = Double.parseDouble(read.next());
                a.add(num);
                num = Double.parseDouble(read.next());
                b.add(num);
            }
            read.close();


            try(FileWriter writer = new FileWriter(file, false))//запись в файл
            {
                double sum = 0;
                for(int i=0; i<a.size(); i++) {
                    sum=a.get(i)*b.get(i);
                    writer.write(a.get(i)+" "+b.get(i)+" "+sum+"\n");
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
