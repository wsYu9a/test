package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bb;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class ApkCacheManager {
    private Future amr;
    private File axw;
    private final ExecutorService axx;
    private final Callable<Void> axy;

    /* renamed from: com.kwad.sdk.core.diskcache.ApkCacheManager$1 */
    public class AnonymousClass1 implements Callable<Void> {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ew */
        public Void call() {
            synchronized (ApkCacheManager.class) {
                try {
                    if (ApkCacheManager.this.axw != null && ApkCacheManager.this.axw.exists() && !ApkCacheManager.this.Eu()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.n(apkCacheManager.axw)) {
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.h(file);
                                if (ApkCacheManager.this.Eu()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                } finally {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.ApkCacheManager$2 */
    public class AnonymousClass2 implements Comparator<File> {
        public AnonymousClass2() {
        }

        private static int c(File file, File file2) {
            if (file.lastModified() >= file2.lastModified()) {
                return file.lastModified() == file2.lastModified() ? 0 : 1;
            }
            return -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return c(file, file2);
        }
    }

    public enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        Holder() {
        }

        public final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ ApkCacheManager(byte b10) {
        this();
    }

    public boolean Eu() {
        File file = this.axw;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.axw.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && l(this.axw) <= 400;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public void h(File file) {
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
                h(file2);
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    private int l(File file) {
        return (int) ((m(file) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        File[] listFiles = file.listFiles();
        long j10 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i10 = 0; i10 < length; i10++) {
                j10 += listFiles[i10].isDirectory() ? m(listFiles[i10]) : listFiles[i10].length();
            }
        }
        return j10;
    }

    public List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        v(arrayList);
        return arrayList;
    }

    private void v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            public AnonymousClass2() {
            }

            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }
        });
    }

    public final void Ev() {
        File file = this.axw;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.amr;
        if (future == null || future.isDone()) {
            this.amr = this.axx.submit(this.axy);
        }
    }

    private ApkCacheManager() {
        this.axx = GlobalThreadPools.Hs();
        this.axy = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            public AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: Ew */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    try {
                        if (ApkCacheManager.this.axw != null && ApkCacheManager.this.axw.exists() && !ApkCacheManager.this.Eu()) {
                            ApkCacheManager apkCacheManager = ApkCacheManager.this;
                            for (File file : apkCacheManager.n(apkCacheManager.axw)) {
                                if (file.getName().endsWith(".apk")) {
                                    ApkCacheManager.this.h(file);
                                    if (ApkCacheManager.this.Eu()) {
                                        return null;
                                    }
                                }
                            }
                            return null;
                        }
                        return null;
                    } finally {
                    }
                }
            }
        };
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.axw = bb.de(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }
}
