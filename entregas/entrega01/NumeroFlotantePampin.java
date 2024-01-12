public class NumeroFlotantePampin {
    public static void main(String[] args) {

        float datoFloat = 14.5f;

        System.out.println("Dato float: " + datoFloat);

        System.out.println("Parte entera: " + (int) datoFloat);
        
        System.out.println("Parte decimal: " + (datoFloat - (int) datoFloat));

    }
}