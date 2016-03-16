# Tecnicas de diseño TP 0
![Build Status](https://travis-ci.org/lfrinaldi/template-tp0.svg?branch=master) 

## Enunciado
Dada una regular expression y un entero n, se deben generar n strings que matcheen la
regular expression dada. Las características que deben tener dichos strings se explican más
abajo.

La regular expression de entrada es una secuencia de caracteres que incluye SOLAMENTE:
* . (punto): Genera un caracter aleatoriamente. Si se limita a caracteres ASCII, esto es un
caracter random entre el ASCII 0 y el ASCII 255. Ejemplo: “.” genera strings de la forma
“a”, “b”, “h”, “4”, “!”, etc.
* \[\<char 0\>\<char 1\>...\<char n\>\] (conjunto): Genera un caracter aleatoriamente, pero
restringido a los caracteres especificados entre corchetes. Ejemplo: “[abc]” genera
strings de la forma “a”, “b”, “c”, y solo esos.
* Literales​: Genera el caracter especificado y solo ese caracter. Si es un caracter
reservado se puede escapar anteponiendo backslash. Ejemplo: “a” produce un solo
string “a”, “\\[“ produce un solo string “[“.
* ? (Cuantificador cero o uno): Genera de forma aleatoria cero o una ocurrencia del
caracter que lo precede. Ejemplo: “a?” Produce solo dos strings diferentes “” y “a”.
* \* (Cuantificador cero o muchos): Genera de forma aleatoria cero o muchas ocurrencias
del caracter que lo precede. En éste caso debemos imponer algún límite a cuantos
caracteres se generan. Éste valor se pasa como parámetro en el constructor de la clase
que genera los strings. Ejemplos, “a*” genera strings de la forma “”, “a”, “aa”, “aaa”,
“aaaa”, etc.
* + (Cuantificador uno o muchos): Genera de forma aleatoria una o muchas ocurrencias
del caracter que lo precede. En éste caso, como en el anterior, debemos imponer algún
límite a cuantos caracteres se generan. Ejemplo, “a+” genera strings de la forma “a”,
“aa”, “aaa”, “aaaa”, etc.

#### Restricciones
No utilizar Herencia ni Interfaces para la resolución
