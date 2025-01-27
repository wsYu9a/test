package com.alimm.tanx.core.ut.core;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.core.thread.FileThreadPool;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rb.b;

/* loaded from: classes.dex */
public class CacheUserReportManager {
    private static final String TAG = "CacheUserReportManager";
    private static volatile CacheUserReportManager instance;
    public static volatile int tempFileName;
    private final int FILE_MAX_SIZE = 1000;

    @Deprecated
    private final int FILE_MERGE_SIZE = 5;
    private final File cacheDir = FileUtils.mkdir(FileUtils.getExternalDir(TanxCoreSdk.getApplication(), 0).getPath() + "/ut/");

    /* renamed from: com.alimm.tanx.core.ut.core.CacheUserReportManager$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$utStr;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CacheUserReportManager.this.judgeFileDelete();
            FileUtils.saveStr2File(FileUtil.getAndCreateFile(CacheUserReportManager.this.cacheDir.getPath(), CacheUserReportManager.this.createFileName()), str);
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.CacheUserReportManager$2 */
    public class AnonymousClass2 implements Comparator<File> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (FileUtil.getFileName(file2) - FileUtil.getFileName(file));
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.CacheUserReportManager$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ File val$file;

        public AnonymousClass3(File file) {
            file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileUtils.deleteFile(file);
        }
    }

    public String createFileName() {
        return System.currentTimeMillis() + b.f30387c;
    }

    public static CacheUserReportManager getInstance() {
        if (instance == null) {
            synchronized (CacheUserReportManager.class) {
                try {
                    if (instance == null) {
                        instance = new CacheUserReportManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void judgeFileDelete() {
        try {
            File file = this.cacheDir;
            if (file != null) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    LogUtils.d(TAG, "UserReport :judgeFileDelete()listFiles为空，或length为0");
                    return;
                }
                LogUtils.d(TAG, "UserReport :judgeFileDelete()文件个数->" + listFiles.length);
                if (listFiles.length >= 1000) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(listFiles));
                    Collections.sort(arrayList, new Comparator<File>() { // from class: com.alimm.tanx.core.ut.core.CacheUserReportManager.2
                        public AnonymousClass2() {
                        }

                        @Override // java.util.Comparator
                        public int compare(File file2, File file22) {
                            return (int) (FileUtil.getFileName(file22) - FileUtil.getFileName(file2));
                        }
                    });
                    while (arrayList.size() - 1000 >= 0) {
                        FileUtils.deleteFile((File) arrayList.get(arrayList.size() - 1));
                        arrayList.remove(arrayList.size() - 1);
                        LogUtils.d(TAG, "UserReport :judgeFileDelete(),超过文件阈值开始删除->当前文件个数" + listFiles.length);
                    }
                }
            }
        } catch (Exception e10) {
            LogUtils.e(IUserReport.TAG, e10);
        }
    }

    public void deleteFile(File file) {
        FileThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.CacheUserReportManager.3
            final /* synthetic */ File val$file;

            public AnonymousClass3(File file2) {
                file = file2;
            }

            @Override // java.lang.Runnable
            public void run() {
                FileUtils.deleteFile(file);
            }
        });
    }

    public List<File> readCacheFileList() {
        File[] listFiles = this.cacheDir.listFiles();
        ArrayList arrayList = new ArrayList();
        return (listFiles == null || listFiles.length <= 0) ? arrayList : new ArrayList(Arrays.asList(listFiles));
    }

    public void saveFile(UtBean utBean) {
        saveFile(JSON.toJSONString(utBean));
    }

    public void saveFile(String str) {
        FileThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.CacheUserReportManager.1
            final /* synthetic */ String val$utStr;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                CacheUserReportManager.this.judgeFileDelete();
                FileUtils.saveStr2File(FileUtil.getAndCreateFile(CacheUserReportManager.this.cacheDir.getPath(), CacheUserReportManager.this.createFileName()), str);
            }
        });
    }
}
