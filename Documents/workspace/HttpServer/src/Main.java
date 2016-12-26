
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws Exception{
		System.out.println("start >>>");
		
		try(
			ServerSocket server = new ServerSocket(8080);
			Socket socket = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			){
			//in.lines().forEach(System.out::println);
			String line = in.readLine();
			StringBuilder header = new StringBuilder();
			
			while (line != null && !line.isEmpty()){//空行になるまで読み続ける
				header.append(line + "\n");
				line = in.readLine();
			}
			System.out.println(header);
		}
		System.out.println("<<< end");
		
	}
}
