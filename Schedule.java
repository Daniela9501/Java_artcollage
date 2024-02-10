import java.util.ArrayList;

public class Schedule{

    public static void main (String [] args){

        ArrayList<String> agenda = new ArrayList<String>(5);
        agenda.add("exercise");
        agenda.add("record learning objectives");
        agenda.add("lunch");
        agenda.add("class");
        agenda.add("feed cats");

        agenda.add(1, "breakfast"); // with .add (index, "name of the item i want to add")

        for (int i = 0 ; i < agenda.size() ; i++) { //.size of the actual array no the capacity 
            StdOut.println(i + " - " + agenda.get(i)); //.get I am getting by index
        }

        agenda.set(3, "browse the web"); // .set I can replace items in my array

        for (int i = 0 ; i < agenda.size() ; i++) { //.size of the actual array no the capacity 
            StdOut.println(i + " - " + agenda.get(i)); //.get I am getting by index
        }
    }
}