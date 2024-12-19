# Free Souls API 

Free Souls API es un servicio API REST para gestionar personajes, armas y armaduras.

## Objetivo

El objetivo de este proyecto es proporcionar una API para gestionar personajes mediante una API que permite realizar un CRUD completo (Crear, Leer, Actualizar, Eliminar) para cada uno de estos recursos, facilitando su integración con otros sistemas o el uso para pruebas y aprendizaje.

## Tecnologías

- **Java 21** 
- **Spring Boot**: Framework para desarrollar la aplicación de backend.
- **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.
- **Base de datos H2**
- **Postman**: Herramienta para realizar pruebas de la API.

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/FranGarciaga/Free-Souls-API
   cd Free-Souls-API
   
2. Configura el archivo application.properties para conectar la base de datos H2.

3. Accede a la Base de datos en:
   ```bash
   URL base: http://localhost:8080/h2-console

## **Personajes**

1. **CRUD de Personajes:**
    - Permitir crear personajes con la siguiente información:
        - Nombre 
        - Nivel
        - Tipo de personaje
        - Vida
        - Energia
        - Fuerza
2. **Búsqueda de Personajes:**
    - Buscar personajes por su nombre o número de identificación único.
    - Ver todos los detalles del personaje
3. **Listado de Personajes:**
    - Listar todos los personajes registrados en el sistema.
    - Mostrar información básica como nombre y tipo.
4. **Actualización de Personajes:**
    - Permitir modificar los datos de un personaje registrado.
5. **Eliminación de Personajes:**
    - Permitir eliminar un personaje del sistema.
  
## **Gestor de Armas**

1. **CRUD de Armas:**
    - Permitir crear armas con la siguiente información:
        - Nombre 
        - Daño
        - Peso
        - Tipo de arma
2. **Búsqueda de Armas:**
    - Buscar armas por su nombre o número de identificación único.
    - Ver todos los detalles del arma
3. **Listado de Armas:**
    - Listar todas las armas registradas en el sistema.
    - Mostrar información básica como nombre y tipo.
4. **Actualización de Armas:**
    - Permitir modificar los datos de un arma registrada.
5. **Eliminación de Armas:**
    - Permitir eliminar un arma del sistema.
  
## **Armaduras**

1. **CRUD de Armaduras:**
    - Permitir crear armaduras con la siguiente información:
        - Nombre 
        - Defensa
        - Peso
2. **Búsqueda de Armaduras:**
    - Buscar armaduras por su nombre o número de identificación único.
    - Ver todos los detalles de la armadura
3. **Listado de Armaduras:**
    - Listar todas las armaduras registradas en el sistema.
    - Mostrar información básica como nombre y defensa.
4. **Actualización de Armaduras:**
    - Permitir modificar los datos de una armadura registrada.
5. **Eliminación de Armaduras:**
    - Permitir eliminar una armadura del sistema.

---

## Usos en Postman

### Personajes
| Método | Endpoint             | Descripción             |
|--------|----------------------|-------------------------|
| POST   | /characters           | Crear un personaje      |
| GET    | /characters           | Listar personajes       |
| GET    | /characters/{id}      | Obtener personaje por ID|
| PUT    | /characters/{id}      | Actualizar personaje    |
| DELETE | /characters/{id}      | Eliminar personaje      |

**Enums**:
- `health`
- `stamina`
- `strength`

### Armas
| Método | Endpoint             | Descripción             |
|--------|----------------------|-------------------------|
| POST   | /weapons             | Crear un arma           |
| GET    | /weapons             | Listar armas            |
| GET    | /weapons/{id}        | Obtener arma por ID     |
| PUT    | /weapons/{id}        | Actualizar arma         |
| DELETE | /weapons/{id}        | Eliminar arma           |

**Enums**:
- `damage`
- `weight`

### Armaduras
| Método | Endpoint             | Descripción             |
|--------|----------------------|-------------------------|
| POST   | /armors              | Crear una armadura      |
| GET    | /armors              | Listar armaduras        |
| GET    | /armors/{id}         | Obtener armadura por ID |
| PUT    | /armors/{id}         | Actualizar armadura     |
| DELETE | /armors/{id}         | Eliminar armadura       |

-----------------------------

## Planificación

1. Sobre la marcha

----------------------------
