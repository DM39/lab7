package Contexts;

import PageObjects.MerchPage;
import PageObjects.MainPage;

public class MainPageContext {
private MainPageContext(){}
private static MainPage filterPrice(MainPage mainpage , int maximal) throws InterruptedException {
    mainpage=mainpage.setMaximalPrice(maximal);
    mainpage=mainpage.facility();
    Thread.sleep(2000);
    mainpage.MaximalPrice.sendKeys("");
    return mainpage.submit();
}

private static MainPage filterCountry(MainPage mainPage,String country){
    return mainPage.setCountry(country);
}

public static MerchPage ChooseItem(MainPage mainPage, String name, String country, int maximal) throws InterruptedException {
    Thread.sleep(2000);
    mainPage=filterCountry(filterPrice(mainPage, maximal),country);
    Thread.sleep(2000);
    return mainPage.selectGood(name);
}
}
