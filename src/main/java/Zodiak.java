import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zodiak {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Podaj datę urodzin w formacie YYYY-MM-DD ");
        String dataUrodzenia = cin.nextLine();

        Map<TwoDates, String> znakiZodiaku = stworzMape(dataUrodzenia.substring(0, 4));
        Zodiak zodiak = new Zodiak();
        System.out.println(zodiak.isBetween(znakiZodiaku, dataUrodzenia));

    }

    private static Map<TwoDates, String> stworzMape(String rok) {
        Map<TwoDates, String> datyZnakow = new HashMap<>();
        
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-03-21"), LocalDate.parse(rok + "-04-20")), "Baran");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-04-20"), LocalDate.parse(rok + "-05-23")), "Byk");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-05-23"), LocalDate.parse(rok + "-06-22")), "Bliznieta");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-06-22"), LocalDate.parse(rok + "-07-23")), "Rak");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-07-23"), LocalDate.parse(rok + "-08-24")), "Lew");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-08-24"), LocalDate.parse(rok + "-09-23")), "Panna");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-09-23"), LocalDate.parse(rok + "-10-23")), "Waga");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-10-23"), LocalDate.parse(rok + "-11-22")), "Skorpion");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-11-22"), LocalDate.parse(rok + "-12-22")), "Strzelec");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-01-20"), LocalDate.parse(rok + "-02-19")), "Wodnik");
        datyZnakow.put(new TwoDates(LocalDate.parse(rok + "-02-19"), LocalDate.parse(rok + "-03-21")), "Ryby");

        return datyZnakow;
    }

    private String isBetween(Map<TwoDates, String> znakiZodiaku, String dataUrodzenia) {
        LocalDate data = LocalDate.parse(dataUrodzenia);
        String rok = dataUrodzenia.substring(0, 4);
        String zodiak = null;
        if (data.isAfter(LocalDate.parse(rok + "-12-21")) || data.isBefore(LocalDate.parse(rok + "-01-20"))) {
            zodiak = "Koziorozec";
        }
        for (TwoDates date : znakiZodiaku.keySet()) {
            if (data.isAfter(date.start) && data.isBefore(date.end)) {
                zodiak = znakiZodiaku.get(date);
            }
        }
        return zodiak;
    }

    public static class TwoDates {
        LocalDate start;
        LocalDate end;

        TwoDates(LocalDate start, LocalDate end) {
            this.start = start.minusDays(1);
            this.end = end;
        }
    }
}
