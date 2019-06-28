package response;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;


@WebServlet("/ResImgServlet")
public class ResImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������дһ��ͼƬ
		String path = this.getServletContext().getRealPath("code.png");
		
		//��������ͼƬ
		FileInputStream in = new FileInputStream(path);
		
		//��ȡһ�������
		ServletOutputStream out = response.getOutputStream();
		
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = in.read(buffer)) != -1) {
			System.out.println(len);
			System.out.println(Arrays.toString(buffer));
			out.write(buffer, 0, len);
		}
		
	}

}
