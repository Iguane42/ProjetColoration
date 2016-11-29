/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcoloration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Sommet {
    private ArrayList<Sommet> voisins;
    private int couleur;
    
    public Sommet()
    {
        this.voisins = new ArrayList<>();
        this.couleur = -1;
    }

    /**
     * @return the voisins
     */
    public ArrayList<Sommet> getVoisins() {
        return voisins;
    }

    /**
     * @return the couleur
     */
    public int getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
    
    public boolean verifierCouleurVoisins(int couleur) {
        for (Sommet voisin : voisins) {
            if (voisin.getCouleur() == couleur) {
                return false;
            }
        }
        return true;
    }
    
    public int getDsat(){
        ArrayList<Integer> couleurs = new ArrayList<>();
        for (Sommet voisin : voisins) {
            int color = voisin.getCouleur();
            if (color != -1) {
                boolean estpresent = false;
                for (int couleur2 : couleurs){
                    if (color == couleur2) {
                        estpresent = true;
                        break;
                    }
                }
                if (estpresent == false) {
                    couleurs.add(color);
                }
            }
        }
        return couleurs.size();
    }
    
}
