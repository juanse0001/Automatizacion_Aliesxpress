package co.com.AutoFacebook.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AliExpressHomePage {

    //Botones de busqueda
    public static final Target SEARCH_INPUT = Target.the("Search input")
            .located(By.id("search-key"));
    public static final Target SEARCH_FIELD = Target.the("campo de busqueda")
            .located(By.id("search-words"));
    public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda")
            .located(By.cssSelector("input[type='button'][title='submit']"));

    public static final Target FIRST_PRODUCT_LINK = Target.the("primer enlace de producto en los resultados")
            .located(By.cssSelector("a.search-card-item.lj_b"));
    public static final Target CATEGORY_DROPDOWN = Target.the("Category dropdown activator")
            .located(By.cssSelector("div.Category--categoryTitle--3bXGRN"));
    public static final Target CATEGORY_LIST = Target.the("Category list")
            .located(By.cssSelector("ul.Category--categoryList--2QE5_K6"));
    public static final Target PRODUCT_TITLES = Target.the("títulos de productos en los resultados de búsqueda")
            .located(By.cssSelector("h3.lj_jz"));

    public static final Target SAVE_REGION_BUTTON = Target.the("botón Guardar de selección de región")
            .located(By.xpath("//div[contains(@class, 'saveBtn') and text()='Guardar']"));



    //Filtros de busqueda
    public static final Target FILTER_RELEVANCE = Target.the("Filtro de Relevancia")
            .located(By.xpath("//span[contains(@class, 'gb_az') and text()='Relevancia']"));
    public static final Target FILTER_ORDERS = Target.the("Filtro de Pedidos")
            .located(By.xpath("//span[contains(@class, 'gb_az') and text()='Pedidos']"));

    public static final Target FILTER_PRICE = Target.the("Filtro de Precio")
            .located(By.xpath("//span[contains(@class, 'gb_az') and text()='Precio']"));
    public static final Target PRODUCT_DETAIL_MODAL_CONTAINER = Target.the("Contenedor del modal de detalles del producto")
            .located(By.cssSelector(".product-popup--detail--29J_sR_"));


    // Botón Agregar al carritoo dentro del modal
    public static final Target BOTON_AGREGAR_CARRITO = Target.the("botón 'Agregar a la cesta'")
            .located(By.cssSelector("button[class*='add-to-cart'][class*='comet-v2-btn-important']"));
    //Ir a cesta
    public static final Target BUTTON_IR_A_LA_CESTA = Target.the("enlace 'Ir a la Cesta'")
            .located(By.cssSelector("a.cart-summary-tocart"));

    public static final Target ADD_TO_CART_BUTTON_IN_MODAL = Target.the("boton agregar al carrito dentro del modal")
            .located(By.xpath("//button[contains(@class, 'sku-go-cart') or contains(@class, 'next-btn') and contains(., 'Agregar a la cesta')]")); // Verifica el texto y clases

    // Opciones de SKU dentro del modal (color, tamaño, etc.)
    public static final Target SKU_OPTIONS_IN_MODAL = Target.the("opciones de SKU dentro del modal")
            .located(By.cssSelector(".sku-property-list > li > a")); // O un selector más específico para los elementos clicables de SKU

    public static final Target MODAL_CLOSE_BUTTON = Target.the("boton de cerrar modal")
            .located(By.cssSelector(".comet-v2-modal-close, .next-dialog-close"));
    public static final Target COOKIE_ACCEPT_BUTTON = Target.the("Boton de aceptar cookies")
            .located(By.xpath("//button[text()='Aceptar']"));
    public static final Target GENERIC_POPUP_CLOSE_BUTTON = Target.the("Boton de cerrar pop-up generico")
            .located(By.xpath("//div[contains(@class, 'next-dialog-close') or contains(@class, 'comet-v2-modal-close')]"));


    //boton para la seleccion de monedaa
    public static final Target SAVE_BUTTON_CURRENCY_SHIPMENT = Target.the("botón 'Guardar' en el modal de configuración")
        .located(By.cssSelector("div[class*='es--saveBtn']"));
    public static final Target LINK_OPEN_CURRENCY_SHIPMENT_MODAL = Target.the("enlace/botón para abrir el modal de moneda y envío")
            .located(By.xpath("//div[contains(@class, 'ship-to--menuItem') and contains(@class, 'ship-to--newMenuItem')]"));
    public static final Target CONTENEDORES_TARJETAS_PRODUCTO = Target.the("Contenedores de tarjetas de producto")
            .located(By.cssSelector("div.hm_bu.search-item-card-wrapper-gallery"));

    // Enlaces de productos dentro de las tarjetas - selector más específico
    public static final Target PRODUCT_CARD_ITEM_LINK = Target.the("Enlaces de producto con clase lj_b")
            .located(By.cssSelector("a.lj_b.h4_h9"));
}