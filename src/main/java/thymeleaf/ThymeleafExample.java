package thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import thymeleaf.bean.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by udadh on 5/18/2017.
 */
public class ThymeleafExample {

    public static void main(String[] s) throws IOException {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setSuffix(".html");
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        FileWriter fw = new FileWriter("result.html");
        User user = new User(new Long(999), "Uday");
        Context context = new Context(Locale.ENGLISH);
        context.setVariable("username", "variable from context");
        context.setVariable("user", user);
        engine.process("template", context, fw);


    }

}
