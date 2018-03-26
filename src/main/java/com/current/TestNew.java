package com.current;

public class TestNew {

    public static void main(String[] args) {

    }
}

class Circle
{
    private float radius;
    Circle(float radius)
    {
        this.radius = radius;
    }

    public int getArea()
    {
        return (int)Math.ceil(3.14159265*radius*radius);
    }

}

class Rectangle
{
    private float width;
    private float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public int getArea()
    {
       return (int)Math.ceil(width*height);
    }
}

class Square
{
    private float width;

    public Square(float width) {
        this.width = width;
    }

    public int getArea()
    {
        return (int)Math.ceil(width*width);
    }
}
