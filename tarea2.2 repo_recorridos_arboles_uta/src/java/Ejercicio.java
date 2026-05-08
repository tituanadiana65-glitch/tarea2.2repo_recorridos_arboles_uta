import java.util.LinkedList;
import java.util.Queue;

class Nodo {
    int dato;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase para el Ejercicio 5
class ModuloWeb {
    String nombre;
    ModuloWeb izquierda;
    ModuloWeb derecha;

    public ModuloWeb(String nombre) {
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class Ejercicio {

    //funcion para agregar nodo
    public static void agregarNodo(Nodo raiz, int valor) {
        if(raiz==null)return; 
            
        Queue<Nodo> cola= new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual=cola.poll();
             //izquierda
             if (actual.izquierda==null) {
                actual.izquierda=new Nodo(valor);
               
                return;  
             }else{
                cola.add(actual.izquierda);
             }
             //derecha
             if (actual.derecha==null) {
                actual.derecha=new Nodo(valor);
               
                return;  
             }else{
                cola.add(actual.derecha);
             }
            
        }
        
    }

    // ========== RECORRIDOS ==========
    public static void preorden(Nodo raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }

    public static void inorden(Nodo raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    public static void postorden(Nodo raiz) {
        if (raiz == null) return;
        postorden(raiz.izquierda);
        postorden(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

    public static void bfs(Nodo raiz) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.dato + " ");

            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // ========== EJERCICIO 3: CONTAR NODOS ==========
    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    // ========== EJERCICIO 4: CONTAR HOJAS ==========
    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    // ========== EJERCICIO 5: SISTEMA WEB ==========
    public static void preordenWeb(ModuloWeb raiz) {
        if (raiz == null) return;
        System.out.print(raiz.nombre + " -> ");
        preordenWeb(raiz.izquierda);
        preordenWeb(raiz.derecha);
    }

    public static void inordenWeb(ModuloWeb raiz) {
        if (raiz == null) return;
        inordenWeb(raiz.izquierda);
        System.out.print(raiz.nombre + " -> ");
        inordenWeb(raiz.derecha);
    }

    public static void bfsWeb(ModuloWeb raiz) {
        if (raiz == null) return;
        Queue<ModuloWeb> cola = new LinkedList<>();
        cola.add(raiz);
        int nivel = 1;

        while (!cola.isEmpty()) {
            int size = cola.size();
            System.out.print("Nivel " + nivel + ": ");
            for (int i = 0; i < size; i++) {
                ModuloWeb actual = cola.poll();
                System.out.print(actual.nombre);
                if (i < size - 1) System.out.print(", ");
                if (actual.izquierda != null) cola.add(actual.izquierda);
                if (actual.derecha != null) cola.add(actual.derecha);
            }
            System.out.println();
            nivel++;
        }
    }

    public static void main(String[] args) {
        // ========== EJERCICIOS 1 y 2 ==========
        System.out.println("RECORRIDOS DE ARBOLES BINARIOS - UTA");

        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);

        System.out.println("\n--- EJERCICIO 1 (Arbol original) ---");
        System.out.print("Preorden: ");
        preorden(raiz);
        System.out.print("\nInorden: ");
        inorden(raiz);
        System.out.print("\nPostorden: ");
        postorden(raiz);
        System.out.print("\nBFS: ");
        bfs(raiz);
        System.out.println();

        // Agregar nodos: 1, 3, 18, 25
        agregarNodo(raiz, 1);
        agregarNodo(raiz, 3);
        agregarNodo(raiz, 18);
        agregarNodo(raiz, 25);
        agregarNodo(raiz, 30);
        agregarNodo(raiz, 40);

        System.out.println("\n--- EJERCICIO 2 (Arbol modificado) ---");
        System.out.println("Nuevos nodos agregados: 1, 3, 18, 25, 30, 40");
        System.out.print("Preorden: ");
        preorden(raiz);
        System.out.print("\nInorden: ");
        inorden(raiz);
        System.out.print("\nPostorden: ");
        postorden(raiz);
        System.out.print("\nBFS: ");
        bfs(raiz);
        System.out.println();

        // ========== EJERCICIO 3 ==========
        System.out.println("\n--- EJERCICIO 3: Contar nodos totales ---");
        System.out.println("Total de nodos en el arbol: " + contarNodos(raiz));

        // ========== EJERCICIO 4 ==========
        System.out.println("\n--- EJERCICIO 4: Contar hojas ---");
        System.out.println("Total de hojas en el arbol: " + contarHojas(raiz));

        // ========== EJERCICIO 5 ==========
        System.out.println("\n--- EJERCICIO 5: Sistema Web (Proyecto Final) ---");

        ModuloWeb sistema = new ModuloWeb("Sistema Web");
        sistema.izquierda = new ModuloWeb("Usuarios");
        sistema.derecha = new ModuloWeb("Inventario");
        sistema.izquierda.izquierda = new ModuloWeb("Registrar");
        sistema.izquierda.derecha = new ModuloWeb("Buscar");
        sistema.derecha.izquierda = new ModuloWeb("Productos");
        sistema.derecha.derecha = new ModuloWeb("Reportes");

        System.out.println("\nEstructura del sistema:");
        System.out.println("            Sistema Web");
        System.out.println("           /           \\");
        System.out.println("     Usuarios        Inventario");
        System.out.println("      /    \\          /      \\");
        System.out.println(" Registrar Buscar  Productos Reportes\n");

        System.out.println("1) Mostrar menu principal (Preorden):");
        System.out.print("   ");
        preordenWeb(sistema);
        System.out.println("NULL");

        System.out.println("\n2) Procesar primero modulos internos (Inorden):");
        System.out.print("   ");
        inordenWeb(sistema);
        System.out.println("NULL");

        System.out.println("\n3) Mostrar modulos nivel por nivel (BFS):");
        bfsWeb(sistema);
    }
}