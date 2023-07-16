package com.luma.testsuite;

import com.luma.pages.WomenPage;
import com.luma.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class WomenPageTest extends BaseTest {

    WomenPage womenPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        womenPage = new WomenPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        womenPage.mouseHoverToWomenMenu();
        // Mouse Hover on Tops
        womenPage.mouseHoverWomenTopMenu();
        // Click on Jackets
        womenPage.mouseHoverWomenTopMenuClickOnJackets();
        Thread.sleep(1000);
        // Storing jackets names in list
        List<String> jacketsNameListBefore = womenPage.getJacketsNames();
        System.out.println("size ---" + jacketsNameListBefore.size());

        // Select Sort By filter “Product Name”
        womenPage.filterByProductName();
        Thread.sleep(1000);

        // After Sorting value
        List<String> jacketsNameListAfter = womenPage.getJacketsNamesAfterSorting();

        // Sort the before name list into Ascending Order
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        // Verify the products name display in alphabetical order
        Assert.assertEquals(jacketsNameListBefore, jacketsNameListAfter);

    }


    @Test(groups = {"regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        womenPage.mouseHoverToWomenMenu();
        // Mouse Hover on Tops
        womenPage.mouseHoverWomenTopMenu();
        // Click on Jackets
        womenPage.mouseHoverWomenTopMenuClickOnJackets();
        Thread.sleep(1000);
        // Storing jackets price in list
        List<Double> jacketsPriceListBefore= womenPage.getJacketsPriceListBefore();
        // Select Sort By filter “Price”
        womenPage.getFilterByProductPrice();
        // After Sorting Products by Price
        Thread.sleep(1000);
        // Storing jackets price in list after
        List<Double> jacketsPriceListAfter= womenPage.getJacketsPriceListAfter();
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(jacketsPriceListBefore);
        // Verify the products price display in Low to High
        Assert.assertEquals(jacketsPriceListBefore, jacketsPriceListAfter);
    }


}
