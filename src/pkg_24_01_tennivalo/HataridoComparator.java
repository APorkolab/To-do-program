package pkg_24_01_tennivalo;

import java.util.Comparator;


public class HataridoComparator implements Comparator<Tennivalo> {

    @Override
    public int compare(Tennivalo egyik, Tennivalo masik) {
        if(egyik.getHatarido().isBefore(masik.getHatarido())) {
            return -1;
        }
        else if(egyik.getHatarido().isEqual(masik.getHatarido())) {
            return 0;
        }
        else {
            return +1;
        }
    }
}