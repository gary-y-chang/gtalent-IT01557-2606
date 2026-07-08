package phase01basic.oop.lesson14;

import java.io.*;
import java.net.*;

/**
 * Lab.2 參考解 —— 多用戶檔案上傳伺服器
 *
 * 整合三大主題：
 *   1. Socket 網路傳輸（ServerSocket / Socket）
 *   2. 檔案 I/O（FileOutputStream 位元組流寫入硬碟）
 *   3. 多執行緒（每個連線開一條 Thread，同時服務多位上傳者）
 *
 * 傳輸協定（與 UploadClient 對應）：
 *   [UTF 檔名] [long 檔案大小] [檔案位元組...]
 *
 * 啟動：javac UploadServer.java && java UploadServer
 */
public class UploadServer {

    private static final int    PORT    = 9000;
    private static final String SAVE_DIR = "uploads";   // 接收檔案的存放資料夾

    public static void main(String[] args) {
        // 確保存放資料夾存在
        File dir = new File(SAVE_DIR);
        if (!dir.exists()) dir.mkdirs();

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("[伺服器] 已啟動，於 Port " + PORT + " 等待上傳…");

            // 持續接聽，每來一個連線就交給一條新執行緒處理
            while (true) {
                Socket client = server.accept();
                System.out.println("[伺服器] 新連線：" + client.getInetAddress().getHostAddress());
                new Thread(() -> handleClient(client)).start();
            }
        } catch (IOException e) {
            System.err.println("[伺服器] 啟動失敗：" + e.getMessage());
        }
    }

    /** 處理單一客戶端的上傳（在獨立執行緒中執行）。 */
    private static void handleClient(Socket socket) {
        String peer = socket.getInetAddress().getHostAddress();
        try (Socket s = socket;
             DataInputStream in = new DataInputStream(
                     new BufferedInputStream(s.getInputStream()));
             DataOutputStream ack = new DataOutputStream(s.getOutputStream())) {

            // 1. 先讀出檔名與檔案大小（協定的前兩個欄位）
            String fileName = in.readUTF();
            long   fileSize = in.readLong();
            System.out.printf("[%s] 開始接收：%s（%d bytes）%n", peer, fileName, fileSize);

            // 2. 位元組流分塊寫入硬碟
            File out = new File(SAVE_DIR, fileName);
            long received = 0;
            try (FileOutputStream fos = new FileOutputStream(out);
                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                byte[] buffer = new byte[4096];   // 4KB 緩衝區
                int n;
                // 只讀 fileSize 個位元組，避免多讀到下一份資料
                while (received < fileSize && (n = in.read(buffer, 0,
                        (int) Math.min(buffer.length, fileSize - received))) != -1) {
                    bos.write(buffer, 0, n);      // 只寫實際讀到的 n 個位元組
                    received += n;
                }
            }

            System.out.printf("[%s] 完成：已存為 %s（%d bytes）%n",
                    peer, out.getPath(), received);

            // 3. 回覆客戶端一則確認訊息
            ack.writeUTF("上傳成功：" + fileName + "（" + received + " bytes）");

        } catch (IOException e) {
            System.err.printf("[%s] 傳輸中斷：%s%n", peer, e.getMessage());
        }
    }
}
