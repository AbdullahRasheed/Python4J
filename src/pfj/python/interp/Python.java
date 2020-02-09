package pfj.python.interp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Python {

    public static List<String> runScript(String path, Object... obj) throws IOException{
        File script = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(script));
        List<String> write = new ArrayList<>();
        String s;
        int counter = 0;
        while((s = reader.readLine()) != null){
            if(counter < obj.length) {
                write.add(s.split("=")[0] + "=" +
                        ((obj[counter] instanceof String) ?
                                (((((String)obj[counter]).startsWith("[") && ((String)obj[counter]).endsWith("]") && ((String)obj[counter]).contains(",")))
                                ? obj[counter] : '"' + (String)obj[counter] + '"') : obj[counter]));
                counter++;
            }else write.add(s);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(script));
        for (String s1 : write) {
            writer.append(s1);
            writer.newLine();
        }
        writer.close();

        Process p = Runtime.getRuntime().exec("python " + path);
        reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String out;
        List<String> output = new ArrayList<>();
        while((out = reader.readLine()) != null){
            output.add(out);
        }
        return output;
    }

    public static List<String> runScript(String path) throws IOException{
        Process p = Runtime.getRuntime().exec("python " + path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String out;
        List<String> output = new ArrayList<>();
        while((out = reader.readLine()) != null){
            output.add(out);
        }
        return output;
    }
}
