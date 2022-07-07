package com.aleksi.model;

import com.aleksi.model.product.TypesOfProducts;
import com.aleksi.model.product.boat.Boat;
import com.aleksi.model.product.boat.BoatBrand;
import com.aleksi.model.product.boat.PassengersCount;
import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.model.product.fishing.FishingSummerType;

public class Main {
    public static void main(String[] args) {
        Boat boat = new Boat(1, "akva", 0, 10.48, 5, "лодка -колодка", 4.35, 220,
                PassengersCount.ONE, BoatBrand.AKVA, TypesOfProducts.TOURISM, TypesOfProducts.BOATS);
        System.out.println(boat);

        FishingSummer fishingSummer = new FishingSummer(2, "крючки", 0, 10.30, 15,
                "крюк одинарный", FishingSummerType.HOOKS);

        FishingSummer fishingSummer1 = new FishingSummer(3, "крючки", 0, 10.30, 15,
                "крюк одинарный", FishingSummerType.HOOKS, TypesOfProducts.FISHING_SUMMER);

        System.out.println(fishingSummer);
        System.out.println(fishingSummer1);
    }
}