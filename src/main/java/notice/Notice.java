package notice;

public class Notice {
	private int seqno;//���� �۹�ȣ
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
	private String title;//���� ������
	private String id;//���� �ۼ���
	private String content;//���� ����
	private String datt;//���� �ۼ���
}//�Խñ� ������ �����ϴ� DTO