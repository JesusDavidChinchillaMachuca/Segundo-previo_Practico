# Segundo Previo - Plataforma Académica (API REST)

**Estudiante:** Jesus David Chinchilla Machuca y Sofia Suárez Angarita
**Código:** 1152177  y 1152144
**Repositorio GitHub:** [segundo-previo-practico](https://github.com/JesusDavidChinchillaMachuca9/segundo-previo_practico)

## Descripción del Proyecto

Este proyecto consiste en el diseño e implementación de una **API REST robusta** para una plataforma académica, desarrollada utilizando **Spring Boot** y **Lombok**. Su propósito es gestionar usuarios, asignaturas, horarios, evaluaciones y disponibilidad de docentes, permitiendo una planificación eficiente de clases y evitando conflictos de horario.

## Funcionalidades Principales

- Gestión de usuarios con roles diferenciados (ADMIN, TEACHER, STUDENT).
- Gestión de asignaturas, evaluaciones y horarios.
- Control de disponibilidad e indisponibilidad de docentes.
- Planificación de clases y verificación de conflictos de horario.
- Reportes académicos por estudiante y asignatura.
- Historial de calificaciones y auditoría de acciones.

## Arquitectura del Proyecto

- **Controller:** Define los endpoints RESTful.
- **Service:** Contiene la lógica de negocio.
- **Repository:** Gestiona la persistencia con JPA (extiende de `JpaRepository`).
- **Model:** Define las entidades del dominio con anotaciones JPA.

## Tecnologías Usadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- H2 / PostgreSQL (según configuración)
- Maven
- Git y GitHub

## Estructura de Entidades (Modelo de Datos)

- **User:** Base para ADMIN, TEACHER, STUDENT.
- **Student:** Lista de asignaturas inscritas.
- **Teacher:** Horarios disponibles e indisponibles, asignaturas.
- **Subject:** Docente asignado, estudiantes, evaluaciones.
- **SubjectEnrollment:** Relación estudiante-asignatura.
- **Evaluation:** Trabajo, parcial o prueba.
- **Schedules:** Horarios por docente o asignatura.

## Endpoints Clave

- `/teachers/schedule`: Consultar, actualizar, eliminar disponibilidad.
- `/teachers/unavailable`: Agregar, consultar o eliminar indisponibilidad.
- `/subjects/schedule`: Asignar o modificar horarios de clases.
- `/reports/student`: Reporte académico consolidado.
- `/reports/subject`: Análisis de desempeño por asignatura.
- `/grades/history`: Historial de modificaciones en calificaciones.
- `/evaluations/search`: Búsqueda avanzada de evaluaciones.
- `/audit`: Trazabilidad de acciones de usuario.
- `/availability`: Reporte consolidado de disponibilidad docente.

## GitHub y Control de Versiones

- Flujo de trabajo con ramas: `main`, `develop`, `feature-*`.
- Commits documentados con mensajes descriptivos.
- Archivo `README.md` con instrucciones del proyecto.
- Proyecto privado compartido con el instructor.

## Criterios de Evaluación

| Criterio                          | Descripción                                                  | Ponderación |
|----------------------------------|--------------------------------------------------------------|-------------|
| **Funcionalidad**                | Cumple con todos los requerimientos especificados            | 50%         |
| **Estructura y Organización**    | Arquitectura en capas y buenas prácticas                     | 10%         |
| **Uso de POO**                   | Encapsulamiento, herencia, polimorfismo                      | 10%         |
| **Persistencia de Datos**        | JPA y base de datos relacional                               | 10%         |
| **Uso de GitHub**                | Flujo en ramas, commits claros, documentación                | 5%          |
| **Validaciones y Manejo de Errores** | Validaciones y gestión de excepciones                      | 15%         |

## Instrucciones para Ejecutar el Proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/JesusDavidChinchillaMachuca9/segundo-previo_practico.git
