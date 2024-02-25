package SuikaGame;

public class Nodo {
    // Atributos
    private Fruta valor;
    private Nodo siguiente;
    
    // Método Constructor

    public Nodo(Fruta valor) {
        this.valor = valor;
        this.siguiente = null;
    }
    
    // Métodos Getters y Setters

    public Fruta getValor() {
        return valor;
    }

    public void setValor(Fruta valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
