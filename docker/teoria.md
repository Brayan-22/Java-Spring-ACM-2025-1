# 🐳 Guía Teórica Completa de Docker

Este documento sirve como un recurso teórico fundamental, parte del curso ACM Java Spring para comprender Docker en profundidad, desde sus conceptos básicos hasta la orquestación con Swarm.

---

## 1. ¿Qué es Docker y cuál es su propósito?

Docker es una plataforma de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores.  
Un contenedor es un paquete ligero, portátil y autosuficiente que incluye una aplicación y todas sus dependencias (código, librerías, herramientas del sistema, etc.).

**Propósito Principal:**  
Resolver el clásico problema que se presenta en desarrollo de "funciona en mi máquina, pero no en producción".  
Al empaquetar la aplicación en un contenedor, se asegura que el entorno sea **consistente, predecible y reproducible** en cualquier lugar donde se ejecute Docker.

---

### 🆚 Diferencia Clave: Contenedores vs. Máquinas Virtuales (VMs)

- **Máquinas Virtuales (VMs):**  
  - Virtualizan el hardware para ejecutar un sistema operativo completo.  
  - Cada VM tiene su propio SO, lo que consume muchos recursos (CPU, RAM, almacenamiento).

- **Contenedores:**  
  - Virtualizan el sistema operativo.  
  - Comparten el kernel del sistema operativo anfitrión.  
  - Solo empaquetan la aplicación y sus dependencias.  
  - Son ligeros, rápidos y eficientes en el uso de recursos.

---

## 2. Arquitectura y Componentes de Docker

Docker utiliza una arquitectura **cliente-servidor**.

- **Docker Daemon (`dockerd`):**  
  Proceso persistente que gestiona imágenes, contenedores, volúmenes y redes.

- **Docker Client (`docker`):**  
  Interfaz de línea de comandos (CLI) para interactuar con el daemon.

- **Docker Registry:**  
  Sistema para almacenar y distribuir imágenes.  
  Docker Hub es el registro público por defecto.

---

### 🔧 Objetos Fundamentales de Docker

- **Imágenes:** Son como plantillas utilizadas para crear contenedores.  
- **Contenedores:** Son instancias en ejecución de una imagen. Aislados y efímeros por defecto.  
- **Redes:** Canales de comunicación entre contenedores.  
- **Volúmenes:** Mecanismo preferido para persistencia de datos.

---

## 3. Redes (Networking) en Docker

El networking permite el aislamiento y la comunicación entre contenedores.

### Principales Drivers de Red:

- **bridge (puente):**  
  Red interna en el host. Comunicación por nombres DNS.  
  Requiere mapeo de puertos para acceder desde fuera.

- **host:**  
  El contenedor comparte directamente la red del host.  
  Menos seguro, pero de mayor rendimiento.

- **overlay:**  
  Red distribuida entre múltiples daemons de Docker.  
  Usada en el modo orquestación de docker Swarm para interconexión entre nodos.

- **none:**  
  Aísla completamente el contenedor de cualquier red.

---

## 4. Almacenamiento y Persistencia de Datos

Dado que los contenedores son efímeros, es crucial gestionar los datos de forma persistente.

- **Volúmenes:**  
  - Recomendado por Docker.  
  - Independientes del ciclo de vida del contenedor.  
  - Se gestionan con comandos como `docker volume create`.

- **Bind Mounts:**  
  - Mapeo directo entre un directorio del host y el contenedor.  
  - Útiles en desarrollo.

- **tmpfs Mounts:**  
  - Montajes en memoria.  
  - Útiles para datos temporales o sensibles.

---

## 5. Creación de Imágenes: El Dockerfile

Un `Dockerfile` contiene instrucciones para construir imágenes.

### Instrucciones Clave:

- `FROM`: Imagen base.  
- `WORKDIR`: Directorio de trabajo.  
- `COPY` y `ADD`: Copiar archivos al contenedor.  
- `RUN`: Ejecutar comandos (instalaciones, compilaciones).  
- `EXPOSE`: Documentar puertos expuestos.  
- `CMD`: Comando por defecto que se ejecuta al instanciar un contenedor, puede ser sobrescrito.  
- `ENTRYPOINT`: Ejecutable principal del contenedor. Más rígido que `CMD`.
- `ENV`: Define variables de entorno que se utilizarán para personalizar en el arranque las imagenes creadas.
**Combinación común:**  
```Dockerfile
ENTRYPOINT ["/usr/bin/mi-app"]
CMD ["--modo", "produccion"]

Una vez se tiene la imagen, hay dos formas de utilizarlas, una es ejecutandolas directamente y la otra es usando docker compose o docker stack
