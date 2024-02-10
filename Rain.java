import java.awt.Color;

public class Rain {

    // 1. Write Client programs that test all methods ofyour newly created data type

    // Instance variables 

    private Raindrop [] raindrops;
    private int numberOfRaindrops;

    // Default constructor: no argument constructor

    public Rain () {
        numberOfRaindrops = 100;
        raindrops = new Raindrop [numberOfRaindrops];

        // Create each raindrop 

        for (int i = 0; i < raindrops.length; i++){

            double x = StdRandom.uniform(-1.0, 1.0);
            double y = 1.0;
            double length = StdRandom.uniform(0.01, 0.05);
            Color color = new Color (StdRandom.uniform(256),StdRandom.uniform(256), StdRandom.uniform(256));

            // Create raindrop i
            raindrops [i] = new Raindrop (x, y, length , color);
        }
    }

    public Rain (int numberOfRaindrops) {
        this.numberOfRaindrops = numberOfRaindrops;
        raindrops = new Raindrop [numberOfRaindrops];

        // Create each raindrop 

        for (int i = 0; i < raindrops.length; i++){

            double x = StdRandom.uniform(-1.0, 1.0);
            double y = 1.0;
            double length = StdRandom.uniform(0.01, 0.05);
            Color color = new Color (StdRandom.uniform(256),StdRandom.uniform(256), StdRandom.uniform(256));

            // Create raindrop i
            raindrops [i] = new Raindrop (x, y, length , color);
        }
        

    }

    // 3. Differentiate between public and private access modifiers 

    public void makeRainFall (){
        int n = 1000;
        while (n > 0) {

            StdDraw.clear(); // to clear the canvas

            // make each drop fall one time
            for (int i = 0; i < raindrops.length ; i++){
                raindrops[i].fall();
            }

            n -=1;
        }
    }

    // 2. Distinguish among parameters variables, local variables and instance variable

    public static void  main (String [] args) {

        StdDraw.setXscale(-1.0 , 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        Rain r = new Rain (450);
        r.makeRainFall();

    }






}