package Contexts;

import PageObjects.OrderPage;;

public class EndingContext {
    private EndingContext(){}
    private static void setParametres(OrderPage page,String Name,String Surname){
        page.inputNameSurname(Name,Surname);
    }
    public static void CheckOrder(OrderPage page,String Name,String Surname){
        setParametres(page,Name,Surname);
        System.out.println(page.CheckOrder());
    }
}
