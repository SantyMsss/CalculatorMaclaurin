import javax.swing.JOptionPane;


public class PruebaMaclaurin {
    public void calculateAndDisplayResult() {
        String funcion = JOptionPane.showInputDialog("Elija la función (exponencial, logaritmo natural, seno, coseno):").toLowerCase();
        double x = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x:"));
        double resultado = 0.0;

        if (funcion.equals("exponencial")) {
            resultado = calcularAproximacionExponencial(x);
        } else if (funcion.equals("logaritmo natural")) {
            resultado = calcularAproximacionLogaritmoNatural(x);
        } else if (funcion.equals("seno")) {
            resultado = calcularAproximacionSeno(x);
        } else if (funcion.equals("coseno")) {
            resultado = calcularAproximacionCoseno(x);
        } else {
            JOptionPane.showMessageDialog(null, "Función no reconocida.");
            System.exit(1);
        }

        JOptionPane.showMessageDialog(null, String.format("Aproximación de %s(%.2f) con 10 términos de la serie de Maclaurin: %.6f", funcion, x, resultado));
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
