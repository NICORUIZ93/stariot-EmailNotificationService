# MassMessenger 📨

**MassMessenger** es un microservicio escalable construido con **Spring Boot 3** para el envío masivo de correos electrónicos y notificaciones. Utiliza **RabbitMQ** como broker de mensajes para gestionar colas de tareas asíncronas, **Spring Mail** para el envío de correos electrónicos y **Docker** para la containerización de la aplicación. Además, integra **Lombok** para simplificar el código y mejorar la productividad.

---

## Características principales 🚀

- **Envío masivo de correos electrónicos**: Permite enviar correos electrónicos de manera eficiente y asíncrona.
- **Notificaciones**: Base para extender el servicio con notificaciones push, SMS u otros canales.
- **RabbitMQ**: Gestión de colas de mensajes para procesamiento asíncrono y escalable.
- **Dockerizado**: Fácil despliegue y configuración con Docker y Docker Compose.
- **Lombok**: Código limpio y reducido gracias a la anotación automática de getters, setters y constructores.

---

## Tecnologías utilizadas 🛠️

- **Spring Boot 3**
- **RabbitMQ**
- **Spring Mail**
- **Lombok**
- **Docker**
- **Docker Compose**
- **Gradle** (gestión de dependencias)

---

## Requisitos previos 📋

- **Java 17**: Asegúrate de tener instalado JDK 17.
- **Docker**: Para ejecutar RabbitMQ y containerizar la aplicación.
- **Gradle**: Para construir y gestionar el proyecto.

---

## Configuración ⚙️

### 1. Clona el repositorio

```bash
git clone https://github.com/tu-usuario/mass-messenger.git
cd mass-messenger
```

### 2. Configura las variables de entorno

Edita el archivo `src/main/resources/application.properties` para configurar:

- **RabbitMQ**: Credenciales y dirección del servidor.
- **Spring Mail**: Credenciales del servidor SMTP (por ejemplo, Gmail).

### 3. Ejecuta con Docker Compose

```bash
docker-compose up --build
```

Esto levantará:
- Un contenedor con **RabbitMQ**.
- Un contenedor con la aplicación **MassMessenger**.

---

## Uso 🖥️

### Enviar un correo electrónico

Realiza una solicitud **POST** al endpoint `/api/email/send` con el siguiente cuerpo:

```json
{
    "to": "destinatario@example.com",
    "subject": "Asunto del correo",
    "text": "Contenido del correo electrónico."
}
```

Ejemplo con `curl`:

```bash
curl -X POST http://localhost:8080/api/email/send \
-H "Content-Type: application/json" \
-d '{
    "to": "destinatario@example.com",
    "subject": "Hola",
    "text": "Este es un correo de prueba."
}'
```

### Verificar colas en RabbitMQ

Accede a la interfaz de gestión de RabbitMQ en:  
[http://localhost:15672](http://localhost:15672)  
Usuario: `guest`  
Contraseña: `guest`

---

## Estructura del Proyecto 🗂️

```
src/
├── main/
│   ├── java/
│   │   └── com/example/messaging/
│   │       ├── config/          # Configuración de RabbitMQ y otros beans
│   │       ├── controller/      # Controladores REST
│   │       ├── service/         # Lógica de negocio (envío de correos, etc.)
│   │       ├── model/           # Modelos de datos (DTOs, entidades)
│   │       ├── repository/      # Repositorios de datos (opcional)
│   │       └── MessagingApplication.java # Punto de entrada de la aplicación
│   └── resources/
│       ├── application.properties # Configuración de la aplicación
│       └── static/              # Archivos estáticos (opcional)
└── test/
    └── java/
        └── com/example/messaging/ # Pruebas unitarias y de integración
```

---

## Pruebas 🧪

Ejecuta las pruebas con:

```bash
./gradlew test
```

---

## Contribución 🤝

¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añade nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

## Licencia 📄

Este proyecto está bajo la licencia **MIT**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## Autor ✒️

- **Tu Nombre** - [@tu-usuario](https://github.com/tu-usuario)

---

¡Esperamos que este proyecto te sea útil! Si tienes alguna pregunta o sugerencia, no dudes en abrir un issue. 😊

---

### Capturas de pantalla (opcional)

Si deseas, puedes agregar capturas de pantalla de la interfaz de RabbitMQ o ejemplos de correos enviados.

---

¡Gracias por usar **MassMessenger**! 🚀
