package vo;

public class ShopVo {

	String link;
	String title;
	String image;
	int lprice;
	int hprice;
	String mallname;

	public ShopVo() {

	}

	public ShopVo(String link, String title, String image, int lprice, int hprice, String mallname) {
		super();
		this.link = link;
		this.title = title;
		this.image = image;
		this.lprice = lprice;
		this.hprice = hprice;
		this.mallname = mallname;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLprice() {
		return lprice;
	}

	public void setLprice(int lprice) {
		this.lprice = lprice;
	}

	public int getHprice() {
		return hprice;
	}

	public void setHprice(int hprice) {
		this.hprice = hprice;
	}

	public String getMallname() {
		return mallname;
	}

	public void setMallname(String mallname) {
		this.mallname = mallname;
	}

}