
# ***Tarifa Batch***

Es un Batch que lee tarifas de una base de datos y las escribe en un tarifas.csv


## ***Documentation***
### ***Tarifa.java***
Clase que sirve para dar tipo a los objetos de la bbdd
### ***BatchConfig.java***
Es donde se hace el job y steps
### ***Reader.java***
Tiene un Bean de un JdbcCursorItemReader que hace una consulta para sacar los datos de la bbdd
### ***Writer.java***
Tiene un Bean de un FlatFileItemWriter de la clase Tarifa que crea un writer para poder escribir el fichero tarifas.csv
### ***JobCompletionNotificationListener***
Implementa JobExecutionListener.
Tiene un par de metodos para logear cuando el batch empieza y acaba
### ***TESTS***
Tiene un par de test que controlan el Reader y Writer para que lean y escriban correctamente



