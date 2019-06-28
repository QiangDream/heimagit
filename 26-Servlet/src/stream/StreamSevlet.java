package stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthStyle;


@WebServlet("/StreamSevlet")
public class StreamSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����һ���ļ�
		//һ��ʹ�þ���·��
		String path = this.getServletContext().getRealPath("a.txt");
		System.out.println(path);
		//�����ļ�  ��������  �ֽ���
		FileInputStream in = new FileInputStream(path);
		System.out.println(in);
		
		//��ȡ�ֽ���
		//��ȡһ���ַ� 
		//System.out.println(in.read());
		//System.out.println(in.read());
		//System.out.println(in.read());
		//System.out.println(in.read());
		//System.out.println(in.read());
		//���ļ���ȡ���ʱ�� �ͻ᷵��һ��-1
		//System.out.println(in.read());
		
		
		//��ǰ��ȡ�˼����ַ�  ���������� ��һ����û�ж�ȡ ���ͻ᷵��һ��-1
		/*
		 * 
		byte[] buffer = new byte[5];		
		System.out.println(Arrays.toString(buffer));
		
		int len = in.read(buffer);
		System.out.println(len);
		System.out.println(Arrays.toString(buffer));
		
		len = in.read(buffer);
		System.out.println(len);
		System.out.println(Arrays.toString(buffer));
		
		
		len = in.read(buffer);
		System.out.println(len);
		System.out.println(Arrays.toString(buffer));
		
		len = in.read(buffer);
		System.out.println(len);
		System.out.println(Arrays.toString(buffer));
		
		len = in.read(buffer);
		System.out.println(len);
		System.out.println(Arrays.toString(buffer));*/
		
		
		byte[] buffer = new byte[5];		
		System.out.println(Arrays.toString(buffer));
		
		int len = 0;
		while((len = in.read(buffer)) != -1) {
			System.out.println(len);
			System.out.println(Arrays.toString(buffer));
		
			System.out.println(new String(buffer,0,len));
		}
		//�ر��ļ�
		in.close();
	
	}

}
