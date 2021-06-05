package steps;

import driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import pages.HacebPage;
import utils.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HacebSteps {
    private static ArrayList<Map<String, String>> LecturaExcel = new ArrayList<Map<String, String>>();
    public static String defaulWindows;
    public static void cambiarmeDeVentana() {
        defaulWindows = SeleniumWebDriver.driver.getWindowHandle();
        boolean validacionPantalla = false;
        while (validacionPantalla == false) {
            Set<String> lista = SeleniumWebDriver.driver.getWindowHandles();
            if(lista.size() > 1) {
                Iterator<String> I1 = lista.iterator();
                while (I1.hasNext()) {
                    String child_window = I1.next();

                    if (!defaulWindows.equals(child_window)) {
                        SeleniumWebDriver.driver.switchTo().window(child_window);
                    }
                }
                validacionPantalla = true;
            }
        }

    }
    public static void volverALaVentanaPrincipal() {
        SeleniumWebDriver.driver.switchTo().window(defaulWindows);
    }

    public void EscribirTexto(By elemento,String Texto) {
        boolean validarElemento = false;
        while (validarElemento == false) {
            try {
                SeleniumWebDriver.driver.findElement(elemento).sendKeys(Texto);
                validarElemento = true;
            } catch (Exception e) {

            }
        }

    }
    public void clicEnElemento(By elemento) {
        boolean validarElemento = false;
        while (validarElemento == false) {
            try {
                SeleniumWebDriver.driver.findElement(elemento).click();
                validarElemento = true;
            } catch (Exception e) {

            }
        }
    }

    public String obtenerTextoDeElemento(By elemento) {
        boolean validarElemento = false;
        String textElemento = "";
        while (validarElemento == false) {
            try {
                textElemento = SeleniumWebDriver.driver.findElement(elemento).getText();
                validarElemento = true;
            } catch (Exception e) {

            }
        }
        return textElemento;
    }

    public void validarTextoEnPantalla(By elemento, String texto) {

        assertEquals(true, SeleniumWebDriver.driver.findElement(elemento).isDisplayed());
    }

    public void buscarPalabraEnHaceb () {
        try {
            LecturaExcel = Excel.readExcel("C:\\Users\\Usuario\\Desktop\\HACEB-EXCEL SQA.xlsx","Hoja1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < LecturaExcel.size(); i++) {
            EscribirTexto(HacebPage.getCajaBusqueda(), LecturaExcel.get(i).get("Productos"));
            clicEnElemento(HacebPage.getBotonBusqueda());
            HacebPage.setImagenBusqueda(LecturaExcel.get(i).get("Productos"));
            clicEnElemento(HacebPage.getImagenBusqueda());
            HacebPage.setResultadoBusqueda(LecturaExcel.get(i).get("Productos"));
            System.out.println(HacebPage.getResultadoBusqueda());
           // validarTextoEnPantalla(HacebPage.getResultadoBusqueda(), LecturaExcel.get(i).get("Productos"));

        }
    }
}