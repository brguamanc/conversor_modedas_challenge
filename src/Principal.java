import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("***************************************************");
            System.out.println("Seleccione un tipo de cambio:");
            System.out.println("1) Dólar => Peso Argentino"+'\n'+
                    "2) Peso Argentino => Dólar"+'\n'+
                    "3) Dólar => Real brasileño"+'\n'+
                    "4) Real brasileño => Dólar" +'\n'+
                    "5) Dólar => Peso Colombiano" +'\n'+
                    "6) Peso Colombiano => Dólar" +'\n'+
                    "7) Salir");
            System.out.println("***************************************************");
            var busqueda = Integer.valueOf(sc.nextLine());
            if(busqueda.equals(7)){
                break;
            }
            ConsultaMoneda consulta = new ConsultaMoneda();
             try{
                 MonedaDTO moneda = consulta.consultarMoneda(busqueda);
                 CambioMoneda cambio = new CambioMoneda();
                 System.out.println("Ingrese la cantidad a cambiar");
                 var dinero = Double.valueOf(sc.nextLine());
                 System.out.println("************ Su dinero convertido es: ************ ");
                 double resultado = cambio.cambiarMoneda(moneda,dinero,busqueda);
                 System.out.println(Math.round(resultado * 100d) / 100d);
                 System.out.println("Cambio realizado con éxito");
                 System.out.println("***************************************************");
             }catch (RuntimeException e){
                 System.out.println(e.getMessage());

             }


        }

    }
}
