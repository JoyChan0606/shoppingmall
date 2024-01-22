package com.vam.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.io.File;
import java.nio.file.Path; // Add this import statement
import java.nio.file.Paths; // Add this import statement
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.mapper.AdminMapper;
import com.vam.model.AttachImageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TaskTest {
	@Autowired
	private AdminMapper mapper;

	private String getFolderYesterDay() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    String str = sdf.format(cal.getTime());
	    return str.replace("-", File.separator);
	}

	@Test
	public void taskTests() {
	    List<AttachImageVO> fileList = mapper.checkFileList();

	    System.out.println("fileList : ");
	    fileList.forEach(list -> System.out.println(list));
	    System.out.println("========================================");

	    List<Path> checkFilePath = new ArrayList<>();

	    fileList.forEach(vo -> {
	        Path originalPath = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
	        checkFilePath.add(originalPath);

	        Path thumbnailPath = Paths.get("C:\\upload", vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName());
	        checkFilePath.add(thumbnailPath);
	    });

	    System.out.println("checkFilePath : ");
	    checkFilePath.forEach(list -> System.out.println(list));
	    System.out.println("========================================");

	    File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
	    File[] targetFile = targetDir.listFiles();

	    System.out.println("targetFile : ");
	    if (targetFile != null) {
	        for (File file : targetFile) {
	            System.out.println(file);
	        }
	    }
	    System.out.println("========================================");
	}
}
