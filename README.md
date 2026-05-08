# Recorridos de Árboles Binarios - C++ y Java

## Descripción del Proyecto

Este proyecto implementa y analiza los principales recorridos sobre árboles binarios: **Preorden, Inorden, Postorden y BFS**, utilizando los lenguajes **C++ y Java**. Además, incluye funciones auxiliares para contar nodos y hojas, y aplica los conceptos a un caso práctico modelando un sistema web.

## Objetivo

Implementar y analizar los principales recorridos de árboles binarios mediante la programación en C++ y Java, aplicando conceptos de recursividad y estructuras de datos.

## Estructura del Árbol

### Árbol Original
        10
       /  \
      5    15
     / \   / \
    2   7 12 20
```

### Árbol Modificado (Ejercicio 2)
Se agregaron los nodos: 1, 3, 18, 25, 30, 42
          10
       /     \
     5        15
    / \       / \
   2   7     12 20
`/ \  / \    / \
1  3 18 25 30   42

## Resultados de los recorridos

### Árbol original
| Recorrido | Resultado |
|-----------|-----------|
| Preorden | 10, 5, 2, 7, 15, 12, 20 |
| Inorden | 2, 5, 7, 10, 12, 15, 20 |
| Postorden | 2, 7, 5, 12, 20, 15, 10 |
| BFS | 10, 5, 15, 2, 7, 12, 20 |

### Árbol modificado
| Recorrido | Resultado |
|-----------|-----------|
| Preorden | 10, 5, 2, 1, 3, 7, 15, 12, 20, 18, 25 |
| Inorden | 1, 2, 3, 5, 7, 10, 12, 15, 18, 20, 25 |
| Postorden | 1, 3, 2, 7, 5, 12, 18, 25, 20, 15, 10 |
| BFS | 10, 5, 15, 2, 7, 12, 20, 1, 3, 18, 25 |

### Conteo
| Árbol | Nodos totales | Hojas |
|-------|---------------|-------|
| Original | 7 | 4 |
| Modificado | 11 | 5 |


## Funciones implementadas

- **preorden()** - Recorrido recursivo raíz-izquierda-derecha
- **inorden()** - Recorrido recursivo izquierda-raíz-derecha
- **postorden()** - Recorrido recursivo izquierda-derecha-raíz
- **bfs()** - Recorrido iterativo usando una cola
- **contarNodos()** - Cuenta recursivamente el total de nodos
- **contarHojas()** - Cuenta recursivamente los nodos sin hijos

## Ejemplo práctico: Sistema web

Se modela un sistema web como árbol binario:

**Qué recorrido usar según la necesidad:**

| Necesidad | Recorrido | Razón |
|-----------|-----------|-------|
| Mostrar menú principal | Preorden | Muestra primero la raíz y luego los módulos principales |
| Procesar módulos internos | Inorden | Procesa submódulos antes que el módulo padre |
| Mostrar por niveles | BFS | Organización jerárquica clara y visual |


## Cómo ejecutar

**C++:
```bash
g++ ejercicios.cpp -o programa
./programa

**java:
javac Ejercicios.java
java Ejercicios

##
