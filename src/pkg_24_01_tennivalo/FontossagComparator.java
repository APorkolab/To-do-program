package pkg_24_01_tennivalo;

import java.util.Comparator;


public class FontossagComparator implements Comparator<Tennivalo> {

    @Override
    public int compare(Tennivalo egyik, Tennivalo masik) {
        if (egyik.getFontossag() > masik.getFontossag()) {
            return -1;
        } else if (egyik.getFontossag() == masik.getFontossag()) {
            return 0;
        } else {
            return 1;
        }
    }

}