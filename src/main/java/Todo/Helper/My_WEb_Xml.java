package Todo.Helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class My_WEb_Xml extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] a = { My_Configuration.class };
		return a;
	}

	@Override
	protected String[] getServletMappings() {
		String[] a = { "/" };
		return a;
	}

}
