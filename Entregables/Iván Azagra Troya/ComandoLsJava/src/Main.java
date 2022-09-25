import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = null;
        StringBuilder sb = null;
        try {
            final Process process = new ProcessBuilder("powershell.exe", "/c", "ls C:\\Users\\BlobTheVod").start();
            sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine())!= null) {
                sb.append(line).append("\n");
            }
            System.out.println(sb);
        }catch(IOException e) {
            System.out.println("Error durante la lectura: " + e.getMessage());
        }finally {
            if(reader != null){
                try{
                reader.close();
                }catch(IOException e){
                    System.out.println("Error de cierre del lector: " + e.getMessage());
                }
            }

        }
    }
}