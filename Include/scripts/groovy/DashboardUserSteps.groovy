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



class DashboardUserSteps {


	@Given("User must be logged on dashboard prevent")
	public void user_must_be_logged_on_dashboard_prevent() {
		LoginUserSteps loginUser = new LoginUserSteps()
		loginUser.user_launch_app()
		loginUser.userSplashScreen("Login Succeess")
		loginUser.userFillFormLogin("qatesting@email.com", "password")
		loginUser.userVerifyBtnLogin("positive")
	}

	@When("User click button consultation")
	public void user_click_button_consultation() {
		Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.widget.ButtonConsultation'), 30, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ButtonConsultation'), 30)
		Mobile.delay(3)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-List-doctor.png', FailureHandling.STOP_ON_FAILURE)
	}

	@When("User choose doctor on list doctor page")
	public void user_choose_doctor_on_list_doctor_page() {
		Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.view.ViewContentListDoctor'), 30, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.view.ViewContentListDoctor'), 30)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-detail-doctor.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.delay(3)
	}

	@Then("User verify details doctor successfully")
	public void user_verify_details_doctor_successfully() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewDoctorDetail'), 30, FailureHandling.STOP_ON_FAILURE)
		def getDoctorName = Mobile.getText(findTestObject('Object Repository/contoh/android.view.ViewDetailDoctorName'), 20, FailureHandling.STOP_ON_FAILURE)
		Mobile.comment(getDoctorName)
		def getPriceDoctor = Mobile.getText(findTestObject('Object Repository/dashboard-mobile/android.view.ViewPriceDoctor'), 20)
		Mobile.comment(getPriceDoctor)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ButtonChatDetailDoctor'), 20)
		Mobile.tap(findTestObject('Object Repository/consultation-chat-mobile/android.widget.ButtonNext'), 20)
		Mobile.tap(findTestObject('Object Repository/consultation-chat-mobile/android.widget.ButtonBayar'), 20)
		Mobile.delay(10)
		Mobile.setText(findTestObject('Object Repository/consultation-chat-mobile/android.widget.EditTextChat'), "Halo dokter!", 0)
		Mobile.tap(findTestObject('Object Repository/consultation-chat-mobile/android.view.ViewBtnSendChat'), 0)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/screenshot-schedule-doctor.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.closeApplication()
	}

	@Given("User click consultation history and verified")
	public void user_click_consultation_history_and_verified() {
		user_must_be_logged_on_dashboard_prevent()
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewConsultHistoryNavbar'), 20)
		Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewListConsultationHistory'), 20, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/list-consult-history.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewListConsultationHistory'),20)
		Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.view.ViewContentDiagnosisConsultHIstory'), 20, FailureHandling.STOP_ON_FAILURE)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/diagnosis-content.png', FailureHandling.STOP_ON_FAILURE)
		
	}

	@And("User click notification and verified")
	public void user_click_notification_and_verified() {
		Mobile.pressBack()
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewNotificationNavbar'), 20)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/list-notif-consult.png', FailureHandling.STOP_ON_FAILURE)
	}


	@Then("User click profile and get profile data")
	public void user_click_profile_and_get_profile_data() {
		Mobile.pressBack()
		Mobile.tap(findTestObject('Object Repository/contoh/android.widget.ImageViewIconProfile'), 20)
		Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.view.ViewEmailProfile'), 20)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/email-profile.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.closeApplication()
	}

	@Given("User click and set text (.*) article")
	public void userClickandInputSearch(String valueSearch) {
		user_must_be_logged_on_dashboard_prevent()
		Mobile.delay(2)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageView'), 0)
		Mobile.delay(2)
		Mobile.tap(findTestObject('Object Repository/dashboard-mobile/android.widget.EditText'), 0)
		Mobile.setText(findTestObject('Object Repository/dashboard-mobile/android.widget.EditTextSearchArticle'), valueSearch, 0)
	}

	@When("User click value search and include (.*)")
	public void userClickValue(String description) {
		Mobile.delay(2)
		Mobile.comment(description)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/search-value.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.delay(2)
	}
	@Then("User verify expected condition based on (.*)")
	public void userVerifyCondition(String status) {
		if(status == 'success') {
			Mobile.tap(findTestObject('Object Repository/contoh/android.view.ViewListContentArticle'), 10, FailureHandling.STOP_ON_FAILURE)
			Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.widget.ImageViewImageDetailArticle'), 20)
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/search-found.png', FailureHandling.STOP_ON_FAILURE)
		}
		else {
			Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/search-not-found.png', FailureHandling.STOP_ON_FAILURE)
		}
		Mobile.closeApplication()
	}


	@Given("User verify article list page")
	public void userVerifyArticle() {
		user_must_be_logged_on_dashboard_prevent()
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/dashboard.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementExist(findTestObject('Object Repository/contoh/android.widget.ImageViewImageArticle'), 20)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/list-article.png', FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User click article to see details verify article get content")
	public void clickArticle() {
		Mobile.tap(findTestObject('Object Repository/contoh/android.widget.ImageViewImageArticle'), 20)
		Mobile.verifyElementExist(findTestObject('Object Repository/dashboard-mobile/android.view.ViewTitleArticleDetail'), 20)
		Mobile.takeScreenshot('/Users/jasmine/Katalon Studio/qe-katalon-mobile/Images/content-article.png', FailureHandling.STOP_ON_FAILURE)
		Mobile.closeApplication()
	}
}
