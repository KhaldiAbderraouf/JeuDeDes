package model;
import java.io.Serializable;


public abstract class Case implements Cloneable
{
 protected int numero;// numero de la case
 protected Couleur couleur; // couleur de la case

 /* methode abstraite qui decrit l'utilité de chaque case*/
 public abstract int[] Action();
}