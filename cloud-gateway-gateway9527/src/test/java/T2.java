import java.time.ZonedDateTime;

/**
 * @author Elliot Ji
 * @date 2020/3/16.
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime  z = ZonedDateTime.now();  //默认时区
        System.out.println(z);
    }
}
