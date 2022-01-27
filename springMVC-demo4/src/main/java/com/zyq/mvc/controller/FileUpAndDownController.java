package com.zyq.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.*;
import java.util.UUID;

/**
 * @ClassName FileUpAndDownController
 * @Author MagicBOOK
 * @Date 2022-01-22 21:20
 * @Version 1.0
 */
@Controller
public class FileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
    @RequestMapping(value = "/testUp", method = RequestMethod.POST)
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        fileName = fileName.replaceAll("-", "");
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        System.out.println(photoPath);
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "success";
    }

























    @RequestMapping(value = "/fileUp", method = RequestMethod.POST)
//    @ResponseBody
    public String fileUp(HttpSession httpSession, MultipartFile file) throws IOException {
//        获取文件名
        String originalFilename = file.getOriginalFilename();
//        取出文件后缀，将UUID产生的UUID码与后缀合并，生成新的文件名
        String newName = originalFilename.substring(originalFilename.lastIndexOf("."));
        newName=UUID.randomUUID().toString()+newName;
//        获取photo所在文件夹的服务器真实路径
        ServletContext servletContext = httpSession.getServletContext();
        String photo = servletContext.getRealPath("mine"+File.separator+"photo");
        File file1 = new File(photo);
        if(!file1.exists()){
            file1.mkdirs();
        }
        String pathName = photo+File.separator+newName;
        file.transferTo(new File(pathName));
        return "success";
    }

    @RequestMapping("/fileDown")
    @ResponseBody
    public ResponseEntity<byte[]> fileDown(HttpSession session) throws IOException {
////        获取服务器中文件的真实路径
//        ServletContext servletContext = session.getServletContext();
//        String realPath = servletContext.getRealPath("/mine/photo/e209af87-7f8e-44c7-9c92-96ee814a5888.jpg");
////        创建输入流
//        InputStream is = new FileInputStream(realPath);
////        创建字节数组
//        byte[] bytes = new byte[is.available()];
//        is.read(bytes);
////        这个MultiValueMap继承了MAP，可以实现一个key对应多个value
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        //设置要下载方式以及下载文件的名字，这句不能变
//        headers.add("Content-Disposition", "attachment;filename=1.jpg");
////        设置响应码
//        HttpStatus statusCode = HttpStatus.OK;
////        这里responseEntity的有参构造器需要三个参数：响应体，响应头，响应状态码
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
//        is.close();
//        return responseEntity;
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/mine/photo/e209af87-7f8e-44c7-9c92-96ee814a5888.jpg");
        InputStream is = new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity(bytes,headers, HttpStatus.OK);
        is.close();
        return responseEntity;
    }

}
