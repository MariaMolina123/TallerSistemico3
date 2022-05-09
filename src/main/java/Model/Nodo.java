package Model;

import java.util.Optional;

public class Nodo {
    private Coordenada coordenada;
    private Nodo siguiente;
 
    public Nodo(Coordenada value) {
        this.coordenada = value;
    }
 
    public Coordenada getValue() {
        return coordenada;
    }
 
    public void setValue(Coordenada value) {
        this.coordenada = value;
    }
 
    public Nodo getNext() {
        return siguiente;
    }
 
    public void setNext(Nodo next) {
        this.siguiente = next;
    }
}
