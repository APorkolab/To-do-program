package pkg_24_01_tennivalo;

import java.util.Comparator;

public class ABCComparator implements Comparator<Tennivalo> {

    @Override
    public int compare(Tennivalo egyik, Tennivalo masik) {
        return egyik.getNev().compareTo(masik.getNev());
    }
}
