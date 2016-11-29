/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcoloration;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Graphe {
    
    private ArrayList<Sommet> sommets;
    
    public Graphe() {
        this.sommets = new ArrayList<>();
    }
    
    public Graphe(ArrayList<Sommet> sommets) {
        this.sommets = sommets;
    }

    /**
     * @return the sommets
     */
    public ArrayList<Sommet> getSommets() {
        return sommets;
    }
    
    public void relierSommets(int indice1, int indice2) {
        Sommet sommet1 = sommets.get(indice1);
        Sommet sommet2 = sommets.get(indice2);
        sommet1.getVoisins().add(sommet2);
    }

    /**
     * @param sommets the sommets to set
     */
    public void setSommets(ArrayList<Sommet> sommets) {
        this.sommets = sommets;
    }
    
    private ArrayList<Sommet> getListeOrdreDecroissant(){
        int max = 0;
        for (Sommet sommet : sommets) {
            int nbvoisins = sommet.getVoisins().size();
            if (nbvoisins > max) {
                max = nbvoisins;
            }
        }
        ArrayList<Sommet> buffer = new ArrayList<>();
        for (int i = max; i >= 0; i--) {
            for (Sommet sommet : sommets) {
                int nbvoisins = sommet.getVoisins().size();
                if (nbvoisins == i) {
                    buffer.add(sommet);
                }
            }
        }
        
        return buffer;
    }
    
    public void welshPowell()
    {
        long debut = System.currentTimeMillis();
        //ArrayList<Sommet> buffer = getListeOrdreDecroissant();
        ArrayList<Sommet> buffer = sommets;
        int couleur = 1;
        int nbcolore = 0;
        while(nbcolore < buffer.size()){
            for(Sommet sommet : buffer) {
                if (sommet.getCouleur() == -1 && sommet.verifierCouleurVoisins(couleur) == true) {
                    sommet.setCouleur(couleur);
                    nbcolore ++;
                }
            }
            couleur ++;
        }
        long fin = System.currentTimeMillis()-debut;
        System.out.println("Nombre de couleur : "+couleur+". Exécuté en "+fin+" ms");

    }
    
    //public void greedy(ArrayList<Sommet> ALS){
    public void greedy(){
        long debut = System.currentTimeMillis();
        //ArrayList<Sommet> ALS = getListeOrdreDecroissant();
        ArrayList<Sommet> ALS = sommets;
        int nbCouleur;
        int nbCouleurMax = 1;
        
        for(Sommet s : ALS){
            nbCouleur = 1;
            while(!s.verifierCouleurVoisins(nbCouleur)){
                nbCouleur++;
                if(nbCouleur > nbCouleurMax){
                    nbCouleurMax = nbCouleur;
                }
            }
            s.setCouleur(nbCouleur);
        }
        
        long fin = System.currentTimeMillis()-debut;
        System.out.println("Nombre de couleur : "+nbCouleurMax+". Exécuté en "+fin+" ms");

    }
    
    public void dSatur(){
        
    }
}
