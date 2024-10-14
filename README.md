```

¿Como funciona el programa?
La API recibe un array de strings como parámetro, donde cada elemento representa una fila de una matriz NxN que contiene una secuencia de ADN. Los caracteres permitidos en los strings son exclusivamente A, T, C y G, que corresponden a las bases nitrogenadas del ADN.

Para determinar si una persona es mutante, la secuencia de ADN debe contener más de una serie de cuatro letras idénticas consecutivas, ya sea en dirección horizontal, vertical o diagonal.

El usuario debe enviar la secuencia de ADN en formato JSON, asegurándose de que forme una matriz NxN válida.

Asi se veria una request de un DNA mutante:
```json
{
  "dna": [
    "AACGTT",
    "ATGTCC",
    "ACGGGG",
    "ATTGCC",
    "CCGTCC",
    "CCGTCC"
  ] 
}
```
###### Respuesta para un ADN mutante:
```json
{
  status: 200 OK
  Devuelve un true
}
```
Esta matriz contiene más de una secuencia de cuatro letras idénticas consecutivas, lo que indica que el ADN ingresado pertenece a un mutante.

En caso de que el ADN proporcionado no sea válido, la API devolverá una respuesta de error personalizada. Entre los posibles errores se incluyen: una matriz que NO sea de NxN, un array vacío, caracteres no válidos, un array nulo o una fila nula.
###### Request de un DNA no valido
```json
{
  "dna": [
    "AACGTT",
    "ATGTCC",
    "ACGGGG",
    "ATTGCC",
    "CCGTCC",
    "CC"
  ] 
}
```
###### Respuesta para un ADN no mutante:
```json
{
    Lanza un FORBIDDEN, con el siguiente texto: "Dna incorrecto"
}
```
## Despliegue
El proyecto se encuentra alojado en Render y podran acceder a travez del siguiente link.

[Accede a la API Mutantes](https://parcialunoprog3.onrender.com)

Para Ingresar a la base de datos, puedes ingresar con el siguiente link:

[Accede a la base de datos H2](http://localhost:8080/h2-console/)

Credenciales de acceso a la base de datos en memoria:
* URL: jdbc:h2:./mutants;
* USERNAME: sa
* PASSWORD: root

## Endpoints de la api
* ### Endpoint /mutant/test
Este endpoint de tipo **POST** recibe como parametro un JSON con la matriz que contiene el DNA. Para luego evaluar si el dna ingresado es correcto (Que tenga las letras que solo se pueden ingresar, que sea una matriz cuadrada y que no se repita el dna ingresado),
para luego verificar si el dna es mutante o humano.


## Endpoints de los stats
* ### Endpoint /mutant/stats
Este endpoint de tipo **GET** nos devuelve un JSON con la cantidad de personas con DNA humano o mutante y ademas un ratio.

###### Respons del endpoint /stats

```json
{
    "mutants": Cantidad de dnas detectados como mutantes,
    "humans": Cantidad de dnas detectados como humanos,
    "ratio": mutants/humans
}
```
