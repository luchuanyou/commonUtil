import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class ListTest {
    public static void main(String[] args) {
        //合并
        distinctList();
    }
    /**
     * 合并
     */
    public static void distinctList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");

        System.out.println("==="+list);


        for(int i=0;i<list.size();i++){
            for(String str2:list2){
                if(list.get(i).equals(str2)){
                    list.remove(list.get(i));
                    i--;
                    break;
                }
            }
        }
        System.out.println("====="+list);
        Pattern nonRegPattern = Pattern.compile("[\\pP\\p{Punct}\\￥\\s*|\t|\r|\n]+");
        Matcher sdf = nonRegPattern.matcher("fdsad fdsa");
        System.out.println("sdf:"+sdf);
        System.out.println(sdf.replaceAll(""));
    }
}
