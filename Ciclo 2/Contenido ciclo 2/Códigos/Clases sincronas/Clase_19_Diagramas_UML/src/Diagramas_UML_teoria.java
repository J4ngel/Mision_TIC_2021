public class Diagramas_UML_teoria {
    /* UML -> Unified Modeling Language

    lenguaje visual, se usan diagramas

    Permite modelar:
    procesos
    sistemas
    software

    Es:
    Extensible: se pueden agregar y extender todo lo que se necesite
    Flexible: no solo se limita a modelar solamente una cosa 
    Escalable: se puede hacer del tamaño que se necesite

    Modelo: 
        -Un patrón sobre el cual algo que se producirá está basado
        -Un diseño o tipo
        -Modelar es construir un plan basándonos en un patron 
        -En UML -> forma visual de describir un negocio y sus reglas 

    Diagrama:
        -
        -Se usa para un proposito especifico
        -Tiene simbolos especiales
        -
        -Tienen una notacion que tienen elementos que trabajan entre si
        (conectoes, simbolos, etc)
        -Se encarga de hacer especificaciones de lenguaje (OMG -> Object Management Group)
        
    Tipos de diagrama:
        De estructura:
        Muestran la estructura estatica de los elementos del sistema
            Clases, componentes, objetos, implementación, paquetes, etc

        De comportamiento:
        Muestra el comportamiento dinamico de los elementos del sistema
            Actividad, casos de uso, diagramos de estado, de colaboración y de secuencia
        
    
    En donde se usa:
        Modelar procesos de negocios
        Describir la arquitectura de un sistema
        Mostrar la estructura de una app
        Mostrar el comportamiento de un sistema
        Modelar la estructura de los datos
        Crear las especificaciones de sistema
        Facilitar la creación de código
    
    POO en el contexto UML:
        Para las clases
            Generalización:
            Especialización:

        Asociaciones: Dos clases estan relacionadas o conectadas en alguna forma

        Colaboracion:
            Una clase trabaja junto con otra para llevar acabo algo
        
        Actores:

        Agregación: 
            Una relación del todo y sus partes
            el obj agregado tiene existencia independientemente de obj contenedor

        Composición:
            Todas las partes pertenecen a una unidad completa
            si desaparece el contenedor, desaparecen las partes

        Multiplicidad o Cardinalidad:
            Indica la cantidad de objetos que participan en una relación
            1 a 1
            1 a muchos
            muchos a muchos
        
            Modelo 4 + 1:
                Vista:
                    logica:
                        muestra las partes del sistema y sus interacciones
                        podemos ver los componentes del sistema y como interactuan
                    procesos:
                        Muestra la comunicación entre procesos
                    fisica:
                        Modela en ambiente de ejecución
                    desarrollo:
                        Muestra los modulos o componentes  
                    casos de uso:
                        Muestra la funcionalidad del sistema
                            Sistema
                            Actor (rol) --> puede ser una persona o un sistema
                            Objetivo / caso de uso
            
            Modelo estatico:
                Muestra las caracteristicas estructurales del sistema
                Se enfoca en las partes

                tipos:
                    Clases
                    Objetos
                    Casos de uso

            Modelo dinamico:
                Muestra cono el sistema se comporta antes de los eventos externos

                Secuencia
                Comunicación
                Actividad
            
            Modelo de implementación:
                Muestra diferentes elementos necesarios para la implementación del sistema

            ----------------------------------------------------
            Diagramas de casos de uso:
                Identifica los componentes principales que forma al sistema

            ej:
            Sistema:
                Biblioteca
            Actor:
                Biblotecario, Estudiante, Banco
            Casos de uso:
                Rol o acciones de cada actor
                
                Bibliotecario:
                    ordenar libros, cmprarlibros, crear credenciales, cobrar retraso, depositar dinero
                Estudiante:
                    buscar libro, sacar libro, regresar libro
                Banco:
                    Depositar dinero

            Dependencia include:
                el caso de uso invocador depende del caso de uso incluido para poder completar su objetivo
                (flecha punteada y <<include>>)
            
            Dependencia extend:
                dependencia opcional:
                (flecha punteada y <<Extend>>) 
            
            Generalización:
                hace referencia a la herencia en las clases
                (Linea no punteada que termina con una punta de flecha blanca en el interior de la punta)

            Test WAVE
            W - que hacer y no como hacerlo
            A - describe la perspectiva del actor
            V - incluye valor para el actor?
            E - flujo de eventos del escenario completo?

            Diagrama de clases
                -Uno de los mas comunes
                -Diagrama estático
                -Se usa un clasificador que es una figura rectangular
                -En el clasificador para la clase colocamos el nombre, los atributos y las operaciones

                - ------> privado
                + ------> publico
                # ------> protected
                ~ ------> paquete

                Relacion asociada:
                    describe un conjunto de enlaces, los cuales representan conexiones a traves de objetos
                    se lee como: tiene un
                    Se muestra como una linea o a veces como una flecha abierta (linea continua)
                
                Relación de cardinalidad:
                    Indica el número de onjetos en una asociación
                        (linea continua)
                        1 1
                        1 *
                        1 1...*

                Asociación reflexiva
                    El objeto de una clase puede interactuar en mas de una clase
                
                Agregación:
                    Es parte de - está hecho de
                    (linea continua que termina en un rombo blanco)
                
                Composición:
                    Si el contenedor se destruye, se destruyen las partes
                    (linea continua que termina en un rombo negro)
                
                Generalización:
                    Describe herencia - es un
                    (linea continua flecha con punta blanca)
                
                Dependencia:
                    -Muestra una relacion en la que una clase usa otra clase de alguna manera
                    -Usa a
                    (linea punteada, flecha normal (sin relleno))

                Realización:
                    
                Elementos de anotación:
                    Encargada de documentar los modelos
                    (como una ojita doblada)
                
                Restricciones:
                    Muestra limitaciones o condciones de un objeto en el diagrama
                    se usan {} para definir una restricción en una nota
        */
}
