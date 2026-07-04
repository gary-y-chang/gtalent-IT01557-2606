package phase01basic.oop.lesson14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ChatClient {
    public static void main(String[] args) {
        String serverIp = "127.0.0.1"; // 本機測試 IP
        int port = 8888;
        System.out.println("[客戶端] 正在連線至伺服器 " + serverIp + ":" + port + "...");

        // 1. 建立 Socket 連線至伺服器
        try (Socket socket = new Socket(serverIp, port);

                // 2. 建立網路輸入/輸出串流(未指定編碼，使用系統預設編碼)
                // BufferedReader in =
                //         new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // 2. 建立網路輸入/輸出串流（明確指定 UTF-8 編碼）
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                PrintWriter out =
                        new PrintWriter(new java.io.OutputStreamWriter(socket.getOutputStream(), UTF_8), true);



                // 3. 建立控制台輸入流
                Scanner scanner = new Scanner(System.in, UTF_8.name())) {

            System.out.println("[客戶端] 連線成功！請先發言。");
            System.out.println("----------------------------------------");

            while (true) {
                // 客戶端輸入訊息並送出
                System.out.print("我說: ");
                String clientMsg = scanner.nextLine();
                out.println(clientMsg); // 送出訊息給伺服器

                // 如果輸入 bye，結束迴圈
                if ("bye".equalsIgnoreCase(clientMsg.trim())) {
                    System.out.println("[客戶端] 正在結束對話...");
                    break;
                }

                // 等待並讀取伺服器的回應
                String serverResponse = in.readLine();
                if (serverResponse == null) {
                    System.out.println("[客戶端] 伺服器已斷開連線。");
                    break;
                }
                System.out.println("伺服器回應: " + serverResponse);
            }

        } catch (Exception e) {
            System.err.println("[客戶端] 發生錯誤: " + e.getMessage());
        }
        System.out.println("[客戶端] 已退出。");
    }
}
