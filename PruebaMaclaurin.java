import javax.swing.JOptionPane;

/* 
 *  CALCULADORA IMPLEMENTADA PARA LA ASIGNATURA DE MATEMATICAS III
 * SE CUMPLEN CON LAS FUNCIONES DEL SENO, COSENO, LN Y EULER CUANDO N=10
 * EL VALOR DE X ES ASIGNADO POR EL USUARIO
 * 
 *
 * DESARROLLADO POR:
 * UNIDAD CENTRAL DEL VALLE DEL CAUCA
 * SANTIAGO MARTINEZ SERNA
 * LAURA SOFIA TORO GARCIA
 * SANTIAGO ALEJANDRO SANTACRUZ
 * 
*/


public class PruebaMaclaurin {


    public void Calculadora() {


        // Seleccionar la función a aproximar   
        do{
        int funcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la función a aproximar:\n"
                + "1. seno\n"
                + "2. coseno\n"
                + "3. Ln\n"
                + "4. Euler\n"));
                
        // Ingresar el valor de x
        double x = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x:"));
        double resultado = 0.0;

        // Calcular la aproximación
        switch (funcion) {
            case 1:
                resultado = Seno(x);
                break;
            case 2:
                resultado = Coseno(x);

                break;
            case 3:
                resultado = Ln(x);
                break;
            case 4:
                resultado = Exponencial(x);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: Opción inválida.");
                System.exit(1);
        }

        
        JOptionPane.showMessageDialog(null, "El resultado es de la aproximacion es: " + resultado);
    }while(JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?")==0);
    }

    // INICIO DE FUNCIONES MATEMÁTICAS


    // FUNCION EULER
    public double Exponencial(double x) {
        double aproximacion = 0.0;
        for (int n = 0; n < 10; n++) {
            aproximacion += Math.pow(x, n) / factorial(n);
        }
        return aproximacion;
    }

    // FUNCION LOGARITMO NATURAL
    public static double Ln(double x) {
        if (x <= 0) {
            JOptionPane.showMessageDialog(null, "Error: El logaritmo natural no está definido para números no positivos.");
            System.exit(1);
        }

        double aproximacion = 0.0;
        for (int n = 1; n <= 10; n++) {
            aproximacion += (1.0 / n) * Math.pow((x - 1) / x, n);
        }
        return aproximacion;
    }
    


        // FUNCION SENO
    public double Seno(double x) {
        // Convertir de grados a radianes
        x = Math.toRadians(x);

        double aproximacion = 0.0;
        for (int n = 0; n < 10; n++) {
            aproximacion += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }
        return aproximacion;
    }

    // FUNCION COSENO
    public double Coseno(double x) {
        // Convertir de grados a radianes
        x = Math.toRadians(x);

        double aproximacion = 0.0;
        for (int n = 0; n < 10; n++) {
            aproximacion += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return aproximacion;
    }


    // FUNCION FACTORIAL
    public double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }



     public static void main(String[] args) {
         PruebaMaclaurin cl = new PruebaMaclaurin();
        cl.Calculadora();
    }

}
