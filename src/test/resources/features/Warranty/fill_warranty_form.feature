#language:es
#author:JohnRondon

Característica: Llenar el formulario de garantía
  Como usuario
  Quiero automatizar el llenado del formulario de garantía
  Para probar la funcionalidad del formulario.

  @warranty_form

  Escenario: Verificar el llenado exitoso del formulario de garantía
    Dado que el usuario se encuentra en la página del formulario de garantía
    Cuando el usuario llena el formulario con datos válidos
      | company          | contactPerson | customerAddress | customerPhone | customerCity | customerState | customerZip | homeownerName | homeownerPhone | homeownerAddress | homeownerCity | homeownerState | homeownerZip | item | model | serialNumber | brand | dateInstalled | reasonForWarranty | signature |
      | Mi Empresa      | Juan Pérez    | Calle Falsa 123 | 1234567890    | Ciudad        | Estado        | 12345       | Ana Gómez      | 0987654321     | Calle Verdadera 456 | Ciudad        | Estado        | 54321       | Producto | Modelo | 123456789 | Marca | 2023-01-01 | Garantía | Firma |
    Entonces el formulario debe ser enviado exitosamente