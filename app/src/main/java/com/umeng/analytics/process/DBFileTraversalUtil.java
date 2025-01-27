package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class DBFileTraversalUtil {

    /* renamed from: a */
    private static ExecutorService f26032a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static FileLockUtil f26033b = new FileLockUtil();

    /* renamed from: com.umeng.analytics.process.DBFileTraversalUtil$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f26034a;

        /* renamed from: b */
        final /* synthetic */ FileLockCallback f26035b;

        /* renamed from: c */
        final /* synthetic */ a f26036c;

        AnonymousClass1(File file, FileLockCallback fileLockCallback, a aVar) {
            file = file;
            fileLockCallback = fileLockCallback;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (File file : file.listFiles()) {
                    if (file.getName().endsWith(com.umeng.analytics.process.a.f26055d)) {
                        DBFileTraversalUtil.f26033b.doFileOperateion(file, fileLockCallback);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file.getName());
                    }
                }
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Throwable unused) {
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
        }
    }

    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, FileLockCallback fileLockCallback, a aVar) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f26032a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1

                /* renamed from: a */
                final /* synthetic */ File f26034a;

                /* renamed from: b */
                final /* synthetic */ FileLockCallback f26035b;

                /* renamed from: c */
                final /* synthetic */ a f26036c;

                AnonymousClass1(File file2, FileLockCallback fileLockCallback2, a aVar2) {
                    file = file2;
                    fileLockCallback = fileLockCallback2;
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        for (File file2 : file.listFiles()) {
                            if (file2.getName().endsWith(com.umeng.analytics.process.a.f26055d)) {
                                DBFileTraversalUtil.f26033b.doFileOperateion(file2, fileLockCallback);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                            }
                        }
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}
