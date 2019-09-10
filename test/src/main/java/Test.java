import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sgh
 * @date 2019/9/10 14:18
 */
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("start");
            // python指令 记得配好环境变量
            String command = "python";
            // python的路径 可以相对地址
            String path = "python.py";
            String parms = "Hello";
            // 参数列表
            String[] argv = new String[]{command, path, parms};
            Process pr = Runtime.getRuntime().exec(argv);
            // 得到 BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
