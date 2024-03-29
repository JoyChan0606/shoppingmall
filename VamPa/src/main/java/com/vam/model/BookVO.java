package com.vam.model;

import java.util.Date;
import java.util.List;

public class BookVO {
	
	private int bookId;		//상품id
	private String bookName;	//상품 이름
	private int authorId;		//작가 id
	private String authorName;	//작가 이름
	private String publeYear;	//출판일
	private String publisher;	//출판사
	private String cateCode;	//카테고리 코드
	private String cateName;	//카테고리 이름
	private int bookPrice;		//상품 가격
	private int bookStock;		//상품 재고
	private double bookDiscount;	//상품 할인률
	private String bookIntro;	//상품 소개
	private String bookContents;	//상품목차
	private Date regDate;		//등록 날짜
	private Date updateDate;	//수정 날짜
	private List<AttachImageVO> imageList;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPubleYear() {
		return publeYear;
	}
	public void setPubleYear(String publeYear) {
		this.publeYear = publeYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}
	public double getBookDiscount() {
		return bookDiscount;
	}
	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}
	public String getBookIntro() {
		return bookIntro;
	}
	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<AttachImageVO> getImageList() {
		return imageList;
	}
	public void setImageList(List<AttachImageVO> imageList) {
		this.imageList = imageList;
	}
	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", authorId=" + authorId + ", authorName="
				+ authorName + ", publeYear=" + publeYear + ", publisher=" + publisher + ", cateCode=" + cateCode
				+ ", cateName=" + cateName + ", bookPrice=" + bookPrice + ", bookStock=" + bookStock + ", bookDiscount="
				+ bookDiscount + ", bookIntro=" + bookIntro + ", bookContents=" + bookContents + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + ", imageList=" + imageList + "]";
	}
}
