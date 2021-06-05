package pages;

import org.openqa.selenium.By;

public class HacebPage {
    private static By cajaBusqueda = By.xpath("//input[@id='full-search']");
    private static By botonBusqueda = By.xpath("//button[@class='btn btn-search']");
    private static By imagenBusqueda; // By.xpath("//div[contains(@data-name,'"+producto+"')]");
    private static By resultadoBusqueda;//h1[contains(text(),'"+producto+"')]//ancestor::div[@class='title-product visible-only-mobile']

    public static void setImagenBusqueda(String producto) {
        HacebPage.imagenBusqueda = By.xpath("//div[contains(@data-name,'"+producto+"')]");
    }

    public static void setResultadoBusqueda(String producto) {
        HacebPage.resultadoBusqueda = By.xpath("//div[@class='title-product visible-only-mobile']//h1[contains(text(),'"+producto+"')]");
    }

    public static By getCajaBusqueda() {
        return cajaBusqueda;
    }

    public static By getBotonBusqueda() {
        return botonBusqueda;
    }

    public static By getImagenBusqueda() {
        return imagenBusqueda;
    }

    public static By getResultadoBusqueda() {
        return resultadoBusqueda;
    }



}
