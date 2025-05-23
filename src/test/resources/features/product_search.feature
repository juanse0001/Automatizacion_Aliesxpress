# src/test/resources/features/product_search.feature

# language: es
# author: [Tu nombre o equipo]

@aliExpressSearch
Característica: Compra de productos en AliExpress
  Como usuario de AliExpress
  Quiero buscar un producto, aplicar un filtro aleatorio, seleccionarlo y agregarlo a la cesta
  Para poder iniciar el proceso de compra

  Escenario: Buscar, filtrar aleatoriamente, seleccionar y agregar un reloj inteligente a la cesta
    Dado que "Juan" está en la página principal de AliExpress
    Cuando Juan busca "relojes inteligentes"
    Y aplica un filtro de resultados aleatorio
    Entonces selecciona un producto
    Dado Que Juan esta en los detalles del producto
    Y guarda la configuración de moneda y envío si aparece el modal
    Entonces agrega a la cesta