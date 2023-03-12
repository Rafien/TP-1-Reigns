package main;

import java.util.ArrayList;
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
    private static ArrayList<Question> questions;

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
        initBanqueQuestions();
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
            question.appliqueEffetsGauche(personnage);
        }else{
            question.appliqueEffetsDroite(personnage);
        }
    }




    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    private static void initBanqueQuestions(){
        questions = new ArrayList<>();
        //for nbQuestion init Question i
        //fonction initQi
        // voir https://refactoring.guru/fr/design-patterns/builder ou prototype
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        questions.add(question5);
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }
}