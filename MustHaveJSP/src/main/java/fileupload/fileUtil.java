package fileupload;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class fileUtil {
	//요청 객체 내에 전송되어온 파일을 디스크에 저장하고 파일명을 리턴
	public static String uploadFile(HttpServletRequest req, String sDirectory)throws ServletException, IOException{
		//multipart에서 name이 "ofile"인 part를 가져와서 part변수에 할당
		Part part = req.getPart("ofile");//request 객체의 메서드 전송된 폼값을 받아서 Part객체에 저장
		//part 객체의 해더값 중 content-disposition 읽어오기
		String partHeader = part.getHeader("content-disposition"); //Part객체에서 content-disposition헤더 값 읽어옴
		//partheader= form-data; name=attachedfile; filename=파일명.jpg
		String[] phArr = partHeader.split("filename="); // 헤더내용에서 파일명 추출을 할려고 split으로 분리해서 더블쿼테이션 제거
		String originalFileName = phArr[1].trim().replace("\"", "");
		if (!originalFileName.isEmpty()) { //파일명이 빈게 아니면 디렉토리에 저장
			part.write(sDirectory + File.separator +originalFileName);
		}
		return originalFileName; //db에 저장해야하니 원본파일명 리턴
		
	}
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));// uploadFile에서 저장된 파일명 변경할려고 확장자 컷
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());// 현재시간
		String newFileName = now + ext;// 현재확장자와 파일명 결합해서 새로운 파일명생성
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);//
		
		return newFileName;// 새로운 파일명 리턴
	}
	
	public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException{
		ArrayList<String> listFileName = new ArrayList<>(); //2개시상의 파일을 첨부하니까 원본 파일명을 저장하는 ArrayList  컬렉션 생성
		Collection<Part> parts = req.getParts(); //getParts메서드로 전송된 폼값을 받기, Collection<Part>타입으로 반환되니까 for문으로 갯수만큼 반복
		for(Part part : parts) {
			if(!part.getName().equals("ofile")) // 파일을 첨부하는데 사용할 name속성값은 ofile이니까 나머지는 저장대상이 아님
				continue;
			String partHeader = part.getHeader("content-disposition"); //헤더값에서 파일명 추출하고, 디렉토리에 저장하는 코드는 uploadFile() 메서드와 동일
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if (!originalFileName.isEmpty()) {
				part.write(sDirectory+ File.separator +originalFileName);
			}
			listFileName.add(originalFileName);//원본 파일명 ArrayList컬렉션에 추가
		}
		return listFileName; //파일명 컬렉션 반환 
	}
	
	public static void download(HttpServletRequest req, HttpServletResponse resp,
            String directory, String sfileName, String ofileName) {
        String sDirectory = req.getServletContext().getRealPath(directory);
        try {
            // 파일을 찾아 입력 스트림 생성
            File file = new File(sDirectory, sfileName);
            InputStream iStream = new FileInputStream(file);

            // 한글 파일명 깨짐 방지
            String client = req.getHeader("User-Agent");
            if (client.indexOf("WOW64") == -1) {
                ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            else {
                ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
            }

            // 파일 다운로드용 응답 헤더 설정
            resp.reset();
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition",
                           "attachment; filename=\"" + ofileName + "\"");
            resp.setHeader("Content-Length", "" + file.length() );

            //out.clear();  // 출력 스트림 초기화

            // response 내장 객체로부터 새로운 출력 스트림 생성
            OutputStream oStream = resp.getOutputStream();

            // 출력 스트림에 파일 내용 출력
            byte b[] = new byte[(int)file.length()];
            int readBuffer = 0;
            while ( (readBuffer = iStream.read(b)) > 0 ) {
                oStream.write(b, 0, readBuffer);
            }

            // 입/출력 스트림 닫음
            iStream.close();
            oStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("예외가 발생하였습니다.");
            e.printStackTrace();
        }
    }
}
