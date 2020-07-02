package myutil;

import java.util.Calendar;

public class Jumin {

	String jumin_no;

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}
	
	
    //             01234567890123  <= index(첨자)
    // jumin_no = "801212-1234567";

	//출생년도
	public int getYear() {
		
		String strYear 	= jumin_no.substring(0,0+2);
		int    year 	= Integer.parseInt(strYear);
		//성별정보 구한다
		char gender = jumin_no.charAt(7);
		
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			year = year + 1900;
		else
			year = year + 2000;
		
		return year;
	}
	
	/*        
	            내국인    외국인    
	            남  여    남  여
	    1900    1   2     5   6  
	    2000    3   4     7   8  
	 */
	
	
	
	//나이
	public int getAge() {
		//현재 시스템 날짜 구하기
		Calendar c = Calendar.getInstance();
		//현재 년도
		int current_year = c.get(Calendar.YEAR);
		
		int age = current_year - this.getYear() + 1;
		
		return age;
	}
	
	// 12지
	// 4  5  6  7  8  9  10 11 0  1  2  3  <= 출생년도%12
	// 자 축 인 묘 진 사 오 미 신 유 술 해 
	//띠
	public String getTti() {
		
		switch(this.getYear()%12)
		{
		  case  0: return "원숭이";
		  case  1: return "닭";
		  case  2: return "개";
		  case  3: return "돼지";
		  case  4: return "쥐";
		  case  5: return "소";
		  case  6: return "호랑이";
		  case  7: return "토끼";
		  case  8: return "용";
		  case  9: return "뱀";
		  case 10: return "말";
		  case 11: return "양";
		}
		
		return "";
	}
	
	
/*        
    		내국인    외국인    
    		남  여    남  여
	1900    1   2     5   6  
	2000    3   4     7   8  
*/
	
	//성별
	public String getGender() {
		char gender = jumin_no.charAt(7);
		
		if(gender=='1' || gender=='3' || gender=='5' || gender=='7')
		   return "남자";
		
		return "여자";
	}
	
	//      4  5  6  7  8  9  0  1  2  3        <=출생년도%10 
	//10간  갑 을 병 정 무 기 경 신 임 계
	//      4  5  6  7  8  9  10 11 0  1  2  3  <=출생년도%12
	//12지  자 축 인 묘 진 사 오 미 신 유 술 해
	
	//2020%10 -> 0
	//2020%12 -> 4
	
	//60갑자
	public String getGanji() {
		String gan="갑";
		String ji="자";
		int gan_index = this.getYear()%10;//0~9
		int ji_index  = this.getYear()%12;//0~11
		
		switch(gan_index)
		{
		   case 0: gan = "경";break;
		   case 1: gan = "신";break; 
		   case 2: gan = "임";break; 
		   case 3: gan = "계";break; 
		   case 4: gan = "갑";break; 
		   case 5: gan = "을";break; 
		   case 6: gan = "병";break; 
		   case 7: gan = "정";break; 
		   case 8: gan = "무";break; 
		   case 9: gan = "기";break; 
		}
		
		switch(ji_index)
		{
			case  0: ji = "신";break;
			case  1: ji = "유";break;
			case  2: ji = "술";break;
			case  3: ji = "해";break;
			case  4: ji = "자";break;
			case  5: ji = "축";break;
			case  6: ji = "인";break;
			case  7: ji = "묘";break;
			case  8: ji = "진";break;
			case  9: ji = "사";break;
			case 10: ji = "오";break;
			case 11: ji = "미";break;
		}
		
		return String.format("%s%s년", gan,ji);
		
	}
	
	//60갑자를 다른방법으로 구해봄.
	public String getGanji2() {
		
		int gan_index = this.getYear()%10;//0~9
		int ji_index  = this.getYear()%12;//0~11
		
		//                 0 1                   <=index   
		String gan_list = "경신임계갑을병정무기";
		//                 0 1 2 3 4 5
		String ji_list  = "신유술해자축인묘진사오미";
		
		//2020
		char gan = gan_list.charAt(gan_index); //'경'
		char ji  = ji_list.charAt(ji_index);   //'자'
		
		return String.format("%c%c년", gan, ji);
		
	}
	
	
	//출생계절
	public String getSeason() {
		
		String strMonth = jumin_no.substring(2,2+2);
	    int    month    = Integer.parseInt(strMonth);
	    // 3~5:봄  6~8:여름  9~11:가을 12,1,2:겨울
	    switch(month/3) 
	    {
	     case 1: return "봄";
	     case 2: return "여름";
	     case 3: return "가을";
	    }
	    
		return "겨울";
	}
	
	//출생지역
	public String getLocal() {
		String strLocal = jumin_no.substring(8, 8+2);
		int    local    = Integer.parseInt(strLocal);
		
		if(local>=0 && local<=8) return "서울";
		else if(local>= 9 && local<=12) return "부산";
		else if(local>=13 && local<=15) return "인천";
		else if(local>=16 && local<=25) return "경기도";
		else if(local>=26 && local<=34) return "강원도";
		else if(local>=35 && local<=39) return "충청북도";
		else if(local==40) return "대전";
		else if(local>=41 && local<=47) return "충청남도";
		else if(local>=48 && local<=54) return "전라북도";
		else if(local>=55 && local<=58) return "광주";
		else if(local>=59 && local<=66) return "전라남도";
		else if(local>=67 && local<=70) return "대구광역시";
		else if(local>=71 && local<=81) return "경상북도";
		else if(local>=82 && local<=84 ||
				 local>=86 && local<=91) return "경상남도";
		else if(local==85) return "울산";
		else if(local>=92 && local<=95) return "제주도";
	
		
		return "";
	}
	
	//유효성
	public boolean isValid() {
		
		//           01234567890123   
		//jumin_no ="801212-1234560"
		//           2345670892345 
		// '0':48 '1':49 '2':50
		//'1'=>1 변환
		//'1' - '0' => 1
		//49  -  48 =>   
		
		int sum = 0;
		
		/*
		//방법1)
		sum = sum + (jumin_no.charAt(0)  - '0') * 2 ;
		sum = sum + (jumin_no.charAt(1)  - '0') * 3 ;
		sum = sum + (jumin_no.charAt(2)  - '0') * 4 ;
		sum = sum + (jumin_no.charAt(3)  - '0') * 5 ;
		sum = sum + (jumin_no.charAt(4)  - '0') * 6 ;
		sum = sum + (jumin_no.charAt(5)  - '0') * 7 ;
		sum = sum + (jumin_no.charAt(7)  - '0') * 8 ;
		sum = sum + (jumin_no.charAt(8)  - '0') * 9 ;
		sum = sum + (jumin_no.charAt(9)  - '0') * 2 ;
		sum = sum + (jumin_no.charAt(10) - '0') * 3 ;
		sum = sum + (jumin_no.charAt(11) - '0') * 4 ;
		sum = sum + (jumin_no.charAt(12) - '0') * 5 ;
		*/
		
		//방법2)반복문 이용
		/*
		int su = 2;
		for(int i=0;i<=12;i++) {
			if(i==6)continue;
			
			sum = sum + (jumin_no.charAt(i)  - '0') * su ;
			su++;
			if(su>9)su=2;
		}
		*/
		
		//방법3
		int [] check_su = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		for(int i=0;i<=12;i++) {
			sum = sum + (jumin_no.charAt(i) - '0') * check_su[i];
		}
		
		//체크수
		int check_num = (11-(sum%11))%10;
		
		System.out.println(check_num);
		
		//마지막 수
		int last_num  = jumin_no.charAt(13) - '0';
		
		return (last_num == check_num);
	}

	
}
