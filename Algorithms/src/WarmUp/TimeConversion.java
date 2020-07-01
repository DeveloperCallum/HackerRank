package WarmUp;

import java.text.DecimalFormat;

public class TimeConversion {

    static String timeConversion(String s) {
        String[] parts = s.substring(0, 8).split(":");
        String time = s.substring(8, 10);
        float intTIme = Float.parseFloat(parts[0] + "." + parts[1] + "" + parts[2]);
        if(intTIme >= 12.00 && intTIme  <= 12.59  && time.toLowerCase().equals("am")){
            intTIme -= 12f;
        } else if(intTIme >= 1.00 && intTIme < 12.00 && time.toLowerCase().equals("pm")){
            intTIme += 12f;
        }
        char[] build;
        if(intTIme < 10) build = ("0" + new DecimalFormat("#.####").format(intTIme)).replace(".", ":").toCharArray();
        else build = String.valueOf( new DecimalFormat("#.####").format(intTIme)).replace(".", ":").toCharArray();

        if(intTIme != 0){
            String finalString = "";
            for (int i = 0; i < 8 ; i++) {
                try{
                    if(i == 5) finalString += ":";
                    finalString += String.valueOf(build[i]);
                }catch (ArrayIndexOutOfBoundsException e){
                    finalString += "0";
                }
            }
            return finalString.substring(0, 8);
        }
        return "00:00:00";
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:00:00AM"));
    }
}
