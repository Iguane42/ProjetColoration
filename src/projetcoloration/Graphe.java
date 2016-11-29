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
}
