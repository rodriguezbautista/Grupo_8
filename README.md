# TPFINALPROGRA3

Solicitud
Se requiere el desarrollo de un sistema informático para una empresa de traslados de pasajeros y de mensajería. La interfaz de usuario será una computadora, los requerimientos serán limitados.

Descripción breve del sistema
El sistema debe gestionar parte de la información de una empresa de transporte de pasajeros y mensajería.

La Empresa cuenta con una flota de Vehículos de diferentes características, un conjunto de Choferes que manejan cualquiera de los Vehículos y un conjunto de Clientes registrados con los cuales opera. Estos actores y recursos son dinámicos en el tiempo, o sea, pueden aumentar.

A modo de ejemplo se presentan estos casos:

Casos de uso :

Un Cliente registrado completa el formulario de solicitud de Viaje (Pedido) (ver funcionalidad 2.2). En ese momento se crea un Viaje en estado “solicitado”.
El sistema deberá permitir la creación de un viaje (Pedido) y mostrar su evolución en el tiempo siguiendo la cronología propuesta en la sección “Evolución del Viaje desde que nace como Pedido”
Usuarios del sistema
El sistema tendrá dos tipos de usuarios (en la primera parte):

Un Administrador
Varios Clientes
Funcionalidades solicitadas
Se solicita que el sistema contemple las siguientes funcionalidades:

1) Funcionalidades del Administrador
Gestión de clientes, choferes y vehículos.
Alta, Modificación, Consulta
Solicitud de listados de:
de Clientes
de Choferes
de Vehículos
de Viajes (*1)
Cálculo de salarios mensuales de cada Chofer. Esto incluye el dinero que reciben los choferes contratados.
Cálculo del total de dinero necesario para pagar los salarios.
   (*1) se debe generar un listado ordenado por costo del viaje, de mayor a menor. Para no alterar la colección de viajes original, se deberá clonar y luego trabajar sobre el clon.

2) Funcionalidades del Cliente
Registro de un nuevo Cleinte. El sistema debe notificar en caso de error, ya que no se puede repetir un nombre de usuario.
Completar un formulario de solicitud de viaje. El sistema evaluará la solicitud e informará al usuario sobre:
Aceptación del Pedido
Rechazo con motivos (falta de vehículo, falta de chofer, solicitud incoherente)
Pagar el Viaje.
Calificar el Chofer.
Visualización de historial de los propios Viajes.

Metodología a utilizar para el desarrollo
Pasos a seguir:

Entender bien toda la narrativa completa.
Revisar cada funcionalidad solicitada y determinar los requerimientos implicados.
Elaborar el “mundo del problema”, determinar cada clase con sus responsabilidades.
Establece cuáles son las clases necesarias de la capa de modelo (clases que mayoritariamente se utilizan para el almacenamiento de los datos)
Determinar los atributos propios de cada Clase (declaración de Clases).
Composiciones
Agregaciones
Asignar las responsabilidades a cada clase utilizando la “Técnica del experto”.
Para cada requerimiento determinar qué clase es responsable de ejecutarlo.
Determinar todos los pasos necesarios para satisfacer cada requerimiento, esto puede generar uno o varios métodos.
Aclaraciones
Se debe utilizar el denominado Proceso Disciplinado de Desarrollo. En donde se utiliza una programación basada en contratos.

Para cada clase establecer:

Contrato de Clase.
Contrato de Constructor.
Contrato de cada Método.
Declarar las excepciones que lanzará cada método (un constructor también podría lanzar una excepción).
  Cada contrato se define estableciendo: Invariantes de Clase, Precondiciones, Postcondiciones. Se debe utilizar la herramienta JavaDoc para definirlo. Los invariantes, precondiciones y postcondiciones también se deben implementar utilizando aserciones.

   Durante este proceso se debe determinar muy bien en qué situaciones es conveniente utilizar precondiciones, postcondiciones, invariantes, lanzamiento de excepciones y/o validaciones con if.

   Respetar un diseño de tres capas: Presentación, Negocio, Modelo.

Ideas sobre el mundo del problema (responsabilidades de cada clase, comportamiento y características)
Estructura de datos
Clase Cliente

Clase Chofer

Clase Vehículo (Moto Auto o Combi)

Clase Pedido (agregacion con Cliente) tipo de vehículo.

Clase Viaje (composición con pedido y agregación con Chofer y Vehiculo)

Usuarios
Existen dos categorías de Usuarios: Administrador y Cliente.  Los Usuarios tendrán un nombre de usuario, contraseña y nombre real.

Vehículo (Aplicar patrón Factory)
Existen tres tipos de vehículos, Motos, Automóviles, y Combis. Se tendrán en cuenta su identificador (número de patente) y sus prestaciones.

Tabla de Prestaciones de Vehículos

Moto

Automóvil

Combi

Cant. Max Pasajeros

1

4

10

Pet Friendly

No

Si

No

Baúl

No

Si

Si


De cada vehículo se necesita conocer:

Nro de Patente
Cant_max_pasajeros
PF (acepta mascotas o no)
Baul

   Los vehículos tendrán un índice de prioridad para cada viaje, de forma que se elige el mejor vehículo para cada pedido priorizando motos, autos y combi en ese orden. Para ello, la clase vehículo contará con un método:

Integer getPrioridad (Pedido pedido)  que devolverá un objeto de tipo Integer indicando el valor de prioridad para el pedido en cuestión. Si el vehículo no es apto para el pedido retornará null. Aplicar el patrón Template en el siguiente orden:

Verifica cantidad Pasajeros
Verifica Uso de Baul
Verifica Transporte de Mascota
Si califica realizar cálculo

Moto: Si solo pide un pasajero sin mascota ni baúl retorna 1000 puntos.

Auto: Si pide baul el valor es 40 * cantPax. Sino el valor es 30 * cantPax

Combi: Retorna un entero = cantidad de pax solicitados*10 + 100 puntos por uso de baul


Chofer
Existen tres tipos de Choferes, que se discriminan según el tipo de vinculación laboral: permanente, temporario, contratado.

Las características requeridas para todos los Choferes son las siguientes:

dni
nombre
El comportamiento común a todos está dado por los siguientes métodos:

getSueldoBruto(...) //sueldo con los pluses
getSueldoNeto(....) //sueldo con las retenciones aplicadas y los pluses
getter’s y setter’s
Chofer Permanente
Las características de los Choferes Permanentes son:

sueldo_basico: valor numérico
plus_x_antiguedad: porcentaje de aumento que se aplica al básico por antiguedad
plus_x_hijos: porcentaje de aumento que se aplica al básico por cantidad de hijos
aportes: porcentaje de descuento que se aplica al sueldo bruto (basico + pluses).
fecha_ingreso: fecha en que ingresa a la empresa.
        Los métodos deben diseñarse.

        El chofer permanente es un empleado de planta de la empresa y su salario se calcula en base a un valor básico y un plus por antigüedad. También tiene un aumento por cantidad de hijos y un descuento por aportes jubilatorios

Chofer Temporario
Las características de los Choferes Temporarios son:

sueldo_basico: valor numérico
aportes: idem Chofer Permanente
plus_x_cantidad_viajes: porcentaje que se aplica al básico según la cantidad de viajes, por ejemplo: más de 40 viajes en el mes, se incrementa el sueldo_basico en un 10%
Los métodos deben diseñarse.

Los choferes temporarios son empleados temporarios de la empresa y su salario mensual se calcula en base a un sueldo básico, un plus por cantidad de viajes y tiene los mismos descuentos por aportes que el Permanente

Chofer Contratado
Las características de los Choferes Contratados son:

ganancia_viaje: porcentaje que recibirá el chofer por un viaje realizado. El chofer rinde todo el dinero a la empresa y a fin de mes la empresa le retorna su ganancia.
Los métodos deben diseñarse

Viaje
El viaje contiene información sobre Cliente, Vehículo, Chofer, zona, mascota, equipaje, cantidad de pasajeros, distancia recorrida, costo.

El costo del viaje deberá calcularse y consignarse a cada Viaje, ya que puede haber cambios en los valores en un futuro, y será el siguiente: Un valor base de $ 1000 (se podrá modificar), y luego, dependiendo de la cantidad de pasajeros, Km recorridos, y tipo de viaje, la fórmula será la siguiente:

Costos discriminados por servicios

Tabla de zonas

Estándar

Calles sin asfaltar

Zona Peligrosa

Cant Pax.

+10% base por Pax

+20% base por Pax

+10% base por Pax

Distancia

+10% base por Km

+15% base por Km

+20% base por Km


Tabla Mascotas

con mascota

sin Mascota

Cant Pax.

+10% base por Pax

Sin incremento

Distancia

+20% base por Km

Sin incremento


Tabla de Equipaje

de mano

en baúl

Cant Pax.

Sin incremento

+10% base por Pax

Distancia

Sin incremento

+5% base por Km


La solicitud del viaje (Pedido):

Los clientes podrán solicitar diferentes tipos de viajes completando un formulario donde deberán aclarar la zona, el tipo de servicio y el tipo de equipaje

Por zonas:

Estándar
Calles sin asfaltar
Zona Peligrosa
Servicio pet friendly:

Con traslado de mascota
Sin traslado de mascota
Tipo de equipaje:

Equipaje en mano
Equipaje en Baúl

Formulario de Pedido

El cliente llenará un formulario de Pedido (solicitud de viaje) con la siguiente información:

Fecha (fecha y hora)
Tipo de Servicio: transporte de pasajeros o mensajería
Zona: Estandar, Sin asfaltar, Peligrosa
Mascotas: sí / no
Equipaje: Manual / Baúl
Cantidad de Pasajeros
Cliente que solicita el pedido (esto debe agregarse en forma automática)

Evolución del Viaje desde que nace como Pedido

El sistema deberá ser capaz de evaluar un Pedido y responder sí lo acepta o rechaza. Las causas de rechazo están determinadas por la incoherencia en la confección del Pedido, o sea, el cliente no ha leído la Tabla de Prestaciones de Vehículos. En caso de que no exista en la planta ningún vehículo que cumpla con lo requerido no se creará un Viaje (a partir del Pedido) y se lanzarán excepciones según sea el motivo de rechazo.

Con cada Pedido aceptado, el sistema generará un Viaje en situación de “solicitado”.

El sistema deberá ser capaz de asignar al Viaje “solicitado” el mejor vehículo disponible que cumpla con lo requerido.

El sistema deberá ser capaz de asignar un Chofer a un Viaje “con Vehiculo” y el Viaje pasará a situación de “iniciado”. En esta primer etapa, sí no existe un Chofer disponible, el sistema informará de la situación lanzando las excepciones correspondientes.

El sistema deberá ser capaz de registrar el pago por parte del Cliente de un Viaje “iniciado” (el Viaje pasa a situación de “pagado”).

El sistema deberá ser capaz de registrar una calificación del Chofer por parte del Cliente de un Viaje “finalizado”, lo cual dejará al Viaje en situación de “calificado”.

En esta primera etapa, al finalizar un viaje, tanto el chofer como el vehículo involucrado, pasarán al final de sus correspondientes listas.

Características del Viaje

El Viaje contendrá la siguiente información:

Una referencia al Pedido que lo originó.
Una referencia al Chofer asignado.
Costo.
Distancia real recorrida.
Calificación del Chofer por parte del Cliente (de 0 a 10 estrellas).
Cálculo de comisiones y puntajes.
Por demanda del administrador se realiza una actualización de los puntajes (de un mes) de los usuarios de acuerdo a las siguientes reglas:

Clientes:
5 puntos por cada viaje realizado
10 puntos para el cliente con mayor cantidad de viajes
Chofer:
15 puntos para el que más km recorrió
Estos puntajes los otorga la empresa, no es lo mismo que la calificación del Cliente. O sea, el Chofer tendrá dos tipos de observaciones: la Calificación por parte del Cliente (estrellas) y el Puntaje de la empresa (puntos).

Generación de Reportes
Se realizan a demanda del administrador de la empresa

Detalle de cada Usuario. Incluye Estrellas y Puntaje
Detalle de los salarios pagados por la empresa a cada Chofer.
Detalle de los Viajes realizados por un Chofer en particular en un período de días.
Detalle de los Viajes realizados por un Cliente en particular en un período de días.
Ideas generales
En la primera etapa se debe utilizar una arquitectura de tres capas (Presentación, Negocio, Datos). Luego, para la segunda parte se la adaptará utilizando el patrón MVC.

Todas las funcionalidades deben estar implementadas en la capa de negocio, se debe utilizar el patrón FACADE.

Independientemente de las funcionalidades específicas para cada actor (Cliente, Administrador, Chofer), todas se programan en la capa de negocios.

Cada actor hará una solicitud al sistema de cada funcionalidad que le corresponde. En la segunda etapa, esto se resolverá a través de las vistas correspondientes a cada Usuario.

Se debe respetar una programación basada en contratos.
 
