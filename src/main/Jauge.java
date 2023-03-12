package main;

import java.util.Map;

/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Jauge {
    /**
     * Le type de la jauge
     */
    protected TypeJauge type;
    /**
     * Le nom de la jauge
     */
    protected String nom;
    /**
     * La valeur de la jauge
     */
    protected int valeur;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public Jauge(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    /**
     * Retourne le nom de la jauge.
     *
     * @return le nom de la jauge
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la jauge.
     *
     * @param nom Le nouveau nom de la jauge
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la valeur de la jauge.
     *
     * @return la valeur de la jauge
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la jauge.
     *
     * @param valeur La nouvelle valeur de la jauge
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne le type de la jauge.
     *
     * @return le type de la jauge
     */
    public TypeJauge getType() {
        return type;
    }

    /**
     * Modifie le type de la jauge.
     *
     * @param type Le nouveau type de la jauge
     */
    public void setType(TypeJauge type) {
        this.type = type;
    }

    /**
     * Applique les effets associés au choix gauche sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     * @param question
     */
    public static void appliqueEffetsGauche(Personnage personnage, Question question){
        appliqueEffets(Question.effetJaugeGauche, personnage);
    }

    /**
     * Applique les effets associés au choix droit sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     * @param question
     */
    public static void appliqueEffetsDroite(Personnage personnage, Question question){
        appliqueEffets(Question.effetJaugeDroite, personnage);
    }

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    private static void appliqueEffets(Map<TypeJauge, Integer> effets,
                                       Personnage personnage){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
            switch(effet.getKey()){
                case ARMEE:
                    personnage.getJaugeArmee().setValeur(
                            personnage.getJaugeArmee().getValeur()
                                    +effet.getValue());
                    break;
                case CLERGE:
                    personnage.getJaugeClerge().setValeur(
                            personnage.getJaugeClerge().getValeur()
                                    +effet.getValue());
                    break;
                case FINANCE:
                    personnage.getJaugeFinance().setValeur(
                            personnage.getJaugeFinance().getValeur()
                                    +effet.getValue());
                    break;
                case PEUPLE:
                    personnage.getJaugePeuple().setValeur(
                            personnage.getJaugePeuple().getValeur()
                                    +effet.getValue());
                    break;
            }
        }
    }
}
