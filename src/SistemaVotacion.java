import java.util.Scanner;

public class SistemaVotacion{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxCandidatos = 10;  
        int[] votos = new int[maxCandidatos + 1]; 

        int totalVotos = 0;
        int candidato;

        System.out.println("=== SISTEMA DE VOTACIÓN ===");
        System.out.println("Ingrese el número del candidato (1 - " + maxCandidatos + ")");
        System.out.println("Ingrese 0 para terminar.");

        while (true) {
            System.out.print("Voto: ");
            candidato = scanner.nextInt();

            if (candidato == 0) {
                break;
            }

            if (candidato >= 1 && candidato <= maxCandidatos) {
                votos[candidato]++;  // Se suma el voto en su cubeta
                totalVotos++;
            } else {
                System.out.println("Número de candidato inválido.");
            }
        }

        System.out.println("\n=== RESULTADOS ===");

        if (totalVotos == 0) {
            System.out.println("No se registraron votos.");
        } else {
            for (int i = 1; i <= maxCandidatos; i++) {
                if (votos[i] > 0) {
                    double porcentaje = (votos[i] * 100.0) / totalVotos;
                    System.out.printf("Candidato %d: %d votos (%.2f%%)%n",
                            i, votos[i], porcentaje);
                }
            }

            System.out.println("Total de votos: " + totalVotos);
        }

        scanner.close();
    }
}
