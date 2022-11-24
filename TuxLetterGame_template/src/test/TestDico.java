package test;

import game.Dico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Aminata
 */
public class TestDico {

    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        // System.out.println("mot de niveau 1 " );  

        System.out.println("Chargement du dico : ");
        Dico dictionnaire = new Dico("");
        try {
            dictionnaire.lireDictionnaireDOM("src/game/", "dico.xml");
        } catch (SAXException ex) {
            Logger.getLogger(TestDico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestDico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
