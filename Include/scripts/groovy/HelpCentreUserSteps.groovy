import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import LoginUserSteps


class HelpCentreUserSteps {

	@Given("User must be logged on dashboard prevent for feature help centre")
	public void user_must_be_logged_on_dashboard_prevent_for_feature_help_centre() {
		LoginUserSteps loginUser = new LoginUserSteps()
		loginUser.user_launch_app()
		loginUser.userSplashScreen("Login Succeess")
		loginUser.userFillFormLogin("qatesting@email.com", "password")
		loginUser.userVerifyBtnLogin("positive")
		
	}
	
	@When("User click icon hamburger and click option help centre")
	public void user_click_icon_hamburger_and_click_option_help_centre() {
		
		Mobile.tap(findTestObject('Object Repository/help-centre-mobile/android.widget.ImageViewHamburgerIcon'), 20)
		Mobile.delay(2)
		Mobile.tap(findTestObject('Object Repository/help-centre-mobile/android.widget.ImageViewHelpCenter'), 20)
		
	}
	
	@Then("User verify web view help centre prevent")
	public void user_verify_web_view_help_centre_prevent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/help-centre-mobile/android.webkit.WebViewHelpCentre'), 20)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-help-centre.png', FailureHandling.STOP_ON_FAILURE)
	}
	
	
}