//5. Даны 2 целых числа от 10 до N. Подсчитайте 
//количество всех четных чисел из 
//этого интервала, делящихся на 4.


import java.util.Scanner;
//обявление публичного класса
public class Nuber5 {
    
    public static void calculation(String[] args) {
        //объект Scanner для считывания ввода пользователя
        Scanner scanner = new Scanner(System.in);
        int  N = scanner.nextInt();
        try{

        // ввод значение 
        System.out.print("Введите значение N, которое больше 10: ");
        //значение введенного числа N
        

        // проверка, что N больше или равно 10
        if (N < 10) {
            // если N меньше 10, выводим сообщение
            System.out.println("N должно быть не менее 10.");
            return;
        }

        // вызов метода и вывод результатф
        int count = DivisionByFour(N);
        System.out.println("Количество четных чисел, делящихся на 4, от 10 до " + N + ": " + count);
        }catch (IllegalArgumentException e){
            
            System.out.println("Тест провален");
        }

    }
    

    //подсчет четных чисел, делящихся на 4 от 10 до N
    public static int DivisionByFour(int N) {
        //счетчик
        int count = 0;
        
        //от 10 до N включительно
        for (int i = 10; i <= N; i++) {
            //является ли число четным и делится ли на 4
            if (i % 2 == 0 && i % 4 == 0) {
                //увеличиваем счетчик
                count++;
            }
        }
        return count;
    }
}

