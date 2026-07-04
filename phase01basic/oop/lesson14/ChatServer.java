package phase01basic.oop.lesson14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ChatServer {
    public static void main(String[] args) {
        int port = 8888;
        System.out.println("[伺服器] 正在啟動，監聽埠號: " + port + "...");

        // 1. 建立 ServerSocket 並監聽埠號
        try (ServerSocket serverSocket = new ServerSocket(port);
                // 2. 等待客戶端連線（程式會在此阻塞，直到有人連入）
                Socket socket = serverSocket.accept();

                // 3. 建立網路輸入/輸出串流(未指定編碼，使用系統預設編碼)
                // BufferedReader in =
                //         new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // 3. 建立網路輸入/輸出串流（明確指定 UTF-8 編碼）
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                PrintWriter out =
                        new PrintWriter(new java.io.OutputStreamWriter(socket.getOutputStream(), UTF_8), true);


                // 4. 建立控制台輸入流（用來打字回應）
                Scanner scanner = new Scanner(System.in, UTF_8.name())) {

            System.out.println("[伺服器] 客戶端連線成功！可以開始聊天了。");
            System.out.println("----------------------------------------");

            String clientMsg;
            // 循環讀取客戶端傳來的訊息，直到對方輸入 "bye"
            while ((clientMsg = in.readLine()) != null) {
                System.out.println("客戶端說: " + clientMsg);

                if ("bye".equalsIgnoreCase(clientMsg.trim())) {
                    System.out.println("[伺服器] 客戶端已中斷連線。");
                    break;
                }

                // 伺服器端輸入回應
                System.out.print("回覆客戶端: ");
                String serverResponse = scanner.nextLine();
                out.println(serverResponse); // 送出訊息給客戶端
            }

        } catch (Exception e) {
            System.err.println("[伺服器] 發生錯誤: " + e.getMessage());
        }
        System.out.println("[伺服器] 已關閉。");
    }
}

