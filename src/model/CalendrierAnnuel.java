package model;

import java.util.Arrays;

public class CalendrierAnnuel {

    private class Mois {
        private String nom;
        private boolean[] jours;

        public Mois(String nom, int nbJours) {
            this.nom = nom;
            this.jours = new boolean[nbJours];
            Arrays.fill(this.jours, false);
         }

        public boolean estLibre(int jour) {
            return !jours[jour - 1];
            }


        public void reserver(int jour) {
            if (!estLibre(jour)) {
                throw new IllegalStateException("Ce jour est déjà réservé.");
            }
            jours[jour - 1] = true;
        }
    }

    private Mois[] mois;


    public CalendrierAnnuel() {
        this.mois = new Mois[12];
        this.mois[0] = new Mois("Janvier", 31);
        this.mois[1] = new Mois("Février", 28);
        this.mois[2] = new Mois("Mars", 31);
        this.mois[3] = new Mois("Avril", 30);
        this.mois[4] = new Mois("Mai", 31);
        this.mois[5] = new Mois("Juin", 30);
        this.mois[6] = new Mois("Juillet", 31);
        this.mois[7] = new Mois("Août", 31);
        this.mois[8] = new Mois("Septembre", 30);
        this.mois[9] = new Mois("Octobre", 31);
        this.mois[10] = new Mois("Novembre", 30);
        this.mois[11] = new Mois("Décembre", 31);
    }

    public boolean estLibre(int jour, int mois) {
        if (mois < 1 || mois > 12) {
            throw new IllegalArgumentException("Mois invalide. Le mois doit être entre 1 et 12.");
        }
        return this.mois[mois - 1].estLibre(jour);
    }


    public boolean reserver(int jour, int mois) {
        if (mois < 1 || mois > 12) {
            throw new IllegalArgumentException("Mois invalide. Le mois doit être entre 1 et 12.");
        }
        try {
            this.mois[mois - 1].reserver(jour);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

}

