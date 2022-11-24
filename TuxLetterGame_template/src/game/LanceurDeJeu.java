
package game;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



/**
 *
 * @author diagneam
 */
public class LanceurDeJeu {
   public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException {
        // Declare un Jeu
        Jeu jeu;
        //system.out.printl(l.getLetter());
        //Instancie un nouveau jeu
        jeu = new Jeu(){};
        //Execute le jeu
        //l.getLetter();
        jeu.execute();
        
        //system.out.print(l.getLetter());
    } 
}
    

