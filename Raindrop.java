import java.awt.Color;

public class Raindrop {
    //Atributes 
    //Instance variables
    // Private modifier to hide the variable from other classes 
    private double x; // (x,y) coordinate for the staring point of the raindrop
    private double y;
    private double length; // how heavy the drop is 
    private Color color;

    // Explain the purpose of a constructor 
    // No argument constructor: Default constructor
    public Raindrop (){
        x = y = 0.0;
        length = 0.05;
        color = new Color (0, 0, 0);
        }
        
    // 4 arguments constructor
    public Raindrop (double x, double y, double length, Color color){
        this.x = x;
        this.y = y;
        this.length = length;
        this.color = color;
    }

    // Differentiate between public and private access modifiers
    // Accessor methods

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public double getlength(){
        return length;
    }

    public Color getcolor (){
        return color;
    }

    //Simulate the drop falling 
    public void fall (){
        double oldy = y;
        y -= length;
        StdDraw.setPenColor(color);
        StdDraw.line(x, oldy,x, y);
    }

    // toString() method is the string representation of the object 

    public String toString() {
        return "("+ x + ","+ y +"), length ="+ length + ", " + color.toString();
    }

    //equals method returns true if this object equals the argument object

    public boolean equals (Object other){

        if (other instanceof Raindrop){
            Raindrop o = (Raindrop) other;
            return this.x == o.x &&
                    this.y == o.y &&
                    this.length == o.length &&
                    this.color.equals(o.color);
        } else {
            return false;
        }
    }

    // write a client program that will create and use objects of a class that you wrote

    public static void main (String [] args){

        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setXscale(-1.0, 1.0);

        Raindrop r1 = new Raindrop(); // instantiating one object of type Raindrop
        StdOut.println(r1);
        r1.fall();
        StdOut.println(r1);

        Raindrop r2 = new Raindrop(0.4, 0.5, 0.02, new Color(255, 0 , 0));
        StdOut.println(r2);
        r2.fall();
        StdOut.println(r2);

        Raindrop r3 = new Raindrop(0.4, 0.52, 0.02, new Color(255, 0 , 0));
        StdOut.println(r3.getx()+ " " + r3.gety() + " " + r3.getlength() + " " + r3.getcolor());

        StdOut.println(r1.equals(r2));
        StdOut.println(r2.equals(r3));

    }


}