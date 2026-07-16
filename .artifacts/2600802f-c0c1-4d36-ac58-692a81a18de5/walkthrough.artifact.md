# Walkthrough - Pruebas Unitarias para LongitudViewModel

Se han implementado las pruebas unitarias para `LongitudViewModel` siguiendo el estándar de calidad y estructura del proyecto (basado en `AreaViewModelTest`).

## Cambios Realizados

### [NEW] [LongitudViewModelTest.kt](file:///home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/app/src/test/java/com/aristidevs/convertirdorunidadesandroid/presentation/vm/LongitudViewModelTest.kt)

Se creó un nuevo archivo de pruebas que cubre:
- **Estado Inicial**: Verifica que el ViewModel arranque con `Metro` y `0.0`.
- **Cambio de Valor**: Valida que al ingresar "1000.0", las salidas se calculen correctamente (ej: 1.0 km, 100000.0 cm).
- **Cambio de Unidad**: Asegura que si el usuario cambia la unidad (ej: a KM), **todas las salidas** (desde metros hasta años luz) se recalculen correctamente manteniendo el valor numérico, validando la integridad total del estado.
- **Manejo de Errores**:
    - Si se ingresa texto ("abc"), el valor se vuelve `null` y **todas las salidas** (desde metros hasta años luz) se resetean a `0.0`.
    - Si se ingresa un valor vacío, el comportamiento es idéntico, asegurando una limpieza completa de la UI.
- **Cobertura Total**: Un test exhaustivo que recorre todas las unidades de `UnidadLongitud` para prevenir errores de mapeo en el bloque `when`.

## Verificación

Se ejecutaron las pruebas unitarias mediante Gradle:
- **Comando**: `./gradlew :app:testDebugUnitTest`
- **Resultado**: Todas las pruebas (173 en total en el módulo, incluyendo las nuevas) pasaron exitosamente.

> [!TIP]
> Mantener la consistencia con `AreaViewModelTest` facilita el mantenimiento del código, ya que otros desarrolladores encontrarán una estructura familiar en todo el módulo de presentación.

> [!IMPORTANT]
> Se utilizó un `delta` de `0.001` para las comparaciones de `Double`, lo que garantiza que pequeñas variaciones de precisión en las fórmulas de conversión no causen fallos falsos en las pruebas.
