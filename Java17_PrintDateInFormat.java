import java.text.SimpleDateFormat;
import java.util.Date;

public class Java17_PrintDateInFormat {
    public static void main(String[] args) {

        String format = "dd-MM-YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date today = new Date();
        System.out.println(today);
        System.out.println(simpleDateFormat.format(today));
    }
}
