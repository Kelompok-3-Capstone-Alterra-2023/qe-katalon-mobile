import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('/Users/jasmine/Katalon Studio/qe-katalon-mobile/apk/app-release.apk', true)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.ButtonHyperSignUp'), 0)

Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextUsername'), 0)

Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextUsername'), "qa sdet", 0)

Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextEmail'), 0)

Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextEmail'), "qaeng@email.com", 0)

Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditText - DOBNEW'), 0)

Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditText - DOBNEW'), "09/10/1998", 0)

Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextPassword'), 0)

Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextPassword'), "password12", 0)

Mobile.tap(findTestObject('Object Repository/register-mobile/android.widget.EditTextConfirmPass'), 0)

Mobile.setText(findTestObject('Object Repository/register-mobile/android.widget.EditTextConfirmPass'), "password12", 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/register-mobile/android.widget.ButtonSIgnUp'), 0)

Mobile.delay(10)






//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.setText(findTestObject('null'), 'jasmine.nabila@trilogi.ac.id', 0)
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.setText(findTestObject('null'), 'checkcheck', 0)
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.verifyElementVisible(findTestObject('Object Repository/login-mobile/android.view.ViewLoginFailed'), 30)
//
//Mobile.delay(5)


