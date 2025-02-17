package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadExcelfile {

	WebDriver driver;

	@Test
	public void readingExcel() throws IOException {

		FileInputStream fis = new FileInputStream(new File(""));
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh = wb.getSheet("sheet1");
		// int row = sh.getLastRowNum();

		for (int i = 1; i < sh.getLastRowNum(); i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(2);
			cell.getStringCellValue();
		}

	}

	// factory design patten
	// when dyanamic object creation will there based on input
	@Test
	public void getDriver(String input) {
		if (input.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (input.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

	}

}
