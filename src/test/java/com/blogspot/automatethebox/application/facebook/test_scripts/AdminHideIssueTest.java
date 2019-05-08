package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.application.facebook.abstract_scripts.AbstractAuthenticationTest;
import com.blogspot.automatethebox.application.facebook.pages.AdministrationPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;



public class AdminHideIssueTest extends AbstractAuthenticationTest {

	@Override
	public void testSetup() {

	}

	@Test(description = "Test for admit to check if admin can change issue status")
	public void adminStatusTest() throws InterruptedException {
		homePage.closeModal();
		AdministrationPage administrationPage = homePage.navigeteToAdministrationPage();
		administrationPage.openIssuesTable();
		administrationPage.selectStatusOfIssue("Visible");
		assertTrue(administrationPage.areAllColumnsHidden());

		administrationPage.clickFirstIssue();
		assertTrue(administrationPage.isModalPresent());
		assertTrue(administrationPage.isHideIssueLinkPresent());
		administrationPage.clickHideIssue();
		assertTrue(administrationPage.isShowIssueLinkPresent());
		administrationPage.closeModal();
		administrationPage.logout();


	}
}
