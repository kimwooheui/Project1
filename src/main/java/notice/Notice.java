package notice;

public class Notice {
	private int seqno;//공지 글번호
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatt() {
		return datt;
	}
	public void setDatt(String datt) {
		this.datt = datt;
	}
	private String title;//공지 글제목
	private String id;//공지 작성자
	private String content;//공지 내용
	private String datt;//공지 작성일
}//게시글 정보를 저장하는 DTO
