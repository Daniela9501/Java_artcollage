import java.awt.Color;

public class glasseffect{


    //Return random integer between a and b 
    public static int random (int a, int b){
        return a + StdRandom.uniform(b-a+1);
    }


    public static void main (String [] args){

        // 1. Reads and image from a file and create a Picture
        Picture input = new Picture ("Sky.jpeg");
        input.show(); // display image

        int width = input.width(); // number of columns in the picture
        int height = input.height(); // number of rows in the picture

        Picture output = new Picture(width, height); // create a Picture widthxheight

        // 2. Apply and image filter that makes it look like it is been seen through glass
        // accomplish that by plotting pixel (y, x) in the color of a random neighbor pixel (yy, xx)
        for (int x = 0; x < width; x++){ // go over columns
            for ( int y = 0; y < height; y++){ // go over rows
                int xx = (width + x + random (-5, 5)) % width;
                int yy = (height + y + random (-5, 5)) % height;
                Color color = input.get(xx,yy);
                output.set(x , y , color);


            }
        }
        output.show();
    }
}