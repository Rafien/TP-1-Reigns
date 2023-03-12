package main;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {
    /**
     * le personnage joué
     */
    static Personnage personnage;

    /**
     * la banque de questions
     */
    private static ListQuestion questions = ListQuestion.getInstance();

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){
        // début du jeu
        debutDeJeu();
        int nbTours = 0;

        //fonction Vivant
        while(!personnage.finDuJeu()){
            //fonction TourDeJeu
            nbTours++;
            tourDeJeu();
        }

        // fin du jeu
        //fonction fin jeu
        //fonction affichageFin
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }

    private static void tourDeJeu() {
        Question question = getQuestionAleatoire();
        reponseQuestion(question);
        personnage.AfficheJauges();
    }

    private static void debutDeJeu() {
        System.out.println("Bienvenue sur Reigns");
        initJeu();
        Personnage.afficherInfosPerso(Reigns.personnage);

    }



    private static void initJeu() {
        // tirage des questions
        System.out.println("Création du personnage...");
        //initiation du personnage
        Personnage.initPersonnage();
    }





    
    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        //fonction recupReponse
        Scanner scanner = new Scanner(System.in);
        question.reponse = "";
        while(!question.reponse.equals("G") && !question.reponse.equals("D")){
            interpreterReponse(question, scanner);
        }
        // applique les malus
        appliquerMalus(question);

    }

    private static void interpreterReponse(Question question, Scanner scanner) {
        System.out.println("Entrez la réponse (G ou D)");
        System.out.flush();
        question.reponse = scanner.nextLine();
    }

    private static void appliquerMalus(Question question) {
        if(question.reponse.equals("G")){
            Jauge.appliqueEffetsGauche(personnage, question);
        }else{
            Jauge.appliqueEffetsDroite(personnage, question);
        }
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()* questions.getLquestions().size());
        return questions.getLquestions().get(numQuestion);
    }
}