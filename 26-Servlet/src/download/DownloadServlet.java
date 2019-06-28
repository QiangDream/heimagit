package download;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*******************1.�����������***********************************/
		// �����ļ�������
		String name = request.getParameter("filename");
		System.out.println(name);
		
		/*******************2.�Խ��յĲ������б��봦��**************************/
		//��ȡ����  ��Ĭ�ϻ�Բ������б���    ISO8859-1
		//������ת�ض�����λ
		byte[] bytes = name.getBytes("ISO8859-1");
		//��ȥʹ��UTF-8���б���
		name = new String(bytes,"UTF-8");
		System.out.println(name);
		
		/*******************3.�����������Ӧ���ļ�������*************************/
		// �����ļ�������ȡmime����
		String mimeType = this.getServletContext().getMimeType(name);
		// ���� mimeType
		response.setContentType(mimeType);
		
		/*******************4.����������Ը�������ʽ����*************************/		
		// ��ȡ�ͻ�����Ϣ
		String agent = request.getHeader("User-Agent");
		// ����һ��������¼����֮�������
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE����
			filenameEncoder = URLEncoder.encode(name, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// �������
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(name.getBytes("utf-8")) + "?=";
		} else {
			// ���������
			filenameEncoder = URLEncoder.encode(name, "utf-8");
		}
		
		// ������������Ը�����ʽ������ ��Ҫ����
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);
		
		/********************5.�����ļ���Ӧ�������*************************/
		// ƴ���ļ���·��
		String path = this.getServletContext().getRealPath("download/" + name);
		// ����path�����ļ�
		FileInputStream in = new FileInputStream(path);
		// ��ȡ��Ӧ�����
		ServletOutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			// д����Ӧ����
			out.write(buffer, 0, len);
		}
		// �ر��ļ�
		in.close();
	}

}
