/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


/**
 *
 * @author Harshit Srivastava
 */
public class decompressor {
    public static void method(File file)throws IOException{
        String fileDirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file); // these bytes are compressed already
        GZIPInputStream gzip=new   GZIPInputStream(fis); // so that those compressed bytes are read properly
        FileOutputStream fos=new FileOutputStream(fileDirectory+"/DecompressedFile");
          
         byte[] buffer=new byte[1024];
         int len;
         while((len=fis.read(buffer))!=-1){ // read buffer upto the end of the file
             fos.write(buffer,0,len);
             
         }
         gzip.close();
         fos.close();
         fis.close();
    }
    public static void main(String args[])throws IOException{
    File path=new File("/user/HarshitSrivastava/Downloads/Compressor/compressordecompressor/CompressedFile.gz");
    method(path);
    }
}
