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
                + "1. Seno\n"
                + "2. Coseno\n"
                + "3. Euler\n"));
                
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
           /* case 4:
                resultado = Ln(x);
                break;
            */
            case 3:
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
        String mensaje = "¡Bienvenido a la Calculadora de Aproximaciones de Maclaurin!\n\n"
        + "Manual de Usuario:\n\n"
        + "En el siguiente menú, podrás seleccionar la función para conocer su aproximación mediante la serie de Maclaurin.\n"
        + "Se utiliza n = 10 en todas las aproximaciones.\n\n"
        + "1. Función Seno:\n"
        + "   - Ingresa el valor de x (en grados). Rango permitido: 0 - 360.\n\n"
        + "2. Función Coseno:\n"
        + "   - Ingresa el valor de x (en grados). Rango permitido: 0 - 360.\n\n"
        + "3. Función Euler (e^x):\n"
        + "   - Ingresa cualquier valor de x.\n\n"
        + "Presiona 'Cancelar' para salir de la aplicación.\n\n";
        
JOptionPane.showMessageDialog(null, mensaje);

        
        PruebaMaclaurin cl = new PruebaMaclaurin();
        cl.Calculadora();
    }

}
