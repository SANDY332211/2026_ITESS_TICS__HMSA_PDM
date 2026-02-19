# 📐 Punto en Polígono Convexo – JavaFX

Aplicación gráfica desarrollada en **Java + JavaFX** que permite visualizar un **plano cartesiano**, dibujar un **polígono convexo** y verificar si un punto se encuentra **dentro o fuera** del polígono utilizando algoritmos geométricos eficientes.

---

## 🚀 Características

- 📊 Plano cartesiano con ejes X y Y
- 🔲 Dibujo de polígono convexo
- 📍 Visualización de coordenadas de vértices
- 🎯 Evaluación de punto dentro/fuera
- 🧮 Algoritmo geométrico optimizado (O(log n))
- 🎨 Resultado visual con colores (verde / rojo)

---

## 🏗 Arquitectura del Proyecto

El sistema está dividido en tres clases principales:

```
JavaFX_TI601  →  Interfaz gráfica
ConvexPolygon →  Lógica matemática
Point         →  Modelo geométrico
```

Esto permite una correcta separación entre:

- 🎨 Vista (UI)
- 🧠 Lógica
- 📍 Modelo

---

# 📦 Diagrama UML de Clases

```
+---------------------------+
|     JavaFX_TI601          |
+---------------------------+
| + start(Stage)            |
| + main(String[])          |
+---------------------------+
            |
            | usa
            v
+---------------------------+
|     ConvexPolygon         |
+---------------------------+
| - vertices : List<Point>  |
| - seq : List<Point>       |
| - p0 : Point              |
| - debugP0 : Point         |
| - debugV1 : Point         |
| - debugV2 : Point         |
| - debugS1 : double        |
| - debugS2 : double        |
+---------------------------+
| + ConvexPolygon(List)     |
| + isInside(Point)         |
| - prepare()               |
| - asegurarSentido...()    |
| - productoCruzVectores()  |
| - pointInTriangle()       |
| - areaTriangulo()         |
+---------------------------+
            |
            | contiene
            v
+---------------------------+
|          Point            |
+---------------------------+
| + x : double              |
| + y : double              |
+---------------------------+
| + Point(x,y)              |
| + crossProduct()          |
| + sqrLen()                |
| + minus()                 |
+---------------------------+
```

---

# 🔁 Diagrama de Secuencia

```
Usuario
   |
   | Ejecuta aplicación
   v
JavaFX_TI601
   |
   | crea ConvexPolygon
   v
ConvexPolygon
   |
   | isInside(p)
   |    |
   |    → productoCruzVectores()
   |    → búsqueda binaria
   |    → pointInTriangle()
   |          → areaTriangulo()
   |
   v
Devuelve true / false
   |
   v
JavaFX_TI601 pinta círculo verde o rojo
```

---

# 🔄 Diagrama de Actividad

```
Inicio
  |
Convertir punto relativo (p - p0)
  |
¿Fuera del rango angular?
  |---- Sí → FALSE
  |
Búsqueda binaria del sector
  |
Formar triángulo
  |
Calcular áreas
  |
¿Área total == suma subáreas?
  |---- Sí → TRUE
  |---- No → FALSE
  |
Fin
```

---

# 🧮 Explicación del Algoritmo

El método `isInside()` utiliza:

1. ✔ Ordenamiento antihorario de vértices  
2. ✔ Punto ancla (p0)  
3. ✔ Producto cruz para orientación  
4. ✔ Búsqueda binaria para eficiencia  
5. ✔ Comparación de áreas para validación  

Complejidad temporal: **O(log n)**.

---

# 📂 Estructura del Proyecto

```
javafx_ti601/
│
├── JavaFX_TI601.java
├── ConvexPolygon.java
└── Point.java
```

---

# 🛠 Tecnologías

- Java 17+
- JavaFX
- Programación Orientada a Objetos
- Geometría Computacional

---

# 🎯 Objetivo

Demostrar la aplicación práctica de algoritmos de geometría computacional en una interfaz gráfica, manteniendo separación entre modelo, lógica y vista.

---

# ⭐ Conclusión

Este proyecto integra:

- Matemáticas
- Algoritmos eficientes
- Programación orientada a objetos
- Visualización gráfica

para resolver el problema clásico de **Punto en Polígono Convexo**.
