![](https://user-images.githubusercontent.com/69222739/95393199-c6ae0080-08bf-11eb-96da-355de61463c3.jpg)

Imagen Tomada de: https://www.google.com/search?q=music&sxsrf=ALeKk03-0cVsLnh1qdV4TEPARXCsQu_2aQ:1602108886161&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiv9LPYwKPsAhUtpFkKHWtZAUgQ_AUoAXoECA0QAw&biw=1366&bih=547#imgrc=TFaYhsQnuyOq1M

# Integrative Task 2 by Camilo González Velasco
## APO I

### Enunciado: 

Cansados de las continuas interrupciones de la publicidad y comerciales mientras escuchan música usando las plataformas de streaming, usted y unos compañeros de la universidad decidieron aplicar sus conocimientos en programación para diseñar e implementar el prototipo de una aplicación que permita organizar y compartir música entre sus usuarios.

Inicialmente, el equipo de desarrollo decidió bautizar la aplicación: el **Music Collect & Share** o **MCS**  para referirse al prototipo de la app de forma corta. En un momento de creatividad crearon un logo y lo convirtieron en ascii para el prototipo (mientras aprenden interfaz gráfica de usuario)

El Music Collect & Share tiene varios usuarios registrados, un pool de canciones compartidas y una colección de playlists.  Cada usuario tiene un apodo o nombre de usuario que es una sola palabra, sin espacios.  Por ejemplo, lunalunera, djchristian y seyerman son nombres de usuarios de la aplicación. Todos los usuarios tienen además una contraseña, una edad y una categoría.  La categoría de un usuario  puede ser, newbie, little contributor, mild contributor y star contributor, la categoría de un usuario  se asigna dependiendo de la cantidad de canciones que han compartido en el pool de canciones así:
  
- Un usuario está en la categoría newbie cuando está recién creado y hasta que comparte tres canciones.

- A partir de tres canciones compartidas, un usuario se convierte en  little contributor hasta que comparta diez canciones.

- Cuando un usuario comparte diez canciones se convierte en usuario mild contributor  y conserva esta categoría hasta que comparte 30 canciones.

- A partir de las 30 canciones compartidas, el usuario está en la categoría star contributor

Cada canción en el pool de canciones del **MCS** tiene un título, un nombre de artista o banda, una fecha de lanzamiento, una duración y un género. El género se refiere al género musical, aunque existen diversos  géneros musicales, usted y sus compañeros decidieron limitar los géneros de las canciones del **MCS** a rock, hip hop, música clásica, reggae, salsa y metal.  

De forma general,  cada playlist en el **MCS** tiene un nombre, una duración y los géneros de las canciones que hacen parte del playlist. La duración de una playlist se obtiene sumando la duración de cada una de las canciones en el play list, y los géneros es el conjunto de géneros de las canciones del playlist.  Por tanto, cuando se crea un playlist en el **MCS** este playlist tiene un nombre pero está vacío por tanto su duración es cero y su conjunto de géneros está vacío.  La duración y el conjunto de géneros cambia a medida que se vayan agregando canciones.  A continuación se explica con un ejemplo:

- Se crea un playlist llamado “Música para programar”, con  duración igual a cero y género vacío.

- Se incluye en la playlist la canción “November rain” de Guns N’ Roses con duración 4:43 y género Hard Rock.  Por tanto, se actualiza la duración de la playlist a 4:43 y el género a ROCK

- Se incluye la canción “Nothing else matters” de Metallica con duración 6:28 y género Hard Rock. Entonces se actualiza la duración de la playlist a 11:11 y género sigue siendo ROCK

- Se incluye la canción “Jump around” de House of Pain con duración 3:37 y género hip hop.  Entonces la duración de la playlist se actualiza a  14:48 y su género se actualiza a ROCK, HIP HOP

Los playlist tienen tres variantes: playlists privados, restringidos y públicos. A continuación se explican las particularidades de los playlists:
- Un playlist privado tiene un único usuario que puede añadir y listar las canciones que contiene.
- Un playlist restringido tiene un máximo de cinco usuarios que pueden añadir y listar canciones.
- Un playlist público no tiene restricciones de usuarios, es abierto para todos, pero tiene una calificación promedio, porque cualquier usuario puede ingresar una calificación entre 1  y 5 indicando qué tanto le gustó el playlist (1 la nota más baja, 5 la nota más alta)


### Autor

**Camilo González Velasco**
[Cuenta de Github](https://github.com/camilogonzalez7424)
[Cuenta de Twitter](https://twitter.com/CamiloGonzlezV3)
2020
