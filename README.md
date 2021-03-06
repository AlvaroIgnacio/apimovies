# API de peliculas

Esta API de peliculas es mi proyecto final del curso "Taller "Docker para Administradores/as de Sistemas y Desarrolladores/as" 2021" dictado en la [Universidad Nacional del Comahue](https://web.curza.uncoma.edu.ar/) por Leandro Boisselier.  

La API permite consultar películas, actores, y además agregar películas y comentarios sobre las mismas.
Es un proyecto implementado con el lenguaje Java 11, framework Spring Boot y una base de datos Mysql versión 5.7  
El proyecto viene listo para ser instalado y ejecutado con datos de prueba.

## Instalación

Descargar el proyecto (git clone o descargar el zip).  
Construir la imagen con:  

```bash
docker-compose up --build
```
  
Durante este proceso puede ser que la aplicación se reinicie varias veces. Esto es normal ya que la misma debe esperar que Mysql se inicie, cree el esquema y usuario requerido.  
Docker compose descarga e instala una imagen de mysql y crea la base de datos del proyecto.  

El jar ejecutable en Java tiene embebido un Tomcat 9. Al arrancar por primera vez se crea un conjunto de datos de prueba, incluyendo películas, actores y comentarios.  

Para posteriores inicios basta con:

```bash
docker-compose up -d
```

## Uso

Listar los todos los actores
```bash
http://localhost:8084/actors?page=0&size=10
```
donde page indica el nro de la página y size la cantidad de registros por página.

Listar todas las películas
```bash
http://localhost:8084/movies
```

El archivo "API peliculas.postman_collection.json" contiene casos de prueba para todas las funciones de la API (importar con Postman).

## Volúmenes
Opté por crear un _bind mount_ para la base de datos.  Esto permite acceder a la BD como a cualquier otra instalada en el host, ya sea por consola o con herramientas como [Workbench](https://www.mysql.com/products/workbench/)  
../data/apimovies es el directorio donde se creará por defecto la BD. Esto se puede cambiar editando el archivo docker-compose.yml

## Variables de entorno
Algunas de las variables de entorno configurables son:  
- **SPRING_DATASOURCE_USERNAME**: el usuario que se conectará con la BD  
- **SPRING_DATASOURCE_PASSWORD**: contraseña de dicho usuario  
- **SPRING_JPA_SHOW_SQL**: permite definir si se muestran las sentencias SQL generadas por la aplicación. Los valores posibles son TRUE o FALSE  
- **LOGGING_LEVEL_ROOT**: nivel de detalle con que trabaja el generador de logs. Los valores posibles son: ERROR, WARN, INFO, DEBUG, TRACE  

## Estrategias de backup y recuperación para la persistencia de datos de la aplicación
La BD estará creada en el host, por lo cual cualquier esquema de backup en uso se puede aplicar a esta BD.  
Al ser un *bind mount* la bd sigue existiendo al detener el contenedor. Además puede ser accedida por otras aplicaciones, herramientas de consulta y administración.  

## Referencias
[Build your Java image](https://docs.docker.com/language/java/build-images/)  
[10 best practices to build a Java container with Docker](https://snyk.io/blog/best-practices-to-build-java-containers-with-docker/)  
[Externalizing properties of a spring boot application on docker ](https://www.linkedin.com/pulse/externalizing-properties-spring-boot-application-docker-phani-bushan)  
[Spring Boot Docker](https://spring.io/guides/topicals/spring-boot-docker/)  

## Licencia
[MIT](https://choosealicense.com/licenses/mit/)