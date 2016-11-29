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
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    // Fonction qui permet d'importer les fichiers textes et de les insérer dans les graphes
    public static Graphe importFichier(String file) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            ArrayList<Sommet> sommets = new ArrayList<>();

            while(line != null){
                //System.out.println(line);
                line = br.readLine();
            }
            Graphe graphe = new Graphe();
            
            return graphe;
        }
    }
    
}
