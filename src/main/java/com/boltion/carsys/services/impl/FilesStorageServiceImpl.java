package com.boltion.carsys.services.impl;

import com.boltion.carsys.services.FilesStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Service
public class FilesStorageServiceImpl implements FilesStorageService {


    @Override
    public void init() {

    }

    @Override
    public void save(MultipartFile file, String id, String rootPath) {
    }

    @Override
    public void load(String filename, String rootPath) {
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }
}
