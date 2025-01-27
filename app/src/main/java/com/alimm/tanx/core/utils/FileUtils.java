package com.alimm.tanx.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.log.LogBean;
import com.alimm.tanx.core.log.LogItemBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class FileUtils implements NotConfused {
    private static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    private static final String TAG = "FileUtils";

    public interface FileKeepRule {
        boolean needKept(String str);
    }

    private static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public static boolean copyFile(InputStream inputStream, FileOutputStream fileOutputStream) {
        try {
            try {
                byte[] bArr = new byte[1444];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                inputStream.close();
                return true;
            } catch (Exception e11) {
                e11.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        return false;
                    }
                }
                if (inputStream == null) {
                    return false;
                }
                inputStream.close();
                return false;
            }
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                    throw th2;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th2;
        }
    }

    private static boolean copyTo(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            closeIO(fileOutputStream2);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e10) {
                    e = e10;
                    fileOutputStream = fileOutputStream2;
                    LogUtils.d(TAG, "copyTo exception: output = " + file, e);
                    closeIO(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean decompress(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(new File(str)));
                boolean z10 = true;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            closeIO(zipInputStream2);
                            return z10;
                        }
                        if (!TextUtils.isEmpty(nextEntry.getName()) && nextEntry.getName().contains("../")) {
                            LogUtils.e("decompress", "发现不安全的zip文件解压路径！");
                            closeIO(zipInputStream2);
                            return false;
                        }
                        String joinPath = joinPath(str2, nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            mkdir(joinPath);
                        } else {
                            z10 &= copyTo(new File(joinPath), zipInputStream2);
                        }
                    } catch (Exception e10) {
                        e = e10;
                        zipInputStream = zipInputStream2;
                        LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        zipInputStream = zipInputStream2;
                        closeIO(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            deleteFile(new File(str));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void deleteExpiredFile(File file, int i10, FileKeepRule fileKeepRule) {
        if (file != null) {
            try {
                if (!file.exists() || System.currentTimeMillis() - file.lastModified() <= TimeUnit.DAYS.toMillis(i10)) {
                    return;
                }
                if (fileKeepRule != null && fileKeepRule.needKept(file.getName())) {
                    return;
                }
                LogUtils.d(TAG, "deleteExpiredFile: file = " + file);
                deleteFile(file);
            } catch (Exception e10) {
                LogUtils.e(e10);
            }
        }
    }

    public static void deleteExpiredFiles(String str, int i10, FileKeepRule fileKeepRule) {
        try {
            List<File> files = getFiles(str);
            LogUtils.d(TAG, "deleteExpiredFiles: expireDays = " + i10);
            if (files == null || files.size() <= 0) {
                return;
            }
            Iterator<File> it = files.iterator();
            while (it.hasNext()) {
                deleteExpiredFile(it.next(), i10, fileKeepRule);
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, "deleteExpiredFiles: exception.", e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteExpiredFiles: exception." + LogUtils.getStackTraceMessage(e10), "");
        }
    }

    public static synchronized boolean deleteFile(File file) {
        File[] listFiles;
        synchronized (FileUtils.class) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
    }

    private static boolean ensureFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (IOException e10) {
            e = e10;
            e.printStackTrace();
            return false;
        } catch (SecurityException e11) {
            e = e11;
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exists(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (SecurityException e10) {
            LogUtils.d(TAG, "call exists failed.", e10);
            return false;
        }
    }

    public static File getExternalDir(Context context, int i10) {
        File file = null;
        try {
        } catch (Throwable unused) {
            LogUtils.d(TAG, "getExternalDir exception: type = " + i10);
        }
        if (i10 != 0) {
            if (i10 == 1) {
                file = context.getExternalCacheDir();
            }
            return file;
        }
        file = context.getExternalFilesDir(null);
        return file;
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= 0 || lastIndexOf >= str.length() + (-1)) ? "" : str.substring(lastIndexOf + 1);
    }

    private static List<File> getFiles(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                }
                list.add(file2);
            }
        }
        return list;
    }

    public static synchronized String getStrFromFile(String str) {
        String str2;
        synchronized (FileUtils.class) {
            String str3 = "";
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                e = e10;
            }
            if (!new File(str).exists()) {
                closeIO(null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    str2 = new String(bArr, StandardCharsets.UTF_8);
                    try {
                        fileInputStream2.close();
                        closeIO(fileInputStream2);
                    } catch (Exception e11) {
                        e = e11;
                        str3 = str2;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        closeIO(fileInputStream);
                        str2 = str3;
                        return str2;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                closeIO(fileInputStream);
                throw th;
            }
        }
    }

    public static String joinPath(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        if (strArr != null) {
            for (int i10 = 0; i10 < strArr.length && !TextUtils.isEmpty(strArr[i10]); i10++) {
                if (i10 > 0) {
                    sb2.append(File.separator);
                }
                sb2.append(strArr[i10]);
            }
        }
        return sb2.toString();
    }

    public static File mkdir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.mkdirs();
            return file;
        } catch (Exception e10) {
            LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e10);
            return file;
        }
    }

    public static String readAssetFile(Context context, String str) {
        if (context == null || str == null) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            String sb3 = sb2.toString();
                            closeIO(bufferedReader2);
                            return sb3;
                        }
                        sb2.append(readLine);
                    }
                } catch (Exception e10) {
                    e = e10;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    closeIO(bufferedReader);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    closeIO(bufferedReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static List<String> readLines(String str) {
        LinkedList linkedList = new LinkedList();
        if (exists(str)) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            linkedList.add(readLine);
                        } catch (IOException e10) {
                            e = e10;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            closeIO(bufferedReader);
                            throw th;
                        }
                    }
                    closeIO(bufferedReader2);
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e11) {
                e = e11;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveAndAppendStr2File(Context context, File file, LogBean logBean) {
        FileOutputStream fileOutputStream;
        Throwable th2;
        Exception e10;
        synchronized (FileUtils.class) {
            boolean z10 = false;
            if (file == null || context == null || logBean == null) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(file, true);
                for (int i10 = 0; i10 < logBean.events.size(); i10++) {
                    try {
                        try {
                            LogItemBean logItemBean = logBean.events.get(i10);
                            fileOutputStream.write((logItemBean.time + " " + logItemBean.level + " [ " + logItemBean.tag + " ] " + logItemBean.message).getBytes());
                            fileOutputStream.write("\r\n".getBytes());
                        } catch (Throwable th3) {
                            th2 = th3;
                            closeIO(fileOutputStream);
                            throw th2;
                        }
                    } catch (Exception e11) {
                        e10 = e11;
                        Log.e(TAG, "saveAndAppendStr2File ", e10);
                        e10.printStackTrace();
                        closeIO(fileOutputStream);
                        return z10;
                    }
                }
                fileOutputStream.close();
                closeIO(fileOutputStream);
                z10 = true;
            } catch (Exception e12) {
                fileOutputStream = null;
                e10 = e12;
            } catch (Throwable th4) {
                fileOutputStream = null;
                th2 = th4;
                closeIO(fileOutputStream);
                throw th2;
            }
            return z10;
        }
    }

    public static synchronized boolean saveStr2File(File file, String str) {
        synchronized (FileUtils.class) {
            boolean z10 = false;
            if (file == null) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str.getBytes());
                        fileOutputStream2.close();
                        closeIO(fileOutputStream2);
                        z10 = true;
                    } catch (Exception e10) {
                        e = e10;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(TAG, "saveStrToFile ", e);
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                        e.printStackTrace();
                        closeIO(fileOutputStream);
                        return z10;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        closeIO(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
                return z10;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static boolean unZipFolder(String str, String str2) throws Exception {
        if (!new File(str).exists()) {
            return false;
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return true;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
            } else {
                File file = new File(str2 + File.separator + name);
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                fileOutputStream.close();
            }
        }
    }

    public static InputStream upZip(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        return zipFile.getInputStream(zipFile.getEntry(str2));
    }

    public static void writeLine(String str, boolean z10, String str2) {
        if (!ensureFileExists(str)) {
            return;
        }
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(str, z10)));
                try {
                    printWriter2.println(str2);
                    closeIO(printWriter2);
                } catch (IOException e10) {
                    e = e10;
                    printWriter = printWriter2;
                    e.printStackTrace();
                    closeIO(printWriter);
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    closeIO(printWriter);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void deleteExpiredFile(String str, int i10, FileKeepRule fileKeepRule) {
        File[] listFiles;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    deleteExpiredFile(file2, i10, fileKeepRule);
                }
            }
            deleteExpiredFile(new File(str), i10, fileKeepRule);
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    public static List<File> getFiles(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            getFiles(str, arrayList);
        }
        return arrayList;
    }

    public static synchronized boolean saveStr2File(String str, String str2) {
        synchronized (FileUtils.class) {
            boolean z10 = false;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        new File(file.getParent()).mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.close();
                        closeIO(fileOutputStream2);
                        z10 = true;
                    } catch (Exception e10) {
                        fileOutputStream = fileOutputStream2;
                        e = e10;
                        LogUtils.e(TAG, "saveStrToFile ", e);
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                        e.printStackTrace();
                        closeIO(fileOutputStream);
                        return z10;
                    } catch (Throwable th2) {
                        fileOutputStream = fileOutputStream2;
                        th = th2;
                        closeIO(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e11) {
                e = e11;
            }
            return z10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    public static synchronized String getStrFromFile(File file) {
        synchronized (FileUtils.class) {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                } catch (Exception e10) {
                    e = e10;
                }
                if (!file.exists()) {
                    closeIO(null);
                    return null;
                }
                ?? fileInputStream = new FileInputStream(file);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader((InputStream) fileInputStream, StandardCharsets.UTF_8);
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    closeIO(fileInputStream);
                } catch (Exception e11) {
                    e = e11;
                    bufferedReader = fileInputStream;
                    e.printStackTrace();
                    closeIO(bufferedReader);
                    return sb2.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = fileInputStream;
                    closeIO(bufferedReader);
                    throw th;
                }
                return sb2.toString();
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }
}
