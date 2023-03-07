import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Controlador {
    Scanner sc = new Scanner(System.in);
    String respS;
    int RespI;
    boolean ciclo = true;
    ArrayList<String> Temp = new ArrayList<String>();
    String Key;
    String Vari = "";
    String Valor;
    Map<String, ArrayList<String>> mp;
    Map<String, ArrayList<String>> checkout;
    Boolean Encontrado = false;
    String Dire = "C:\\Users\\Usuario\\Desktop\\Universidad\\Tercer Semestre\\Datos Compu\\HDT_6\\src\\ListadoProducto.txt";



    public  void Iniciar(){
        System.out.println("Elija el tipo de hashmap que desea escribir: HashMap, TreeMap, LinkedHashMap");
        respS = sc.next();
        respS = respS.toLowerCase();
        mp = Map_Factory.MAPFactory(respS);
        checkout = Map_Factory.MAPFactory(respS);



        Reader();
        while (ciclo){
            RespI = 0;
            System.out.println("Elija el numero de una de las opciones: ");
            System.out.println("1. Agregar Producto al carrito");
            System.out.println("2. Mostrar categoria de un producto");
            System.out.println("3. Mostrar productos en el carrito y su cantidad");
            System.out.println("4. Mostrar productos en el carrito y su cantidad ordenado");
            System.out.println("5. Mostrar Producto y categoria del inventario");
            System.out.println("6. Mostrar Producto y categoria del inventario ordenado");
            System.out.println("7. Salir");

            RespI = sc.nextInt();
            sc.nextLine();

            if(RespI == 1){
                System.out.println("Escriba la categoria del producto que desea: ");
                Key = sc.nextLine();
                boolean result = mp.containsKey(Key);
                if(result){
                    System.out.println("Escriba el nombre del producto que desea");
                    Valor = sc.nextLine();
                    checkout.get(Key).add(Valor);
                }
                if(!result){
                    System.out.println("ERROR: NO EXISTE LA CATEGORIA QUE DESEA");
                }
            }
            if(RespI == 2){
                System.out.println("");
                System.out.println("Escriba el nombre del producto que desea: ");
                respS = sc.nextLine();
                String[] strings = mp.keySet().toArray(new String[mp.size()]);
                for(int i = 0; i < strings.length;i++){
                    for (int j = 0; j < mp.get(strings[i]).size(); j++) {
                        if(mp.get(strings[i]).get(j).equals(respS)){
                            Encontrado = true;
                            Vari = strings[i];
                        }
                    }
                }
                if (Encontrado){
                    System.out.println("La categoria al que su producto pertenece es: "+Vari);
                }
                else {
                    System.out.println("No se ha encontrado el producto en el sistema");
                }
                System.out.println("");
            }
            if(RespI == 3){
                for(String key: checkout.keySet()){
                    System.out.println(key + " :" + checkout.get(key));
                }
            }
            if(RespI == 4){
                String[] strings = checkout.keySet().toArray(new String[checkout.size()]);
                ArrayList<String> Ordenado = new ArrayList<String>(Arrays.asList(strings));
                Collections.sort(Ordenado);
                for(int i = 0; i < Ordenado.size();i++){
                    System.out.println(Ordenado.get(i) + " :" + checkout.get(Ordenado.get(i)));
                }
            }
            if(RespI == 5){
                for(String key: mp.keySet()){
                    System.out.println(key + " :" + mp.get(key));
                }
            }
            if(RespI == 6){
                String[] strings = mp.keySet().toArray(new String[mp.size()]);
                ArrayList<String> Ordenado = new ArrayList<String>(Arrays.asList(strings));
                Collections.sort(Ordenado);
                for(int i = 0; i < Ordenado.size();i++){
                    System.out.println(Ordenado.get(i) + " :" + mp.get(Ordenado.get(i)));
                }
            }
            if(RespI == 7){
                System.out.println("SALIENDO DEL PROGRAMA....");
                break;
            }






        }
    }

    public void Reader(){
        try(BufferedReader br = new BufferedReader(new FileReader(Dire))){
            String ln;
            while ((ln = br.readLine()) != null){
                String[] partes = ln.split("\\|");
                Key = partes[0].trim();
                Valor = partes[1].trim();
                //TESTEO 1
                if(mp.containsKey(Key)){
                    mp.get(Key).add(Valor);
                }
                else {
                    ArrayList<String> Prueba = new ArrayList<String>();
                    ArrayList<String> Prueba2 = new ArrayList<String>();
                    mp.put(Key,Prueba);
                    checkout.put(Key,Prueba2);
                    mp.get(Key).add(Valor);
                    Prueba2.removeAll(Prueba2);
                }
            }
        }catch (Exception e){
            e.printStackTrace();

        }
    }




}
