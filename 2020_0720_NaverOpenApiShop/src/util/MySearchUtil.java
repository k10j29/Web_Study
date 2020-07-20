package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.ShopVo;

public class MySearchUtil {

	public static List<ShopVo> search_item(String item_name, int start, int display) {
		List<ShopVo> list = new ArrayList<ShopVo>();

		String clientId = "MF3Z91EEmV3wFAyXcUUP";
		String clientSecret = "as3HKQFO7L";

		try {
			item_name = URLEncoder.encode(item_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d",
					item_name, start, display);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId);
			// 발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(connection.getInputStream());

			Element root = doc.getRootElement();// rss
			List<Element> element_list = (List<Element>) root.getChild("channel").getChildren("item");

			for (Element item : element_list) {

				String title = item.getChildText("title");
				String link = item.getChildText("link");
				String image = item.getChildText("image");

				int lprice = 0;
				int hprice = 0;

				try {
					lprice = Integer.parseInt(item.getChildText("lprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					hprice = Integer.parseInt(item.getChildText("hprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}

				String mallname = item.getChildText("mallName");

				ShopVo vo = new ShopVo(link, title, image, lprice, hprice, mallname);

				// ArrayList에 넣기
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
