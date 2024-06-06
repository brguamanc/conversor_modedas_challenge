public class CambioMoneda {
    public double cambiarMoneda(MonedaDTO moneda, double valorInicial, int opcion ){
        var codigo = new String();

        if (opcion == 2 || opcion == 4 || opcion == 6) {
            codigo = "USD";
        } else if (opcion == 1 ) {
            codigo= "ARS";
        } else if (opcion == 3) {
            codigo ="BRL";
        }else if (opcion == 5) {
            codigo ="COP";
        }
        var cambio = moneda.conversion_rates().get(codigo);
        double resultado = valorInicial * cambio;
        return resultado;
    }
}
