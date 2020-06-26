package com.company;


//LB_1
/*Создать классы, спецификации которых приведены ниже.
        Определить конструкторы и методы setТип(), getТип(), toString().
        Определить дополнительно  методы в классе, создающем массив объектов.
        Задать критерий выбора данных и вывести эти данные на консоль.
        В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.*/

/*28.	 Определить класс Окружность на плоскости, координаты центра которой задаются с помощью Рациональной Дроби.
        Определить площадь и периметр. Создать массив/список/множество объектов и определить группы окружностей,
        центры которых лежат на одной прямой. Определить наибольший и наименьший по площади (периметру) объект.*/


import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Circle.MaxAreaPerimeter;

public class Main {

    public static void main(String[] args) {

        ArrayList<Circle> arrayCircle = new ArrayList<Circle>();
        arrayCircle.add(new Circle(1,1,6));
        arrayCircle.add(new Circle(2,2,7));
        arrayCircle.add(new Circle(3,3,8));
        arrayCircle.add(new Circle(2,7,9));

        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";

        while (true){
            System.out.println("1 - вывести на консоль площадь окружностей");
            System.out.println("2 - вывести на консоль периметр окружностей");
            System.out.println("3 - определить группы окружностей, центры которых лежат на одной прямой");
            System.out.println("4 - Определить наибольший по площади (периметру) объект.");
            System.out.println("5 - Определить наименьший по площади (периметру) объект.");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (x){
                case 1:
                    //вывести на консоль площадь окружностей
                    for (Circle c: arrayCircle ) {
                        System.out.println("Пощадь окружности \n" + c.toString() + "\n равна = " + c.area()) ;
                    }
                    break;
                case 2:
                    // вывести на консоль периметр окружностей
                    for (Circle c: arrayCircle ) {
                        System.out.println("Периметр окружности \n" + c.toString() + "\n равен  = " + c.perimeter());
                    }
                    break;
                case 3:
                    //  определить группы окружностей, центры которых лежат на одной прямой
                    Circle.groupCircle(arrayCircle);
                    break;
                case 4:
                    // Определить наибольший по площади (периметру) объект.
                    Circle.MaxAreaPerimeter(arrayCircle);
                    break;
                case 5:
                    // поиск государсвта в файле по столице
                    Circle.MinAreaPerimeter(arrayCircle);
                    break;
            }
        }





    }
}
