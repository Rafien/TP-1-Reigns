package main;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    protected Genre genre;
    /**
     * La jauge de Clergé
     */
    protected Jauge jaugeClerge;
    /**
     * La jauge de Peuple
     */
    protected Jauge jaugePeuple;
    /**
     * La jauge d'Armée
     */
    protected Jauge jaugeArmee;
    /**
     * La jauge de Finances
     */
    protected Jauge jaugeFinance;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     * @param genre Le genre du personnage
     */
    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;

        // Initialisation des jauges entre 15 et 35 points
        //mettre ailleurs
        jaugeClerge = new Jauge("Clergé", 15 + (int)(Math.random() * (35 - 15)));
        jaugePeuple = new Jauge("Peuple", 15 + (int)(Math.random() * (35 - 15)));
        jaugeArmee = new Jauge("Armée", 15 + (int)(Math.random() * (35 - 15)));
        jaugeFinance = new Jauge("Finances", 15 + (int)(Math.random() * (35 - 15)));
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {
        afficheJauge(jaugeClerge);
        afficheJauge(jaugePeuple);
        afficheJauge(jaugeArmee);
        afficheJauge(jaugeFinance);
        System.out.println();
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu(){
        if(jaugeClerge.getValeur()<=0
                || jaugeClerge.getValeur()>=50
                || jaugePeuple.getValeur()<=0
                || jaugePeuple.getValeur()>=50
                || jaugeArmee.getValeur()<=0
                || jaugeArmee.getValeur()>=50
                || jaugeFinance.getValeur()<=0
                || jaugeFinance.getValeur()>=50){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
    private void afficheJauge(Jauge jauge) {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }

    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    /**
     * Retourne la jauge du clergé
     * @return la jauge du clergé
     */
    public Jauge getJaugeClerge() {
        return jaugeClerge;
    }

    /**
     * Modifie la jauge du clergé
     * @param jaugeClerge La nouvelle jauge du clergé
     */
    public void setJaugeClerge(Jauge jaugeClerge) {
        this.jaugeClerge = jaugeClerge;
    }

    /**
     * Retourne la jauge du peuple
     * @return la jauge du peuple
     */
    public Jauge getJaugePeuple() {
        return jaugePeuple;
    }
    /**
     * Modifie la jauge du peuple
     * @param jaugePeuple La nouvelle jauge du peuple
     */
    public void setJaugePeuple(Jauge jaugePeuple) {
        this.jaugePeuple = jaugePeuple;
    }

    /**
     * Retourne la jauge de l'armée
     * @return la jauge de l'armée
     */
    public Jauge getJaugeArmee() {
        return jaugeArmee;
    }
    /**
     * Modifie la jauge de l'armée
     * @param jaugeArmee La nouvelle jauge de l'armée
     */
    public void setJaugeArmee(Jauge jaugeArmee) {
        this.jaugeArmee = jaugeArmee;
    }

    /**
     * Retourne la jauge des finances
     * @return la jauge des finances
     */
    public Jauge getJaugeFinance() {
        return jaugeFinance;
    }
    /**
     * Modifie la jauge des finances
     * @param jaugeFinance La nouvelle jauge des finances
     */
    public void setJaugeFinance(Jauge jaugeFinance) {
        this.jaugeFinance = jaugeFinance;
    }

}
