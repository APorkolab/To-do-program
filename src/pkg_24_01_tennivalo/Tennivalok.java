package pkg_24_01_tennivalo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tennivalok {

    private Comparator comp;
    private List<Tennivalo> tennivaloLista = new ArrayList<Tennivalo>();

    public List<Tennivalo> getElvegzettFeladatok() {
        if (tennivaloLista == null) {
            return null;
        }
        List<Tennivalo> elvegzett = new ArrayList<>();

        for (int i = 0; i < tennivaloLista.size(); i++) {
            if (tennivaloLista.get(i).isElvegzett()) {
                elvegzett.add(tennivaloLista.get(i));
            }
        }
        if (comp != null) {
            elvegzett.sort(comp);
        }
        return elvegzett;

    }
//  (Itt, ha szükséges, a sorrendezést is hajtsa végre. Alapértelmezett a sorszám szerinti). 

    public List<Tennivalo> getHatralevoFeladatok() {
        if (tennivaloLista == null) {
            return null;
        }

        List<Tennivalo> hatralevo = new ArrayList<>();

        for (int i = 0; i < tennivaloLista.size(); i++) {
            if (!tennivaloLista.get(i).isElvegzett()) {
                hatralevo.add(tennivaloLista.get(i));
            }
        }
        if (comp != null) {
            hatralevo.sort(comp);
        }

        return hatralevo;
    }

    public void felvesz(Tennivalo t) {
        tennivaloLista.add(t);
    }

    public void elvegez(int elvegzendo) {
        for (Tennivalo i : tennivaloLista) {
            if (i.getSorszam() == elvegzendo) {
                i.setElvegzett(true);
                break;
            }
        }
    }

    public void fontossagSorrend() {
        this.comp = new FontossagComparator();

    }

    public void hataridoSorrend() {
        this.comp = new HataridoComparator();
    }

    public void abcSorrend() {
        this.comp = new ABCComparator();
    }
}

//Legyen egy Tennivalok osztályunk is, amelynek tennivaloLista adattagjában, a felvett Tennivalo példányokat tároljuk. Használjunk a feladat megoldásához List adatszerkezetet.
//
//Valamint legyen Comparator típusú comp adattagunk, mely a sorrendezéshez szükséges Comparator-t tárolja majd.
