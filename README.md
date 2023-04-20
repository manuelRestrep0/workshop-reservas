# Sistema de reservas para un hotel.

Este es un proyecto api REST para gestionar reservas del hotel Ashir. 
La api permite a los clientes buscar y reservas habitaciones en el hotel, tambien permite registrar nuevos clientes.

El proyecto esta hecho principalmente con las siguientes tecnologías: 

[![My Skills](https://skills.thijs.gg/icons?i=java,mysql,git)](https://skills.thijs.gg)

Ademas se hizo uso de Spring boot para utilizar diferentes librerias tales como:

<ol>
	<li>Rest-api</li>
	<li>Swagger</li>
	<li>Spring data</li>
	<li>Spring security</li>
	<li>JUnit</li>
	<li>Github Desktop</li>
</ol>

## Rutas: 

POST - http://localhost:8080/api/v1/cliente  (Para registrar un cliente.)

GET -  http://localhost:8080/api/v1/disponibles/{fecha} (Se obtienen las habitaciones disponibles en la fecha indicada.)

GET -  http://localhost:8080/api/v1/disponibles/habitacion?tipo="tipo-de-habitacion"&fecha="fecha-reserva" (Se obtienen las habitaciones del tipo indicado disponibles en la fecha indicada.)

GET -  http://localhost:8080/api/v1/
 
GET -  http://localhost:8080/api/v1/reservas/{cedula} (Se obtinen las reservas de un cliente dada su cedula.)

POST -  http://localhost:8080/api/v1/reservar?numero&fecha&cedula  (Se realiza la reserva de una habitación.)

