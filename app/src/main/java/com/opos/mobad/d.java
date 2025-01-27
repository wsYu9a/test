package com.opos.mobad;

import android.content.Context;
import android.os.Build;
import com.opos.mobad.e.a.n;
import com.opos.mobad.n.b;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* loaded from: classes4.dex */
final class d {

    /* renamed from: a */
    private Context f20365a;

    /* renamed from: com.opos.mobad.d$1 */
    class AnonymousClass1 implements com.opos.mobad.n.b {

        /* renamed from: a */
        final /* synthetic */ Context f20366a;

        /* renamed from: com.opos.mobad.d$1$1 */
        class C04381 implements com.opos.mobad.e.a.h {

            /* renamed from: a */
            final /* synthetic */ b.a f20368a;

            C04381(b.a aVar) {
                aVar = aVar;
            }

            @Override // com.opos.mobad.e.a.h
            public void a(boolean z, String str) {
                b.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(z, str);
                }
            }
        }

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.opos.mobad.n.b
        public void a(String str) {
            com.opos.mobad.cmn.service.b.a.a().a(str);
        }

        @Override // com.opos.mobad.n.b
        public void a(String str, b.a aVar) {
            File a2 = com.opos.mobad.cmn.service.b.a.a().a(context, str);
            if (a2 != null) {
                n.a(str, a2.getAbsolutePath(), new com.opos.mobad.e.a.h() { // from class: com.opos.mobad.d.1.1

                    /* renamed from: a */
                    final /* synthetic */ b.a f20368a;

                    C04381(b.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // com.opos.mobad.e.a.h
                    public void a(boolean z, String str2) {
                        b.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(z, str2);
                        }
                    }
                });
            } else if (aVar2 != null) {
                aVar2.a(false, "");
            }
        }
    }

    /* renamed from: com.opos.mobad.d$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20370a;

        AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            try {
                File file = new File(com.opos.cmn.d.c.b(context));
                if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                for (File file2 : listFiles) {
                    if (file2 != null) {
                        if (file2.exists() && file2.isFile()) {
                            com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                            com.opos.cmn.an.f.a.b("InterMobAdManager", (file2.lastModified() + 432000000 >= System.currentTimeMillis() || !file2.delete()) ? "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",don't need delete file=" + file2.getName() : "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",need delete file=" + file2.getName());
                        }
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.d$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.d();
            d.this.e();
            d.this.f();
            d.this.g();
            d.this.h();
        }
    }

    /* renamed from: com.opos.mobad.d$4 */
    class AnonymousClass4 implements Comparator<File> {
        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }
    }

    /* renamed from: com.opos.mobad.d$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InterMobAdManager", "startClearRewardSP");
            Map<String, Long> b2 = com.opos.mobad.cmn.a.b.f.b(d.this.f20365a);
            if (b2 == null || b2.size() <= 0) {
                return;
            }
            for (Map.Entry<String, Long> entry : b2.entrySet()) {
                if (entry.getValue().longValue() + 259200000 < com.opos.cmn.b.a.a.c()) {
                    com.opos.cmn.an.f.a.b("InterMobAdManager", "remove pkgName=" + entry.getKey() + ",timestamp=" + entry.getValue());
                    com.opos.mobad.cmn.a.b.f.e(d.this.f20365a, entry.getKey());
                }
            }
        }
    }

    private void a(Context context) {
        String str = Build.BRAND;
        if (str == null) {
            str = "";
        }
        com.opos.cmn.an.b.a.a(context, str);
        com.opos.mobad.cmn.service.pkginstall.c.a().a(context);
        com.opos.mobad.d.d.a().a(context);
        com.opos.mobad.cmn.service.b.a.a().a(context, str, com.opos.cmn.a.a.b());
        com.opos.mobad.o.e.b.a().a(new com.opos.mobad.n.b() { // from class: com.opos.mobad.d.1

            /* renamed from: a */
            final /* synthetic */ Context f20366a;

            /* renamed from: com.opos.mobad.d$1$1 */
            class C04381 implements com.opos.mobad.e.a.h {

                /* renamed from: a */
                final /* synthetic */ b.a f20368a;

                C04381(b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.opos.mobad.e.a.h
                public void a(boolean z, String str2) {
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(z, str2);
                    }
                }
            }

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.opos.mobad.n.b
            public void a(String str2) {
                com.opos.mobad.cmn.service.b.a.a().a(str2);
            }

            @Override // com.opos.mobad.n.b
            public void a(String str2, b.a aVar2) {
                File a2 = com.opos.mobad.cmn.service.b.a.a().a(context, str2);
                if (a2 != null) {
                    n.a(str2, a2.getAbsolutePath(), new com.opos.mobad.e.a.h() { // from class: com.opos.mobad.d.1.1

                        /* renamed from: a */
                        final /* synthetic */ b.a f20368a;

                        C04381(b.a aVar22) {
                            aVar = aVar22;
                        }

                        @Override // com.opos.mobad.e.a.h
                        public void a(boolean z, String str22) {
                            b.a aVar22 = aVar;
                            if (aVar22 != null) {
                                aVar22.a(z, str22);
                            }
                        }
                    });
                } else if (aVar22 != null) {
                    aVar22.a(false, "");
                }
            }
        });
    }

    private void a(File file, long j2, int i2) {
        String str;
        File[] listFiles;
        StringBuilder sb;
        String str2;
        if (file.exists() && file.isDirectory()) {
            long e2 = com.opos.cmn.an.d.b.a.e(file.getAbsolutePath());
            int b2 = com.opos.mobad.cmn.a.b.f.b(file.getAbsolutePath());
            if (e2 >= j2 || b2 >= i2) {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "video cache size over max size or over max count,start clear video cache.");
                if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.opos.mobad.d.4
                    AnonymousClass4() {
                    }

                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file22) {
                        long lastModified = file2.lastModified() - file22.lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        return lastModified == 0 ? 0 : -1;
                    }

                    @Override // java.util.Comparator
                    public boolean equals(Object obj) {
                        return true;
                    }
                });
                for (int i3 = 0; i3 < listFiles.length / 2; i3++) {
                    File file2 = listFiles[i3];
                    if (file2 != null && file2.exists() && file2.isFile()) {
                        com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                        if (file2.delete()) {
                            sb = new StringBuilder();
                            sb.append("file.lastModified()=");
                            sb.append(file2.lastModified());
                            sb.append(",System.currentTimeMillis()=");
                            sb.append(com.opos.cmn.b.a.a.b());
                            str2 = ",need delete file=";
                        } else {
                            sb = new StringBuilder();
                            sb.append("file.lastModified()=");
                            sb.append(file2.lastModified());
                            sb.append(",System.currentTimeMillis()=");
                            sb.append(com.opos.cmn.b.a.a.b());
                            str2 = ",don't need delete file=";
                        }
                        sb.append(str2);
                        sb.append(file2.getName());
                        com.opos.cmn.an.f.a.b("InterMobAdManager", sb.toString());
                    }
                }
                return;
            }
            str = "video cache size not over max size or over max count,don't need clear video cache.";
        } else {
            str = "folder not exist";
        }
        com.opos.cmn.an.f.a.b("InterMobAdManager", str);
    }

    private void b(Context context) {
        Context applicationContext = context.getApplicationContext();
        com.opos.cmn.an.e.c.a().b();
        com.opos.mobad.cmn.service.pkginstall.b.a(applicationContext).a();
        com.opos.mobad.cmn.service.pkginstall.c.a().b(applicationContext);
        com.opos.mobad.cmn.service.a.a.a(applicationContext).a();
    }

    private void c() {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.d.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.d();
                d.this.e();
                d.this.f();
                d.this.g();
                d.this.h();
            }
        });
    }

    private void c(Context context) {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.d.2

            /* renamed from: a */
            final /* synthetic */ Context f20370a;

            AnonymousClass2(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    File file = new File(com.opos.cmn.d.c.b(context));
                    if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            if (file2.exists() && file2.isFile()) {
                                com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                                com.opos.cmn.an.f.a.b("InterMobAdManager", (file2.lastModified() + 432000000 >= System.currentTimeMillis() || !file2.delete()) ? "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",don't need delete file=" + file2.getName() : "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",need delete file=" + file2.getName());
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
                }
            }
        });
    }

    public void d() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicVideoCache");
        try {
            if (com.opos.cmn.d.d.a(this.f20365a)) {
                a(new File(com.opos.cmn.d.d.a()), DownloadConstants.GB, 50);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
        }
    }

    public void e() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPrivateVideoCache");
        try {
            a(new File(com.opos.cmn.d.d.b(this.f20365a)), 536870912L, 25);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
        }
    }

    public void f() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicDownloadApkCache");
        try {
            if (com.opos.cmn.d.a.a(this.f20365a)) {
                a(new File(com.opos.cmn.d.a.a()), DownloadConstants.GB, 50);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
        }
    }

    public void g() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPrivateDownloadApkCache");
        try {
            a(new File(com.opos.cmn.d.a.c(this.f20365a)), 536870912L, 25);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
        }
    }

    public void h() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearDynamicUnzipDir");
        try {
            com.opos.mobad.service.c.b.a().b(this.f20365a);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
        }
    }

    public void a() {
        Context context;
        if (com.opos.mobad.cmn.a.b.f.d()) {
            try {
                if (!com.opos.mobad.cmn.a.b.f.c() || (context = this.f20365a) == null) {
                    return;
                }
                b(context);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e2);
            }
        }
    }

    public void a(Context context, String str) {
        try {
            this.f20365a = context.getApplicationContext();
            com.opos.mobad.cmn.a.b.f.a(str);
            com.opos.cmn.an.f.a.b("InterMobAdManager", "init sdk success.");
            a(this.f20365a);
            com.opos.mobad.cmn.a.b.f.b();
            c(this.f20365a);
            c();
            b();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("InterMobAdManager", "init", e2);
        }
    }

    public void b() {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.d.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "startClearRewardSP");
                Map<String, Long> b2 = com.opos.mobad.cmn.a.b.f.b(d.this.f20365a);
                if (b2 == null || b2.size() <= 0) {
                    return;
                }
                for (Map.Entry<String, Long> entry : b2.entrySet()) {
                    if (entry.getValue().longValue() + 259200000 < com.opos.cmn.b.a.a.c()) {
                        com.opos.cmn.an.f.a.b("InterMobAdManager", "remove pkgName=" + entry.getKey() + ",timestamp=" + entry.getValue());
                        com.opos.mobad.cmn.a.b.f.e(d.this.f20365a, entry.getKey());
                    }
                }
            }
        });
    }
}
