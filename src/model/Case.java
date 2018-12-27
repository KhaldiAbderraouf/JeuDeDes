package model;
import java.io.Serializable;


public abstract class Case implements Cloneable
{
 private Couleur couleur; // couleur de la case
 
 public Case(Couleur c){
	 couleur=c;
 }

 /* methode abstraite qui decrit l'utilité de chaque case*/
 public abstract int[] Action();

 public Couleur getCouleur() {
	return couleur;
 }
 

}