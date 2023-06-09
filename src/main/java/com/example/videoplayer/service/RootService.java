package com.example.videoplayer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RootService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${file.basePath}")
    protected String basePath;

    @Value("${file.uploadPath}")
    protected String uploadPath;

    @Value("${file.tempPath}")
    protected String tempPath;

    protected void checkDir(File f) {
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
    }

    protected String getTPath(Integer chunk, Integer chunks, String name) {
        return tempPath + "/" + name + "/" + chunk + "-" + chunks + "-" + name + ".tmp";
    }

    protected String getFPath(Integer chunk, Integer chunks, String name) {
        return tempPath + "/" + name + "/" + chunk + "-" + chunks + "-" + name + ".flag.tmp";
    }

}