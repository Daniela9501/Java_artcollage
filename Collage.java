import java.awt.Color;


/*
 * This class contains methods to create and perform operations on a collage of images.
 * 
 * @author Daniela Riano Castano dr982
 */ 

public class Collage {

    // The orginal picture
    private Picture originalPicture;

    // The collage picture is made up of tiles.
    // Each tile consists of tileDimension X tileDimension pixels
    // The collage picture has collageDimension X collageDimension tiles
    private Picture collagePicture;

    // The collagePicture is made up of collageDimension X collageDimension tiles
    // Imagine a collagePicture as a 2D array of tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    // Imagine a tile as a 2D array of pixels
    // A pixel has three components (red, green, and blue) that define the color 
    // of the pixel on the screen.
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 150
     * 2. initializes originalPicture with the filename image
     * 3. initializes collagePicture as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see constructors for the Picture class).
     * 4. update collagePicture to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public Collage (String filename) {

        // WRITE YOUR CODE HERE
        collageDimension = 4;
        tileDimension = 150;
        originalPicture = new Picture(filename);
        collagePicture = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        for (int row = 0; row < collagePicture.height(); row++) {
            for (int col = 0; col < collagePicture.width(); col++) {
                collagePicture.set(col, row, Color.BLACK);
            }
        }
        scale(originalPicture, collagePicture);
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes originalPicture with the filename image
     * 3. initializes collagePicture as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collagePicture to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */    
    public Collage (String filename, int td, int cd) {

        // WRITE YOUR CODE HERE
        this.tileDimension = td;
        this.collageDimension = cd;
        this.originalPicture = new Picture (filename);
        this.collagePicture = new Picture (this.tileDimension*this.collageDimension, this.tileDimension*this.collageDimension);
        scale(this.originalPicture, this.collagePicture);
    }


    /*
     * Scales the Picture @source into Picture @target size.
     * In another words it changes the size of @source to make it fit into
     * @target. Do not update @source. 
     *  
     * @param source is the image to be scaled.
     * @param target is the 
     */
    public static void scale (Picture source, Picture target) {

        // WRITE YOUR CODE 
        int sourceWidth = source.width();
        int sourceHeight = source.height();
        int targetWidth = target.width();
        int targetHeight = target.height();
        for (int targetX = 0; targetX < targetWidth; targetX++) {
            for (int targetY = 0; targetY < targetHeight; targetY++) {
                int sourceX = targetX * sourceWidth / targetWidth;
                int sourceY = targetY * sourceHeight / targetHeight;
                Color color = source.get(sourceX, sourceY);
                target.set(targetX, targetY, color);
            }
        }
    }

     /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */   
    public int getCollageDimension() {
        return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */    
    public int getTileDimension() {
        return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    
    public Picture getOriginalPicture() {
        return originalPicture;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    
    public Picture getCollagePicture() {
        return collagePicture;
    }

    /*
     * Display the original image
     * Assumes that original has been initialized
     */    
    public void showOriginalPicture() {
        originalPicture.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */    
    public void showCollagePicture() {
	    collagePicture.show();
    }

    /*
     * Updates collagePicture to be a collage of tiles from original Picture.
     * collagePicture will have collageDimension x collageDimension tiles, 
     * where each tile has tileDimension X tileDimension pixels.
     */    
    public void makeCollage () {

        // WRITE YOUR CODE HERE

        Picture tile = new Picture(tileDimension, tileDimension);
        scale(originalPicture, tile);
        for (int col = 0; col < collagePicture.width(); col += tileDimension) {
            for (int row = 0; row < collagePicture.height(); row += tileDimension) {
                for (int tileCol = 0; tileCol < tileDimension; tileCol++) {
                    for (int tileRow = 0; tileRow < tileDimension; tileRow++) {
                        int x = col + tileCol;
                        int y = row + tileRow;
                        if (x < collagePicture.width() && y < collagePicture.height()) {
                            collagePicture.set(x, y, tile.get(tileCol, tileRow));
                        }
                    }
                }
            }
        }
    }

    

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
        int tileWidth = collagePicture.width() / collageDimension;
        int tileHeight = collagePicture.height() / collageDimension;

        int startX = collageCol * tileWidth;
        int startY = collageRow * tileHeight;

        for (int x = startX; x< startX+tileWidth ; x++){
            for (int y = startY; y < startY + tileHeight; y++){
                Color color = collagePicture.get(x,y);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

            if (component.equals("red")) {
                green = 0;
                blue = 0;
            } else if (component.equals("green")) {
                red = 0;
                blue = 0;
            } else if (component.equals("blue")) {
                red = 0;
                green = 0;
            }

            Color newColor = new Color(red, green, blue);

            collagePicture.set(x, y, newColor);
        }
    }
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
        Picture tile = new Picture (tileDimension, tileDimension);
        Picture originalPicture = new Picture (filename);
        scale (originalPicture,tile);
        
        int x = collageCol*tileDimension;
        int y = collageRow*tileDimension;
        for (int tilecol= 0; tilecol<tileDimension; tilecol++){
            for (int tilerow=0; tilerow<tileDimension; tilerow++){
                int px = x + tilecol;
                int py = y + tilerow;
                if (px<collagePicture.width() && py < collagePicture.height()){
                    collagePicture.set(px,py, tile.get(tilecol,tilerow));
                }
            }
        }
    }
       /*  Picture replacement = new Picture(filename);
        int startX = collageCol * tileDimension;
        int startY = collageRow * tileDimension;
        for (int x = 0; x < tileDimension; x++) {
            for (int y = 0; y < tileDimension; y++) {
                int replacementX = x * replacement.width() / tileDimension;
                int replacementY = y * replacement.height() / tileDimension;
                Color replacementColor = replacement.get(replacementX, replacementY);
                int targetX = startX + x;
                int targetY = startY + y;
                collagePicture.set(targetX, targetY, replacementColor);
            }
        }
    
        collagePicture.show();
    }*/

    /*
     * Grayscale tile at (collageCol, collageRow)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void grayscaleTile (int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
        int startX = collageCol * tileDimension;
        int startY = collageRow * tileDimension;

        for (int x = startX; x < startX + tileDimension; x++) {
            for (int y = startY; y < startY + tileDimension; y++) {
                Color originalColor = collagePicture.get(x, y);
                Color grayscaleColor = toGray(originalColor);
                collagePicture.set(x, y, grayscaleColor);
            }
        }

        showCollagePicture();
    }   
        
        
        /*int endX = startX + tileDimension;
        int endY = startY + tileDimension;
    
        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                Color originalColor = collagePicture.get(x, y);
                Color grayscaleColor = toGray(originalColor);
                collagePicture.set(x, y, grayscaleColor);
            }
        }
    
        showCollagePicture();*/
   

    /**
     * Returns the monochrome luminance of the given color as an intensity
     * between 0.0 and 255.0 using the NTSC formula
     * Y = 0.299*r + 0.587*g + 0.114*b. If the given color is a shade of gray
     * (r = g = b), this method is guaranteed to return the exact grayscale
     * value (an integer with no floating-point roundoff error).
     *
     * @param color the color to convert
     * @return the monochrome luminance (between 0.0 and 255.0)
     */
    private static double intensity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (r == g && r == b) return r;   // to avoid floating-point issues
        return 0.299*r + 0.587*g + 0.114*b;
    }

    /**
     * Returns a grayscale version of the given color as a {@code Color} object.
     *
     * @param color the {@code Color} object to convert to grayscale
     * @return a grayscale version of {@code color}
     */
    private static Color toGray(Color color) {
        int y = (int) (Math.round(intensity(color)));   // round to nearest int
        Color gray = new Color(y, y, y);
        return gray;
    }

    /*
     * Closes the image windows
     */
    public void closeWindow () {
        if ( originalPicture != null ) {
            originalPicture.closeWindow();
        }
        if ( collagePicture != null ) {
            collagePicture.closeWindow();
        }
    }
}
