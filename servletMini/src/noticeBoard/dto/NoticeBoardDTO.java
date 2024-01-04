package noticeBoard.dto;

public class NoticeBoardDTO {
	private Integer noticeId;
	private String noticeTitle;
	private String noticeDate;
	private String noticeContent;
	private String userId;
	
	
	
	
	public NoticeBoardDTO(Integer noticeId, String noticeTitle, String noticeDate, String noticeContent,
			String userId) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.userId = userId;
	}




	public Integer getNoticeId() {
		return noticeId;
	}




	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}




	public String getNoticeTitle() {
		return noticeTitle;
	}




	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}




	public String getNoticeDate() {
		return noticeDate;
	}




	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}




	public String getNoticeContent() {
		return noticeContent;
	}




	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	@Override
	public String toString() {
		return "NoticeBoardDTO [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeContent=" + noticeContent + ", userId=" + userId + "]";
	}
	
	
	
}
