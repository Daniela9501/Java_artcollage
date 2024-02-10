public class OOB1 {

    public static void main (String [] args) {
        String s1 = new String ("apple");
        String s2 = new String ("Pie");
        String s3 = s1 + " " + s2;

        System.out.println(s3);

        for ( int i = 0; i < s3.length(); i ++){

        System.out.println(s3.charAt(i) + " ");
        }
        System.out.println();
        
        String s4 = s3.substring(6, 9);

        System.out.println(s4);

        // equals 

        if (s1.equals(s2)){
            System.out.println("Same Strings");
        }else{
            System.out.println("Diferents Strings");
        }

        // Compare 
        int c = s1.compareTo(s2);
        if (c==0){
            System.out.println("Same Strings");
        } else if (c<0){
            System.out.println(s1 + "<" + s2);
        }else{
            System.out.println(s1 + ">" + s2);
        }
    }

}