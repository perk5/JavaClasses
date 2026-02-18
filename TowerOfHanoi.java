import java.util.*;
class TowerOfHanoi{
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    List<Integer> c = new ArrayList<>();


    public void towerHanoi(){
        if(a.size() == 1){
            c.add(a.get(0));
            a.remove(0);
            transferFromBtoC();
            System.out.println(c);
            return;
        }

        b.add(a.get(0));
        a.remove(0);
        towerHanoi();
    }

    public void transferFromBtoC(){
        if(b.size() == 0){
            return;
        }
        c.add(b.get(0));
        b.remove(0);
        
        transferFromBtoC();

    }

    public static void main(String args[]){
        TowerOfHanoi Toh = new TowerOfHanoi();
        Toh.a.add(1);
        Toh.a.add(2);
        Toh.a.add(3);
        Toh.a.add(4);
        Toh.towerHanoi();
    }
}   