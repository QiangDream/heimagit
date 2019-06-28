package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext sc1 = config.getServletContext();
		System.out.println(sc1);
		//д��һЩ��Ϣ��ServletContext
		sc1.setAttribute("lk", "�ÿ�");
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String value = context.getInitParameter("lk");
		//System.out.println(value);
		//����·��  D:\Java\Tomcat\apache-tomcat-7.0.85\webapps\26-Servlet  webӦ�õĸ�·�� 
		//�ѵ�ǰ�ַ������·��  �ó�һ���µĵ�ַ
		//����һ���ļ���Ҫʹ�þ���·��
		String realPath = context.getRealPath("WEB-INF/b.txt");
		//System.out.println(realPath);
		
		//ʹ�������������ȡ�ֽ����·��
		//���ֽ���Ŀ¼���м�����Դ
		String path = OneServlet.class.getClassLoader().getResource("com/it666/servlet/d.txt").getPath();
		//System.out.println(path);
		
		
	}


}
