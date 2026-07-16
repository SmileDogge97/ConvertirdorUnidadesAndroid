# Walkthrough - Pruebas Unitarias para MasaViewModel

Se han implementado satisfactoriamente las pruebas unitarias para el `MasaViewModel`, garantizando la integridad de los cálculos de masa y el comportamiento de la interfaz de usuario ante diferentes entradas.

## Cambios Realizados

### [NEW] [MasaViewModelTest.kt](file:///home/frankyriverswilkerson/MisProyectosDeProgramacion/MisAppsDeAndroid/ConvertidorUnidadesAndroid/app/src/test/java/com/aristidevs/convertirdorunidadesandroid/presentation/vm/MasaViewModelTest.kt)

Se creó una suite de pruebas completa que incluye:
- **Estado Inicial**: Verifica que el ViewModel arranque correctamente (Gramo, 0.0).
- **Conversión de Valor**: Valida que al ingresar "1000.0" gramos, se obtengan las equivalencias correctas en Kg, Libras y Toneladas.
- **Cambio de Unidad**: Asegura que el cambio de unidad base (ej: a Kilogramo) provoque un recálculo inmediato de todas las salidas.
- **Robustez de Entrada**:
    - Manejo de texto no numérico: Limpia el estado y pone todas las salidas en `0.0`.
    - Manejo de campo vacío: Comportamiento idéntico de limpieza.
- **Mapeo de Unidades**: Un test exhaustivo que valida el flujo para Gramo, Kilogramo, Libra y Tonelada.

## Verificación

Se ejecutaron las pruebas unitarias del módulo `:app`:
- **Resultado**: 179 pruebas pasadas (incluyendo las 6 nuevas pruebas de Masa).
- **Precisión**: Se utilizó un `delta` de `0.001` para manejar las variaciones decimales en las conversiones de masa.

> [!TIP]
> Al igual que en Longitud, se ha mantenido la validación exhaustiva de **todas** las unidades de salida en cada escenario de prueba para evitar que cambios futuros rompan el mapeo parcial del estado.
