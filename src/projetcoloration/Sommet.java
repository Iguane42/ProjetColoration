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
public class Sommet {
    private ArrayList<Sommet> voisins;
    
    public Sommet()
    {
        this.voisins = new ArrayList<>();
    }

    /**
     * @return the voisins
     */
    public ArrayList<Sommet> getVoisins() {
        return voisins;
    }
    
    
}
