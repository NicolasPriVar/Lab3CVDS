# Proyecto de Pruebas de Biblioteca

## Integrantes

- **Juan Esteban Cancelado Sánchez**
- **Nicolás Prieto Vargas**

## Estructura del Proyecto

Se han creado las siguientes carpetas en la estructura del proyecto:

- `library`
- `book`
- `loan`
- `user`

Estas carpetas están presentes tanto en la carpeta principal como en la de pruebas (`test`).

![Tree de las carpetas creadas](image-1.png)

## Pruebas y Modificaciones

### Prueba de `addBook`

Se implementó la prueba inicial para el método `addBook`, y se realizó una mínima modificación para que la prueba pasara satisfactoriamente.

![Prueba mínima](image.png)

### Prueba para Libros con el Mismo ISBN

Se creó una prueba para verificar que no se puedan agregar dos libros con el mismo ISBN. Esta prueba inicialmente falló.

![Prueba 2 libros con mismo código](image-2.png)

Se modificó el método `addBook` para asegurar que no se puedan crear dos libros con el mismo ISBN.

![Modificación para evitar ISBN duplicado](image-3.png)

### Prueba de Creación de Libros con Diferente ISBN

Se verificó que es posible agregar múltiples libros con ISBN diferentes sin problemas.

![Creación de más de un libro con diferente ISBN](image-4.png)

### Prueba de Adición de Usuarios

Se implementó una prueba para agregar usuarios al sistema correctamente.

![Añadir usuario](image-5.png)

### Integración de Jacoco

Se añadió el código necesario en el archivo `pom.xml` para generar un informe de cobertura del código utilizando Jacoco.

![Jacoco](image-6.png)

### Resultados Finales

Finalmente, se logró una cobertura de código superior al 80%, con el sistema funcionando correctamente.

![Final](image-7.png)
