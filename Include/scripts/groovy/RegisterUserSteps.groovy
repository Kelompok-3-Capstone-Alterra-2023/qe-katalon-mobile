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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.github.javafaker.Faker
import java.text.SimpleDateFormat;



class RegisterUserSteps {

	Faker faker = new Faker();
	String nameFaker = faker.name().firstName();
	String lastFaker = faker.name().lastName();
	String passwordFaker = faker.internet().password();
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User launch app for register")
	public void user_launch_app_for_register() {
		String directory = RunConfiguration.getProjectDir()
		def pathApk = ((directory + '/apk/') + 'app-release.apk')
		Mobile.startApplication(pathApk, true)
	}

	@When("User must be showing splash screen define (.*) and click button skip and click button sign up")
	public void userClickHyperLinkSignUp(String description) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/splash-screen-mobile/android.widget.ImageView'), 30)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-splashscreen.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/splash-screen-mobile/android.widget.ImageView'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/splash-screen-mobile/android.widget.Button'), 30)
		Mobile.tap(findTestObject('Object Repository/splash-screen-mobile/android.widget.Button'), 0)
		Mobile.delay(3)
		Mobile.comment(description)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewProfileNavbar'), 20)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-verifyLoginPage.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementVisible(findTestObject('Object Repository/register-mobile/android.widget.ButtonHyperSignUp'), 0)
		Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.ButtonHyperSignUp'), 0)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-registerpage.png', FailureHandling.STOP_ON_FAILURE)
	}

	@When("User fill (.*),(.*),(.*),(.*) and flag (.*)")
	public void user_fill(String username, String email, String password, String confirm_password, String status) {
		if(status == 'positive') {
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextUsername'), 0)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextUsername'), nameFaker+' '+lastFaker, 0)

			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextEmail'), 0)
			String incNumber = CustomKeywords.'Utils.randomNumber'(3)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextEmail'), nameFaker+'.'+lastFaker+'@yahooo.com', 0)

			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.ButtonIconDates'), 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.view.ViewApply1Date'), 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.view.ViewBtnApply'), 0)

			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextPassword'), 0)

			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextPassword'), 'password', 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextConfirmPass'), 0)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextConfirmPass'), 'password', 0)
		}
		else {
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextUsername'), 0)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextUsername'), username, 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextEmail'), 0)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextEmail'), email, 0)
			Mobile.delay(5)

			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.ButtonIconDates'), 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.view.ViewApply1Date'), 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.view.ViewBtnApply'), 0)

			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextPassword'), 0)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextPassword'), password, 0)
			Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextConfirmPass'), 0)
			Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextConfirmPass'), confirm_password, 0)
		}
	}

	@Then("User verify register feature condition (.*) must be expected")
	public void userVerifyRegister(String status) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/register-mobile/android.widget.ButtonDaftar'), 0)
		Mobile.tapAndHold(findTestObject('Object Repository/register-mobile/android.widget.ButtonDaftar'), 3, 0)
		Mobile.delay(2)
		if(status == 'positive') {
			Mobile.verifyElementVisible(findTestObject('Object Repository/register-mobile/android.view.ViewLabelKodeVerif'), 0)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/register-inputotp.png', FailureHandling.STOP_ON_FAILURE)
		}
		else if(status == 'negative'){
			Mobile.verifyElementVisible(findTestObject('Object Repository/register-mobile/android.widget.ButtonDaftar'), 0)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/ss-negatif.png', FailureHandling.STOP_ON_FAILURE)
		}
		else {
			Mobile.verifyElementVisible(findTestObject('Object Repository/register-mobile/android.view.ViewToastNegatif'), 0)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/register-failed.png', FailureHandling.STOP_ON_FAILURE)
		}
		Mobile.delay(3)
		Mobile.closeApplication()
	}
}