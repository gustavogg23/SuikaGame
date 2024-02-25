package SuikaGame;

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
}
