package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;
import com.vam.service.AuthorService;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorMapperTests {
 
    @Autowired
    private AuthorMapper mapper;
    
    private AuthorService service;
    
    private static final Logger LOGGER = Logger.getLogger(AuthorMapperTests.class.getName());
    
    /* 작가 등록 테스트
    @Test
    public void authorEnrollTest() throws Exception {
        AuthorVO author = new AuthorVO();
        author.setNationId("01");
        author.setAuthorName("테스트");
        author.setAuthorIntro("테스트 소개");
        
        mapper.authorEnroll(author);
    }    
    */
   /*
    @Test
    public void authorGetListTest() throws Exception{
        
        Criteria cri = new Criteria(3,10);    // 3페이지 & 10개 행 표시
        cri.setKeyword("1");
       
        List<AuthorVO> list = mapper.authorGetList(cri);
        
        for(int i = 0; i < list.size(); i++) {
            System.out.println("list" + i + ".........." + list.get(i));
        }
        
    }*/
    /*
    @Test
    public void authorGetTotalTest() throws Exception{
    	
    	Criteria cri = new Criteria();
    	cri.setKeyword("1");
    	
    	int total = mapper.authorGetTotal(cri);
    	
    	System.out.println("total = " + total);
    }
    */
    /*
    @Test
    public void authorGetDetailTest() throws Exception {
    	int authorId=1;
    
    	LOGGER.info("author......" + service.authorGetDetail(authorId));
    	
    	
    }
    */
    
    /* 작가 정보 수정 
	@Test
	public void authorModifyTest() {
		
		AuthorVO author = new AuthorVO();
				
		author.setAuthorId(1);
		System.out.println("수정 전...................." + mapper.authorGetDetail(author.getAuthorId()));
		
		author.setAuthorName("수정");
		author.setNationId("01");
		author.setAuthorIntro("소개 수정 하였습니다.");
		
		mapper.authorModify(author);
		System.out.println("수정 후...................." + mapper.authorGetDetail(author.getAuthorId()));
		
	}
    */
    /* 작가 정보 삭제 */
	@Test
	public void authorDeleteTest() {
		
		
		int authorId = 36;
		
		int result = mapper.authorDelete(authorId);
		
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
	}
}



















