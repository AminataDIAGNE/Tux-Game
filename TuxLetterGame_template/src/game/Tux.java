/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author dembeleo
 */
import env3d.Env;
import env3d.advanced.EnvNode;
import org.lwjgl.input.Keyboard;

public class Tux extends EnvNode {

    private Env env;
    private Room room;

    /**
     * Constructeur du personnage Tux
     *
     * @param env
     * @param room
     */
    public Tux(Env env, Room room) {
        //Dans le constructeur
        this.env = env;// initialisation de l'attribut env
        this.room = room;// initialisation de l'attribut room
        setScale(4.0);
        setX(this.room.getWidth() / 2);// positionnement au milieu de la largeur de la room
        setY(getScale() * 1.1); // positionnement en hauteur basé sur la taille de Tux
        setZ(this.room.getDepth() / 2); // positionnement au milieu de la profondeur de la room
        setTexture("models/tux/tux.png");
        setModel("models/tux/tux.obj");
    }

    public void déplace() {
        if (env.getKeyDown(Keyboard.KEY_Z) || env.getKeyDown(Keyboard.KEY_UP)) { // Fleche 'haut' ou Z
            // Haut
            this.setRotateY(0);
            this.setZ(this.getZ() + 1.0);
        }
        if (env.getKeyDown(Keyboard.KEY_Q) || env.getKeyDown(Keyboard.KEY_LEFT)) { // Fleche 'gauche' ou Q
            // Gauche
            this.setRotateX(-90);
            this.setX(this.getX() - 1.0);
        }
        if (env.getKeyDown(Keyboard.KEY_D) || env.getKeyDown(Keyboard.KEY_RIGHT)) { // Fleche 'droite' ou D
            // DROITE
            this.setRotateX(90);
            this.setX(this.getX() + 1.0);

        }
        if (env.getKeyDown(Keyboard.KEY_D) || env.getKeyDown(Keyboard.KEY_RIGHT)) { // Fleche 'droite' ou D
            // bas
            this.setRotateX(-180);
            this.setX(this.getX() -1.0);
        }
    }
        
}
