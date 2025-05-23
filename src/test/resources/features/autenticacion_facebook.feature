#language:es
  #author:JohnRondon

Característica: Autenticacion en la pagina de Facebook
  Como usuario de Facebook
  Quiero autenticarme en el portal de Facebook
  Para poder acceder al contenido y funcionalidades disponibles en mi cuenta.

  @autenticacion

  Escenario: Verificar la autenticacion exitosa en la pagina de Facebook
    Dado que el usuario se encuentra en la pagina de inicio de sesion de Facebook
    Cuando ingrese las credenciales correctas (usuario y contrasena)
      | usuarios | clave |
      | student  | Password123    |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido a su pagina de inicio de Facebook