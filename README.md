Integrantes: 
Juan Esteban Cancelado Sanchéz
Nicolás Prieto Vargas

Se agregaron las carpetas library, book, loan y user tanto a la carpeta principal como a la carpeta de test.

![tree de las carpetas creadas](image-1.png)

Se hizo la prueba de addBook y se modificó de la mínima manera para que pase la prueba.
![Prueba mínima](image.png)

Se creó la prueba de crear agregar dos libros con el mismo isbn y no pasó.
![prueba 2 libros con mismo código](image-2.png)

Ahora se  modifica el método para que esa prueba pase de tal manera que no se puedan crear dos libros con el mismo isbn.
![modificación de crear dos libros con mismo código](image-3.png)

Ahora se hizo la prueba para poder crear más de un libro sin problema con diferente isbn.
![creación de más de un libro con diferente isbn](image-4.png)

Ahora se creó la prueba para añadir los usuarios al arreglo.
![Añadir usuario](image-5.png)

Se agregó en el pom el código dado para crear el archivo que nos da la cobertura total del programa.
![Jacoco](image-6.png)