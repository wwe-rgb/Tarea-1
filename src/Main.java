//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String archivoCSV = "C:\\Users\\tbere\\IdeaProjects\\untitled\\src\\csv\\Presencia Redes Sociales.csv";
        String linea = "";
        String separador = "";
        String cvsSplitBy=",";






        /*int lineNumber = 0;  // Contador de filas

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((linea = br.readLine()) != null) {
                lineNumber++;  // Incrementa el contador de filas

                // Divide la línea en valores
                String[] values = linea.split(cvsSplitBy);

                // Buscar números en la línea
                for (int i = 0; i < values.length; i++) {
                    try {
                        double number = Double.parseDouble(values[i]);
                        System.out.println("Número encontrado: " + number + " en la fila " + lineNumber + ", columna " + (i + 1));
                    } catch (NumberFormatException e) {
                        // No es un número, continuar
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};

        int[] twitterFollowers = new int[6];
        int[] youtubeViews = new int[6];
        int[] twitterLikes = new int[6];
        int[] facebookLikes = new int[6];
        int[] youtubeLikes = new int[6];

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((linea = br.readLine()) != null) {
                // Usar coma como separador

                String[] data = linea.split(cvsSplitBy);

                String redSocial = data[0].trim();
                String concepto = data[1].trim();

                if (redSocial.equals("TWITTER") && concepto.equals("SEGUIDORES")) {
                    for (int i = 0; i < 6; i++) {
                        twitterFollowers[i] = Integer.parseInt(data[i + 3].trim());
                    }
                }

                if (redSocial.equals("YOUTUBE") && concepto.equals("VISUALIZACIONES")) {
                    for (int i = 0; i < 6; i++) {
                        youtubeViews[i] = Integer.parseInt(data[i + 3].trim());
                    }
                }

                if (redSocial.equals("TWITTER") && concepto.equals("ME GUSTA EN PUBLICACIONES")) {
                    for (int i = 0; i < 6; i++) {
                        twitterLikes[i] = Integer.parseInt(data[i + 3].trim());
                    }
                }

                if (redSocial.equals("FACEBOOK") && concepto.equals("ME GUSTA EN PUBLICACIONES")) {
                    for (int i = 0; i < 6; i++) {
                        facebookLikes[i] = Integer.parseInt(data[i + 3].trim());
                    }
                }

                if (redSocial.equals("YOUTUBE") && concepto.equals("ME GUSTA EN PUBLICACIONES")) {
                    for (int i = 0; i < 6; i++) {
                        youtubeLikes[i] = Integer.parseInt(data[i + 3].trim());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calcular la diferencia de seguidores en Twitter entre enero y junio
        int twitterFollowersDifference = twitterFollowers[5] - twitterFollowers[0];
        System.out.println("Diferencia de seguidores en Twitter entre enero y junio: " + twitterFollowersDifference);

        // Calcular la diferencia de visualizaciones de YouTube entre dos meses seleccionados
        int month1 = 0; // Enero
        int month2 = 5; // Junio
        int youtubeViewsDifference = youtubeViews[month2] - youtubeViews[month1];
        System.out.println("Diferencia de visualizaciones en YouTube entre enero y junio: " + youtubeViewsDifference);

        // Calcular el promedio de crecimiento de Twitter y Facebook entre enero y junio
        double twitterGrowthAverage = (twitterFollowers[5] - twitterFollowers[0]) / 6.0;
        double facebookGrowthAverage = (facebookLikes[5] - facebookLikes[0]) / 6.0;
        System.out.println("Promedio de crecimiento de seguidores en Twitter: " + twitterGrowthAverage);
        System.out.println("Promedio de crecimiento de 'Me gusta' en Facebook: " + facebookGrowthAverage);

        // Calcular el promedio de "Me gusta" en YouTube, Twitter y Facebook
        double twitterLikesAverage = calculateAverage(twitterLikes);
        double facebookLikesAverage = calculateAverage(facebookLikes);
        double youtubeLikesAverage = calculateAverage(youtubeLikes);

        System.out.println("Promedio de 'Me gusta' en Twitter: " + twitterLikesAverage);
        System.out.println("Promedio de 'Me gusta' en Facebook: " + facebookLikesAverage);
        System.out.println("Promedio de 'Me gusta' en YouTube: " + youtubeLikesAverage);
    }

    public static double calculateAverage(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / (double) data.length;
    }
}