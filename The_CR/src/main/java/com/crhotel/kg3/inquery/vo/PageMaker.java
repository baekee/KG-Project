package com.crhotel.kg3.inquery.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;
	private int tempEndPage;
	private Criteria cri;
	
	public Criteria getCri() {
		return cri;
	}
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
	
	public boolean isPrev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
        this.prev = prev;
    }
	
	public boolean isNext() {
		return next;
	}
	
	public void setNext(boolean next) {
        this.next = next;
    }
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }
	
	public int getTempEndPage() {
		return tempEndPage;
	}
	
	public void setTempEndPage(int tempEndPage) {
		this.tempEndPage = tempEndPage;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	 
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
	  
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));
		this.tempEndPage = tempEndPage;
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		return uriComponents.toUriString();
	}

}
