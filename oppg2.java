import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class oppg2 {

    public static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> func) {

        for (Ansatt ansatt : ansatte) {
            // apply function på hver ansatt
            // func.apply(ansatt);
            ansatt.setLonn(func.apply(ansatt));
        }

    }

    public static void main(String[] args) {

        Ansatt ansatt1 = new Ansatt("Johann", "Bugge", "Regional Manager", Kjonn.MANN, 3000000);
        Ansatt ansatt2 = new Ansatt("Fredrik", "Haarde", "Assistant to the Regional Manager", Kjonn.MANN, 1500000);
        Ansatt ansatt3 = new Ansatt("Lasse", "Hænsen", "Accountant", Kjonn.MANN, 1400000);
        Ansatt ansatt4 = new Ansatt("Nico", "Gangdal", "Temp", Kjonn.MANN, 0);
        Ansatt ansatt5 = new Ansatt("Kvinne", "Kvote", "Receptionist", Kjonn.KVINNE, 100000);

        List<Ansatt> ansatte = Arrays.asList(ansatt1, ansatt2, ansatt3, ansatt4, ansatt5);

        // Fast kronetillegg:
        lonnsoppgjor(ansatte, (ansatt) -> {
            int kronetillegg = 1337;
            int newLonn = kronetillegg + ansatt.getLonn();

            return newLonn;
        });

        // Fast prosenttillegg(5%):
        lonnsoppgjor(ansatte, (ansatt) -> {
            double prosentillegg = 0.05;
            int newLonn = (int) ((1 + prosentillegg) * ansatt.getLonn());

            return newLonn;
        });

        // Fast kronetilleg ved lav lønn:

        lonnsoppgjor(ansatte, (ansatt) -> {
            int kronetillegg = 100;
            int newLonn = ansatt.getLonn();
            if (ansatt.getLonn() < 1500000) {
                newLonn += kronetillegg;
            }
            return newLonn;
        });

        // Fast prosenttilegg hvis mann:
        lonnsoppgjor(ansatte, (ansatt) -> {
            double prosenttillegg = 0.15;
            int newLonn = ansatt.getLonn();
            if (ansatt.getKjonn() == Kjonn.MANN) {
                newLonn = (int) ((1 + prosenttillegg) * ansatt.getLonn());
            }
            return newLonn;
        });
    }

    private static void skrivUtAlle(List<Ansatt> ansatte) {
        for (Ansatt ansatt : ansatte) {
            System.out.println(ansatt);
        }
    }
}

enum Kjonn {
    MANN, KVINNE;
}