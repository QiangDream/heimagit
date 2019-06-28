package response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������Ӧ�� ����״̬��
		response.setStatus(200);
		
		//�����Ӧͷ
		response.addHeader("name", "it666");
		response.addIntHeader("age", 10);
		response.addDateHeader("my-Date", new Date().getTime());
		
		//�޸���Ӧͷ
		response.setHeader("name", "lk");
		response.setIntHeader("age", 30);
		
		//�����ض���
		//response.setHeader("location", "/26-Servlet/LocationServlet");
		//response.sendRedirect("/26-Servlet/LocationServlet");
		//��ʱˢ���ض���  ��3���Ӳ�ȥת��
		//response.setHeader("refresh","3;url=http://www.baidu.com");
		
		//���û���������ʹ�õı��� UTF-8
		//response.setCharacterEncoding("UTF-8");
		
		//����Ӧ���������������ʹ��ʲô���ı���������
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		//����ʹ�ü�д ����������Ӧ��֮ǰ�����ñ���
		response.setContentType("text/html;charset=UTF-8");
		
		//������Ӧ�� 
		//д�ַ�
		response.getWriter().write("it666");
		//����ַ�������html�������������
		response.getWriter().write("<h1>it666</h1>");
		//д����
		response.getWriter().write("�ÿ�");
		
	}

}
