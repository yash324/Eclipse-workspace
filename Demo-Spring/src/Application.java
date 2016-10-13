import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Application {
public static void main(String[] args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println(appContext);
	String msg = (String) appContext.getBean("message");
	System.out.println("msg= "+msg);
	ApplicationContext appContext2 = new FileSystemXmlApplicationContext("config/applicationContext.xml");
	System.out.println(appContext2);
		
}
}
