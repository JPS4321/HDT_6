import java.util.*;
public class Map_Factory {
    //Juan Pablo Solis
    //22102


    public static Map  MAPFactory(String opcion){
        return switch (opcion){
            case "hashmap" -> new HashMap <String, ArrayList<String>>();
            case "treemap" -> new TreeMap <String, ArrayList<String>>();
            case "linkedhashmap" -> new LinkedHashMap<String, ArrayList<String>>();
            default -> null;
        };
    }
}
