package question.dto;

public class QuestionDTO {
	private String questionId;
	private String questionTitle;
	private String questionDate;
	private String questionContent;
	
	
	public QuestionDTO() {}
	
	public QuestionDTO(String questionId, String questionTitle, String questionDate, String questionContent) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionDate = questionDate;
		this.questionContent = questionContent;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	@Override
	public String toString() {
		return "QuestionDTO [questionId=" + questionId + ", questionTitle=" + questionTitle + ", questionDate="
				+ questionDate + ", questionContent=" + questionContent + "]";
	}
	
	
	
}
