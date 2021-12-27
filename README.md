# Prueba técnica
Desarrollo de la prueba técnica para la creación de e-commerce

# Descripción
Este es un proyecto desarrollado para una prueba técnica de selección

# Tecnología utilizada
La tecnología que se ha utilizado para desarrollar esta aplicación es Spring Boot, debido a su facilidad de utilización y lo adecuadamente diseñado para la función demandada.

# Distribución de carpetas
La carpeta principal de la aplicación es la de "main" encontrada en el paquete com.test.main. Dentro de esta encontramos los dos paquetes, como son "controllers" y "entities".
En controllers encontramos definido el controlador para las diferentes funciones de la aplicación, llamado CartController.
En la carpeta "entities" encontramos definidas las clases que se utilizan en la aplicación: "Product" y "Cart".

# EndPoints
El programa consta de 1 principal endpoint

## /cart
Este endpoint nos permite:

### GET "/cart/{id}"
Nos devuelve el carrito existente previamente creado, pasándole el id del carrito.

### POST "/cart/{id}"
Nos permite crear un carrito, en este caso también necesitamos pasarle el id con el que se creará el carrito.

### PUT "/cart/{id}"
También podemos añadir productos al carrito, en el endpoint pondremos el id del carrito al que se añadirán los productos y en el body de la petición pondremos un json con una lista de objetos "Product", este debe tener la siguiente estructura:
```json
[
{"id":1,"description":"Laptop","amount":2},
{"id":2,"description":"Keyboard","amount":3}
]
```

### DELETE "/cart/{id}"
Finalmente con este endpoint eliminamos el carrito donde id es el número de id del carrito, por ejemplo "/cart/1"

## Volatilidad del carrito
El carrito es volatil gracias a la función deleteVolatileCart(), que tiene asociado un tag de tipo @Scheduled, que elimina el carrito cada 10 minutos.

# Instalación
Para su instalación solo se requiere tener Java 11 instalado en el ordenador o contenedor.

