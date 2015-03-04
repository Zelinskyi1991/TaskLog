import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sasha on 03.03.2015.
 */



/*
Задание 2. Напишите программу, которая получает с клавиатуры имя, фамилию и возраст людей. После того, как ввод завершён,
        программа выводит список всех людей в формате
        Фамилия Имя Возраст ОтклонениеОтСреднегоВозраста
        Отклонение от среднего возраста (с точностью до сотых года) считается по формуле: СреднийВозраст - ВозрастЧеловека.*/

public class task1 {
    public static void main(String[] args) throws IOException {
        String []name = new String[0];String[]lastName = new String[0];Double []age = new Double[0];
        String check;
        Double sum = null;
        Double avg=null;
        boolean misMatch = true;



        BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input caunt of records");
        int caunt=Integer.parseInt( buff.readLine());
       for(int i=0;i<=caunt;i++)
            {


                System.out.println("if you want to continue y");
                    check=buff.readLine();



                    if (check.equals("y") || check.equals("Y")) {
                        try {


                            System.out.println("input name");
                            name[i] = buff.readLine();
                        }
                        catch(IOException o){
                            System.out.println(o);
                        }
                        try{
                        System.out.println("input lastname");
                        lastName[i] =buff.readLine();}
                        catch(IOException a){
                            System.out.println(a);
                        }
                        try{
                        System.out.println("input age");
                        age[i] =Double.parseDouble( buff.readLine());}
                        catch (IOException e){
                            System.out.println(e);
                        }

                    }
                    else
                    {
                        sum = age[i];
                        sum=sum+sum;
                        avg = sum / i;


                        System.out.println(name[i] + " " + lastName[i] + " "+(avg - age[i]));
                        break;

                    }



                }



    }
}
