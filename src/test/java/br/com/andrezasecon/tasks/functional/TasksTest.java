package br.com.andrezasecon.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	
	public WebDriver accessAplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\java\\seleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		
		//acessar a aplicação
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void shouldSaveTaskWithSuccess() {
		
		WebDriver driver = accessAplication();
		
		try {
			
		// Clicar em add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via selenium2");
		
		//escrever data
		driver.findElement(By.id("dueDate")).sendKeys("2021/12/25");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
//		//validar mensagem sucesso
//		String message = driver.findElement(By.id("message")).getText();
//		Assert.assertEquals("Success!", message);
		
		}  finally {
			
			//fechar o browser
			driver.quit();			
		}
		
	}
	
	@Test
	public void shouldNotSaveTaskWithoutDescription() {
		
		WebDriver driver = accessAplication();
		
		try {
			
		// Clicar em add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever data
		driver.findElement(By.id("dueDate")).sendKeys("2021/12/25");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de erro

//		String message = driver.findElement(By.id("message")).getText();
//		Assert.assertEquals("Fill the task description", message);
		
		}  finally {
			
			//fechar o browser
			driver.quit();			
		}
		
	}
	
	@Test
	public void shouldNotSaveTaskWithoutDate() {
		
		WebDriver driver = accessAplication();
		
		try {
			
		// Clicar em add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via selenium2");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de erro

//		String message = driver.findElement(By.id("message")).getText();
//		Assert.assertEquals("Fill the due date", message);
		
		}  finally {
			
			//fechar o browser
			driver.quit();			
		}
		
	}
	
	@Test
	public void shouldSaveTaskWithPastDate() {
		
		WebDriver driver = accessAplication();
		
		try {
			
		// Clicar em add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descrição
		driver.findElement(By.id("dueDate")).sendKeys("2010/12/25");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de erro

//		String message = driver.findElement(By.id("message")).getText();
//		Assert.assertEquals("Fill the due date", message);
		
		}  finally {
			
			//fechar o browser
			driver.quit();			
		}
	}

}
