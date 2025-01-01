package iocexamples;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {IocExample.class})
public class IocExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
         context.register(IocExample.class);
        context.refresh();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.getBeanNamesIterator().forEachRemaining(System.out::println);

    }
}
