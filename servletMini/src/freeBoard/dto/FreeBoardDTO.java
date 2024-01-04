package freeBoard.dto;

public class FreeBoardDTO {
	private String freeId;
	private String title;
	private String date;
	private String freeContent;
	private Integer userId;
	
	
	public FreeBoardDTO() {}
	
	public FreeBoardDTO(String freeId, String title, String date, String freeContent, Integer userId) {
		super();
		this.freeId = freeId;
		this.title = title;
		this.date = date;
		this.freeContent = freeContent;
		this.userId = userId;
	}
	public String getFreeId() {
		return freeId;
	}
	public void setFreeId(String freeId) {
		this.freeId = freeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "FreeBoardDTO [freeId=" + freeId + ", title=" + title + ", date=" + date + ", freeContent=" + freeContent
				+ ", userId=" + userId + "]";
	}

	
	
	
}
