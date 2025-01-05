
package com.mycompany.src.utils;

import java.util.Random;

public class CodigoUtils {
     
    // Método auxiliar para generar números aleatorios en un rango
    public int generarNumeroRandom(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    public int mostrarCodigo() {
            String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
                    String[] abecedariord = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q",
                            "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};

                    Random random = new Random();

                    String letra = abecedario[random.nextInt(abecedario.length)]; 
                    String letrados = abecedariord[random.nextInt(abecedariord.length)];

                    int numero1 = generarNumeroRandom(0, 10, random);
                    int numero2 = generarNumeroRandom(0, 10, random);
                    int numero3 = generarNumeroRandom(0, 10, random);
                    int numero4 = generarNumeroRandom(1, 10, random);


                    int codigo = numero1 +numero2 + numero3 + numero4;
                    System.out.println("Código generado: " + codigo);
             
         return codigo;
    }
    public int generarCodigoRandomUsuario() {
        int random = (int) (Math.random()*999)+999;
        return random;
    }
    public int generarCodigoRandomComentarios() {
        int random = (int) (Math.random()*999)+2999;
        return random;
    }
    public int generarCodigoRandomTarea() {
        int random = (int) (Math.random()*4999) +4999;
        return random;
    }
    public int generarCodigoRandomEtiqueta() {
        int random = (int) (Math.random()*1999) +4999;
        return random;
    }
    public int generarCodigoRandomActividades() {
        int random = (int) (Math.random()*999) +7999;
        return random;
    }
    public int generarCodigoRandomCategoria() {
        int random = (int) (Math.random()*999) +9999;
        return random;
    }
    public int generarCodigoRandomTarea_Etiqueta() {
        int random = (int) (Math.random()*9999) +99999;
        return random;
    }
    
    public static void main(String[] args) {
        CodigoUtils random = new CodigoUtils();
        System.out.println("gaaa: " + random.generarCodigoRandomUsuario());
        System.out.println("ya: " + random.generarCodigoRandomComentarios());
        System.out.println("ya: " + random.generarCodigoRandomTarea());
        
        System.out.println("");
    }
}
