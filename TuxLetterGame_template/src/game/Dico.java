
package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author diagneam
 */
public class Dico {

    private ArrayList<String> listeNiveau1;
    private ArrayList<String> listeNiveau2;
    private ArrayList<String> listeNiveau3;
    private ArrayList<String> listeNiveau4;
    private ArrayList<String> listeNiveau5;
    private String cheminFichierDico;

    public Dico(String cheminFichier) {
        this.cheminFichierDico = cheminFichier;
        listeNiveau1 = new ArrayList<String>();
        listeNiveau2 = new ArrayList<String>();
        listeNiveau3 = new ArrayList<String>();
        listeNiveau4 = new ArrayList<String>();
        listeNiveau5 = new ArrayList<String>();

    }

    public String getMotDepuisListeNiveau(int niveau) {
        switch (vérifieNiveau(niveau)) {
            case 1:
                return getMotDepuisListe(this.listeNiveau1);

            case 2:
                return getMotDepuisListe(this.listeNiveau2);
            case 3:
                return getMotDepuisListe(this.listeNiveau3);
            case 4:
                return getMotDepuisListe(this.listeNiveau4);
            case 5:
                return getMotDepuisListe(this.listeNiveau5);
            default:
        }
        return null;
    }

    public void ajouteMotADico(int niveau, String mot) {
        int level = vérifieNiveau(niveau);
        switch (level) {
            case 1:
                listeNiveau1.add(mot);
                break;
            case 2:
                listeNiveau2.add(mot);
                break;
            case 3:
                listeNiveau3.add(mot);
                break;
            case 4:
                listeNiveau4.add(mot);
                break;
            case 5:
                listeNiveau5.add(mot);
                break;
            default:
        }
    }

    public String getCheminFichierDico() {
        return cheminFichierDico;
    }

    private int vérifieNiveau(int niveau) {
        if ((niveau >= 1) && (niveau <= 5)) {
            return niveau;
        } else {
            return 1; //valeur par défaut du niveau
        }
    }

    public String getMotDepuisListe(ArrayList<String> list) {
        if (!list.isEmpty()) {
            // generation random numbers entre 0 et la taille de la list
            int rand = (int) (Math.random() * list.size() - 1) + 1;
            //System.out.println( rand + "-> "+ list.get(rand) );
            return list.get(rand);
        } //si liste vide return valeur par défaut
        else {
            return "ListeVide";
        }

    }

    public ArrayList<String> getList1() {
        return listeNiveau1;
    }

    public void lireDictionnaireDOM(String path, String filename) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        FileInputStream in = new FileInputStream(new File(path + "" + filename));
        Document doc = dbBuilder.parse(in, "UTF-8");

        // récupère la liste des éléments Mots
        NodeList listeMot = doc.getElementsByTagName("nsl:mot");
        System.out.println("nombre de mot =   " + listeMot.getLength());

        for (int i = 0; i < listeMot.getLength(); i++) {
            Element mot = (Element) listeMot.item(i);
            String mot_text = mot.getTextContent();
            int mot_niveau = Integer.parseInt(mot.getAttribute("niveau"));
            System.out.println(mot_text + "(" + mot_niveau + ")");

            switch (mot_niveau) {
                case 1:
                    this.listeNiveau1.add(mot_text);
                    break;
                case 2:
                    this.listeNiveau2.add(mot_text);
                    break;
                case 3:
                    this.listeNiveau3.add(mot_text);
                    break;
                case 4:
                    this.listeNiveau4.add(mot_text);
                    break;
                case 5:
                    this.listeNiveau5.add(mot_text);
                    break;
            }
        }
    }

}
