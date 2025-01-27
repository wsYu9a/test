package com.alimm.tanx.core.log;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.UploadLogRequest;
import com.alimm.tanx.core.ut.core.thread.FileThreadPool;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.ZipUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import p1.a;
import rb.b;

/* loaded from: classes.dex */
public class tanxc_do {
    public static volatile int tanxc_do;
    private static volatile tanxc_do tanxc_if;
    private final int tanxc_byte = 100;
    private String tanxc_case = "";

    @Deprecated
    private final int tanxc_char = 5;
    private final File tanxc_for;
    private final File tanxc_int;
    private String tanxc_new;
    private String tanxc_try;

    /* renamed from: com.alimm.tanx.core.log.tanxc_do$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ LogBean tanxc_do;

        public AnonymousClass1(LogBean logBean) {
            logBean = logBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            tanxc_do tanxc_doVar = tanxc_do.this;
            tanxc_doVar.tanxc_do(tanxc_doVar.tanxc_for, 100);
            FileUtils.saveAndAppendStr2File(TanxCoreSdk.getApplication(), FileUtil.getAndCreateFile(tanxc_do.this.tanxc_for.getPath(), tanxc_do.this.tanxc_new()), logBean);
        }
    }

    /* renamed from: com.alimm.tanx.core.log.tanxc_do$2 */
    public class AnonymousClass2 implements Comparator<File> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: tanxc_do */
        public int compare(File file, File file2) {
            return (int) (FileUtil.getFileName(file2) - FileUtil.getFileName(file));
        }
    }

    /* renamed from: com.alimm.tanx.core.log.tanxc_do$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ File tanxc_do;

        public AnonymousClass3(File file) {
            file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileUtils.deleteFile(file);
        }
    }

    /* renamed from: com.alimm.tanx.core.log.tanxc_do$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: com.alimm.tanx.core.log.tanxc_do$4$1 */
        public class AnonymousClass1 implements NetWorkCallBack<LogResultBean> {
            final /* synthetic */ UploadLogRequestBean tanxc_do;

            public AnonymousClass1(UploadLogRequestBean uploadLogRequestBean) {
                uploadLogRequestBean = uploadLogRequestBean;
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(LogResultBean logResultBean) {
                tanxc_do.this.tanxc_do(uploadLogRequestBean.logFile);
                if (logResultBean != null) {
                    Log.d("CacheLogManager", logResultBean.toString());
                }
            }
        }

        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<File> tanxc_for = tanxc_do.this.tanxc_for();
            if (tanxc_for == null || tanxc_for.size() <= 0) {
                return;
            }
            for (int i10 = 0; i10 < tanxc_for.size(); i10++) {
                UploadLogRequest uploadLogRequest = new UploadLogRequest();
                UploadLogRequestBean uploadLogRequestBean = new UploadLogRequestBean();
                uploadLogRequestBean.logFile = tanxc_for.get(i10);
                uploadLogRequest.request(uploadLogRequestBean, (NetWorkCallBack<LogResultBean>) new NetWorkCallBack<LogResultBean>() { // from class: com.alimm.tanx.core.log.tanxc_do.4.1
                    final /* synthetic */ UploadLogRequestBean tanxc_do;

                    public AnonymousClass1(UploadLogRequestBean uploadLogRequestBean2) {
                        uploadLogRequestBean = uploadLogRequestBean2;
                    }

                    @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                    public void error(int i102, String str, String str2) {
                    }

                    @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                    /* renamed from: tanxc_do */
                    public void succ(LogResultBean logResultBean) {
                        tanxc_do.this.tanxc_do(uploadLogRequestBean.logFile);
                        if (logResultBean != null) {
                            Log.d("CacheLogManager", logResultBean.toString());
                        }
                    }
                });
            }
        }
    }

    public tanxc_do() {
        this.tanxc_new = "";
        this.tanxc_try = "";
        this.tanxc_new = FileUtils.getExternalDir(TanxCoreSdk.getApplication(), 0).getPath() + "/log";
        this.tanxc_try = FileUtils.getExternalDir(TanxCoreSdk.getApplication(), 0).getPath() + "/log_zip";
        this.tanxc_for = FileUtils.mkdir(this.tanxc_new);
        this.tanxc_int = FileUtils.mkdir(this.tanxc_try);
    }

    private void tanxc_byte() {
        tanxc_if.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_do.4

            /* renamed from: com.alimm.tanx.core.log.tanxc_do$4$1 */
            public class AnonymousClass1 implements NetWorkCallBack<LogResultBean> {
                final /* synthetic */ UploadLogRequestBean tanxc_do;

                public AnonymousClass1(UploadLogRequestBean uploadLogRequestBean2) {
                    uploadLogRequestBean = uploadLogRequestBean2;
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i102, String str, String str2) {
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                /* renamed from: tanxc_do */
                public void succ(LogResultBean logResultBean) {
                    tanxc_do.this.tanxc_do(uploadLogRequestBean.logFile);
                    if (logResultBean != null) {
                        Log.d("CacheLogManager", logResultBean.toString());
                    }
                }
            }

            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                List<File> tanxc_for = tanxc_do.this.tanxc_for();
                if (tanxc_for == null || tanxc_for.size() <= 0) {
                    return;
                }
                for (int i10 = 0; i10 < tanxc_for.size(); i10++) {
                    UploadLogRequest uploadLogRequest = new UploadLogRequest();
                    UploadLogRequestBean uploadLogRequestBean2 = new UploadLogRequestBean();
                    uploadLogRequestBean2.logFile = tanxc_for.get(i10);
                    uploadLogRequest.request(uploadLogRequestBean2, (NetWorkCallBack<LogResultBean>) new NetWorkCallBack<LogResultBean>() { // from class: com.alimm.tanx.core.log.tanxc_do.4.1
                        final /* synthetic */ UploadLogRequestBean tanxc_do;

                        public AnonymousClass1(UploadLogRequestBean uploadLogRequestBean22) {
                            uploadLogRequestBean = uploadLogRequestBean22;
                        }

                        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                        public void error(int i102, String str, String str2) {
                        }

                        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                        /* renamed from: tanxc_do */
                        public void succ(LogResultBean logResultBean) {
                            tanxc_do.this.tanxc_do(uploadLogRequestBean.logFile);
                            if (logResultBean != null) {
                                Log.d("CacheLogManager", logResultBean.toString());
                            }
                        }
                    });
                }
            }
        }, 10000);
    }

    public String tanxc_new() {
        if (TextUtils.isEmpty(this.tanxc_case)) {
            this.tanxc_case = tanxc_try() + b.f30387c;
        }
        return this.tanxc_case;
    }

    private String tanxc_try() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
    }

    public List<File> tanxc_for() {
        File file = this.tanxc_int;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public void tanxc_int() {
        try {
            List<File> tanxc_if2 = tanxc_if();
            if (tanxc_if2 == null || tanxc_if2.size() <= 0) {
                tanxc_do(this.tanxc_int, 3);
                tanxc_byte();
            } else {
                tanxc_do(this.tanxc_int, 3);
                ZipUtils.zipFolder(this.tanxc_new, this.tanxc_try + "/" + tanxc_try() + a.f29680b);
                tanxc_do(this.tanxc_int, 3);
                FileUtils.delete(this.tanxc_new);
                tanxc_byte();
            }
        } catch (Exception e10) {
            Log.e("CacheLogManager", LogUtils.getStackTraceMessage(e10));
        }
    }

    public List<File> tanxc_if() {
        File file = this.tanxc_for;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public static tanxc_do tanxc_do() {
        if (tanxc_if == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_if == null) {
                        tanxc_if = new tanxc_do();
                    }
                } finally {
                }
            }
        }
        return tanxc_if;
    }

    public void tanxc_do(LogBean logBean) {
        FileThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_do.1
            final /* synthetic */ LogBean tanxc_do;

            public AnonymousClass1(LogBean logBean2) {
                logBean = logBean2;
            }

            @Override // java.lang.Runnable
            public void run() {
                tanxc_do tanxc_doVar = tanxc_do.this;
                tanxc_doVar.tanxc_do(tanxc_doVar.tanxc_for, 100);
                FileUtils.saveAndAppendStr2File(TanxCoreSdk.getApplication(), FileUtil.getAndCreateFile(tanxc_do.this.tanxc_for.getPath(), tanxc_do.this.tanxc_new()), logBean);
            }
        });
    }

    public void tanxc_do(File file, int i10) {
        if (file != null) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    Log.d("CacheLogManager", "ILog :judgeFileDelete()listFiles为空，或length为0");
                    return;
                }
                if (listFiles.length >= i10) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(listFiles));
                    Collections.sort(arrayList, new Comparator<File>() { // from class: com.alimm.tanx.core.log.tanxc_do.2
                        public AnonymousClass2() {
                        }

                        @Override // java.util.Comparator
                        /* renamed from: tanxc_do */
                        public int compare(File file2, File file22) {
                            return (int) (FileUtil.getFileName(file22) - FileUtil.getFileName(file2));
                        }
                    });
                    while (arrayList.size() - i10 >= 0) {
                        FileUtils.deleteFile((File) arrayList.get(arrayList.size() - 1));
                        arrayList.remove(arrayList.size() - 1);
                        Log.d("CacheLogManager", "ILog :judgeFileDelete(),超过文件阈值开始删除->当前文件个数" + listFiles.length);
                    }
                }
            } catch (Exception e10) {
                Log.e(ILog.TAG, LogUtils.getStackTraceMessage(e10));
            }
        }
    }

    public void tanxc_do(File file) {
        FileThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_do.3
            final /* synthetic */ File tanxc_do;

            public AnonymousClass3(File file2) {
                file = file2;
            }

            @Override // java.lang.Runnable
            public void run() {
                FileUtils.deleteFile(file);
            }
        });
    }
}
