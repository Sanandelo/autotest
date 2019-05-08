package com.blogspot.automatethebox.application.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.blogspot.automatethebox.application.facebook.pages.HomePage.APP_TITLE;
import static org.testng.Assert.assertEquals;

public class AdministrationPage extends LoadableComponent<AdministrationPage> {

	private WebDriver driver;

	@FindBy(css = "li[to='/admin/issues'")
	private WebElement issuesButton;

	@FindBy(css= ".md-menu.md-select")
	private WebElement typeDropdown;

	@FindBy(css = ".md-menu-content-bottom-start ul button")
	private List<WebElement> options;


	@FindBy(css = "tbody tr")
	private List<WebElement>  issues;

	@FindBy(className = "md-dialog-fullscreen")
	private WebElement modalWindow;

	@FindBy(css = "#hide button")
	private WebElement hideIssueButton;

	@FindBy(css = "#show button")
	private WebElement showIssueButton;

	@FindBy(css = "ul button")
	private WebElement logoutButton;

	public AdministrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected void load() {

	}

	protected void isLoaded() throws Error {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, APP_TITLE, "Not on the AdminPage page.");
	}

	public void openIssuesTable() {
		issuesButton.click();
	}

	public void selectStatusOfIssue(String statusOfIssue) throws InterruptedException {
		typeDropdown.click();
		Thread.sleep(2000);
		WebElement visibleOption = options.get(3);
		visibleOption.click();
//		Thread.sleep(2000);
//		WebElement all = options.get(0);
//		all.click();



	}

	public boolean areAllColumnsHidden() throws InterruptedException {
		boolean result = true;
		Thread.sleep(2000);
		List<WebElement> refreshedIssues = driver.findElements(By.cssSelector("tbody tr"));
		for(WebElement element : refreshedIssues) {
			WebElement hiddenColumn = element.findElements(By.cssSelector("td div")).get(7);
			System.out.println("h(" + hiddenColumn.getText() +")h");
			if(hiddenColumn.getText().equals("Yes")){
				result = false;
			}
		}
		return result;
	}

	public void clickFirstIssue() throws InterruptedException {
		issues.get(0).click();
		Thread.sleep(3000);
	}


	public boolean isModalPresent(){
		return modalWindow.isDisplayed();
	}

	public boolean isHideIssueLinkPresent() {
		return hideIssueButton.isDisplayed();
	}

	public void clickHideIssue() {
		hideIssueButton.click();
	}

	public boolean isShowIssueLinkPresent(){
		return showIssueButton.isDisplayed();
	}

	public void closeModal() throws InterruptedException {
		WebElement closeButton = modalWindow.findElement(By.cssSelector(".md-dialog-actions button"));
		closeButton.click();
		Thread.sleep(3000);
	}



	public void logout() {
		List<WebElement> navButton = driver.findElements(By.cssSelector("div.md-toolbar-section-end .md-menu"));
		navButton.get(1).click();
		logoutButton.click();
	}
}
