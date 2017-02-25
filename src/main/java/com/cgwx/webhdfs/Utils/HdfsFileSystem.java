package com.cgwx.webhdfs.Utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;


public class HdfsFileSystem {
    public static void createFile(File localPath, String hdfsPath) throws IOException {
        InputStream in = null;
        try {
            Configuration conf = new Configuration();
            FileSystem fileSystem = FileSystem.get(URI.create(hdfsPath), conf);
            FSDataOutputStream out = fileSystem.create(new Path(hdfsPath));
            in = new BufferedInputStream(new FileInputStream(localPath));
            IOUtils.copyBytes(in, out, 4096, false);
            out.hsync();
            out.close();
            System.out.println("创建并写入文件成功，文件全路径:" + hdfsPath);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
