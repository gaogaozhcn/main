import com.gaogao.spring.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by gaohaiming on 16/9/24.
 */
public class SpringTestCase {
    @Test
    public void test(){
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyTestBean myTestBean= (MyTestBean) beanFactory.getBean("myTestBean");
        String result= myTestBean.getTestString();
        System.out.println(result);
        MyTestBean myTestBean2= (MyTestBean) beanFactory.getBean("myTestBean");
        String result2= myTestBean.getTestString();
        System.out.println(result);
    }
    @Test
    public void test2(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        MyTestBean myTestBean= (MyTestBean) beanFactory.getBean("myTestBean");
        String result= myTestBean.getTestString();
        System.out.println(result);
    }
}
