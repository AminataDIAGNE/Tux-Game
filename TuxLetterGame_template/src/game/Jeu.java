
package game;

/**
 *
 * @author diagneam
 */
import java.util.ArrayList;
import env3d.Env;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public abstract class Jeu {

    // DECLARATION des attributs de  classe
    protected Env env;
    protected Room room;
    protected Profil profil;
    protected Tux tux;
    protected ArrayList<Letter> lettres;
    protected Dico dico;
    //char c = 'o';
    //Letter lettre;
    //String mot="aminata";
    //String mot;
    //mot = get

    public Jeu() throws SAXException, ParserConfigurationException, IOException {

        // Crée un nouvel environnement
        env = new Env();

        // Instancie une Room
        room = new Room();

        //accès et lecture du fichier dico.xml
        dico = new Dico("src/Data/xml/dico.xml");
        dico.lireDictionnaireDOM("src/game/", "dico.xml");

        // Règle la camera
        env.setCameraXYZ(50, 60, 175);
        env.setCameraPitch(-20);

        // Désactive les contrôles par défaut
        env.setDefaultControl(false);

        // Instancie un profil par défaut
        profil = new Profil();

        // Instanciation d'une lettre
        //lettre = new Letter(c, 20.0, 10.0);
        //instancie les lettres en Liste Letter
        lettres = new ArrayList<Letter>();

    }

    public void joue(Partie partie) {

        // TEMPORAIRE : on règle la room de l'environnement. Ceci sera à enlever lorsque vous ajouterez les menus.
        env.setRoom(room);
        //String mot = dico.getMotDepuisListeNiveau(2);

        //lettres = new ArrayList<Letter>('o');
        /*for (int i = 0; i < mot.length(); i++) {
            // lettre.add(mot.charAt(i));
            lettre = new Letter(mot.charAt((int) i), (i * 10 + 20.0), (room.getDepth() / 2));
            env.addObject(lettre);
            lettres.add(lettre);
        }
        */
        for(Letter lettre: lettres){
            env.addObject(lettre);
        }
        //env.addObject(lettres);

        // Instancie un Tux
        tux = new Tux(env, room);
        env.addObject(tux);

        // Ici, on peut initialiser des valeurs pour une nouvelle partie
        démarrePartie(partie);

        // Boucle de jeu
        Boolean finished;
        finished = false;
        while (!finished) {

            // Contrôles globaux du jeu (sortie, ...)
            //1 is for escape key
            if (env.getKey() == 1) {
                finished = true;
            }

            // Contrôles des déplacements de Tux (gauche, droite, ...)
            // ... (sera complété plus tard) ...
            // Ici, on applique les regles
            appliqueRegles(partie);

            // Fait avancer le moteur de jeu (mise à jour de l'affichage, de l'écoute des événements clavier...)
            env.advanceOneFrame();
        }

        // Ici on peut calculer des valeurs lorsque la partie est terminée
        terminePartie(partie);

    }

    public void execute() {

        // pour l'instant, nous nous contentons d'appeler la méthode joue comme cela
        // et nous créons une partie vide, juste pour que cela fonctionne
        
        String mot = dico.getMotDepuisListeNiveau(2);
        for(int i = 0; i < mot.length(); i++){
            double x = (double) Math.random()*(room.getWidth());
            double y = (double) Math.random()* room.getDepth();
            lettres.add(new Letter(mot.charAt(i),x,y));
        }   
        joue(new Partie());
        // Détruit l'environnement et provoque la sortie du programme 
        env.exit();
    }

    protected void démarrePartie(Partie partie) {

    }

    protected void appliqueRegles(Partie partie) {

    }

    protected void terminePartie(Partie partie) {

    }
    protected double distance(Letter letter){
        return tux.distance(letter);
    }
    
    
    protected boolean collision(Letter letter){
        boolean res = false;
        if(distance(letter) < letter.getScale()+tux.getScale()){
            res = true;
        }
        
        return res;
    }

}
