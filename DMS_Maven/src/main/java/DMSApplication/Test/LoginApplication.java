package DMSApplication.Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginApplication {

    private ExtentReports extent;
    private File Name;
    
    @BeforeMethod
    public void setup() {
    	// Initialize Chromedriver1
    	Objectcode.Browserlaunch("Edge");
    }

    @Test(dataProvider = "getData")
    public void DMS_Login(String datasetno, String url, String username, String password) throws IOException {
        System.out.println("Dataset number: " + datasetno);
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        Name = FolderName(datasetno);
        extent = createExtentReport(datasetno, Name);
        ExtentTest test = extent.createTest("DMS_Document Master TestReport");

        try {
            Objectcode.URLlaunch(url);
            test.log(Status.PASS, "Opened the URL");
            Thread.sleep(3000);
            captureScreenshot("URL", Name);
 
            Objectcode.InputField("name", "username", username);
            test.log(Status.PASS, "Entered username: " + username);
            Objectcode.webDriverWait("name","username", 1);
            captureScreenshot("UserName", Name);

            Objectcode.InputField("name", "password", password);
            test.log(Status.PASS, "Entered password: " + password);
            Objectcode.webDriverWait("name","password", 1);
            captureScreenshot("Password", Name);

            Objectcode.ButtonClick("Xpath", "//button[text()='Login']");
            test.log(Status.PASS, "Clicked on Login button");
            Objectcode.webDriverWait("Xpath","//button[text()='Login']", 1);
            captureScreenshot("Login", Name);

        } catch (Exception ex) {
            handleTestFailure(test, ex);
        } finally {
            if (extent != null) {
                extent.flush();
            }
        }
    }

    @DataProvider
    public Object[][] getData() {
        FileInputStream FIS = null;
        XSSFWorkbook ExcelWorkbook1 = null;

        try {
            // Specify the path to your Excel file
            String excelFilePath = "Data\\Datasheet.xlsx";
            FIS = new FileInputStream(excelFilePath);
            ExcelWorkbook1 = new XSSFWorkbook(FIS);
            XSSFSheet Loginsheet = ExcelWorkbook1.getSheetAt(0);
            int rowCount = Loginsheet.getPhysicalNumberOfRows();
            int colCount = Loginsheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rowCount - 1][colCount];
            for (int i = 1; i < rowCount; i++) {
                Row row = Loginsheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (FIS != null) {
                    FIS.close();
                }
                if (ExcelWorkbook1 != null) {
                    ExcelWorkbook1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @AfterMethod
    public void tearDown() {
        Objectcode.closebrowser();
    }

    private ExtentReports createExtentReport(String datasetno, File Name) {
        Random random1 = new Random();
        int rand_int11 = random1.nextInt(1000);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(Name + "\\" + datasetno + "_" + rand_int11 + ".html");
        extent.attachReporter(reporter);
        return extent;
    }

    private void handleTestFailure(ExtentTest test, Exception ex) {
        if (test != null) {
            test.log(Status.FAIL, MarkupHelper.createLabel("Test case failed: " + ex.getMessage(), ExtentColor.RED));
        }
    }

    private File FolderName(String datasetNumber) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timedate = dtf.format(now);
        timedate = timedate.replace('/', '_');
        timedate = timedate.replace(':', '_');
        File f = new File("Results\\Reports\\" + datasetNumber + "_" + timedate);
        System.out.println("Directory created: " + f);
        return f;
    }

    private void captureScreenshot(String screenshotname, File name) {
        try {
            File scrFile = ((TakesScreenshot) Objectcode.driver).getScreenshotAs(OutputType.FILE);
            String screenshotpath = name + "\\" + screenshotname + ".png";
            File Dest = new File(screenshotpath);
            FileUtils.copyFile(scrFile, Dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}