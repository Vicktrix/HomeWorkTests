/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.homeworktests;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**

 @author vitck
 */
public class FindMatchingTest{

    private static List<Double> testList;
    private FindMatching findMatching;
    
    @BeforeAll
    public static void initializeList(){
        testList = List.of(10.0, 15.45, 5.811, 175.0);
    }
    
    @BeforeEach
    public void setInstance() {
        findMatching = new FindMatching();
    }
    
    @AfterAll
    public static void clearListInEnd() {
        testList = null;
    }
    
    @Test
    public void findFirst_matching(){
        Double expected = 5.811;
        assertEquals(expected, findMatching.findFirst(testList,4.0,9.3));
    }
    
    @Test
    public void findFirst_notMatching(){
        Double expected = 5.833;
        assertNotEquals(expected, findMatching.findFirst(testList,4.0,9.3));
    }
    
    @Test
    public void findFirst_fromList_notMatching(){
        Double expected = testList.get(0);
        assertNotEquals(expected, findMatching.findFirst(testList,4.0,9.3));
    }
        
    @Test
    public void findFirst_matchingInterval_butNotFirst(){
        Double expected = 5.811;
//        Double expected = 10.0;
        assertNotEquals(expected, findMatching.findFirst(testList,0.0,20.0));
    }

    @Disabled("This method not ready yet")
    @Test
    public void findFirst_nonMatchingInterval_butSkipped(){
        Double expected = 5.811;
        assertEquals(expected, findMatching.findFirst(testList,4.0,9.3));
    }
        
    @Test 
    // we created this test because first time when we starts 'testFindFirst()' was failed
    // but after our IDE/Maven/dependency works correctly without any changes in code
    public void listIsNotNull() {
        Assertions.assertNotNull(testList,"List isn`t null");
    }
    
    @Test
    public void findFirst_true() {
        Double expected = 5.811;
        assertTrue(findMatching.findFirst(testList,4.0,9.3).equals(expected));
    }
    
    @Test
    public void findFirst_false() {
        Double expected = 5.822;
        assertFalse(findMatching.findFirst(testList,4.0,9.3).equals(expected));
    }
    
    @Test
    public void findFirst_lessInterval_nullExpected() {
        Assertions.assertNull(findMatching.findFirst(testList,-7.0,4.7),"Wrong interval");
    }
    
    @Test
    public void findFirst_upperInterval_nullExpected() {
        Assertions.assertNull(findMatching.findFirst(testList,447.0,255.8),"Wrong interval");
    }
    
    @Test
    public void findFirst_throwNullPointerException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> findMatching.findFirst(testList,3.0,4.0).toString());
    }
}
