/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author shahd
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;
 
import org.junit.Before;
import org.junit.Test;
 
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
/**
 *
 * @author shahd
 */
public class JWebUnitTest {
    
    
    
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("http://localhost:8080/HolidayMaker");
    }
 
    @Test
    public void testLoginPage() {
        beginAt("index.jsp"); 
        assertTitleEquals("HolidayMaker");
        assertLinkPresent("login");
        clickLink("login");
        assertTitleEquals("Login");
    }
     
//    @Test
//    public void testHomePage() {
//        beginAt("home.jsp"); 
//        assertTitleEquals("Home");
//        assertLinkPresent("login");
//        clickLink("login");
//        assertTitleEquals("Login");
//    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
