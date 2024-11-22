## Enunciado
Se pide implementar un login para una aplicación móvil. El login tiene asociado las siguientes casuísticas:

1)	Para poder hacer login, el usuario tendrá que darse de alta. Los datos que se piden son: username y password.
      a)	Para dar de alta un usuario se debe navegar a la pantalla de Altas.
      b)	Si al darse de alta el username ya existe, se mostrará un mensaje de error por consola avisando que el usuario ya existe.
      c)	Si al darse de alta el username no existe, se guardará la información.
      d)	Si el alta se ha realizado correctamente navegará a la pantalla de Welcome.
      e)	Si el alta no se ha completado, se muestra un error por consola y se queda en la pantalla principal.
2)	Para poder hacer login:
      a)	Para hacer login, el usuario debe navegar a la pantalla principal, Login.
      b)	El username debe estar dado de alta.
      c)	El username debe coincidir con el password asociado.
3)	Recordar username y password
      a)	Existe un checkbox que si está seleccionado cuando el usuario hace login correcto, se recuerda el username y el password al abrir la aplicación o navegar a la pantalla login. En este caso, se muestran los datos del username, password y el checkbox queda seleccionado.
      b)	Si al arrancar la aplicación se obtiene los datos del username y password porque estaban guardados y se desmarca la casilla de recordar, entonces se dejan de recordar el username y el password.
4)	Para poder solicitar la baja:
      a)	Para solicitar la baja, el usuario debe navegar a la pantalla de Bajas.
      b)	El username debe estar dado de alta.
      c)	El username debe coincidir con el password asociado.
      d)	Se debe seleccionar la opción de ‘Dar de baja’. El usuario debe ser eliminado.

**Evaluación:**

Los conceptos que van a ser evaluados para la obtención del aprobado son:
- Arquitectura separada por responsabilidades.
- Definición correcta del dominio: Casos de usos, modelos, repositorios.
- Definición correcta de la presentación: Activity, Fragment, ViewModel, LiveData, Navigation
- Inyección de Dependencias con Koin.
  
**Nota:** para poder tener un aprobado en la prueba la aplicación debe cumplir los puntos 1) y 2) con todos sus subapartados.

Los conceptos que van a ser evaluados para la mejora de la calidad son:
- Completar el apartado 3) y 4).
- Componentes visuales extras: ViewBinding, etc.
- Conocimientos de Kotlin: scope functions, métodos simplificados, etc.
- Inglés en nombres de variables, clases, etc.
- Testing.
- GitHub (Pull Request, Merge, Commits, branches…)
- Clean Code: Optimización del código.
- Aplicación de SOLID.
- Realidad del Login. Cuanto de real es el login implementado.
  
*Entrega del examen*
La entrega del examen se hace a través de PR:
- Una PR para el apartado 1). 
- Una PR para el apartado 2). 
- Una PR para el apartado 3). 
- Una PR para el apartado 4). 

El alumno debe gestionar las PR de la forma más conveniente.
