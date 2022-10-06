### Proyecto de Diseño de Bases de Datos para la cursada 2022. 

El proyecto modela publicaciones de propiedades en distintas inmobiliarias

[ UML ]

### Tecnologias necesarias

Debe contar con las siguientes tecnologias para levantar el proyecto localmente

* Maven 
* Java 8 
* MySQL

Las demas herramientas como Hibernate, JPA, conector de MySQL, etc. son dependencias del proyecto, por tanto maven se encargara de instalarlas cuando se ejecute `mvn install`

Les recomendamos que dispongan de las siguientes herramientas:

* Un IDE para inspeccionar y hacer modificaciones en el codigo. Les recomendamos IntelliJ
* Postman o cualquier software que permita realizar peticiones HTTP.

### Start

Para iniciar el proyecto ejecutar: `mvn spring-boot:run`.

Esto inicializará la API que correrá sobre el puerto 8081 del localhost. Este puerto puede cambiarse desde las applications.propperties del proyecto.

Para la conexion con la BD se deben definir tanto string de conexion como usuario y contraseña en la clase HibernateConfiguration

Los endpoints estan definidos en la clase RealStatesController.
