package com.wzg.demo.controller;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/wzg")
public class UploadController {

    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "file", required = true) MultipartFile uploadFile, HttpServletRequest req) {
        System.out.println("req" + req);
        System.out.println("uploadFile" + uploadFile);
        String name = uploadFile.getOriginalFilename();
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile");
        String format = sd.format(new Date());
        File file = new File(realPath + format);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.indexOf("."), oldName.length());
        try {
            uploadFile.transferTo(new File(file, name));
            String path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + "/" + name;
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @RequestMapping("/downloads")
    public String downLoads(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename="2.xlsx";
        String filePath = "D:/download" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return "null";
    }

    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response,@RequestBody String urls) throws UnsupportedEncodingException, UnknownHostException, FileNotFoundException {

        String path11 = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        String path111 = ResourceUtils.getURL("classpath:").getPath();

        System.out.println("项目路径"+path11);
        System.out.println("项目路径"+path111);
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
//        String url = "http://" + hostAddress + ":" ;
        String url=urls;
        String hostName = localHost.getHostName();
        System.out.println(hostName);
        System.out.println(hostAddress);
        System.out.println(url);
        System.out.println("Res应答"+response);
        String filename="3.xlsx";
        String filePath = "D:/download" ;
//        String files=response.getHeader(1);
//        System.out.println("files"+files);
//        String path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + "/" + name;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "chenggong";
        }else {
            System.out.println("不存在");
            System.out.println("不存在");
            return "文件不存在";
        }

    }

    /**
     * 稿源周报excel表格下载
     * @return
     */

    @RequestMapping(value = "/downExcel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String downExcel(HttpServletResponse response) throws UnsupportedEncodingException {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(14);
        String filename = "稿源抓取周报-" + end.format(DateTimeFormatter.ISO_DATE) + ".xlsx";
        String filepath = "files/" + filename;
//        writeExcelFile(start, end, filepath);
        // 如果文件名不为空，则进行下载
        if (filename != null) {
            File file = new File(filepath);
            // 如果文件存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download  successfully!");
                    return "successfully";

                } catch (Exception e) {
                    System.out.println("Download  failed!");
                    return "failed";

                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "表格成功";
    }

}
