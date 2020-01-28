package kitri.edu.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	int cnt = 0;
	ArrayList<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer>>();
	
	@RequestMapping(value = "/upload.file", method = RequestMethod.GET)
	public String uploadForm() {
		return "upload_spring";
	}
	
	@RequestMapping(value = "/upload.file", method = RequestMethod.POST)
	//file의 이름만 전송되는 것이 아니라 file의 전체 내용을 다 담은 것이 전송
	//file의 전체 내용을 다 담는 타입? MultipartFile
	//해당 타입은 commons-fileupload.jar파일에 있음
	
	//public String uploadResult(String name, String description, MultipartFile file1, MultipartFile file2)
	// -> UploadVO에 지정해놓음
	public String uploadResult(UploadVO vo) throws Exception
	{
		System.out.println(vo.getName());
		System.out.println(vo.getDescription());
		
		//MultipartFile안에 들어간 객체의 메소드 사용
		System.out.println(vo.getFile1().getName());
		System.out.println(vo.getFile1().getOriginalFilename());//클라이언트가 나에게 전송한 파일 이름
		//생각할 부분? 서버는 하나고 클라이언트는 여러개
		//즉, 클라이언트들이 같은 파일 올릴때, 어떻게 처리할지!
		//같은 파일 올리면? 기존의 파일에 덮어씌워짐
		System.out.println(vo.getFile1().getSize());//파일 크기
		System.out.println(vo.getFile1().getContentType()); //전송한 파일의 종류
		//applicationXXXX으로 시작? 파일종류는 '실행파일'
		
		//현재 사용자는 file1, file2를 업로드함
		//vo.getFile1(), vo.getFile2() : 2개 파일
		//사용자가 업로드한 이름 그대로 전달받아서 서버컴퓨터 c드라이브 밑에 있는 upload 폴더에 저장
		//java.io.* 에서 사용
		
		//주의 : null이면 X, 같은 파일 이름이면 X
		MultipartFile mf1 = vo.getFile1();
		MultipartFile mf2 = vo.getFile2();
		
		//클라이언트가 전송한 파일명 추출
		String filename1 = mf1.getOriginalFilename();
		String filename2 = mf2.getOriginalFilename();
		
		//업로드 파일 저장 서버 위치
		String uploadpath = "c:/upload/";
		
		//1. 중복 이름 파일 체크 -> 같은 파일있을때 이름 바꾸기
		String[] filelist = new File(uploadpath).list();
		for(String s : filelist) {
			if(s.equals(filename1)) {
				System.out.println(filename1 + " : 있어요~~ ");
				String ext1 = filename1.substring(filename1.lastIndexOf(".")); 
				//'.'이 나타난 마지막 인덱스부터~
				//즉, 확장자를 의미
				String remain = filename1.substring(0, filename1.lastIndexOf("."));
				filename1 = remain+"1"+ext1;			
			}
			
			if(s.equals(filename2)) {
				System.out.println(filename2 + " : 있어요~~ ");
			}
		}
		
		//업로드 파일은 c:upload/업로드파일명으로 지정
		//파일 객체 생성
		File file1 = new File(uploadpath + filename1);
		File file2 = new File(uploadpath + filename2);
		
		
//		try {
//			//mf1의 파일 내용을 c:upload/file1에 그대로 저장
//			mf1.transferTo(file1);
//			mf2.transferTo(file2);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//try-catch문이 아닌 throws 사용
		mf1.transferTo(file1);
		mf2.transferTo(file2);
		
		//현재 'uploadresult_spring'에 보내는 model값이 없음? X
		//매개변수에 @ModelAttribute("v") UploadVO vo
		//이렇게 지정하면? 뷰에서 v로 사용할수 있음
		//@가 없으면? uploadVO라는 이름으로 전달
		return "uploadresult_spring";
	}
	
}

















