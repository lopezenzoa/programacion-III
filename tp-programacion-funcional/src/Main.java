import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       // Ejercicio 1 - Dada una lista de números enteros, utiliza filter para obtener solo los números pares y guárdalos en una nueva lista.
        /*
       List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();

       // Imprime una lista de numeros pares
       System.out.println(pares);

         */

       // Ejercicio 2 - Usa map para convertir cada nombre de una lista en su versión en mayúsculas.

        List<String> animales = Arrays.asList("gato", "perro", "loro", "coballo");
        /*
        animales.stream()
                .map(String::toUpperCase) // transforma cada palabra de la lista en su version en MAYUSCULA
                .forEach(System.out::println); // imprime cada valor que mapea

         */

        // EJERCICIO 3 - Usa sorted para ordenar una lista de números enteros de menor a mayor.

        List<Integer> numeros = Arrays.asList(12, 2, 36, 42, 5, 16, 7, 28, 9, 10);
/*
        List<Integer> numeros_ordenados = numeros.stream().sorted().toList();

        // Imprime la lista de numeros de forma ordenada
        System.out.println(numeros_ordenados);

         */

        // EJERCICIO 4 - Dada una lista de números, usa filter y count para contar cuántos valores son mayores que 7.
        /*
        long mayores_siete = numeros.stream()
                .filter(n -> n > 7)
                .count();

        System.out.println(mayores_siete);

         */

         // EJERCICIO 5 - Usa limit para extraer solo los primeros 5 elementos de una lista de números.
        /*
        List<Integer> primeros =  numeros.stream().limit(5).toList();

        // Imprime los primeros 5 numeros de la lista numeros
        System.out.println(primeros);

         */

        // EJERCICIO 6 - Usa map para transformar una lista de palabras en una lista con la longitud de cada palabra.
        /*
        List<Integer> longitud = animales.stream()
                .map(String::length) // para cada valor de la lista animales (ej "gato") lo transforma en un int correspondiente a la cantidad de letras de la palabra gato=4
                .toList(); // lo lista en una nueva lista

        System.out.println(longitud);

         */

        // EJERCICIO 7 Dada una lista de nombres, usa reduce para concatenarlos en un solo String separados por comas

        List<String> nombres = Arrays.asList("Ailen", "Enzo", "Juan", "Nico", "Emilia");
        /*
        Optional<String> nombres_concatenados = nombres.stream()
                .reduce((p1, p2) -> p1 + ", " + p2);

        System.out.println(nombres_concatenados.get());

         */

        // EJERCICIO 8 - Usa distinct para remover duplicados de una lista de números enteros.
        /*
        List<Integer> numerosDuplicados = Arrays.asList(1, 2 ,3 ,5,5,6,8,8);
        numerosDuplicados.stream()
                .distinct()
                .forEach(System.out::println);

         */

        // EJERCICIO 9 - Usa sorted y limit para encontrar los 3 números más grandes en una lista de enteros.
        /*
        List<Integer> numeros_grandes = numeros.stream().sorted((a, b) -> b - a).limit(3).toList();
        System.out.println(numeros_grandes);

         */

        // EJERCICIO 10 - Usa Collectors.groupingBy para agrupar una lista de palabras según su cantidad de caracteres
        /*
        Map<Integer, List<String>> palabras_por_caracteres = animales.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(palabras_por_caracteres);

         */

        // EJERCICIO 11 - Usa reduce para calcular el producto de todos los números de una lista.
        /*
        numeros = Arrays.asList(1, 2, 3, 4, 5);

        Integer producto = numeros.stream().reduce(1, (a, b) -> a * b).get();
        System.out.println(producto);

         */

        // EJERCICIO 12 - Usa reduce para encontrar el nombre con más caracteres en una lista de nombres.
        /*
        nombres.stream()
                .sorted((n1, n2) -> n2.length() - n1.length())
                .limit(1)
                .forEach(System.out::println);

         */ // sin utilizar reduce 

        /*
        String nombre_mas_largo = nombres.stream()
                .reduce((n1, n2) -> n1.length() > n2.length() ? n1 : n2).get(); // campara el n1 con n2 como devuelve un booleano si es verdad (n1.length() > n2.length()?) retorna n1 si es falto retorna n2 (OPERADORES TERNARIOS)

        System.out.println(nombre_mas_largo);

         */

        // EJERCICIO 13 - Usa map y Collectors.joining para convertir una lista de enteros en una cadena con valores separados por -.
        /*
        String cadena = numeros.stream().map((n1) -> n1.toString()).collect(Collectors.joining(" - ")).toString();
        System.out.println(cadena);

         */

        // EJERCICIO 14 - Usa Collectors.partitioningBy para separar los números de una lista en pares e impares.
        /*
        Map<Boolean, List<Integer>> pares_impares = numeros.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // Imprime un mapa particionando la lista originales en valores pares e impares
        System.out.println(pares_impares);

         */

        // EJERCICIO 15 - Usa filter, map y reduce para obtener la suma de los cuadrados de los números impares de una lista.
        /*
        numeros = Arrays.asList(1, 2, 3, 4, 5);

        Integer suma_cuadrados_impares = numeros.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .reduce(Integer::sum)
                .get();

        System.out.println(suma_cuadrados_impares);

         */
    }


}