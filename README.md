# Resolución de Laberintos utilizando Teoría de Grafos

## Descripción

Este proyecto consiste en una aplicación de escritorio desarrollada en **Java** que permite generar laberintos de forma aleatoria y encontrar el camino más corto entre un punto de inicio y un punto de destino mediante el algoritmo **Breadth-First Search (BFS)**.

El laberinto es representado como un **grafo**, donde cada celda transitable corresponde a un nodo y las conexiones entre ellas representan las aristas. La aplicación fue desarrollada siguiendo los principios de la **Programación Orientada a Objetos (POO)** y utiliza **Java Swing** para la construcción de la interfaz gráfica.

---

## Tecnologías utilizadas

- Oracle OpenJDK 25
- IntelliJ IDEA
- Java Swing
- Git
- GitHub

---

## Requisitos

Antes de ejecutar el proyecto, asegúrese de tener instalado:

- Oracle OpenJDK 25
- IntelliJ IDEA (Community o Ultimate)
- Git (solo para clonar el repositorio)

---

## Instalación

### 1. Clonar el repositorio

Si tiene Git instalado, ejecute el siguiente comando en una terminal:

```bash
git clone https://github.com/KBeba/ResolucionLaberintos-TP3.git
```

### 2. Descargar el proyecto (opcional)

Si no dispone de Git, puede descargar el proyecto directamente desde GitHub:

1. Ingrese al repositorio.
2. Presione el botón **Code**.
3. Seleccione **Download ZIP**.
4. Extraiga el contenido del archivo en la ubicación de su preferencia.

---

## Configuración del proyecto

### 1. Abrir el proyecto

1. Abra IntelliJ IDEA.
2. Seleccione **Open**.
3. Busque la carpeta del proyecto descargado.
4. Presione **OK**.

Espere a que IntelliJ cargue el proyecto.

---

### 2. Configurar el SDK

Si IntelliJ solicita configurar el JDK:

1. Ir al menú:

```
File
→ Project Structure
→ Project
```

2. En **Project SDK**, seleccionar **Oracle OpenJDK 25**.

Si el SDK no aparece:

- Seleccionar **Add SDK**.
- Buscar la carpeta donde está instalado Oracle OpenJDK 25.
- Guardar los cambios.

---

### 3. Ejecutar el programa

Ubique la clase:

```
Main.java
```

Ejecute la aplicación utilizando el botón de IntelliJ IDEA:

```
Run
```

---
## Funcionalidades

La aplicación permite:

- Generar laberintos aleatorios.
- Representar el laberinto mediante un grafo.
- Aplicar el algoritmo Breadth-First Search (BFS).
- Encontrar el camino más corto entre el origen y el destino.
- Visualizar gráficamente la solución encontrada.
- Generar nuevos laberintos de forma dinámica.

---

## Estructura del proyecto

```
src
│
├── Main.java
├── VentanaPrincipal.java
├── PanelLaberinto.java
├── GeneradorLaberinto.java
├── ConversorLaberinto.java
├── BuscadorCamino.java
├── Grafo.java
└── Nodo.java
```

---

## Autor

**Kendra Cabello**

C.I.: 32.503.505
