#include <iostream>
#include <queue>
using namespace std;

struct Nodo {
    int dato;
    Nodo* izquierda;
    Nodo* derecha;

    Nodo(int valor) {
        dato = valor;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

// ========== RECORRIDOS ==========
void preorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->dato << " ";
    preorden(raiz->izquierda);
    preorden(raiz->derecha);
}

void inorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}

void postorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    postorden(raiz->izquierda);
    postorden(raiz->derecha);
    cout << raiz->dato << " ";
}

void bfs(Nodo* raiz) {
    if (raiz == nullptr) return;

    queue<Nodo*> cola;
    cola.push(raiz);

    while (!cola.empty()) {
        Nodo* actual = cola.front();
        cola.pop();

        cout << actual->dato << " ";

        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// ========== EJERCICIO 3: CONTAR NODOS ==========
int contarNodos(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    return 1 + contarNodos(raiz->izquierda) + contarNodos(raiz->derecha);
}

// ========== EJERCICIO 4: CONTAR HOJAS ==========
int contarHojas(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    if (raiz->izquierda == nullptr && raiz->derecha == nullptr) return 1;
    return contarHojas(raiz->izquierda) + contarHojas(raiz->derecha);
}

// ========== EJERCICIO 5: SISTEMA WEB ==========
struct ModuloWeb {
    string nombre;
    ModuloWeb* izquierda;
    ModuloWeb* derecha;

    ModuloWeb(string nom) {
        nombre = nom;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

void preordenWeb(ModuloWeb* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->nombre << " -> ";
    preordenWeb(raiz->izquierda);
    preordenWeb(raiz->derecha);
}

void inordenWeb(ModuloWeb* raiz) {
    if (raiz == nullptr) return;
    inordenWeb(raiz->izquierda);
    cout << raiz->nombre << " -> ";
    inordenWeb(raiz->derecha);
}

void bfsWeb(ModuloWeb* raiz) {
    if (raiz == nullptr) return;
    queue<ModuloWeb*> cola;
    cola.push(raiz);
    int nivel = 1;

    while (!cola.empty()) {
        int size = cola.size();
        cout << "Nivel " << nivel << ": ";
        for (int i = 0; i < size; i++) {
            ModuloWeb* actual = cola.front();
            cola.pop();
            cout << actual->nombre;
            if (i < size - 1) cout << ", ";
            if (actual->izquierda != nullptr) cola.push(actual->izquierda);
            if (actual->derecha != nullptr) cola.push(actual->derecha);
        }
        cout << endl;
        nivel++;
    }
}

int main() {
    // ========== EJERCICIOS 1 y 2 ==========
    cout << "RECORRIDOS DE ARBOLES BINARIOS - UTA" << endl;

    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);

    cout << "\n--- EJERCICIO 1 (Arbol original) ---" << endl;
    cout << "Preorden: ";
    preorden(raiz);
    cout << "\nInorden: ";
    inorden(raiz);
    cout << "\nPostorden: ";
    postorden(raiz);
    cout << "\nBFS: ";
    bfs(raiz);
    cout << endl;

    // Agregar nodos: 1, 3, 18, 25
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha = new Nodo(3);
    raiz->derecha->derecha->izquierda = new Nodo(18);
    raiz->derecha->derecha->derecha = new Nodo(25);


    cout << "\n--- EJERCICIO 2 (Arbol modificado) ---" << endl;
    cout << "Nuevos nodos agregados: 1, 3, 18, 25" << endl;
    cout << "Preorden: ";
    preorden(raiz);
    cout << "\nInorden: ";
    inorden(raiz);
    cout << "\nPostorden: ";
    postorden(raiz);
    cout << "\nBFS: ";
    bfs(raiz);
    cout << endl;

    // ========== EJERCICIO 3 ==========
    cout << "\n--- EJERCICIO 3: Contar nodos totales ---" << endl;
    cout << "Total de nodos en el arbol: " << contarNodos(raiz) << endl;

    // ========== EJERCICIO 4 ==========
    cout << "\n--- EJERCICIO 4: Contar hojas ---" << endl;
    cout << "Total de hojas en el arbol: " << contarHojas(raiz) << endl;

    // ========== EJERCICIO 5 ==========
    cout << "\n--- EJERCICIO 5: Sistema Web (Proyecto Final) ---" << endl;

    ModuloWeb* sistema = new ModuloWeb("Sistema Web");
    sistema->izquierda = new ModuloWeb("Usuarios");
    sistema->derecha = new ModuloWeb("Inventario");
    sistema->izquierda->izquierda = new ModuloWeb("Registrar");
    sistema->izquierda->derecha = new ModuloWeb("Buscar");
    sistema->derecha->izquierda = new ModuloWeb("Productos");
    sistema->derecha->derecha = new ModuloWeb("Reportes");

    cout << "\nEstructura del sistema:" << endl;
    cout << "            Sistema Web" << endl;
    cout << "           /           \\" << endl;
    cout << "     Usuarios        Inventario" << endl;
    cout << "      /    \\          /      \\" << endl;
    cout << " Registrar Buscar  Productos Reportes\n" << endl;

    cout << "1) Mostrar menu principal (Preorden):" << endl;
    cout << "   ";
    preordenWeb(sistema);
    cout << "NULL" << endl;

    cout << "\n2) Procesar primero modulos internos (Inorden):" << endl;
    cout << "   ";
    inordenWeb(sistema);
    cout << "NULL" << endl;

    cout << "\n3) Mostrar modulos nivel por nivel (BFS):" << endl;
    bfsWeb(sistema);

    return 0;
}