package com.boltion.carsys.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @auther sachin
 * @date 2022-09-05
 */
public interface FilesStorageService {
    void init();

    void save(MultipartFile file, String id, String rootPath);

    void load(String filename,String rootPath);

    void deleteAll();

    Stream<Path> loadAll();
}
