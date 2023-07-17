package contactStore;
import java.time.LocalDate;

public class Validation {

    public static boolean checkPhoneNumber(String Tphone_Num){
		return(10 != Tphone_Num.length() || '0' !=Tphone_Num.charAt(0)); // first number need to be 0 and length need to be 10
    }
	
	public static boolean b_Day_Checker(String TB_Day){ // Birthday need to be atleast one day before today
		
		String[] YMD = TB_Day.split("-");
		
		if(YMD.length!= 3){	return false;}

		int Y = Integer.parseInt(YMD[0]);
		int M = Integer.parseInt(YMD[1]);
		int D = Integer.parseInt(YMD[2]);
		
		LocalDate today=LocalDate.now();
		int CY = today.getYear();
		int CM = today.getMonthValue();
		int CD = today.getDayOfMonth();
		
		
		int DoM = 0;
		int[]DaysofMonth ={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if(M<=12){
			DoM=DaysofMonth[M-1];
			if(M==2 && ((Y%4==0)&&(Y%100 !=0 || Y %400 ==0))){ DoM=29;}
		}
        return (Y>CY)? false: ((Y == CY && M > CM )|| ( M >12 || M<=0 )) ? false :((M == CM &&  D>CD )||(D<0 || D > DoM)) ? false : true;

	}

    
	
    

}
