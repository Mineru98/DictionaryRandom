package DictionaryRandom;
import java.util.*;
import DictionaryRandom.DictionaryRandom;
import DictionaryRandom.NoteInfo;

public class Main {
    public static void main(String[] args) {
        ArrayList<NoteInfo> initnoteList = new ArrayList<NoteInfo>(); // Original Array
        
        /*
            We need to insert code(Get initnoteList data from DB)
        */
        
        for(int i = 1; i<= 10; i++) {
            // When creating a NoteInfo object, instead of 1, enter the probability value you want in the second parameter position.
            initnoteList.add(new NoteInfo(i, 10));
            
        }
        
        // under code is production version code

        /* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 

        if(1 > args.size()) System.exit(0);

        for (i in 1..args[0].toInt()) {
            // When creating a NoteInfo object, instead of 1, enter the probability value you want in the second parameter position.
            initnoteList.add(new NoteInfo(i, 1));
        }

        */
        
        ArrayList<Integer> noteList = new ArrayList<Integer>();
        
        for(NoteInfo it: initnoteList) {
            for(int i = 0; i < it.Emersion; i++) {
                noteList.add(it.id);
            }
        }
        
        // if(2 > args.size()) System.exit(0);
        
        // DictionaryRandom obj = new DictionaryRandom(noteList, args[1].toInt());
        DictionaryRandom obj = new DictionaryRandom(noteList, 4);
        ArrayList<Integer> _list = obj.generator();
        System.out.println(_list);
    }
}
