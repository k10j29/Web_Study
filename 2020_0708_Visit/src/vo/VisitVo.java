package vo;

public class VisitVo {

	/*
	 * DB �÷��� �� = Vo �� �Ӽ��� �׸��� = �Է� Form �� patemeter �� ��ġ��Ű��
	 */

	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;

	// �⺻������ ����� (�ڵ��ϼ� constructor)

	public VisitVo() {
	}

	// �������̵� �� ������ (insert data ���� ��ü ���� �ҋ� ���)
	// ���ص������� �۾� ���س����� �Ź� getter ,setter ȣ���ؾ���)

	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	// �������̵� �� ������ (modify data ���� ��ü ���� �Ҷ� ���)

	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	public VisitVo(int idx, String content) {
		super();
		this.idx = idx;
		this.content = content;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}