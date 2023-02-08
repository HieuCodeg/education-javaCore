package md2.nmh.casestudy.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws ParseException {
//        Date ha =  new SimpleDateFormat("yyyy/MM/dd").parse("2012/12/22");
        HashMap<String,String> ha = new HashMap<>();
        ha.put("Tên","Tên ã ồn ại");
        ha.put("Tuổi", "18");
        System.out.println(ha.get("lớp"));


    }
}
