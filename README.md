📚 Segundo Previo - Plataforma Académica (API REST)
👨‍🎓 Estudiantes:
Jesús David Chinchilla Machuca – Código: 1152177

Sofía Suárez Angarita – Código: 1152144

🔗 Repositorio GitHub: segundo-previo-practico

📌 Descripción del Proyecto
Este proyecto consiste en el diseño e implementación de una API REST para una plataforma académica, desarrollada con Spring Boot, Lombok y JPA. Su propósito es gestionar usuarios, asignaturas, evaluaciones, horarios y disponibilidad de docentes, facilitando la planificación de clases y evitando conflictos de horario.

🚀 Funcionalidades Principales
Gestión de usuarios con roles: ADMIN, DOCENTE y ESTUDIANTE.

Administración de asignaturas, horarios y evaluaciones.

Registro y consulta de disponibilidad e indisponibilidad de docentes.

Planificación de clases con verificación automática de conflictos.

Generación de reportes académicos por estudiante y por asignatura.

Historial de calificaciones y registro de acciones del sistema (auditoría).

🏗️ Arquitectura del Proyecto
Controlador: Define los puntos de entrada (endpoints) a través de HTTP.

Servicio: Contiene la lógica de negocio de cada módulo.

Repositorio: Maneja la conexión y persistencia con la base de datos.

Modelo: Representa las entidades del sistema usando anotaciones JPA.

🧰 Tecnologías Utilizadas
Java 17 o superior

Spring Boot

Spring Data JPA

Lombok

Base de datos H2 o PostgreSQL (según configuración)

Maven

Git y GitHub

🗃️ Modelo de Datos – Entidades
Entidad	Descripción
Usuario (User)	Clase base abstracta. Contiene campos comunes como nombre, correo, contraseña y rol. Es extendida por las entidades Admin, Docente y Estudiante.
Administrador (Admin)	Hereda de Usuario. Tiene acceso total al sistema.
Docente (Teacher)	Hereda de Usuario. Puede declarar disponibilidad, gestionar asignaturas y calificar evaluaciones.
Estudiante (Student)	Hereda de Usuario. Se inscribe en asignaturas, presenta evaluaciones y revisa reportes.
Asignatura (Subject)	Representa una materia. Tiene un docente asignado, lista de estudiantes y evaluaciones programadas.
Inscripción (SubjectEnrollment)	Relación entre un estudiante y una asignatura. Indica en qué materias está inscrito cada estudiante.
Horario (Schedule)	Define el día y hora asignado a una clase o a la disponibilidad de un docente.
Evaluación (Evaluation)	Trabajo, parcial o prueba asociada a una asignatura.
Calificación (Grade)	Nota obtenida por un estudiante en una evaluación. Incluye valor, fecha y observaciones.
Bitácora (AuditLog)	Registro detallado de acciones del sistema: cambios, accesos, modificaciones, etc.
Disponibilidad (Availability)	Horarios en los que un docente está disponible para dictar clases.
Indisponibilidad (Unavailability)	Periodos donde el docente no está disponible (licencias, permisos, etc.).
Reporte (Report)	Consolidación de datos académicos por estudiante o asignatura. Incluye notas promedio y desempeño.

🔗 Endpoints Principales
Ruta (Endpoint)	Funcionalidad
/teachers/schedule	Consultar, actualizar o eliminar disponibilidad del docente.
/teachers/unavailable	Registrar y consultar períodos de indisponibilidad.
/subjects/schedule	Asignar o modificar horarios de clase.
/reports/student	Obtener reporte académico consolidado por estudiante.
/reports/subject	Generar análisis de rendimiento por asignatura.
/grades/history	Consultar historial de modificaciones en calificaciones.
/evaluations/search	Buscar evaluaciones por diferentes criterios.
/audit	Consultar historial de acciones del sistema.
/availability	Ver reporte general de disponibilidad de docentes.

📁 Control de Versiones en GitHub
Flujo de trabajo basado en ramas:

main: versión estable del proyecto.

develop: funcionalidades en desarrollo.

feature/*: ramas individuales para nuevas funcionalidades.

Mensajes de commit claros y descriptivos.

Proyecto compartido de forma privada con el docente evaluador.

Documentación completa y actualizada en README.md.

📊 Criterios de Evaluación
Criterio	Descripción	Ponderación
Funcionalidad	Cumple todos los requerimientos especificados	50%
Estructura y Organización	Uso de arquitectura en capas y buenas prácticas	10%
Programación Orientada a Objetos	Uso correcto de herencia, polimorfismo y encapsulamiento	10%
Persistencia de Datos	Uso correcto de JPA y bases de datos relacionales	10%
Uso de GitHub	Flujo con ramas, mensajes claros, trabajo colaborativo	5%
Validaciones y Manejo de Errores	Control de errores, validaciones en entidades y lógica	15%

🧪 Instrucciones para Ejecutar el Proyecto
Clonar el repositorio:

bash
Copiar
Editar
git clone https://github.com/JesusDavidChinchillaMachuca9/segundo-previo_practico.git
cd segundo-previo_practico
Importar en el IDE:
Abrir el proyecto como proyecto Maven en IntelliJ IDEA, Eclipse u otro editor compatible.

Configurar la base de datos (opcional):

Por defecto se usa H2 (base de datos en memoria).

Para usar PostgreSQL, modificar el archivo application.properties.

Ejecutar la aplicación:

Desde el IDE: ejecutar la clase SegundoPrevioPracticoApplication.

Desde la terminal:

bash
Copiar
Editar
mvn spring-boot:run
Probar los servicios REST:
Usar herramientas como Postman o Insomnia para consumir los endpoints.
