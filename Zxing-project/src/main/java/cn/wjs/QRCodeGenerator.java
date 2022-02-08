package cn.wjs;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    private static final String QR_CODE_IMAGE_PATH = "/Users/wujinsen/MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    /**
     * 解密，将生成的二维码转换成文字
     *
     * @param file:二维码文件
     * @throws Exception
     */
    public static String decodeImage(File file) throws Exception {
        //首先判断文件是否存在
        if (!file.exists()) {
            return "";
        }
        //将file转换成内存中的一张图片
        BufferedImage image = ImageIO.read(file);
        MultiFormatReader formatter = new MultiFormatReader();
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
        //将图片的文字信息解析到result中
        Result result = formatter.decode(binaryBitmap);
        System.out.println(result.getText());
        return result.getText();
    }

    public static void main(String[] args) throws Exception{
        try {
            generateQRCodeImage("https://www.baidu.com", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

        System.out.println(decodeImage(new File(QR_CODE_IMAGE_PATH)));
    }

}
