# language: es
# author: [Tu nombre o equipo]

@aliExpressSearch
Característica: Compra de productos en AliExpress
  Como usuario de AliExpress
  Quiero buscar un producto, aplicar un filtro, seleccionarlo y agregarlo a la cesta
  Para poder iniciar el proceso de compra

  Escenario: Buscar y agregar un reloj inteligente a la cesta
    Dado que "Juan" accede a la página principal de AliExpress
    Cuando busca el producto "relojes inteligentes", aplica un filtro aleatorio y selecciona uno de los resultados
    Entonces se encuentra en la página de detalles del producto
    Y guarda la configuración de moneda y envío si aparece el modal
    Y agrega el producto a la cesta
