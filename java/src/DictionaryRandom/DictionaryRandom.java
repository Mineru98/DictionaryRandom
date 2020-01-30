package DictionaryRandom;
import java.util.*;

public class DictionaryRandom {
    private int Count;
    private ArrayList<Integer> list = new ArrayList<>();
    
    DictionaryRandom(ArrayList<Integer> list) {
        this.list = list;
        this.Count = list.size();
    }
    
    DictionaryRandom(ArrayList<Integer> list, int Count) {
        this.list = list;
        this.Count = Count;
        if(this.Count > this.list.size()) {
            throw new IllegalArgumentException("Over ArrayList Size");
        }
    }
    
    public ArrayList<Integer> generator() {
        ArrayList<Integer> _list = new ArrayList<>();
        
        for(int count = 0; count < Count; count++) {
            int rand = (int)(Math.floor(Math.random() * (list.size())));
            int fix = list.get(rand);
            ArrayList<Integer> tmp = new ArrayList<>();

            _list.add(fix);
            int i = 0;
            while(i < list.size()) {
                // System.out.println(""+list.get(i)+", "+fix) // if you want to debugging, remove remark
                if((list.get(i) == fix) && i!=0) {
                    tmp.add(fix);
                    // while(list.remove(fix)) {} // Trade off : Memory vs Readability
                    list.removeAll(tmp);
                    tmp.clear();
                    i--;
                } else i++;
            }
        }
        
        
        return _list;
    }
}
