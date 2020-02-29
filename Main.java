/*
Да се напише компютърна програма, реализираща информационна система, обслужваща склад.
        Програмата да поддържа текстов диалогов режим, позволяващ удобен интерактивен избор на следните операции:

        списък на наличните продукти в склада. За всеки продукт се съхранява и извежда следната информация:
        име (описание - символен низ с произволна дължина)
        срок на годност
        дата на постъпване в склада
        име на производител
        мерна единица (килограми, литри)
        налично количество
        местоположение (секция/рафт/номер) (номерирайте склада си както прецените, че ще ви е удобно, имайте предвид, че в началото той е празен и различно количество стока е нормално да заема различно по обем място)
        допустим брой от продукта на рафт
        коментар (свободен текст)
        записване на нова доставка
        ако нов продукт е с различен срок на годност от вече съществуващ едноименен продукт, той да бъде поставен на различно място
        ако имате достатъчно място, еднакви продукти с един и същи срок на годност да бъдат поставени на едно и също място
        при извеждане на списъка с налични продукти да се изведе общото количество на едноименните продукти независимо от срока им на годност
        справка за наличността в даден период (по дадена начална и крайна дата се извежда списък с всички промени на наличността в дадения период, включително зареждания и извеждания на стоки)
*/
/*  1 име
    2 срок на годност
    3 дата на постъпване
    4 име на производител
    5 мерна единица
    6 налично количество
    7 местоположение (секция , рафт , номер);
    8 допустим брой продукти на рафта;
    9 коментар


 */

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       /* String[] productParametersList ={"Product ID","Product Name","Name of Manufacturer","Expires Day","Expires Month","Date Added (Day)","Date Added (Month)","Measuring Unit","Quantity","Quantity per volume","Additional Comment(optional)"};
        String[][] productsList = new String[1][11];
        System.out.println(productParametersList.length);
        for (int i = 0; i <productsList[0].length; i++) {
            System.out.println("Enter "+productParametersList[i]);
            productsList[0][i]=input.nextLine();
            System.out.println(productsList[0][i]);
        }
        System.out.println();
        for (int i = 0; i <productsList[0].length; i++) {
            System.out.print(productsList[0][i]);

        }*/
        //TODO / slagane v sklada
        int productUID = 1;
        int freeSlot = 0;
        int menuChoice = 0;
        int newDeliveryChoice = 0;
        int deliveredQuantity = 0;
        int newQuantity = 0;
        int orderQuantity;
        int dateForReportMin = 0;
        int dateForReportMax = 0;
        int dateFromHistoryArray = 0;
        int productsToAdd =0;
        int productsToRemove =0;
        String searchForName = new String();
        String oldQuantity = new String();
        String orderDate = new String();
        String deliveryExpireDate = new String();
        String deliveryDate = new String();
        boolean exitMenu = false;
        String[][] productsList = new String[10][8];
       /* productsList[0][0] = "4";
        productsList[0][1] = "4";
        productsList[0][2] = "4";
        productsList[0][3] = "4";
        productsList[0][4] = "4";
        productsList[0][5] = "4";
        productsList[0][6] = "4";
        productsList[0][7] = "4";*/
        //-----------------------------
        //TODO
        String[][] historyList = new String[50][8];
        int currentItemHistoryList = 0;
        String[][] warehouse = new String[10][5];
        //--------------------------------------
        System.out.println();
       /* // Търсене на празно място в productsList
        for (int i = 0; i <productsList.length; i++) {
            System.out.print(productsList[i][0]);
            if (productsList[i][0]==null){
                freeSlot=i;
                System.out.println(freeSlot);
                break;
            }

        }

        //=========================================================*/


        while (exitMenu == false) {
            System.out.println();
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("Добре дошли в главното меню.");
            System.out.println("Моля изберете опция: ");
            System.out.println("1 - Въвеждане на нов продукт.");
            System.out.println("2 - Покажи наличните продукти.");
            System.out.println("3 - Нова доставка.");
            System.out.println("4 - Извеждане на продукт.");
            System.out.println("5 - Отчет на всички действия");
            System.out.println("6 - Справка по име");
            System.out.println("7 - Справка по дата");
            System.out.println("8 - Покажи Склад");
            menuChoice = input.nextInt();
            if (menuChoice == 1) {
                // Търсене на празно място в productsList
                for (int i = 0; i < productsList.length; i++) {
                    //System.out.print(productsList[i][0]);
                    if (productsList[i][0] == null) {
                        freeSlot = i;
                       // System.out.println(freeSlot);
                        break;
                    }

                }
                //---------------------------------
                // Въвеждане на нов продукт.
                for (int i = 0; i < productsList[freeSlot].length; i++) {
                    switch (i) {
                        case 0:
                            productsList[freeSlot][i] = String.valueOf(productUID);
                            productUID++;
                            break;

                        case 1:
                            input.nextLine();
                            System.out.println("Въведете името на продукта и кратко описание :");
                            productsList[freeSlot][i] = input.nextLine();


                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Въведете датата на доставка на продукта (ММДД) :");
                            productsList[freeSlot][i] = input.next();
                            break;
                        case 3:
                            System.out.println("Въведете срокът на годност на продукта (ММДД) :");
                            productsList[freeSlot][i] = input.next();
                            break;
                        case 4:
                            System.out.println("Въведете мерната единица за продукта (кг/бр) :");
                            productsList[freeSlot][i] = input.next();
                            break;
                        case 5:
                            System.out.println("Въведете количество за продукта :");
                            productsList[freeSlot][i] = input.next();
                            break;
                        case 6:
                            System.out.println("Въведете колко място заема продукта за 1 бр/кг (1-99) :");
                            productsList[freeSlot][i] = input.next();

                            break;
                        case 7:
                            input.nextLine();
                            System.out.println("Въведете допълнителен коментар :");
                            productsList[freeSlot][i] = input.nextLine();

                            break;

                    }

                }
                // Добавяне в историята
                for (int i = 0; i < productsList[freeSlot].length; i++) {
                    if (i == 0) {
                        historyList[currentItemHistoryList][i] = "Нов Продукт";
                    }
                    if (i == 4 || i == 6 || i == 7) {
                        historyList[currentItemHistoryList][i] = "";
                    } else {
                        historyList[currentItemHistoryList][i] = productsList[freeSlot][i];
                    }
                }

                historyList[currentItemHistoryList][0] = "Нов Продукт";
                historyList[currentItemHistoryList][4] = productsList[freeSlot][5];
                historyList[currentItemHistoryList][5] = "0";
                historyList[currentItemHistoryList][6] = historyList[currentItemHistoryList][4];
                currentItemHistoryList++;
                //calculate products to add
                productsToAdd = Integer.parseInt(productsList[freeSlot][5])*Integer.parseInt(productsList[freeSlot][6]);
                for (int i = 0; i <warehouse.length; i++) {
                    for (int j = 0; j <warehouse[0].length; j++) {
                        if(warehouse[i][j]==null && productsToAdd>0){
                            warehouse[i][j]=productsList[freeSlot][0];
                            productsToAdd--;
                        }

                    }
                //========================================
                }
            }
            //------------------------------------------------------------------

            // }
            //====================================================
            //-------------- Справка налични продукти ---------------------
            if (menuChoice == 2) {
                System.out.println("===============================");
                System.out.println("----- Налични продукти ------");
                System.out.println("ID| Име |  Дата на доставка | Срок на годност | Кг/Бр. | Количество | Обем | Коментар");
                System.out.println();
                for (int i = 0; i < productsList.length; i++) {
                    if (productsList[i][0] != null) {
                        System.out.print(i + " - ");
                        for (int j = 0; j < productsList[i].length; j++) {

                            System.out.print(productsList[i][j]+ " ");
                        }
                        System.out.println();
                    }

                }
                System.out.println();
                System.out.println("===============================");

            }
            //===========================================================
            //--------------- Доставка -----------------------------------
            if (menuChoice == 3) {

                System.out.println("===============================");
                System.out.println("----- Изберете за кой продукт е доставката ------");
                System.out.println();
                for (int i = 0; i < productsList.length; i++) {
                    if (productsList[i][0] != null) {
                        System.out.print(i + " - ");
                        for (int j = 0; j < productsList[i].length; j++) {

                            System.out.print(productsList[i][j]);
                        }
                        System.out.println();
                    }

                }
                System.out.println();
                System.out.print("Избор :");
                newDeliveryChoice = input.nextInt();
                System.out.println("Въведете доставеното количество :");
                deliveredQuantity = input.nextInt();
                System.out.println("Въведете срок на годност :");
                deliveryExpireDate = input.next();
                System.out.println("Въведете датата на доставка");
                deliveryDate = input.next();
                System.out.println();
                oldQuantity = productsList[newDeliveryChoice][5];
                // Сравнява срокът на годност на доставката и наличният продукт
                if (deliveryExpireDate.equals(productsList[newDeliveryChoice][3])) {
                    for (int i = 0; i < productsList[newDeliveryChoice].length; i++) {
                        System.out.print(productsList[newDeliveryChoice][i] + " ");

                    }
                    System.out.println(productsList[newDeliveryChoice][5]);
                    newQuantity = Integer.parseInt(productsList[newDeliveryChoice][5]) + deliveredQuantity;
                    System.out.println();
                    System.out.println(newQuantity);
                    productsList[newDeliveryChoice][5] = String.valueOf(newQuantity);
                    for (int i = 0; i < productsList[newDeliveryChoice].length; i++) {
                        System.out.print(productsList[newDeliveryChoice][i]);

                    }
                    productsList[newDeliveryChoice][2] = deliveryDate;
                    for (int i = 0; i < productsList[freeSlot].length; i++) {
                        if (i == 0) {
                            historyList[currentItemHistoryList][i] = "Доставка";
                        }
                        if (i == 4 || i == 6 || i == 7) {
                            historyList[currentItemHistoryList][i] = "";
                        } else {
                            historyList[currentItemHistoryList][i] = productsList[freeSlot][i];
                        }
                    }

                    historyList[currentItemHistoryList][0] = "Доставка";
                    historyList[currentItemHistoryList][2] = deliveryDate;
                    historyList[currentItemHistoryList][4] = String.valueOf(deliveredQuantity);
                    historyList[currentItemHistoryList][5] = oldQuantity;
                    historyList[currentItemHistoryList][6] = String.valueOf(newQuantity);
                    currentItemHistoryList++;
                    productsToAdd = Integer.parseInt(productsList[newDeliveryChoice][5])*Integer.parseInt(productsList[newDeliveryChoice][6]);
                    for (int i = 0; i <warehouse.length; i++) {
                        for (int j = 0; j < warehouse[0].length; j++) {
                            if (warehouse[i][j] == null && productsToAdd > 0) {
                                warehouse[i][j] = productsList[freeSlot][0];
                                productsToAdd--;
                            }

                        }
                    }
                }
                // Създава нов продукт ако срокът на годност е различен
                else {
                    // Търси празно място в списъка
                    for (int i = 0; i < productsList.length; i++) {
                        System.out.print(productsList[i][0]);
                        if (productsList[i][0] == null) {
                            freeSlot = i;
                            System.out.println(freeSlot);
                            break;
                        }

                    }
                    // Създава нов продукт като копира данните от старият без дата на доставка и срок на годност
                    for (int i = 0; i < productsList[freeSlot].length; i++) {
                        if (i == 0) {
                            productsList[freeSlot][i] = String.valueOf(productUID);
                            productUID++;
                        }
                        if (i == 2) {
                            productsList[freeSlot][i] = deliveryDate;
                        }
                        if (i == 3) {
                            productsList[freeSlot][i] = deliveryExpireDate;
                        }
                        if (i == 5) {
                            productsList[freeSlot][i] = String.valueOf(deliveredQuantity);
                        } else {
                            productsList[freeSlot][i] = productsList[newDeliveryChoice][i];

                        }

                    }
                    productsList[freeSlot][3] = deliveryExpireDate;
                    for (int i = 0; i < productsList[freeSlot].length; i++) {
                        if (i == 0) {
                            historyList[currentItemHistoryList][i] = "Доставка";
                        }
                        if (i == 4 || i == 6 || i == 7) {
                            historyList[currentItemHistoryList][i] = "";
                        } else {
                            historyList[currentItemHistoryList][i] = productsList[freeSlot][i];
                        }
                    }

                    historyList[currentItemHistoryList][0] = "Доставка";
                    historyList[currentItemHistoryList][2] = deliveryDate;
                    historyList[currentItemHistoryList][3] = deliveryExpireDate;
                    historyList[currentItemHistoryList][4] = String.valueOf(deliveredQuantity);
                    historyList[currentItemHistoryList][5] = "0";
                    historyList[currentItemHistoryList][6] = String.valueOf(deliveredQuantity);
                    currentItemHistoryList++;
                    productsToAdd = Integer.parseInt(productsList[freeSlot][5])*Integer.parseInt(productsList[freeSlot][6]);
                    for (int i = 0; i <warehouse.length; i++) {
                        for (int j = 0; j < warehouse[0].length; j++) {
                            if (warehouse[i][j] == null && productsToAdd > 0) {
                                warehouse[i][j] = productsList[freeSlot][0];
                                productsToAdd--;
                            }

                        }
                    }
                }
                // Добавяне в историята
               /* for (int i = 0; i < productsList[freeSlot].length; i++) {
                    if (i == 0) {
                        historyList[currentItemHistoryList][i] = "Доставка";
                    }
                    if (i==4 || i==6 ||i==7){
                        historyList[currentItemHistoryList][i]="";
                    }
                    else {
                        historyList[currentItemHistoryList][i] = productsList[freeSlot][i];
                    }
                }

                historyList[currentItemHistoryList][0] = "Доставка";
                historyList[currentItemHistoryList][2] = deliveryDate;
                historyList[currentItemHistoryList][4] = String.valueOf(deliveredQuantity);
                historyList[currentItemHistoryList][5] = oldQuantity;
                historyList[currentItemHistoryList][6] =  String.valueOf(newQuantity);
                currentItemHistoryList++;*/

            }
            System.out.println("===============================");
            //==============================================================================
            //  Извеждане на стока
            if (menuChoice == 4) {
                System.out.println("===============================");
                System.out.println("----- Изберете кой продукт ще се извежда от склада. ------");
                System.out.println();
                for (int i = 0; i < productsList.length; i++) {
                    if (productsList[i][0] != null) {
                        System.out.print(i + " - ");
                        for (int j = 0; j < productsList[i].length; j++) {

                            System.out.print(productsList[i][j]);
                        }
                        System.out.println();
                    }

                }
                System.out.println();
                System.out.print("Избор :");
                newDeliveryChoice = input.nextInt();
                System.out.println("Въведете количеството , което ще се изведе :");
                orderQuantity = input.nextInt();
                //----------- за хисторито
                System.out.println("Въведете датата на извеждане на продукта");
                orderDate = input.next();
                System.out.println();
                System.out.println(productsList[newDeliveryChoice][5]);
                oldQuantity = productsList[newDeliveryChoice][5];
                newQuantity = Integer.parseInt(productsList[newDeliveryChoice][5]) - orderQuantity;
                System.out.println();
                System.out.println(newQuantity);
                productsList[newDeliveryChoice][5] = String.valueOf(newQuantity);
                // Добавяне в историята
                for (int i = 0; i < productsList[freeSlot].length; i++) {
                    if (i == 0) {
                        historyList[currentItemHistoryList][i] = "Извеждане";
                    }
                    if (i == 4 || i == 6 || i == 7) {
                        historyList[currentItemHistoryList][i] = "";
                    } else {
                        historyList[currentItemHistoryList][i] = productsList[freeSlot][i];
                    }
                }

                historyList[currentItemHistoryList][0] = "Извеждане";
                historyList[currentItemHistoryList][2] = orderDate;

                historyList[currentItemHistoryList][4] = String.valueOf(orderQuantity);
                historyList[currentItemHistoryList][5] = oldQuantity;
                historyList[currentItemHistoryList][6] = String.valueOf(newQuantity);
                currentItemHistoryList++;
                productsToRemove = orderQuantity*Integer.parseInt(productsList[newDeliveryChoice][6]);
                for (int i = 0; i <warehouse.length; i++) {
                    for (int j = 0; j < warehouse[0].length; j++) {

                        if (warehouse[i][j] == productsList[freeSlot][0] && productsToRemove > 0) {
                            warehouse[i][j] =null;
                            productsToRemove--;

                        }

                    }
                }
            }


            //========== History of Actions ===========
            if (menuChoice == 5) {
                System.out.println();
                System.out.println("Номер на операцията | Вид операция | Име на продукта | Дата на операцията | Срок на годност | Количество променено | Количество преди | Количество след");
                System.out.println();
                for (int i = 0; i < currentItemHistoryList; i++) {
                    System.out.print(i + " - ");
                    for (int j = 0; j < historyList[i].length; j++) {
                        System.out.print(historyList[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if (menuChoice == 6) {
                System.out.println();
                System.out.println("Въведете име за търсене");
                searchForName = input.next();
                for (int i = 0; i < historyList.length; i++) {
                    if (historyList[i][0] != null) {
                        if (historyList[i][1].contains(searchForName)) {
                            for (int j = 0; j < historyList[i].length; j++) {
                                if (j == 0) {
                                } else {
                                    System.out.print(historyList[i][j] + " ");
                                }

                            }
                            System.out.println();
                        }
                    }

                }

                System.out.println();
            }
            if (menuChoice == 7) {
                System.out.println();
                System.out.println("Справка по дати");
                System.out.println();
                System.out.println("Въведете дата ОТ");
                dateForReportMin = input.nextInt();
                System.out.println("Въведете дата ДО");
                dateForReportMax = input.nextInt();
                for (int i = 0; i < historyList.length; i++) {
                    if (historyList[i][0] != null) {
                        dateFromHistoryArray = Integer.parseInt(historyList[i][2]);
                      /*  System.out.println("data ot aray:"+dateFromHistoryArray);
                        System.out.println("data min "+dateForReportMin);
                        System.out.println("data max "+dateForReportMax);*/
                        if (dateFromHistoryArray >= dateForReportMin && dateFromHistoryArray <= dateForReportMax) {
                            for (int j = 0; j < historyList[i].length; j++) {
                                System.out.print(historyList[i][j] + " ");
                            }
                        }

                    }
                }

            }
            if (menuChoice == 8) {
                for (int i = 0; i < warehouse[0].length + 2; i++) {
                    System.out.println();
                    if (i == 0) {
                        for (int j = 0; j < warehouse.length * 4; j++) {
                            System.out.print("-");

                        }
                        System.out.println();
                    }
                    if (i == warehouse[0].length + 2) {
                        for (int j = 0; j < warehouse.length * 4; j++) {
                            System.out.print("-");

                        }
                        System.out.println();
                    } else {
                        if (i < warehouse[0].length) {
                            for (int j = 0; j < warehouse.length; j++) {
                                System.out.print("|");
                                if (warehouse[j][i] != null) {
                                    System.out.print(warehouse[j][i]);
                                } else {
                                    System.out.print("xx");
                                }
                                System.out.print("|");
                            }
                        }
                    }

                }


            }
        }


    }
}












