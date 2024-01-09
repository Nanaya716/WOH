package com.jxc.controller;

import com.jxc.entity.Result;
import com.jxc.entity.SysUser;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.UUID;

@Log4j
@Controller
public class FileController {
    /*1.跳转到上传文件页面*/
    @RequestMapping("toUpload")
    public String toUpload(){
        return "upload";
    }


    /*1.跳转到上传文件页面*/
    @RequestMapping("toUser")
    public String toUser(){
        return "user/index";
    }

    /*1.跳转到上传文件页面*/
    @RequestMapping("toUserEdit")
    public String toUserEdit(){
        return "user/edit";
    }

    /*1.跳转到上传文件页面*/
    @RequestMapping("language")
    public String language(String loc, HttpServletRequest request){
        if(StringUtils.isNotEmpty(loc)) {
            Locale locale = null;
            if(loc.equals("zh_CN")) {
                //设置中文环境
                locale = new Locale("zh","CN");
                request.getSession().setAttribute(
                        SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            }else if(loc.equals("en_US")) {
                //设置英文环境
                locale = new Locale("en","US");
                request.getSession().setAttribute(
                        SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            }else {
                //使用默认的语言环境
                request.getSession().setAttribute(
                        SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
            }
        }
        return "upload";
    }

    /**
     * 上传文件处理方法
     * @param user  文本数据
     * @param part  文件数据，使用MultipartFile[]数组来接收多个文件
     * @param request
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public Result upload(@Valid SysUser user, @RequestParam("file") MultipartFile part, HttpServletRequest request){
        log.info(user);
        //1.创建保存的文件夹
        File dir = new File(request.getServletContext().getRealPath("/upload"));
        if(!dir.exists()){
            dir.mkdirs();
        }
        //2.修改保存的文件名
        String fileType = part.getOriginalFilename().substring(part.getOriginalFilename().indexOf("."), part.getOriginalFilename().length());
        String name = UUID.randomUUID().toString()+fileType;
        File path = new File(dir, name);
        try {
            //3.保存文件
            part.transferTo(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //4.返回保存文件的服务器路径
        return Result.ok("上传成功", "/upload/"+name);
    }

    /**
     * 下载文件
     * @param request
     * @return
     */
    @RequestMapping("download")
    public ResponseEntity download(HttpServletRequest request){
        InputStream is = null;
        byte[] b = null;
        HttpHeaders headers;
        try {
            //1.读取服务端文件
            is = request.getServletContext().getResourceAsStream("img/icon_default.png");
            b = new byte[is.available()];
            is.read(b);
            //2.设置响应类型为附件
            headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+ URLEncoder.encode("icon_default.png","utf-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity(b, headers, HttpStatus.OK);
    }
}
