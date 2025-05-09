📚 Segundo Previo - Plataforma Académica (API REST)
Estudiantes:

Jesús David Chinchilla Machuca - Código: 1152177

Sofía Suárez Angarita - Código: 1152144

Repositorio GitHub:
segundo-previo-practico

📌 Descripción del Proyecto
Este proyecto consiste en el diseño e implementación de una API REST robusta para la gestión de una plataforma académica, desarrollada con Spring Boot y Lombok. El sistema permite gestionar usuarios, asignaturas, evaluaciones, horarios y disponibilidad docente, optimizando así la planificación de clases y evitando conflictos de horario.

🚀 Funcionalidades Principales
Gestión de usuarios con roles diferenciados: ADMIN, TEACHER y STUDENT.

Administración de asignaturas, evaluaciones y horarios.

Control de disponibilidad e indisponibilidad de docentes.

Planificación académica con validación de conflictos de horario.

Generación de reportes académicos por estudiante y asignatura.

Historial de calificaciones y auditoría de acciones realizadas.

🏗️ Arquitectura del Proyecto
Controller: Define los endpoints RESTful.

Service: Contiene la lógica de negocio.

Repository: Maneja la persistencia utilizando Spring Data JPA.

Model: Define las entidades del dominio con anotaciones JPA.

🧰 Tecnologías Utilizadas
Java 17+

Spring Boot

Spring Data JPA

Lombok

H2 / PostgreSQL (configurable)

Maven

Git & GitHub

🗃️ Modelo de Datos (Entidades Principales)
Entidad	Descripción
User	Entidad base abstracta para Admin, Teacher y Student. Contiene campos comunes como nombre, correo y rol.
Admin	Hereda de User. Representa a los administradores del sistema con privilegios globales.
Teacher	Hereda de User. Puede registrar su disponibilidad, asignarse asignaturas y gestionar evaluaciones.
Student	Hereda de User. Se inscribe en asignaturas y visualiza calificaciones y reportes académicos.
Subject	Representa una asignatura. Tiene asociado un docente, estudiantes inscritos y evaluaciones programadas.
SubjectEnrollment	Relación entre Student y Subject. Registra las asignaturas inscritas por un estudiante.
Schedule	Representa un horario (día y hora) asignado a una asignatura o disponibilidad docente.
Evaluation	Evaluación académica que puede ser de tipo trabajo, parcial o prueba. Está asociada a una asignatura.
Grade	Calificación obtenida por un estudiante en una evaluación. Incluye valor numérico y fecha de modificación.
AuditLog	Registro de acciones realizadas en el sistema (modificaciones, accesos, etc.). Útil para trazabilidad.
Availability	Registro de horarios disponibles por parte de un docente. Utilizado para planificar clases.
Unavailability	Registro de indisponibilidades (ausencias, permisos, etc.) declaradas por un docente.
Report	Entidad que consolida información académica (rendimiento por estudiante o por asignatura).

🔗 Endpoints Clave
Endpoint	Descripción
/teachers/schedule	Consultar, actualizar o eliminar disponibilidad docente.
/teachers/unavailable	Gestionar indisponibilidades.
/subjects/schedule	Asignar o modificar horarios de clase.
/reports/student	Generar reporte académico consolidado.
/reports/subject	Analizar rendimiento por asignatura.
/grades/history	Historial de modificaciones en notas.
/evaluations/search	Búsqueda avanzada de evaluaciones.
/audit	Registro de acciones del sistema.
/availability	Consulta de disponibilidad consolidada de docentes.

📁 GitHub y Control de Versiones
Flujo de trabajo con ramas: main, develop, feature-*.

Commits documentados con mensajes descriptivos.

Proyecto privado y compartido con el instructor.

Archivo README.md con instrucciones completas.

📊 Criterios de Evaluación
Criterio	Descripción	Peso
Funcionalidad	Cumplimiento total de requerimientos	50%
Estructura y Organización	Arquitectura en capas, buenas prácticas	10%
Uso de POO	Encapsulamiento, herencia, polimorfismo	10%
Persistencia de Datos	Uso de JPA y bases de datos relacionales	10%
Uso de GitHub	Flujo de ramas, commits claros, documentación	5%
Validaciones y Errores	Manejo de errores y validaciones robustas	15%
