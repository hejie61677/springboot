package com.hejie.springboot.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: springboot
 * @description:
 * @author: hejie
 * @create: 2019-04-29 10:56
 */
@Controller
public class UploadController {

    @RequestMapping("/uploadPage")
    public String uploadPage() {

        return "uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model model) {

        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String aimFileName = request.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;

            //上传文件
            File aimFile = new File(aimFileName);
            aimFile.getParentFile().mkdirs();
            file.transferTo(aimFile);

            model.addAttribute("fileName", fileName);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return "上传失败，" + e.getMessage();

        } catch (IOException e) {

            e.printStackTrace();
            return "上传失败，" + e.getMessage();
        }

        return "showImg";
    }

}
