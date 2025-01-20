
# Responde, usando tus palabras, a las siguientes preguntas.

## a) ¿Qué ventajas e inconvenientes encuentras al usar una base de datos documental con MongoDB?

### Ventajas

* Hacer las consultas a la base de datos es mucho mas simple
* Eres mucho mas libre a la hora de manejar datos

### Desventajas

* Necesitas mucho mas control dentro del codigo
* No tiene que seguir una estructura
* No hay claves primarias ni foraneas

## b) ¿Cuáles han sido los principales problemas que has tenido al desarrollar la aplicación?

### Realmente no he tenido casi ningun problema y los que he tenido si pueden ser considerados como tal son:
* ### La conexion con la base de datos falla muchas veces
* ### Sin querer cambie uno de los campos de juego(fecha_lanzamiento -> fecha) y empece a insertar juegos con el nombre equivocado

## c) ¿Cómo solucionarías el problema de la inconsistencia de datos en una base de datos documental? (El hecho de que en los documentos de una colección no sea obligatorio seguir un esquema único)

### Creo que esto se puede solucionar simplemente teniendo cuidado con el codigo, ya que si sabes constantemente lo que estas haciendo no creo que haya ningun problema a la hora de hacer consultas