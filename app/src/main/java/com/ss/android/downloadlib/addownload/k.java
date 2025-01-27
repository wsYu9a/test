package com.ss.android.downloadlib.addownload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    public static final JSONObject f21467a = new JSONObject();

    /* renamed from: b */
    private static Context f21468b;

    /* renamed from: c */
    private static com.ss.android.download.api.config.g f21469c;

    /* renamed from: d */
    private static com.ss.android.download.api.config.c f21470d;

    /* renamed from: e */
    private static com.ss.android.download.api.config.l f21471e;

    /* renamed from: f */
    private static com.ss.android.download.api.config.h f21472f;

    /* renamed from: g */
    private static com.ss.android.download.api.config.i f21473g;

    /* renamed from: h */
    private static com.ss.android.download.api.config.j f21474h;

    /* renamed from: i */
    private static com.ss.android.download.api.model.a f21475i;

    /* renamed from: j */
    private static com.ss.android.download.api.config.b f21476j;

    /* renamed from: k */
    private static com.ss.android.socialbase.appdownloader.c.h f21477k;

    /* renamed from: l */
    private static com.ss.android.download.api.config.d f21478l;

    /* renamed from: m */
    private static com.ss.android.download.api.config.e f21479m;

    /* renamed from: n */
    private static o f21480n;

    /* renamed from: o */
    private static com.ss.android.download.api.config.k f21481o;

    /* renamed from: p */
    private static u f21482p;

    /* renamed from: q */
    private static com.ss.android.download.api.config.n f21483q;

    /* renamed from: r */
    private static com.ss.android.download.api.config.m f21484r;

    /* renamed from: s */
    private static p f21485s;

    /* renamed from: t */
    private static com.ss.android.download.api.b.a f21486t;

    /* renamed from: u */
    private static q f21487u;

    /* renamed from: v */
    private static s f21488v;

    /* renamed from: com.ss.android.downloadlib.addownload.k$1 */
    public static class AnonymousClass1 implements com.ss.android.download.api.config.c {
        @Override // com.ss.android.download.api.config.c
        public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
        }

        @Override // com.ss.android.download.api.config.c
        public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$2 */
    public static class AnonymousClass2 implements com.ss.android.socialbase.appdownloader.c.h {
        @Override // com.ss.android.socialbase.appdownloader.c.h
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i10) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$3 */
    public static class AnonymousClass3 implements p {
        @Override // com.ss.android.download.api.config.p
        public void a(String str, int i10, JSONObject jSONObject) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$4 */
    public static class AnonymousClass4 implements com.ss.android.download.api.b.a {
        @Override // com.ss.android.download.api.b.a
        public void a(Throwable th2, String str) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$5 */
    public static class AnonymousClass5 implements s {
        @Override // com.ss.android.download.api.config.s
        public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i10) {
        }
    }

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f21468b = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f21468b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f21468b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.c c() {
        if (f21470d == null) {
            f21470d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.k.1
                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f21470d;
    }

    @NonNull
    public static com.ss.android.download.api.config.l d() {
        if (f21471e == null) {
            f21471e = new com.ss.android.download.api.a.a();
        }
        return f21471e;
    }

    public static com.ss.android.download.api.config.h e() {
        return f21472f;
    }

    @NonNull
    public static com.ss.android.download.api.config.i f() {
        if (f21473g == null) {
            f21473g = new com.ss.android.download.api.a.b();
        }
        return f21473g;
    }

    public static com.ss.android.socialbase.appdownloader.c.h g() {
        if (f21477k == null) {
            f21477k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.k.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i10) {
                }
            };
        }
        return f21477k;
    }

    public static o h() {
        return f21480n;
    }

    @NonNull
    public static p i() {
        if (f21485s == null) {
            f21485s = new p() { // from class: com.ss.android.downloadlib.addownload.k.3
                @Override // com.ss.android.download.api.config.p
                public void a(String str, int i10, JSONObject jSONObject) {
                }
            };
        }
        return f21485s;
    }

    @NonNull
    public static JSONObject j() {
        com.ss.android.download.api.config.j jVar = f21474h;
        return (jVar == null || jVar.a() == null) ? f21467a : f21474h.a();
    }

    @NonNull
    public static com.ss.android.download.api.model.a k() {
        if (f21475i == null) {
            f21475i = new a.C0630a().a();
        }
        return f21475i;
    }

    public static com.ss.android.download.api.config.m l() {
        return f21484r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b m() {
        return f21476j;
    }

    @Nullable
    public static com.ss.android.download.api.config.n n() {
        return f21483q;
    }

    public static String o() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.d p() {
        return f21478l;
    }

    public static com.ss.android.download.api.config.e q() {
        return f21479m;
    }

    public static com.ss.android.download.api.config.k r() {
        return f21481o;
    }

    @NonNull
    public static q s() {
        return f21487u;
    }

    public static u t() {
        return f21482p;
    }

    @NonNull
    public static com.ss.android.download.api.b.a u() {
        if (f21486t == null) {
            f21486t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.k.4
                @Override // com.ss.android.download.api.b.a
                public void a(Throwable th2, String str) {
                }
            };
        }
        return f21486t;
    }

    @NonNull
    public static s v() {
        if (f21488v == null) {
            f21488v = new s() { // from class: com.ss.android.downloadlib.addownload.k.5
                @Override // com.ss.android.download.api.config.s
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i10) {
                }
            };
        }
        return f21488v;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0 > 29) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        return a().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String w() {
        /*
            android.content.Context r0 = a()     // Catch: java.lang.Throwable -> L52
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> L52
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Throwable -> L52
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L52
            r2 = 29
            if (r1 < r2) goto L29
            if (r0 != r2) goto L18
            boolean r1 = y3.a.a()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L1a
        L18:
            if (r0 <= r2) goto L29
        L1a:
            android.content.Context r0 = a()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L52
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L52
            return r0
        L29:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            org.json.JSONObject r1 = j()     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "default_save_dir_name"
            java.lang.String r3 = "ByteDownload"
            java.lang.String r1 = r1.optString(r2, r3)     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            return r0
        L52:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.k.w():java.lang.String");
    }

    public static boolean x() {
        return (f21469c == null || f21472f == null || f21474h == null || f21476j == null || f21487u == null) ? false : true;
    }

    public static com.ss.android.download.api.config.g b() {
        return f21469c;
    }

    public static Context a() {
        Context context = f21468b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        f21469c = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.l lVar) {
        f21471e = lVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f21472f = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        f21473g = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.j jVar) {
        f21474h = jVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        f21475i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        f21476j = bVar;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static void a(q qVar) {
        f21487u = qVar;
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        f21486t = aVar;
    }
}
