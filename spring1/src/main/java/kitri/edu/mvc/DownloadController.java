package kitri.edu.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	@RequestMapping("/downloadform")
	public ModelAndView downloadform() {
		//c:upload 폴더 내부의 목록을 화면에 보여주고 a태그 링크 걸어줌
		ModelAndView mav = new ModelAndView();
		//목록 내용
		String[] filelist = new File("c:/upload/").list();
		mav.addObject("filelist", filelist);
		//뷰 이름
		mav.setViewName("downloadform");
		return mav;
	}
	
	@RequestMapping("/downloadresult")
	public void downloadresult(String filename, HttpServletResponse response) throws Exception {
		//파일 이름에 있는 내용을 다운로드
		//서버 응답시, 형식을 명시해줘야함 (ex, text/html) -> 매개변수 HttpServletResponse 지정
		//1. c:\\upload파일에서 filename에 해당하는 파일 찾기
		File f = new File("c:\\upload\\",filename);
		//cf) f.exists()로 해당 파일있는지 확인 가능
		
		//* 파일 다운로드는 아래의 코드로 항상 실행
		//2. 파일 다운로드 준비 -> response? 클라이언트에게 응답할 내용
		//파일 다운로드하기 위한 필수 설정(3가지)
		response.setContentType("application/download"); //다운로드 받을 파일임을 설정
		response.setContentLength((int) f.length());
		response.setHeader("Content-Disposition","attchment;filename=\""+filename+"\"");
		//3. 위에서 지정한 파일을 클라이언트 응답 내부 스트림에 포함
		OutputStream out = response.getOutputStream();
		//out자체는 파일인것이 X
		//4. 즉, out의 형태를 파일의 형태로 변경
		FileInputStream fis = new FileInputStream(f);
		//5. 파일 다운로드 
		FileCopyUtils.copy(fis, out);
		//6. close
		fis.close();
		out.close();
	}

}














