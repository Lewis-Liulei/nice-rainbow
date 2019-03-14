package rt.lewis.facade.test;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import rt.lewis.common.entity.user.User;
import rt.lewis.common.response.RTSuccessReturnMessage;
import rt.lewis.common.response.ReturnMessage;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/test")
public class TestFacade {


    @GetMapping("/testrm")
    public ReturnMessage testrm(){

        int a = 1/0;

        return new ReturnMessage();


    }
    @PostMapping("/ins")
    public User instertUser(@RequestBody User user){

        System.out.println("======================");
        return user;
    }
/*
    @GetMapping("/download")
    public StreamingResponseBody handle() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                // write...
                String filepath="H:\\大文件\\原来是茜公举殿下 - 家庭教师3.mp4";
                InputStream is = new FileInputStream(filepath);
                int c= 0;
                byte[] b = new byte[1024];
                while ((c=is.read(b,0,1024))!=-1){
                    outputStream.write(b,0,c);
                }
                outputStream.flush();


            }
        };
    }
    @GetMapping("/download1")//有问题，不使用
    public ResponseEntity<byte[]> d2() throws IOException {
        HttpHeaders headers = new HttpHeaders();

        String filePath="H:\\378670808829.jpg";
        File file = new File(filePath);
        //"application/x-msdownload;"
        //headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //headers.setContentType(MediaType.valueOf(new MimetypesFileTypeMap().getContentType(file)));
        headers.add("Content-Disposition", "attachment;filename="+file.getName());
        //headers.setContentDispositionFormData("attachment", file.getName());

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);

    }*/

    @GetMapping("/download2")//下载使用这种原生方式
    public void d3(HttpServletResponse response) throws IOException {
        InputStream is=null;
        OutputStream os=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            String filePath="H:\\378670808829.jpg";
            File file = new File(filePath);
            is  = new FileInputStream(file);
            bis  = new BufferedInputStream(is);
            int c =0;
            int length=1024;
            byte [] b = new byte[length];
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + file.getName());
            response.setStatus(200);
            os = response.getOutputStream();
            bos = new BufferedOutputStream(os);
            while ((c=bis.read(b,0,length))!=-1){
                bos.write(b,0,c);
            }
            bos.flush();
        }finally {
            if(bos!=null){
                bos.close();
            }
            if(bis!=null){
                bis.close();
            }
            if(os!=null){
                os=null;
            }
            if(is!=null){
                is.close();
            }
        }


    }


}
