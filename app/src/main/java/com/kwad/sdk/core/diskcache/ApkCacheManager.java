package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.av;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class ApkCacheManager {
    private Future aei;
    private File aej;
    private final ExecutorService aek;
    private final Callable<Void> ael;

    /* renamed from: com.kwad.sdk.core.diskcache.ApkCacheManager$1 */
    final class AnonymousClass1 implements Callable<Void> {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: vi */
        public Void call() {
            synchronized (ApkCacheManager.class) {
                if (ApkCacheManager.this.aej != null && ApkCacheManager.this.aej.exists() && !ApkCacheManager.this.vg()) {
                    ApkCacheManager apkCacheManager = ApkCacheManager.this;
                    for (File file : apkCacheManager.i(apkCacheManager.aej)) {
                        if (file.getName().endsWith(".apk")) {
                            ApkCacheManager.this.c(file);
                            if (ApkCacheManager.this.vg()) {
                                return null;
                            }
                        }
                    }
                    return null;
                }
                return null;
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.ApkCacheManager$2 */
    final class AnonymousClass2 implements Comparator<File> {
        AnonymousClass2() {
        }

        private static int a(File file, File file2) {
            if (file.lastModified() >= file2.lastModified()) {
                return file.lastModified() == file2.lastModified() ? 0 : 1;
            }
            return -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return a(file, file2);
        }
    }

    enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        Holder() {
        }

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    private ApkCacheManager() {
        this.aek = GlobalThreadPools.xU();
        this.ael = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: vi */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.aej != null && ApkCacheManager.this.aej.exists() && !ApkCacheManager.this.vg()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.i(apkCacheManager.aej)) {
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.c(file);
                                if (ApkCacheManager.this.vg()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        try {
            this.aej = av.cB(((e) ServiceProvider.get(e.class)).getContext());
        } catch (Throwable unused) {
        }
    }

    /* synthetic */ ApkCacheManager(byte b2) {
        this();
    }

    public void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            }
            for (File file2 : file.listFiles()) {
                c(file2);
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    private int g(File file) {
        return (int) ((h(file) / 1000.0f) / 1000.0f);
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private long h(File file) {
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                j2 += listFiles[i2].isDirectory() ? h(listFiles[i2]) : listFiles[i2].length();
            }
        }
        return j2;
    }

    public List<File> i(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        m(arrayList);
        return arrayList;
    }

    private void m(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            AnonymousClass2() {
            }

            private static int a(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return a(file, file2);
            }
        });
    }

    public boolean vg() {
        File file = this.aej;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.aej.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && g(this.aej) <= 400;
        }
        return true;
    }

    public final void vh() {
        File file = this.aej;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.aei;
        if (future == null || future.isDone()) {
            this.aei = this.aek.submit(this.ael);
        }
    }
}
