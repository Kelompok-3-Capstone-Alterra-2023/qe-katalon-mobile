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



class LoginUserSteps {


	@Given("User launch app")
	public void user_launch_app() {
		String directory = RunConfiguration.getProjectDir()
		def pathApk = ((directory + '/apk/') + 'app-release.apk')
		Mobile.startApplication(pathApk, true)
	}

	@When("User must be showing splash screen define (.*) and click button skip")
	public void userSplashScreen(String description) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/splash-screen-mobile/android.widget.ImageView'), 30)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-splashscreen.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/splash-screen-mobile/android.widget.ImageView'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/splash-screen-mobile/android.widget.Button'), 30)
		Mobile.tap(findTestObject('Object Repository/splash-screen-mobile/android.widget.Button'), 0)
		Mobile.delay(3)
		Mobile.comment(description)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-verifyLoginPage.png', FailureHandling.STOP_ON_FAILURE)
	}

	@And("User fill (.*) and (.*) and click button sign in")
	public void userFillFormLogin(String username, String password) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/login-mobile/android.widget.EditText'), 30)
		Mobile.tap(findTestObject('Object Repository/login-mobile/android.widget.EditText'), 0)
		Mobile.setText(findTestObject('Object Repository/login-mobile/android.widget.EditText'), username, 30)
		Mobile.tap(findTestObject('Object Repository/login-mobile/android.widget.EditText (2)'), 30)
		Mobile.setText(findTestObject('Object Repository/login-mobile/android.widget.EditText (2)'), password, 30)
		Mobile.tap(findTestObject('Object Repository/login-mobile/android.widget.Button (2)'), 30)
		Mobile.delay(5)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-LoginPageExecute.png', FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User verify condition (.*) must be expected")
	public void userVerifyBtnLogin(String status) {
		if(status == 'positive') {
			Mobile.verifyElementVisible(findTestObject('Object Repository/login-mobile/android.widget.ButtonConsultation'), 30)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-LoginSuccess.png', FailureHandling.STOP_ON_FAILURE)
		}
		else if(status == 'failed') {
			Mobile.verifyElementVisible(findTestObject('Object Repository/login-mobile/android.view.ViewLoginFailed'), 30)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-LoginFailed.png', FailureHandling.STOP_ON_FAILURE)
		}
		else {
			Mobile.verifyElementVisible(findTestObject('Object Repository/login-mobile/android.view.ViewFailed'), 30)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-LoginNegative.png', FailureHandling.STOP_ON_FAILURE)
		}
//		Mobile.closeApplication()
	}
}