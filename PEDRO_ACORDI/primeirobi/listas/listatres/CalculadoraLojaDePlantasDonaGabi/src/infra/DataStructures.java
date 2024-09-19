package infra;

import domain.entities.Sale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class DataStructures {

    public static ArrayList<Sale> salesList = new ArrayList<>();
    public static HashMap<LocalDate, Integer> qtySalesPerDay = new HashMap<>();
}
