import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class oppg1 {

    public static void main(String[] args) {
        oppgave1a();
        oppgave1b();

    }

    public static void oppgave1a() {
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

        listen.sort((input1, input2) -> {
            int første = Integer.parseInt(input1);
            int andre = Integer.parseInt(input2);
            if (første == andre) {
                return 0;
            }
            return første < andre ? -1 : 1;
        });

        System.out.println(listen);
    }

    public static void oppgave1b() {

        System.out.println(beregn(12, 13, (a, b) -> {
            // skal returnere summen av a + b
            return a + b;
        }));

        System.out.println(beregn(-5, 3, (a, b) -> {
            // skal returnere høyest av -5 og 3
            if (a < b) {
                return b;
            } else {
                return a;
            }
        }));

        System.out.println(beregn(54, 45, (a, b) -> {
            // skal returnere absoluttverdien av diffen mellom a og b
            int difference = a - b;

            if (difference < 0) {
                return difference * (-1);
            } else {
                return difference;
            }
        }));
    }

    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> func) {
        return func.apply(a, b);
    }
}
