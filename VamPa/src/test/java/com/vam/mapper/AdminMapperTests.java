package com.vam.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.Criteria;
import com.vam.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {
	@Autowired
	private AdminService service;
	
	/* 상품 등록 & 상품 이미지 등록 테스트 */
	@Test
	public void bookEnrollTEsts() {

		BookVO book = new BookVO();
		// 상품 정보
		book.setBookName("service 테스트");
		book.setAuthorId(27);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("202001");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");

		// 이미지 정보
		List<AttachImageVO> imageList = new ArrayList<AttachImageVO>(); 
		
		AttachImageVO image1 = new AttachImageVO();
		AttachImageVO image2 = new AttachImageVO();
		
		image1.setFileName("test Image 1");
		image1.setUploadPath("test image 1");
		image1.setUuid("test1111");
		
		image2.setFileName("test Image 2");
		image2.setUploadPath("test image 2");
		image2.setUuid("test2222");
		
		imageList.add(image1);
		imageList.add(image2);
		
		book.setImageList(imageList);        
		
		// bookEnroll() 메서드 호출
		service.bookEnroll(book);
		
		System.out.println("등록된 VO : " + book);
		
		
	}
	
	/* 지정 상품 이미지 삭제 
	@Test
	public void deleteImageAllTest() {
		
		int bookId = 56;
		
		mapper.deleteImageAll(bookId);
		
	}
	*/
	
	/* 상품 등록 
	@Test
	public void bookEnrollTest() throws Exception{
		
		BookVO book = new BookVO();
		
		book.setBookName("mapper 테스트");
		book.setAuthorId(28);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("0231");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");
		
		System.out.println("Before BookVO :" + book);
		
		mapper.bookEnroll(book);
		
		System.out.println("After BookVO :" + book);
	}
	*/
	
	/* 이미지 등록 
	@Test
	public void imageEnrollTest() {
		
		AttachImageVO vo = new AttachImageVO();
		
		vo.setBookId(201);
		vo.setFileName("test2");
		vo.setUploadPath("test2");
		vo.setUuid("test4");
		
		mapper.imageEnroll(vo);
		
	}
	*/
	
	/* 카테고리 리스트 
	@Test
	public void cateListTest() throws Exception{
		
		System.out.println("cateList()..........." + mapper.cateList());
		
	}
	*/
	/* 상품 리스트 & 상품 총 갯수 
	@Test
	public void goodsGetListTest() {
		
		Criteria cri = new Criteria();
		
		/* 검색조건 
		cri.setKeyword("테스트");
		
		/* 검색 리스트 
		List list = mapper.goodsGetList(cri);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("result......." + i + " : " + list.get(i));
		}
		
		/* 상품 총 갯수 
		int result = mapper.goodsGetTotal(cri);
		System.out.println("resutl.........." + result);
	}
	*/
	/* 상품 조회 페이지 
	@Test
	public void goodsGetDetailTest() {
		
		int bookId = 150;
		
		BookVO result = mapper.goodsGetDetail(bookId);
		
		System.out.println("상품 조회 데이터 : " + result);
		
		
	}
	/*
	 * /* 상품 정보 수정 
	@Test
	public void goodsModifyTest() {
		
		BookVO book = new BookVO();
		
		book.setBookId(63);
		book.setBookName("mapper 테스트");
		book.setAuthorId(23);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("103002");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");
		
		mapper.goodsModify(book);
		
	}*/
	
	/* 상품 정보 삭제 
	@Test
	public void goodsDeleteTest() {
		
		int bookId = 63;
		
		int result = mapper.goodsDelete(bookId);
		
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
*/
	/* 이미지 등록 
	@Test
	public void imageEnrollTest() {
		
		AttachImageVO vo = new AttachImageVO();
		
		vo.setBookId(137);
		vo.setFileName("test");
		vo.setUploadPath("test");
		vo.setUuid("test2");
		
		mapper.imageEnroll(vo);
		
	}
	 */
}
