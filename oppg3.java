import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class oppg3 {

    public static void main(String[] args) {

        Ansatt ansatt1 = new Ansatt("Johann", "Bugge", "Regional Manager", Kjonn.MANN, 3000000);
        Ansatt ansatt2 = new Ansatt("Fredrik", "Haarde", "Assistant to the Regional Manager", Kjonn.MANN, 1500000);
        Ansatt ansatt3 = new Ansatt("Lasse", "Hænsen", "Accountant", Kjonn.MANN, 1400000);
        Ansatt ansatt4 = new Ansatt("Nico", "Gangdal", "Temp", Kjonn.MANN, 100000);
        Ansatt ansatt5 = new Ansatt("Kvinne", "Kvote", "Receptionist", Kjonn.KVINNE, 100000);

        List<Ansatt> ansatte = Arrays.asList(ansatt1, ansatt2, ansatt3, ansatt4, ansatt5);

        // oppgave3a)

        List<String> ansatteEtternavn = ansatte.stream().map(ansatt -> ansatt.getEtternavn())
                .collect(Collectors.toList());

        for (String etternavn : ansatteEtternavn) {
            System.out.println(etternavn);
        }

        // oppgav3b)
        int antallKvinner = ansatte.stream().filter((ansatt) -> {
            if (ansatt.getKjonn() == Kjonn.KVINNE) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList()).size();
        System.out.println(antallKvinner);

        // oppgave3c)
        ansatte.stream().filter((ansatt) -> {
            if (ansatt.getKjonn() == Kjonn.KVINNE) {
                return true;
            } else {
                return false;
            }
        }).mapToInt(ansatt -> ansatt.getLonn()).average().ifPresent(avg -> System.out.println(avg));

        // oppgave3d
        List<Ansatt> oppdatertLonnForSjefListe = ansatte.stream().map((ansatt) -> {
            if (ansatt.getStilling().toLowerCase().contains("manager")) {
                ansatt.setLonn((int) (ansatt.getLonn() * 1.07));
            }
            return ansatt;
        }).collect(Collectors.toList());
        System.out.println(oppdatertLonnForSjefListe);

        // oppgave 3e
        boolean hoyLonn = !ansatte.stream().filter((ansatt) -> {
            if (ansatt.getLonn() > 800000) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList()).isEmpty();

        System.out.println("Har noen høyere lønn enn 800.000,-: " + hoyLonn);

        // oppgave 3f
        System.out.println(Arrays.toString(ansatte.toArray()));

        // oppgave 3g
        // Kan ikke bruke local variable i lambda, lager et array for å "hacke" en
        // løsning
        int[] currentlyLavest = { -1 };
        currentlyLavest[0] = ansatte.stream().min(Comparator.comparing(Ansatt::getLonn)).get().getLonn();

        List<Ansatt> lavestLonn = ansatte.stream().filter((ansatt) -> {
            if (ansatt.getLonn() > currentlyLavest[0]) {
                return false;
            } else {
                return true;
            }
        }).collect(Collectors.toList());
        System.out.println("Laveste lønn: " + "\n" + lavestLonn);

        // oppgave 3h
        // tar utgangspunkt i at oppgaven mener tallene mellom [1, 1000]
        int sumOfAll = IntStream.rangeClosed(1, 1000).filter(x -> {
            if ((x % 3) == 0 || (x % 5) == 0) {
                return true;
            } else {
                return false;
            }
        }).reduce((sum, x) -> {
            return sum + x;
        }).getAsInt();

        System.out.println("Summen av elementene: " + sumOfAll);
    }
}
