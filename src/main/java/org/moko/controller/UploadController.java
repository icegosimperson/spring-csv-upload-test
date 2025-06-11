package org.moko.controller;

import lombok.RequiredArgsConstructor;
import org.moko.service.SendService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequiredArgsConstructor
public class UploadController {
    private final SendService sendService;

    @GetMapping("/upload")
    public String uploadPage(){
        return "uploadForm";
    }
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        sendService.saveToDatabase(file);
        return "저장 완료!";
    }
}