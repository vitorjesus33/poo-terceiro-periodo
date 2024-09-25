import java.text.NumberFormat;
import java.util.Locale;

public class Conversor {
    
    public static void main(String[] args) {
       
        System.out.println("1994 em romanos: " + toRoman(1994));
        System.out.println("100 USD em BRL: " + convert(100, "USD", "BRL"));
    }
}