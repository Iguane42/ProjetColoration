/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcoloration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class ProjetColoration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        importFichier("../queen5_5.txt");
    }
    
    // Fonction qui permet d'importer les fichiers textes et de les insérer dans les graphes
    //public static Graphe importFichier(String file) throws FileNotFoundException, IOException{
    public static void importFichier(String file) throws FileNotFoundException, IOException{
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            
            ArrayList<Sommet> ALS = new ArrayList<>();
            
            String nomFichier;
            String oriente;
            int nbSommets;
            int nbValSommet;
            int nbArcs;
            int nbValArc;
            
            boolean listeSommet = false;
            boolean listeArete = false;

            while(line != null){
                if(line.indexOf("Nom: ") != -1){
                    nomFichier = line.substring(line.indexOf(" ")+1);
                    System.out.println(nomFichier);
                    line = br.readLine();
                } else if(line.indexOf("Oriente(non/oui): ") != -1){
                    oriente = line.substring(line.indexOf(" ")+1);
                    System.out.println(oriente);
                    line = br.readLine();
                } else if(line.indexOf("NbSommets: ") != -1){
                    nbSommets = Integer.parseInt(line.substring(line.indexOf(" ")+1));
                    System.out.println(nbSommets);
                    line = br.readLine();
                } else if(line.indexOf("NbValSommet: ") != -1){
                    nbValSommet = Integer.parseInt(line.substring(line.indexOf(" ")+1));
                    System.out.println(nbValSommet);
                    line = br.readLine();
                } else if(line.indexOf("NbArcs: ") != -1){
                    nbArcs = Integer.parseInt(line.substring(line.indexOf(" ")+1));
                    System.out.println(nbArcs);
                    line = br.readLine();
                } else if(line.indexOf("NbValArc: ") != -1){
                    nbValArc = Integer.parseInt(line.substring(line.indexOf(" ")+1));
                    System.out.println(nbValArc);
                    line = br.readLine();
                } else if(line.indexOf("--- Liste des sommets") != -1 || listeSommet){
                    if(listeSommet == false){
                        listeSommet = true;
                    } else{
                        if(line.indexOf("--- Liste des aretes") != -1){
                            listeSommet = false;
                            listeArete = true;
                        } else{
                            int index = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                            ALS.add(index, new Sommet());
                            System.out.println(line);
                        }
                    }
                    line = br.readLine();
                } else if(listeArete){
                    if(listeArete == false){
                        listeSommet = false;
                        listeArete = true;
                    } else{
                        System.out.println(line);
                    }
                    line = br.readLine();
                } else{
                    listeSommet = false;
                    listeArete = false;
                    System.out.println(line);
                    line = br.readLine();
                }
                
            }
        }
    }
    
}
