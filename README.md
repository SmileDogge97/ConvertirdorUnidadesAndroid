# Convertidor de Unidades Android

![Kotlin](https://img.shields.io/badge/Kotlin-100%25-blue.svg?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-Material_3-4285F4?logo=android)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-success)

Una aplicación móvil moderna para Android desarrollada completamente en Kotlin y Jetpack Compose. Esta herramienta permite a los usuarios realizar conversiones precisas entre diferentes unidades de medida en 7 categorías distintas. La app incluye soporte para múltiples orientaciones (Vertical y Horizontal) e integra monetización mediante Google AdMob, así como analíticas con Firebase.

## 🚀 Características Principales

*   **7 Categorías de Conversión:** Soporta conversiones de Temperatura, Área, Volumen, Tiempo, Velocidad, Masa y Longitud.
*   **Interfaz Adaptativa (Edge-to-Edge):** Diseño responsivo que se adapta perfectamente tanto a la orientación vertical (Portrait) como horizontal (Landscape).
*   **Menú de Navegación Desplegable:** Uso de menús interactivos para cambiar de conversor de manera dinámica y elegante.
*   **Monetización Integrada:** Banners adaptativos de AdMob integrados fluidamente en la UI sin interrumpir la experiencia del usuario.
*   **Type-Safe Navigation:** Implementación de navegación segura basada en tipos mediante `kotlinx.serialization` y Jetpack Compose Navigation.

## 🏗️ Arquitectura y Estructura del Código

El proyecto sigue los principios de **Clean Architecture** estructurados en torno al patrón **MVVM (Model-View-ViewModel)**, promoviendo una alta separación de responsabilidades y facilitando el testing:

*   📁 **`domain/model/`**: Entidades de datos y modelos base que representan las distintas unidades de medida.
*   📁 **`presentation/state/`**: Gestión del estado inmutable de la Interfaz de Usuario mediante `StateFlow` (`IUEstado`).
*   📁 **`presentation/vm/`**: ViewModels responsables de manejar la lógica de presentación y conectar la vista con los casos de uso.
*   📁 **`presentation/ui/`**: Vistas declarativas construidas un 100% con Jetpack Compose y Material Design 3.
*   📁 **`transformador/`**: Lógica pura de negocio y algoritmos matemáticos dedicados exclusivamente a la conversión de valores. Totalmente testeable (TDD).

## 🛠️ Stack Tecnológico

*   **Lenguaje:** Kotlin (Target JVM 11)
*   **UI Toolkit:** Jetpack Compose (Material 3)
*   **Navegación:** Jetpack Navigation Compose (Type-Safe routes)
*   **Asincronía & Estado:** Kotlin Coroutines & StateFlow
*   **Servicios:**
    *   Google AdMob (Anuncios)
    *   Firebase Analytics
*   **Testing:** JUnit 4/5 y MockK (Amplia cobertura en ViewModels y Transformadores).

## ⚙️ Instalación y Configuración

Sigue estos pasos para compilar y ejecutar el proyecto localmente:

1. Clona este repositorio:
   ```bash
   git clone https://github.com/SmileDogge97/ConvertirdorUnidadesAndroid.git
   ```
2. Abre el proyecto utilizando **Android Studio** (Koala o superior recomendado).
3. **Configuración de Firebase:** Asegúrate de incluir tu archivo `google-services.json` válido en el directorio `app/` si deseas habilitar Firebase Analytics.
4. **Configuración de AdMob:** La app incluye bloques de prueba de AdMob (`R.string.admob_bloque_anuncios_id`). Si deseas compilar para producción, deberás reemplazar estos IDs en tu archivo `strings.xml` y añadir tu App ID de AdMob en el `AndroidManifest.xml`.
5. Ejecuta la aplicación en un emulador o dispositivo físico corriendo Android 7.0 (API 24) o superior.

## 📱 Capturas de Pantalla

|                                                                                                       Retrato (Portrait)                                                                                                       |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|          <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175414.png" title="Pantalla de inicio" width="300"/>           |
| <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175552.png" title="Pantalla de conversión de temperatura" width="300"/> |
|    <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175608.png" title="Pantalla de conversión de area" width="300"/>     |
|   <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175630.png" title="Pantalla de conversión de volumen" width="300"/>   |
|   <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175645.png" title="Pantalla de conversión de tiempo" width="300"/>    |
|  <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175701.png" title="Pantalla de conversión de velocidad" width="300"/>  |
|     <img height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175728.png" title="Pantalla de conversón de masa" width="300"/>     |
|   <img alt="Pantalla de conversión de longitud" height="700" src="/home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/captures/Screenshot_20260812_175745.png" width="300"/>    |

## 🧪 Pruebas Unitarias (Testing)

El proyecto destaca por su excelente cobertura de pruebas unitarias. La lógica matemática ubicada en el paquete `transformador` y la lógica de presentación de los `ViewModels` están cubiertas por pruebas desarrolladas con **JUnit** y la librería de mocking **MockK**.

Para correr las pruebas:
```bash
./gradlew test
```

---
*Desarrollado por JFJM Solutions*