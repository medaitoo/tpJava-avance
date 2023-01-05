package presentation;

import metier.MetierProduitImpl;
import metier.Produit;

import java.util.Scanner;

public class application {
    public static void main(String[] args) {

        int x = 0;
        long id = 0l;
        String nom = "";
        String marque = "";
        double prix = 0f;
        String description = "";
        int qte = 0;

        MetierProduitImpl a = new MetierProduitImpl();
        Produit p1 = new Produit(1l, "produit1", "marque1", 1000.00f, "disc1", 142);
        a.add(p1);

        do {
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");

            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();

            switch (x){
                case 1:
                    System.out.println(a.getAll());
                    break;
                case 2:
                    System.out.println("Entrez l\'id :");
                    Scanner scId = new Scanner(System.in);
                    System.out.println(a.findById(scId.nextLong()).toString());
                    break;
                case 3:
                    Produit produit = new Produit();

                    System.out.println("Entrez l\'id :");
                    id = sc.nextLong();
                    produit.setId(id);
                    if(a.findById(id) != null){
                        System.out.println("Déjà éxistant dans la liste!");
                        break;
                    }
                    System.out.println("Entrez le nom du produit :");
                    nom = sc.next();
                    produit.setNom(nom);

                    System.out.println("Entrez la marque :");
                    marque = sc.next();
                    produit.setMarque(marque);

                    System.out.println("Entrez le prix :");
                    prix = sc.nextFloat();
                    produit.setPrix(prix);

                    System.out.println("Entrez la description :");
                    description = sc.next();
                    produit.setDescription(description);

                    System.out.println("Entrez la quantité en stock :");
                    qte = sc.nextInt();
                    produit.setNbrEnStock(qte);
                    a.add(produit);

                    for (Produit p : a.getAll()) {
                        System.out.println(p);
                    }
                    System.out.println("Le produit a été inséré avec succés.");
                    break;
                case 4:
                    System.out.println("Entrez l\'id du produit à supprimer:");
                    id = sc.nextLong();
                    a.delete(id);
                    break;
                case 5:
                    System.out.println("cdc");
                    break;
                default:
                    System.out.println("Choisissez un autre numéro");
                    break;
            }
        }while (x != 5);
    }
}
