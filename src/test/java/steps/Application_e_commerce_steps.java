package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Application_e_commerce_steps {
	WebDriver driver;
	public Application_e_commerce_steps(Communes_steps cs) {
		this.driver= cs.get_driver();
		
	}
	@Given("seconnecter a la page d accueil")
	public void seconnecter_a_la_page_d_accueil() throws InterruptedException {
		
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
	}

	@When("L utilisateur  s inscrire dans l application")
	public void l_utilisateur_s_inscrire_dans_l_application() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Register']/parent::li")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("input-firstname")).sendKeys("youdas");
		driver.findElement(By.id("input-lastname")).sendKeys("yani");
		driver.findElement(By.id("input-email")).sendKeys("yani@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("999-999-9999");
		driver.findElement(By.id("input-password")).sendKeys("Anella108");
		driver.findElement(By.id("input-confirm")).sendKeys("Anella108");
		driver.findElement(By.xpath("(//div/label[@class='radio-inline']/input)[1]")).click();
		driver.findElement(By.name("agree")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(4000);
		 
	}


	@Then("valider l inscription")
	public void valider_l_inscription() throws InterruptedException {
		Thread.sleep(3000);
		WebElement message=driver.findElement(By.xpath("//div[@id='content']/h1"));
		assert message.getText().equals("Your Account Has Been Created!");
	   
	}


	@When("connecter dans le compte existant abonne a newsletter")
	public void connecter_dans_le_compte_existant_abonne_a_newsletter() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("okrimou@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Anella108");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("(//a[text()='Newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("valider l abonnement a newsletter")
	public void valider_l_abonnement_a_newsletter() throws InterruptedException {
		Thread.sleep(3000);
		WebElement message=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		assert message.getText().equals("Success: Your newsletter subscription has been successfully updated!");
	    
	}


	@Then("valider que l application n accepte pas compte doublant")
	public void valider_que_l_application_n_accepte_pas_compte_doublant() throws InterruptedException {
		Thread.sleep(4000);
		WebElement message=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		assert message.getText().equals("Warning: E-Mail Address is already registered!");
		Thread.sleep(2000);
	    
	}

	
	@When("L utilisateur connecter a son compte")
	public void l_utilisateur_connecter_a_son_compte() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("okrimou@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Anella1008");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	}
	@Then("valider que l application naccede a son compte")
	public void valider_que_l_application_naccede_a_son_compte() {
		WebElement message=driver.findElement(By.xpath("//div[@id='content']/h2[text()='My Account']"));
		assert message.getText().equals("My Account");
	    
	}

	
	@When("reinitailiser mot de passe oublie")
	public void reinitailiser_mot_de_passe_oublie() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("okrimou@gmail.com");
		driver.findElement(By.xpath("(//a[text()='Forgotten Password'])[1]")).click();
		driver.findElement(By.id("input-email")).sendKeys("okrimou@gmail.com");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2000);	
		WebElement message=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		assert message.getText().equals("An email with a confirmation link has been sent your email address.");
		driver.findElement(By.id("input-email")).sendKeys("okrimou@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Anella1008");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}


@When("effctuer une recherche sur un produit {string}")
public void effctuer_une_recherche_sur_un_produit(String mot_cle) throws InterruptedException {
	Thread.sleep(3000);	
	
	driver.findElement(By.xpath("(//input[@name='search'])[1]")).sendKeys(mot_cle);
	driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
    
}
@Then("valider le resulta de recherche {int}")
public void valider_le_resulta_de_recherche(Integer nombre) {
	List<WebElement> resulta_recherche=driver.findElements(By.xpath("//div/div[@class='product-thumb']"));
	assert resulta_recherche.size()>nombre;
    
}

@Then("valider que le resultat de recherche vide")
public void valider_que_le_resultat_de_recherche_vide() {
	
	WebElement message=driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']"));
	assert message.getText().equals("There is no product that matches the search criteria.");
    
   
}


@When("passer la command")
public void passer_la_command() {
	driver.findElement(By.xpath("//a[text()='Samsung SyncMaster 941BW']/parent::h4/parent::div/following-sibling::div/button/span[text()='Add to Cart']")).click();
	driver.findElement(By.xpath("//span[text()='Checkout']")).click();
    
}
@Then("valider que la commande passe")
public void valider_que_la_commande_passe() {
    
}










	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
