class Progression{
    protected long first;
    protected long current;

    Progression(){
        first = 0;
        current = 0;
    }

    public long firstValue(){
        current = first;
        return current;
    }

    protected long nextValue(){
        return ++current;
    }

    public void printProgression(int n){
        System.out.println(firstValue());

        for(int i = 1; i < n; i++){
            System.out.println(nextValue());
        }
    }

}

class ArithProgression extends Progression{
    protected long inc;

    ArithProgression(){
        this(1);
    }

    ArithProgression(int increment){
        inc = increment;
    }

    protected long nextValue(){
        current += inc;
        return current;
    }
}

class GeomProgression extends Progression{

    protected long base;

    GeomProgression(){
        this(2);
    }

    GeomProgression(long b){
        base = b;
        first = 1;
        current = first;
    }

    protected long nextValue(){
        current *= base;
        return current;
    }
}

class Fibonacci extends Progression{
    long prev;

    Fibonacci(){
        this(0,1);
    }
    Fibonacci(long value1, long value2){
        first = value1;
        prev = value2 - value1;
    }

    protected long nextValue(){
        long temp = prev;
        prev = current;
        current += temp;
        return current;
    }
}

public class Inheritance {
    public static void main(String args[]){
        Progression prog;

        System.out.println("Arithmetic progression with default increment : ");

        prog =  new ArithProgression();
        prog.printProgression(10);
        System.out.println("Arithmetic progression with increment 5: ");
        prog =  new ArithProgression(5);
        prog.printProgression(10);
        System.out.println("Geometric progression with default base : ");
        prog = new GeomProgression();
        prog.printProgression(10);
    }
}
