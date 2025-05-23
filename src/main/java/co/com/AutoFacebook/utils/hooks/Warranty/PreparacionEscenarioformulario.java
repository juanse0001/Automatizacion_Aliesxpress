package co.com.AutoFacebook.utils.hooks.Warranty;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PreparacionEscenarioformulario {
    // Este método se ejecuta antes de cada escenario
    @Before
    public void setUp() {
        // Configuración inicial, como abrir el navegador o cargar la página
        System.out.println("Configuración inicial del escenario");
        // Aquí puedes agregar el código necesario para preparar el escenario
    }

    // Este método se ejecuta después de cada escenario
    @After
    public void tearDown() {
        // Limpieza después de la ejecución del escenario
        System.out.println("Limpieza después del escenario");
        // Aquí puedes agregar el código necesario para limpiar el escenario
    }
}
