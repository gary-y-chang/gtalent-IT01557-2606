package phase01basic.oop.lesson14;

import java.io.*;
import java.net.*;

/**
 * Lab.2 參考解 —— 檔案上傳客戶端
 *
 * 流程：
 *   1. 用 FileInputStream 讀取本地檔案（位元組流，任何檔案類型皆可）
 *   2. 透過 Socket 的輸出串流，依協定送出「檔名 + 大小 + 內容」
 *   3. 讀取伺服器回覆的確認訊息
 *
 * 使用方式：
 *   java UploadClient                         （用預設值：連 127.0.0.1、上傳 photo.jpg）
 *   java UploadClient <伺服器IP> <檔案路徑>     （自訂）
 */
public class UploadClient {

    private static final int PORT = 9000;

    public static void main(String[] args) {
        // 允許以命令列參數指定伺服器 IP 與要上傳的檔案，否則用預設值
        String host = args.length > 0 ? args[0] : "127.0.0.1";
        String path = args.length > 1 ? args[1] : "photo.jpg";

        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.err.println("[客戶端] 找不到檔案：" + file.getAbsolutePath());
            return;
        }

        try (Socket socket = new Socket(host, PORT);
             FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataOutputStream out = new DataOutputStream(
                     new BufferedOutputStream(socket.getOutputStream()));
             DataInputStream ack = new DataInputStream(socket.getInputStream())) {

            System.out.printf("[客戶端] 已連線 %s:%d，準備上傳 %s（%d bytes）%n",
                    host, PORT, file.getName(), file.length());

            // 1. 先送出檔名與檔案大小（協定的前兩個欄位）
            out.writeUTF(file.getName());
            out.writeLong(file.length());

            // 2. 位元組流分塊送出檔案內容
            byte[] buffer = new byte[4096];
            int n;
            long sent = 0;
            while ((n = bis.read(buffer)) != -1) {
                out.write(buffer, 0, n);   // 只送實際讀到的 n 個位元組
                sent += n;
            }
            out.flush();                   // 確保緩衝區資料全部送出
            System.out.println("[客戶端] 傳輸完成，共送出 " + sent + " bytes");

            // 3. 讀取伺服器的確認訊息
            String reply = ack.readUTF();
            System.out.println("[客戶端] 伺服器回覆：" + reply);

        } catch (ConnectException e) {
            System.err.println("[客戶端] 無法連線，請先啟動 UploadServer：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("[客戶端] 上傳失敗：" + e.getMessage());
        }
    }
}
