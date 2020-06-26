package com.company;

import java.util.ArrayList;


import static sun.util.calendar.CalendarUtils.mod;

public class Circle {
    double x;
    double y;
    double radius;

//конструктор
    public Circle(int x, int y , int radius){
        if (y == 0) throw new ArithmeticException("ошибка!! ");
        int divisor = gcd(x, y);
        this.x = x / divisor;
        this.y = y / divisor;
        this.radius= radius;
    }

    //НОД
    private static int gcd(int n, int d) {
        return (d == 0 ? n : gcd(d, n % d));
    }

   // Определить площадь S=πr^2
    public double area(){
           double S = 3.14 * Math.pow(this.getRadius(), 2);

        return S;
    }

    // Определить периметр p=2πr
    public double perimeter(){
        double P = 2* 3.14 *this.getRadius();

        return P;
    }

  // Определить наибольший по площади (периметру) объект.
    static public void MaxAreaPerimeter(ArrayList<Circle> arrayCircle){


        double  maxArea =0;
        double  maxPerimeter =0;
        int maxIndexArea = 0;
        int maxIndexPer = 0;
        for (int i = 0; i < arrayCircle.size(); i++) {

            if(maxArea <= arrayCircle.get(i).area()){
                maxArea = arrayCircle.get(i).area();
                maxIndexArea =i;
            }

            if(maxPerimeter <= arrayCircle.get(i).perimeter()){
                maxPerimeter = arrayCircle.get(i).perimeter();
                maxIndexPer =i;
            }
        }
        System.out.println("наибольший по площади объект \n" +
                arrayCircle.get(maxIndexArea).toString() + " max S = " +    maxArea +
                "\n наибольший по периметру объект \n"
                + arrayCircle.get(maxIndexPer).toString() + " max P = " +    maxPerimeter);
    }
    // Определить наименьший по площади (периметру) объект.
    static public void MinAreaPerimeter(ArrayList<Circle> arrayCircle){


        double  minArea =1000;
        double  minPerimeter =1000;
        int minIndexArea = 0;
        int minIndexPer = 0;
        for (int i = 0; i < arrayCircle.size(); i++) {

            if(minArea >= arrayCircle.get(i).area()){
                minArea = arrayCircle.get(i).area();
                minIndexArea =i;
            }

            if(minPerimeter >= arrayCircle.get(i).perimeter()){
                minPerimeter = arrayCircle.get(i).perimeter();
                minIndexPer =i;
            }
        }
        System.out.println("наименьший по площади объект \n" +
                arrayCircle.get(minIndexArea).toString() + " max S = " +    minArea +
                "\nнаименьший по периметру объект \n"
                + arrayCircle.get(minIndexPer).toString() + " max P = " +    minPerimeter);
    }



   // определить группы окружностей, центры которых лежат на одной прямой.
    static public void groupCircle(ArrayList<Circle> arrayCircle){
        ArrayList<Circle> Circlegroup = new ArrayList<Circle>();

        for (int i =0 ; i < arrayCircle.size()-1; i++ ) {
            for (int j =0 ; j < arrayCircle.size(); j++ ) {
                if(j!=i && j!=i+1){
                    // x3-x1/x2-x1 == y3-y1/y2-y1

                    if ((arrayCircle.get(j).getX() - arrayCircle.get(i).getX()) /
                            (arrayCircle.get(i + 1).getX() - arrayCircle.get(i).getX()) ==
                            (arrayCircle.get(j).getY() - arrayCircle.get(i).getY()) /
                                    (arrayCircle.get(i + 1).getY() - arrayCircle.get(i).getY())) {

                        Circlegroup.add(arrayCircle.get(i));
                        Circlegroup.add(arrayCircle.get(i + 1));
                        Circlegroup.add(arrayCircle.get(j));
                    }
                }
            }
        }
        if(Circlegroup.isEmpty()){
            System.out.println(" нет  окружностей, центры которых лежат на одной прямой \n");

        }

        for (int i =0 ; i < Circlegroup.size(); i++ ) {

            if(mod(i,3)==0)
                System.out.println("----------------------------------------------------");

            System.out.println(Circlegroup.get(i).toString());

        }
    }



    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
