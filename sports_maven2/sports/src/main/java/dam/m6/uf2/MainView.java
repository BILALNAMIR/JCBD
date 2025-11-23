package dam.m6.uf2;

import dam.m6.uf2.Controller;
import dam.m6.uf2.Esport;
import dam.m6.uf2.Atleta;
import java.util.List;
import java.util.Scanner;

public class MainView {
    private final Controller controller;
    private final Scanner sc;

    public MainView(Controller controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1.Llistar esports");
            System.out.println("2.Afegir esport");
            System.out.println("3.Llistar atletes");
            System.out.println("4.Afegir atleta");
            System.out.println("5.Buscar atleta");
            System.out.println("6.Sortir");
            System.out.print("Opció: ");

            int op = Integer.parseInt(sc.nextLine());
            try {
                switch (op) {
                    case 1:
                        listEsports();
                        break;
                    case 2:
                        addEsport();
                        break;
                    case 3:
                        listAtletes();
                        break;
                    case 4:
                        addAtleta();
                        break;
                    case 5:
                        buscarAtleta();
                        break;
                    case 6:
                    	buscarAtleta();
                        return;
                    default:
                        System.out.println("opcio incorrecta!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    private void listEsports() throws Exception {
        List<Esport> esports = controller.getAllEsports();
        for (Esport e : esports) System.out.println(e);
    }

    private void addEsport() throws Exception {
        System.out.print("Nom esport: ");
        String nom = sc.nextLine();
        controller.addEsport(nom);
    }

    private void listAtletes() throws Exception {
        List<Atleta> atletes = controller.getAllAtletes();
        for (Atleta a : atletes)
            System.out.println(a.getCod() + " - " + a.getNombre() + " (Esport: " + a.getCodDeporte() + ")");
    }

    private void addAtleta() throws Exception {
        System.out.print("Nom atleta: ");
        String nom = sc.nextLine();
        System.out.print("Codi esport: ");
        int cod = Integer.parseInt(sc.nextLine());
        controller.addAtleta(nom, cod);
    }
    
    private void buscarAtleta() throws Exception {
        System.out.print("Nom a cercar: ");
        String q = sc.nextLine();
        List<String[]> res = controller.searchAtletesByName(q);
        System.out.println("\nResultats cerca:");
        for (String[] row : res) {
            System.out.println(row[0] + " - " + row[1]);
        }
    }
}