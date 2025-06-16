# Financial Recommendation API

**Proyecto de aprendizaje avanzado con Spring Boot 3, Java 21, embeddings y recomendación financiera basada en IA.**

---

## Descripción

Este proyecto implementa un sistema de recomendación financiera capaz de sugerir productos personalizados a usuarios en función de sus necesidades, preferencias y el análisis semántico de los productos disponibles. La API aplica conceptos de **vector embeddings** y utiliza buenas prácticas modernas de desarrollo backend. El propósito principal es explorar cómo integrar inteligencia artificial, bases de datos y recomendaciones en un microservicio profesional usando Java y Spring Boot.

---

## Motivación y Objetivos de Aprendizaje

- Experimentar con IA real en el backend Java: Aprender a integrar y orquestar modelos de IA generativa y de embeddings dentro de APIs modernas usando Spring AI, la nueva abstracción de Spring para trabajar con LLMs y modelos open-source/propietarios.
- Probar modelos locales de IA (Ollama) y cloud: Implementar pipelines de recomendación usando tanto modelos locales (como los servidos con Ollama) como APIs cloud (OpenAI, Cohere, etc.), entendiendo ventajas, limitaciones y el ciclo de vida completo de inferencia y embeddings.
- Integrar técnicas de embeddings y similitud semántica para recomendaciones personalizadas.
- Explorar arquitectura limpia, desacoplada y extensible en Spring Boot 3 y Java 21.
- Mejorar habilidades de testing, observabilidad y buenas prácticas API REST.

---

## Características principales

- **API RESTful** moderna (Spring Boot 3).
- Recomendación de productos financieros usando embeddings (vectorización semántica).
- Endpoints para productos, embeddings y recomendaciones personalizadas.
- Inyección e inicialización automática de embeddings de productos.
- Pruebas de integración, configuración externalizada y estructura profesional.
- Listo para extender a integración con modelos LLM y bases vectoriales externas.

---

## Stack Tecnológico

- Java 21
- Spring Boot 3.x
- Spring Data JPA (con H2 o PostgreSQL, configurable)
- Embeddings (OpenAI, integración adaptable)
- Maven
- Docker (opcional para despliegue)
- Testcontainers (para pruebas integradas, opcional)

---

## Endpoints principales

    /api/products                           Lista todos los productos financieros disponibles
    /api/products                           Crea un nuevo producto financiero
    /api/users/{userId}/recommendations     Obtiene recomendaciones para un usuario, basado en similitud

