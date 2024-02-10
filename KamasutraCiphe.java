public class KamasutraCiphe{

    public static void main (String [] args){

        // 1. take 2 strings as command - line arguments (the key string)

        String top = args [0];
        String bot = args [1];

        // 2. Read Standard input, substitutes for each letter specified by the key string, and writes the result to standard output

        while (StdIn.hasNextLine()){
            String line = StdIn.readLine(); // reads a line from the standar input
            for (int i = 0; i < line.length(); i++){
                char c = line.charAt(i); // retrieving the character at index i from string line 
                if (top.indexOf(c) >= 0){
                    int index = top.indexOf(c);
                    StdOut.print(bot.charAt(index));
                }else if (bot.indexOf(c) >= 0){
                    int index = bot.indexOf(c);
                    StdOut.print(top.charAt(index));
                }else {
                    StdOut.print(c); // this is the character space
                }
            }
        }
    }
}