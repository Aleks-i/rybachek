package com.aleksi;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.model.product.boat.BoatBrand;
import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.model.product.fishing.FishingSummerType;

public class Main {
    public static void main(String[] args) {
        Boat boat = new Boat(1, "akva", 10.48, 5, "лодка -колодка", 4.35, 220,
                1, BoatBrand.AKVA);
        System.out.println(boat);

        FishingSummer fishingSummer = new FishingSummer(2, "крючки", 10.30, 15,
                "крюк одинарный", FishingSummerType.HOOKS);

        FishingSummer fishingSummer1 = new FishingSummer(3, "крючки", 10.30, 15,
                "крюк одинарный", FishingSummerType.HOOKS);

        System.out.println(fishingSummer);
        System.out.println(fishingSummer1);
    }
}