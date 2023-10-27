import javax.swing.JOptionPane;


public class PruebaMaclaurin {



    public void calculateAndDisplayResult() {



        int funcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la función a aproximar:\n"
                + "1. seno\n"
                + "2. coseno\n"
                + "3. \n"
                + "4. \n"));
                

        double x = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x:"));
        double resultado = 0.0;

        switch (funcion) {
            case 1:
                resultado = calcularAproximacionSeno(x);
                break;
            case 2:
                resultado = calcularAproximacionCoseno(x);
                
                break;
            case 3:
                resultado = (x);
                break;
            case 4:
                resultado = (x);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: Opción inválida.");
                System.exit(1);
        }

        
        JOptionPane.showMessageDialog(null, "El resultado es de la aproximacion es: " + resultado);
    }

    public double calcularAproximacionExponencial(double x) {
        double aproximacion = 0.0;
        for (int n = 0; n < 10; n++) {
            aproximacion += Math.pow(x, n) / factorial(n);
        }
        return aproximacion;
    }

    public double calcularAproximacionLogaritmoNatural(double x) {
        if (x <= 0) {
            JOptionPane.showMessageDialog(null, "Error: El logaritmo natural no está definido para números no positivos.");
            System.exit(1);
        }

        double aproximacion = 0.0;
        for (int n = 1; n <= 10; n++) {
            if (n % 2 == 1) {
                aproximacion += (1.0 / n) * Math.pow((x - 1) / x, n);
            } else {
                aproximacion -= (1.0 / n) * Math.pow((x - 1) / x, n);
            }
        }
        return aproximacion;
    }

    public double calcularAproximacionSeno(double x) {
        double aproximacion = 0.0;
        for (int n = 0; n < 10; n++) {
            aproximacion += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }
        return aproximacion;
    }

    public double calcularAproximacionCoseno(double x) {
        double aproximacion = 0.0;
        for (int n = 0; n < 10; n++) {
            aproximacion += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return aproximacion;
    }

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
         PruebaMaclaurin calculator = new PruebaMaclaurin();
        calculator.calculateAndDisplayResult();
    }

}
