package vo;

/* 3�� ��ü 
   DB�ʵ�� = VO �Ӽ��� = (��)Parameter��
*/

// VO(Value Object) : DB Record 1���� ���� ��ü 
//1.�ݵ�� getter/setter method �����ؾߵȴ�.

public class SungVo {
   
	int    no;
	String name;
	int    kor;
	int    eng;
	int    mat;
	int    tot;
	String avg;
	int	   rank;
	
	public SungVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SungVo(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	
	public SungVo(int no, String name, int kor, int eng, int mat) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
    	
	
	
}