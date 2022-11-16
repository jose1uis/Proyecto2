Proyecto 2 fundamentos de programación
Tank Wars Mini-juego.
• Cree un arreglo de 2 dimensiones (de 2 filas x 2 columnas) que almacene Tanques.
• Existen 2 tipos de Tanques: TanquesNormales (con salud igual a 10), TanquesAliens (con salud igual a 20).
• Cree un número aleatorio entre 1 y 4. Este número le dirá la cantidad de Tanques que debe instanciar.
• Utilizando la cantidad anterior, cree un for donde en el cuerpo pida otro número aleatorio (entre 1 y 2).
o Si sale 1 creará un TanqueNormal, y lo pegará en la primera posición disponible del arreglo de 2 dimensiones (por ejemplo en la 0.0).
o Si sale 2 creará un TanqueAlien, y lo pegará en la primera posición disponible del arreglo de 2 dimensiones (por ejemplo en la 0.0).
• Muestre por pantalla (utilizando System.out.prinltn()) el tablero de juego. El arreglo de 2 dimensiones, donde se vean los espacios disponibles y los Tanques vivos. Ejemplo:
• La imagen anterior muestra el “tablero” de juego (arreglo de 2 dimensiones), donde en la posición 0.0 hay un TanqueAlien con salud actual igual a 20. Y en la posición 0.1 hay un TanqueNormal con salud de 10. Las otras 2 posiciones están vacías.
• La idea es crear un juego, que al darle en la opción iniciar juego, cree la cantidad aleatoria de Tanques, y luego muestre un tablero similar al anterior. Y finalmente, se ejecutará un ciclo infinito, en el cual el usuario tendrá la opción de:
1. Disparar una bala (eligiendo la posición sobre la cual disparar). Cada bala quita 5 de sangre. Por ejemplo: si dispara en la 0.0 en TanqueAlien quedará con 15 de sangre.
2. Activar bomba atómica. La cual mata a un Tanque en una posición aleatoria automáticamente.
3. Activar Tanque mutante. La cual duplica la salud del Tanque qué tiene menos salud (omitir revisar los muertos).
4. La frase de la abuela. Muestra al usuario por pantalla una frase inspiradora que diría la abuela cuando jugaba a matar Tanques.
