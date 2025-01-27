package com.alimm.tanx.core.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public class ZipUtils implements NotConfused {
    public static void main(String[] strArr) throws Exception {
        unZip("D:/test.zip", "D:/a");
    }

    private static void mkdir(File file) {
        if (file == null || file.exists()) {
            return;
        }
        mkdir(file.getParentFile());
        file.mkdir();
    }

    public static void unZip(String str, String str2) throws Exception {
        File file = new File(str2);
        if (!file.exists() && !file.mkdir()) {
            throw new Exception("创建解压目标文件夹失败");
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            if (nextEntry.isDirectory()) {
                mkdir(new File(str2 + File.separator + nextEntry.getName()));
            } else {
                String str3 = str2 + File.separator + nextEntry.getName();
                mkdir(new File(str3).getParentFile());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.close();
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
    }

    private static void zipDirectory(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    zipDirectory(file2, str + "/" + file2.getName(), zipOutputStream);
                } else {
                    zipFile(file2, str, zipOutputStream);
                }
            }
        }
    }

    private static void zipFile(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        zipOutputStream.putNextEntry(new ZipEntry(str + "/" + file.getName()));
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                fileInputStream.close();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    public static void zipFolder(String str, String str2) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        zipDirectory(file, file.getName(), zipOutputStream);
        zipOutputStream.close();
    }
}
