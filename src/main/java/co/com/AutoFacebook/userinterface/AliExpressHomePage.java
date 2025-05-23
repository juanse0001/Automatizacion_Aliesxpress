package co.com.AutoFacebook.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AliExpressHomePage {

    //Campo de busqueda
    public static final Target SEARCH_FIELD = Target.the("campo de busqueda")
            .located(By.id("search-words"));

    //Filtros de busqueda
    public static final Target FILTER_RELEVANCE = Target.the("Filtro de Relevancia")
            .located(By.xpath("//span[contains(@class, 'gb_az') and text()='Relevancia']"));
    public static final Target FILTER_ORDERS = Target.the("Filtro de Pedidos")
            .located(By.xpath("//span[contains(@class, 'gb_az') and text()='Pedidos']"));
    public static final Target FILTER_PRICE = Target.the("Filtro de Precio")
            .located(By.xpath("//span[contains(@class, 'gb_az') and text()='Precio']"));



    // Botón Agregar al carritoo dentro del modal
    public static final Target BOTON_AGREGAR_CARRITO = Target.the("botón 'Agregar a la cesta'")
            .located(By.cssSelector("button[class*='add-to-cart'][class*='comet-v2-btn-important']"));

    //Ir a cesta
    public static final Target BUTTON_IR_A_LA_CESTA = Target.the("enlace 'Ir a la Cesta'")
            .located(By.cssSelector("a.cart-summary-tocart"));


    //boton para abrir la seleccion de monedaa
    public static final Target SAVE_BUTTON_CURRENCY_SHIPMENT = Target.the("botón 'Guardar' en el modal de configuración")
        .located(By.cssSelector("div[class*='es--saveBtn']"));

    //Boton para guardar
    public static final Target SAVE_REGION_BUTTON = Target.the("botón Guardar de selección de región")
            .located(By.xpath("//div[contains(@class, 'saveBtn') and text()='Guardar']"));


    public static final Target LINK_OPEN_CURRENCY_SHIPMENT_MODAL = Target.the("enlace/botón para abrir el modal de moneda y envío")
            .located(By.xpath("//div[contains(@class, 'ship-to--menuItem') and contains(@class, 'ship-to--newMenuItem')]"));
    public static final Target CONTENEDORES_TARJETAS_PRODUCTO = Target.the("Contenedores de tarjetas de producto")
            .located(By.cssSelector("div.hm_bu.search-item-card-wrapper-gallery"));

    // Enlaces de productos dentro de las tarjetas - selector más específico
    public static final Target PRODUCT_CARD_ITEM_LINK = Target.the("Enlaces de producto con clase lj_b")
            .located(By.cssSelector("a.lj_b.h4_h9"));
}