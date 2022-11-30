package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileUtils {
    public static String readFileAsString(String path, String fileName) throws IOException {
        byte[] encoded= Files.readAllBytes(Paths.get(path+"\\"+fileName));

        return new String(encoded, Charset.defaultCharset());
    }
    /**
     * This method deletes a file through providing the path to the file and the file name
     * @param path
     * @param fileName
     */
    public static void deleteFile(String path, String fileName) {
        File file = new File(path+ "\\" + fileName);

        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("No File!");
        }
    }
}
