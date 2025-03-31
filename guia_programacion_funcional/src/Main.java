import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Ejercicio 1: Crear una Function que duplique un número y mostrar el resultado con apply().
        /*
        Function<Integer, Integer> duplicarNumero = x -> 2 * x;
        System.out.println(duplicarNumero.apply(5));

         */

        // Ejercicio 2: Crear un Predicate que verifique si un número es par.
        /*
        Predicate<Integer> verificarPar = x -> x % 2 == 0;
        System.out.println(verificarPar.test(7));

         */

        // Ejercicio 3: Crear un Consumer que reciba un mensaje y lo imprima en consola
        /*
        Consumer<String> imprimirMensaje_2 = m -> System.out.println(m);
        imprimirMensaje_2.accept("Probando la Interfaz Consumer con Lambda");

         */

        // Ejercicio 4: Reescribir un Consumer con una referencia a método en lugar de lambda
        /*
        Consumer<String> imprimirMensaje = System.out::println;
        imprimirMensaje.accept("Probando la interfaz Consumer");

         */

        // Ejercicio 5: Crear un método estático llamado "cuadrado" y usarlo con Function mediante referencia a método.
        /*
        Function<Double, Double> calcularCuadrado = Cuadrado::calcular;
        System.out.println(calcularCuadrado.apply(2.0));

         */

        List<String> palabras = Arrays.asList("Hola", "Como", "Estas", "Oso");

        // Ejercicio 6: Dada una lista de palabras, usá stream + map para imprimirlas en mayúsculas.
        /*
        palabras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

         */

        // Ejercicio 7: Imprimir solo las palabras que tengan más de 4 letras usando filter.
        /*
        palabras.stream()
                .filter(palabra -> palabra.length() > 4)
                .forEach(System.out::println);
         */

        // Ejercicio 8: Dada una lista de enteros, usá map y reduce para sumar los cuadrados.
        /*
        List<Integer> numeros = Arrays.asList(2, 4, 6, 8);

        System.out.println(
                numeros.stream()
                        .map(n -> n * n)
                        .reduce(0, Integer::sum)
        );

         */

        // Ejercicio 9: Convertir una lista de palabras a mayúsculas, luego filtrar las que empiezan con vocal, e imprimirlas.
        /*
        palabras.stream()
                .map(String::toUpperCase)
                .filter(palabra -> palabra.startsWith("A") || palabra.startsWith("E") || palabra.startsWith("I") || palabra.startsWith("O") || palabra.startsWith("U"))
                .forEach(System.out::println);

         */

        // Ejercicio 10: Simular un valor que puede ser null usando Optional. Mostrar el valor si existe o un mensaje alternativo si no.
        /*
        String nombre = "Enzo";

        Optional<String> nombre_2 = Optional.of(nombre);

        nombre_2 = Optional.empty();

        System.out.println(nombre_2.orElse("El nombre es nulo"));

         */

        // Ejercicio 11: Usar Optional.map para obtener la longitud de una palabra, y orElse para manejar el caso vacío.
        /*
        String palabra = "Caracteristica";

        Optional<String> longitud = Optional.of(palabra);

        longitud = Optional.empty();

        System.out.println(longitud.map(String::length).orElse(0));


         */
    }
}