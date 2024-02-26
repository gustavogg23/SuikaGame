package SuikaGame;

import java.awt.Graphics2D;

public class Lista {
    // Atributos
    private Nodo cabeza;
    private int tamano;
    
    // Método Constructor
    public Lista() {
        cabeza = null;
        tamano = 0;
    }
    
    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    // Método para agregar una fruta a la lista
    public void agregar(Fruta valor) {
        
        // Se crea un nuevo nodo
        Nodo nuevo = new Nodo(valor);
        
        if (estaVacia()) { // Se verifica si la lista está vacía
            cabeza = nuevo; // En caso de que lo esté el nuevo nodo se convierte en la cabeza
        }
        else {
            Nodo temp = cabeza; // Se crea un nodo temporal
            
            while (temp.getSiguiente() != null) { // Se recorre la lista hasta llegar al último nodo
                temp = temp.getSiguiente(); // Se sigue avanzando al siguiente nodo
            }
            
            temp.setSiguiente(nuevo); // Se agrega el nuevo nodo con su valor al final de la lista
        }      
        tamano++; // Se incrementa el tamano de la lista
    }

    // Método para obtener la cabeza de la lista
    public Nodo getCabeza() {
        return cabeza;
    }
    
    // Método para eliminar una fruta de la lista
    public void eliminar(Fruta valor) {
        if (estaVacia()) { // Se verifica si la lista está vacía
            return;
        }
        
        if (cabeza.getValor().equals(valor)) {
            cabeza = cabeza.getSiguiente();
            tamano--;
            return;
        }
        
        Nodo actual = cabeza;
        
        while (actual.getSiguiente().getValor().equals(valor)) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamano--;
            return;
        }
        
        actual = actual.getSiguiente();
    }
    
//    public void dibujarFrutas(Graphics2D graficos2) {
//    Nodo actual = cabeza; // Comenzamos desde la cabeza de la lista
//
//    while (actual != null) { // Mientras no lleguemos al final de la lista
//        Fruta fruta = actual.getValor(); // Obtenemos la fruta del nodo actual
//        fruta.dibujarFruta(graficos2); // Dibujamos la fruta
//        actual = actual.getSiguiente(); // Avanzamos al siguiente nodo
//    }
//}

}
