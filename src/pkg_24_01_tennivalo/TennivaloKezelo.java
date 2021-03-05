package pkg_24_01_tennivalo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TennivaloKezelo {

    public static LocalDate datumFormaz(String date) {

        try {
            DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
            return LocalDate.parse(date, sf);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static String datumStringbe(LocalDate date) {
        try {
            DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
            return date.format(sf);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {

        Tennivalok tennivaloLista = new Tennivalok();
        try ( Scanner sc = new Scanner(System.in)) {
            String kivalaszt = "";
            do {

                System.out.println("\t\t\tE L I N T É Z E N D Ő   F E L A D A T O K\n");
                System.out.print(String.format("%-3s %-13s %-18s %-41s %s", "#", "| " + "Határidő", "| " + "Fontosság", "| " + "Feladat", "| " + "Elintézve\n\n"));
                if (tennivaloLista != null) {
                    if (!tennivaloLista.getHatralevoFeladatok().isEmpty()) {
                        for (int i = 0; i < tennivaloLista.getHatralevoFeladatok().size(); i++) {
                            String fon = "";
                            String elv = "";
                            switch (tennivaloLista.getHatralevoFeladatok().get(i).getFontossag()) {
                                case 1:
                                    fon = "kicsit fontos";
                                    break;
                                case 2:
                                    fon = "közepesen fontos";
                                    break;
                                default:
                                    fon = "nagyon fontos";
                                    break;
                            }
                            System.out.print(String.format("%-3s %-13s %-18s %-41s %s", tennivaloLista.getHatralevoFeladatok().get(i).getSorszam(),
                                    "| " + datumStringbe(tennivaloLista.getHatralevoFeladatok().get(i).getHatarido()),
                                    "| " + fon, "| " + tennivaloLista.getHatralevoFeladatok().get(i).getNev(), "| nem\n"));
                        }
                        System.out.println("");
                    }
                }

                System.out.println("Menü:\n"
                        + "(a) | Tennivaló felvitele\r\n"
                        + "(b) | Tennivaló elvégzése\r\n"
                        + "(c) | Rendezés fontosság szerint, csökkenő sorrendbe\r\n"
                        + "(d) | Rendezés határidő szerint, növekvő sorrendbe\r\n"
                        + "(e) | Rendezés név (ABC) szerint, növekvő sorrendbe\r\n"
                        + "(f) | Elvégzett feladatok megjelenítése a listában\r\n"
                        + "(g) | Kilépés");

                System.out.print("Mit szeretnél csinálni? ");
                kivalaszt = sc.nextLine();

                switch (kivalaszt) {
                    case "a":
                        System.out.print("Mi a tennivaló? ");
                        String nev = sc.nextLine();
                        System.out.print("Meddig kell elvégezni? (ÉÉÉÉ.HH.NN.) ");
                        String stHatarido = sc.nextLine();
                        LocalDate hatarido = datumFormaz(stHatarido);
                        if (hatarido == null) {
                            System.out.println("Nem megfelelő formátum");
                            return;
                        }
                        System.out.print("Mennyire fontos? (1 - kicsit, 2 - közepesen 3 - nagyon) ");
                        int fontossag = sc.nextInt();
                        System.out.println();
                        sc.nextLine();
                        Tennivalo t = new Tennivalo(nev, fontossag, hatarido);
                        tennivaloLista.felvesz(t);
                        break;
                    case "b":
                        System.out.print("Melyik feladatot végezted el? ");
                        int elvegzendo = sc.nextInt();
                        sc.nextLine();
                        tennivaloLista.elvegez(elvegzendo);
                        System.out.println("");
                        break;
                    case "c":
                        tennivaloLista.fontossagSorrend();
                        System.out.println("");
                        break;
                    case "d":
                        tennivaloLista.hataridoSorrend();
                        System.out.println("");
                        break;
                    case "e":
                        tennivaloLista.abcSorrend();
                        System.out.println("");
                        break;
                    case "f":
                        System.out.println("");
                        System.out.println("\t\t\tE L V É G Z E T T   F E L A D A T O K\n");
                        System.out.print(String.format("%-3s %-13s %-18s %-41s %s", "#", "| Határidő", "| Fontosság", "| Feladat", "| Elintézve\n\n"));
                        if (tennivaloLista != null) {
                            if (!tennivaloLista.getElvegzettFeladatok().isEmpty()) {
                                for (int i = 0; i < tennivaloLista.getElvegzettFeladatok().size(); i++) {
                                    String fon = "";
                                    String elv = "";
                                    switch (tennivaloLista.getElvegzettFeladatok().get(i).getFontossag()) {
                                        case 1:
                                            fon = "kicsit fontos";
                                            break;
                                        case 2:
                                            fon = "közepesen fontos";
                                            break;
                                        default:
                                            fon = "nagyon fontos";
                                            break;
                                    }
                                    System.out.print(String.format("%-3s %-13s %-18s %-41s %s", tennivaloLista.getElvegzettFeladatok().get(i).getSorszam(),
                                            "| " + datumStringbe(tennivaloLista.getElvegzettFeladatok().get(i).getHatarido()),
                                            "| " + fon, "| " + tennivaloLista.getElvegzettFeladatok().get(i).getNev(), "| igen\n"));
                                }
                                System.out.println("");
                            }
                        }
                        break;
                    case "g":
                        System.out.println("Köszi, szia!");
                        break;
                    default:
                        System.out.print("Hibás menüpont!");
                        return;
                }

            } while (!kivalaszt.equals("g"));
        }
    }

}
