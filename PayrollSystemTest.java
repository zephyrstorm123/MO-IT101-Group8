/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.terminalassesmentcp2;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PayrollSystemTest {

    private PayrollSystem payrollSystem;
    private PrintNReadTxt printRead;

    @Before
    public void setup() {
        payrollSystem = new PayrollSystem();
        printRead = new PrintNReadTxt();
    }

    @Test
    public void testSwitchButtons() {
        payrollSystem.switchButtons();

        assertTrue(payrollSystem.btnPersonalInfo.isEnabled());
        assertTrue(payrollSystem.btnSalaryInfo.isEnabled());
        assertTrue(payrollSystem.btnDailyTimesheet.isEnabled());
        assertTrue(payrollSystem.btnPayslip.isEnabled());
        assertTrue(payrollSystem.btnApplyLeave.isEnabled());
        assertTrue(payrollSystem.btnEmployeeMaster.isEnabled());
        assertTrue(payrollSystem.btnUserAccounts.isEnabled());
        assertTrue(payrollSystem.btnSettings.isEnabled());
    }

    @Test
    public void testSwitchPanes() {
        JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane();

        payrollSystem.switchPanes(panel);
        assertEquals(panel, payrollSystem.layeredPane_1.getComponent(0));

        payrollSystem.switchPanes(scroll);
        assertEquals(scroll, payrollSystem.layeredPane_1.getComponent(0));
    }

    @Test
    public void testChooseButton() {
        payrollSystem.chooseButton(payrollSystem.btnPersonalInfo);

        assertFalse(payrollSystem.btnPersonalInfo.isEnabled());
        assertEquals(new Color(255, 255, 255), payrollSystem.btnPersonalInfo.getBackground());

        // Verify other buttons are still enabled and have their default background color
        assertTrue(payrollSystem.btnSalaryInfo.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnSalaryInfo.getBackground());
        assertTrue(payrollSystem.btnDailyTimesheet.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnDailyTimesheet.getBackground());
        assertTrue(payrollSystem.btnPayslip.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnPayslip.getBackground());
        assertTrue(payrollSystem.btnApplyLeave.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnApplyLeave.getBackground());
        assertTrue(payrollSystem.btnEmployeeMaster.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnEmployeeMaster.getBackground());
        assertTrue(payrollSystem.btnUserAccounts.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnUserAccounts.getBackground());
        assertTrue(payrollSystem.btnSettings.isEnabled());
        assertEquals(new Color(0, 140, 184), payrollSystem.btnSettings.getBackground());
    }

    @Test
    public void openUserLoginTest() {
        payrollSystem = new PayrollSystem();

        payrollSystem.openUserLogin();

        UserLogin login = new UserLogin();
        //Initializes the window to be visible
        login.setVisible(true);

        assertTrue("Login Successful", login.verifyLogin("10001", "Admin1234"));
        assertTrue(login.isVisible());
    }

    @Test
    public void testDisplayPayrollMenu() {
        payrollSystem = new PayrollSystem();
        
        // Mock dependencies
        printRead = new PrintNReadTxt();
        printRead.printRead();
        
        UserLogin login = new UserLogin();
        UserLogin.user = "10001";
        payrollSystem.lblUsername = new JLabel();
        payrollSystem.btnPersonalInfo = new JButton();
        payrollSystem.lblNewLabel_2_1 = new JLabel();
        payrollSystem.btnEmployeeMaster = new JButton();
        payrollSystem.btnUserAccounts = new JButton();

        // Call the method under test
        payrollSystem.displayPayrollMenu();

        // Verify the expected behavior
        assertTrue(login.verifyLogin("10001", "Admin1234"));
        assertEquals("Jose Crisostomo", payrollSystem.lblUsername.getText());
        assertTrue(payrollSystem.isVisible());
        assertFalse(payrollSystem.btnPersonalInfo.getModel().isPressed());

        if (!PrintNReadTxt.user[Integer.parseInt(UserLogin.user)-10001].systemRole.equals("Admin")) {
            assertFalse(payrollSystem.lblNewLabel_2_1.isVisible());
            assertFalse(payrollSystem.btnEmployeeMaster.isVisible());
            assertFalse(payrollSystem.btnUserAccounts.isVisible());
        }
    }
}



