/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.inseres.portsniffing;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ByMazarat
 */
public class PortSniffingTest {
    
    public PortSniffingTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
 
    /**
     * Test of runPortScan method, of class PortSniffing.
     */
    @org.junit.jupiter.api.Test
    public void testRunPortScan() throws Exception {
        System.out.println("runPortScan");
        String ip = "";
        int nbrPortMaxToScan = 0;
        PortSniffing instance = new PortSniffing();
        ArrayList expResult = null;
        ArrayList result = instance.runPortScan(ip, nbrPortMaxToScan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PDFScanner method, of class PortSniffing.
     */
    @org.junit.jupiter.api.Test
    public void testPDFScanner() {
        System.out.println("PDFScanner");
        ArrayList openPortList = null;
        PortSniffing instance = new PortSniffing();
        instance.PDFScanner(openPortList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
