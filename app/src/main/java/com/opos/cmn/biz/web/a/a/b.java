package com.opos.cmn.biz.web.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.bj;
import com.opos.cmn.an.g.f;
import com.opos.cmn.func.a.a;
import com.opos.cmn.func.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: e */
    private static String f16843e = "";

    /* renamed from: a */
    private Context f16844a;

    /* renamed from: b */
    private volatile boolean f16845b = false;

    /* renamed from: c */
    private com.opos.cmn.biz.web.a.b.b f16846c;

    /* renamed from: d */
    private ThreadPoolExecutor f16847d;

    /* renamed from: com.opos.cmn.biz.web.a.a.b$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16848a;

        /* renamed from: b */
        final /* synthetic */ com.opos.cmn.biz.web.a.b.a f16849b;

        /* renamed from: c */
        final /* synthetic */ CountDownLatch f16850c;

        AnonymousClass1(Context context, com.opos.cmn.biz.web.a.b.a aVar, CountDownLatch countDownLatch) {
            context = context;
            aVar = aVar;
            countDownLatch = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception, java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [com.opos.cmn.biz.web.a.a.b] */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.opos.cmn.biz.web.a.a.b] */
        /* JADX WARN: Type inference failed for: r3v4, types: [android.content.Context] */
        /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context] */
        @Override // java.lang.Runnable
        public void run() {
            String str = "download resource failed, url:";
            long j2 = 0;
            j2 = 0;
            j2 = 0;
            j2 = 0;
            j2 = 0;
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource", e2);
                str = e2;
            }
            try {
                try {
                    com.opos.cmn.func.a.b a2 = c.a(context, new a.C0385a().b(b.b(context, aVar.f16853a)).a(0).a(b.this.b(aVar.f16853a)).a(aVar.f16854b).a());
                    if (a2 == null || !a2.f17045a) {
                        com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                    } else {
                        com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource success:" + aVar);
                        File file = new File(b.b(context, aVar.f16853a));
                        if (file.exists()) {
                            file.setLastModified(System.currentTimeMillis());
                        }
                    }
                    countDownLatch.countDown();
                    ?? r0 = (countDownLatch.getCount() > 0L ? 1 : (countDownLatch.getCount() == 0L ? 0 : -1));
                    str = r0;
                    if (r0 <= 0) {
                        ?? r02 = b.this;
                        ?? r3 = context;
                        r02.c(r3);
                        str = r02;
                        j2 = r3;
                    }
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.c("WebViewCacheImpl", "download resource", e3);
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                    countDownLatch.countDown();
                    ?? r03 = (countDownLatch.getCount() > 0L ? 1 : (countDownLatch.getCount() == 0L ? 0 : -1));
                    str = r03;
                    if (r03 <= 0) {
                        ?? r04 = b.this;
                        ?? r32 = context;
                        r04.c(r32);
                        str = r04;
                        j2 = r32;
                    }
                }
            } catch (Throwable th) {
                try {
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", str + aVar);
                    countDownLatch.countDown();
                    if (countDownLatch.getCount() <= j2) {
                        b.this.c(context);
                    }
                } catch (Exception e4) {
                    com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource", e4);
                }
                throw th;
            }
        }
    }

    /* renamed from: com.opos.cmn.biz.web.a.a.b$2 */
    class AnonymousClass2 implements Comparator<File> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.lastModified() - file2.lastModified() > 0 ? 1 : -1;
        }
    }

    public static List<File> a(Context context) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        try {
            String b2 = b(context);
            if (com.opos.cmn.an.d.b.a.b(b2) && (listFiles = new File(b2).listFiles()) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file != null) {
                        if (!TextUtils.isEmpty(file.getName()) && file.getName().endsWith(".adweb")) {
                            arrayList.add(file);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WebViewCacheImpl", "", e2);
        }
        return arrayList;
    }

    private void a(Context context, List<com.opos.cmn.biz.web.a.b.a> list) {
        com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource");
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        for (com.opos.cmn.biz.web.a.b.a aVar : list) {
            if (aVar != null) {
                try {
                    if (!TextUtils.isEmpty(aVar.f16853a)) {
                        this.f16847d.execute(new Runnable() { // from class: com.opos.cmn.biz.web.a.a.b.1

                            /* renamed from: a */
                            final /* synthetic */ Context f16848a;

                            /* renamed from: b */
                            final /* synthetic */ com.opos.cmn.biz.web.a.b.a f16849b;

                            /* renamed from: c */
                            final /* synthetic */ CountDownLatch f16850c;

                            AnonymousClass1(Context context2, com.opos.cmn.biz.web.a.b.a aVar2, CountDownLatch countDownLatch2) {
                                context = context2;
                                aVar = aVar2;
                                countDownLatch = countDownLatch2;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception, java.lang.Throwable] */
                            /* JADX WARN: Type inference failed for: r0v15, types: [int] */
                            /* JADX WARN: Type inference failed for: r0v16, types: [com.opos.cmn.biz.web.a.a.b] */
                            /* JADX WARN: Type inference failed for: r0v21, types: [int] */
                            /* JADX WARN: Type inference failed for: r0v22, types: [com.opos.cmn.biz.web.a.a.b] */
                            /* JADX WARN: Type inference failed for: r3v4, types: [android.content.Context] */
                            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context] */
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = "download resource failed, url:";
                                long j2 = 0;
                                j2 = 0;
                                j2 = 0;
                                j2 = 0;
                                j2 = 0;
                                try {
                                } catch (Exception e2) {
                                    com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource", e2);
                                    str = e2;
                                }
                                try {
                                    try {
                                        com.opos.cmn.func.a.b a2 = c.a(context, new a.C0385a().b(b.b(context, aVar.f16853a)).a(0).a(b.this.b(aVar.f16853a)).a(aVar.f16854b).a());
                                        if (a2 == null || !a2.f17045a) {
                                            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                                        } else {
                                            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource success:" + aVar);
                                            File file = new File(b.b(context, aVar.f16853a));
                                            if (file.exists()) {
                                                file.setLastModified(System.currentTimeMillis());
                                            }
                                        }
                                        countDownLatch.countDown();
                                        ?? r0 = (countDownLatch.getCount() > 0L ? 1 : (countDownLatch.getCount() == 0L ? 0 : -1));
                                        str = r0;
                                        if (r0 <= 0) {
                                            ?? r02 = b.this;
                                            ?? r3 = context;
                                            r02.c(r3);
                                            str = r02;
                                            j2 = r3;
                                        }
                                    } catch (Exception e3) {
                                        com.opos.cmn.an.f.a.c("WebViewCacheImpl", "download resource", e3);
                                        com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                                        countDownLatch.countDown();
                                        ?? r03 = (countDownLatch.getCount() > 0L ? 1 : (countDownLatch.getCount() == 0L ? 0 : -1));
                                        str = r03;
                                        if (r03 <= 0) {
                                            ?? r04 = b.this;
                                            ?? r32 = context;
                                            r04.c(r32);
                                            str = r04;
                                            j2 = r32;
                                        }
                                    }
                                } catch (Throwable th) {
                                    try {
                                        com.opos.cmn.an.f.a.b("WebViewCacheImpl", str + aVar);
                                        countDownLatch.countDown();
                                        if (countDownLatch.getCount() <= j2) {
                                            b.this.c(context);
                                        }
                                    } catch (Exception e4) {
                                        com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource", e4);
                                    }
                                    throw th;
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", "downloadUrl url:" + aVar2 + " :fail", e2);
                }
            }
        }
    }

    public f b(String str) {
        try {
            return new f.a().b(str).a("GET").a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("WebViewCacheImpl", "getNetRequest fail", e2);
            return null;
        }
    }

    private static String b(Context context) {
        if (TextUtils.isEmpty(f16843e)) {
            try {
                f16843e = context.getExternalFilesDir("") + File.separator + ".opos_ad_webview_cache";
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("WebViewCacheImpl", "getMatSaveFolder fail", e2);
            }
        }
        return f16843e;
    }

    public static String b(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return b(context) + File.separator + com.opos.cmn.an.a.c.a(str) + ".adweb";
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("WebViewCacheImpl", "getMatSavePath fail", e2);
        }
        return "";
    }

    public void c(Context context) {
        String str;
        com.opos.cmn.an.f.a.b("WebViewCacheImpl", "tryRecycleCache");
        try {
            List<File> a2 = a(context);
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            ArrayList<File> arrayList = new ArrayList();
            long j2 = 0;
            for (File file : a2) {
                if (file.lastModified() <= System.currentTimeMillis() - bj.f5599d) {
                    String name = file.getName();
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", com.opos.cmn.an.d.b.a.e(file) ? "delete mat file success.file path=" + name : "delete mat file  fail.file path=" + name);
                } else {
                    arrayList.add(file);
                    j2 = file.length() + j2;
                }
            }
            if (j2 > this.f16846c.f16857a) {
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.opos.cmn.biz.web.a.a.b.2
                    AnonymousClass2() {
                    }

                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file22) {
                        return file2.lastModified() - file22.lastModified() > 0 ? 1 : -1;
                    }
                });
                for (File file2 : arrayList) {
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", "noPeriodMat=" + file2.getName() + " lastModified:" + file2.lastModified());
                }
                for (File file3 : arrayList) {
                    String name2 = file3.getName();
                    long length = file3.length();
                    if (com.opos.cmn.an.d.b.a.e(file3)) {
                        j2 -= length;
                        str = "delete mat file success.file path=" + name2;
                    } else {
                        str = "delete mat file  fail.file path=" + name2;
                    }
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", str);
                    if (j2 <= this.f16846c.f16857a) {
                        break;
                    }
                }
            }
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "tryRecycleCache nowCachedSize:" + (j2 / 1048576.0f) + "M maxCacheSize:" + (this.f16846c.f16857a / 1048576.0f) + "M");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "tryRecycleCache", e2);
        }
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public WebResourceResponse a(String str) {
        if (this.f16845b) {
            try {
                File file = new File(b(this.f16844a, str));
                if (file.exists()) {
                    WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)), "", new FileInputStream(file));
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", "loadResourceFormLocalCache from cache:" + str);
                    return webResourceResponse;
                }
                com.opos.cmn.an.f.a.b("WebViewCacheImpl", "loadResourceFormLocalCache cache not exits:" + str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("WebViewCacheImpl", "loadResourceFormLocalCache url:" + str, e2);
            }
        } else {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "please call init first");
        }
        return null;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(Context context, com.opos.cmn.biz.web.a.b.b bVar) {
        if (this.f16845b) {
            return;
        }
        this.f16844a = context.getApplicationContext();
        this.f16846c = bVar;
        this.f16847d = new ThreadPoolExecutor(0, this.f16846c.f16858b, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.opos.cmn.biz.web.a.a.a.b("web_cache"), new ThreadPoolExecutor.DiscardPolicy());
        this.f16845b = true;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(List<com.opos.cmn.biz.web.a.b.a> list) {
        if (!this.f16845b) {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "please call init first");
            return;
        }
        com.opos.cmn.an.f.a.c("WebViewCacheImpl", "startCacheResource");
        if (this.f16844a == null || list == null || list.size() <= 0) {
            return;
        }
        a(this.f16844a, list);
    }
}
