/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author Renato
 */
public class Celula implements Cloneable {

    private int x;
    private int y;
    private boolean agente = false;
    private boolean parede = false;
    private boolean caixote = false;
    private boolean objetivo = false;
    private boolean canto = false;

    public Celula(int x, int y, boolean isParede, boolean isObjetivo) {
	this.x = x;
	this.y = y;
	this.parede = isParede;
	this.objetivo = isObjetivo;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Celula other = (Celula) obj;
	return equals(other);
    }

    public boolean equals(Celula other) {
	if (this.agente != other.agente) {
	    return false;
	}
	if (this.parede != other.parede) {
	    return false;
	}
	if (this.caixote != other.caixote) {
	    return false;
	}
	if (this.objetivo != other.objetivo) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public Celula clone() {
	try {
	    return (Celula) super.clone();
	} catch (Exception ex) {
	    return null;
	}
    }

    public boolean temAgente() {
	return agente;
    }

    public void setAgente(boolean agente) {
	this.agente = agente;
    }

    public boolean temCaixote() {
	return caixote;
    }

    public void setCaixote(boolean caixote) {
	this.caixote = caixote;
    }

    public void setCanto(boolean canto) {
        this.canto = canto;
    }

    public boolean isObjetivo() {
	return objetivo;
    }

    public boolean isParede() {
	return parede;
    }

    public boolean isCanto() {
        return canto;
    }
    
    

    /*
     *  V, para uma posição vazia;  P, para uma posição ocupada por uma
     * parede;  A, para uma posição ocupada pelo agente; O, para uma posição
     * objetivo; C, para uma posição que não seja uma posição objetivo, ocupada
     * por um caixote; X, para uma posição objetivo ocupada por um caixote.
     */
    @Override
    public String toString() {
	if (isParede()) {
	    return "P";
	}
	if (temAgente()) {
	    return "A";
	}
	if (temCaixote() && isObjetivo()) {
	    return "X";
	}
	if (temCaixote()) {
	    return "C";
	}
	if (isObjetivo()) {
	    return "O";
	}
	return "V";
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public boolean estaVazia() {
	return !isParede() && !temCaixote();
    }
}
