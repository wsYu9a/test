package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.diskcache.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            File de2;
            d yW;
            synchronized (a.class) {
                try {
                    de2 = bb.de(context);
                } catch (Throwable th2) {
                    c.printStackTrace(th2);
                }
                if (de2.exists()) {
                    for (File file : a.n(de2)) {
                        if (file.getName().endsWith(".apk") && com.kwad.sdk.core.a.CA().de(file.getAbsolutePath()) != null && a.a(context, file) != null && (yW = com.kwad.sdk.c.yU().yW()) != null) {
                            yW.g(file);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a$2 */
    public class AnonymousClass2 implements Comparator<File> {
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

    public static PackageInfo a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getPath(), 65);
                    if (ao.getPackageInfo(context, packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e10) {
                c.printStackTrace(e10);
            }
        }
        return null;
    }

    public static void bl(Context context) {
        h.schedule(new bd() { // from class: com.kwad.sdk.core.diskcache.a.1
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                File de2;
                d yW;
                synchronized (a.class) {
                    try {
                        de2 = bb.de(context);
                    } catch (Throwable th2) {
                        c.printStackTrace(th2);
                    }
                    if (de2.exists()) {
                        for (File file : a.n(de2)) {
                            if (file.getName().endsWith(".apk") && com.kwad.sdk.core.a.CA().de(file.getAbsolutePath()) != null && a.a(context, file) != null && (yW = com.kwad.sdk.c.yU().yW()) != null) {
                                yW.g(file);
                            }
                        }
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    public static List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        v(arrayList);
        return arrayList;
    }

    private static void v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
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
}
