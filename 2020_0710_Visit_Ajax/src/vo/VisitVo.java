package vo;

public class VisitVo {

	/*
	 * DB 컬럼명 과 = Vo 의 속성명 그리고 = 입력 Form 의 patemeter 명 일치시키기
	 */

	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;

	// 기본생성자 만들기 (자동완성 constructor)

	public VisitVo() {
	}

	// 오버라이드 된 생성자 (insert data 삽입 객체 포장 할떄 사용)
	// 안해도되지만 작업 안해놓으면 매번 getter ,setter 호출해야함)

	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	// 오버라이드 된 생성자 (modify data 수정 객체 포장 할때 사용)

	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	public VisitVo(int idx, String content, String pwd, String name) {
		super();
		this.idx = idx;
		this.content = content;
		this.name = name;
		this.pwd = pwd;

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
