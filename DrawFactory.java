package com.Robert;

public class DrawFactory {

    public interface Shape {
        void draw();
    }

    public class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("a Rectangle osztály draw() metódusán belül vagyunk");
        }
    }

    public class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("a Square osztály draw() metódusán belül vagyunk");
        }
    }

    public class Circle implements Shape {

        @Override
        public void draw() {

        }
    }

}

