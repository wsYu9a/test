package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private Handler f21350a;

    /* renamed from: b */
    private com.ss.android.downloadlib.addownload.b.e f21351b;

    /* renamed from: c */
    private AtomicBoolean f21352c = new AtomicBoolean(false);

    /* renamed from: d */
    private AtomicBoolean f21353d = new AtomicBoolean(false);

    /* renamed from: com.ss.android.downloadlib.addownload.d$1 */
    public class AnonymousClass1 implements e.b {

        /* renamed from: a */
        final /* synthetic */ int f21354a;

        /* renamed from: b */
        final /* synthetic */ String f21355b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21356c;

        /* renamed from: d */
        final /* synthetic */ long f21357d;

        /* renamed from: e */
        final /* synthetic */ e.a f21358e;

        public AnonymousClass1(int i10, String str, com.ss.android.downloadad.api.a.b bVar, long j10, e.a aVar) {
            i10 = i10;
            downloadUrl = str;
            bVar = bVar;
            j10 = j10;
            aVar = aVar;
        }

        @Override // com.ss.android.downloadlib.addownload.e.b
        public void a(long j10) {
            d.this.a(i10, downloadUrl, j10, bVar, j10, aVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ e.a f21360a;

        public AnonymousClass2(e.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f21352c.get()) {
                return;
            }
            d.this.f21352c.set(true);
            aVar.a();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d$3 */
    public class AnonymousClass3 implements IFetchHttpHeadInfoListener {

        /* renamed from: a */
        final /* synthetic */ e.b f21362a;

        public AnonymousClass3(e.b bVar) {
            bVar2 = bVar;
        }

        @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
        public void onFetchFinished(Map<String, String> map) {
            if (d.this.f21352c.get()) {
                return;
            }
            d.this.f21352c.set(true);
            long a10 = d.this.a(map);
            if (a10 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(a10));
                    jSONObject.putOpt("available_space", Long.valueOf(d.d()));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
            bVar2.a(a10);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d$4 */
    public class AnonymousClass4 implements com.ss.android.downloadlib.addownload.c.e {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21364a;

        /* renamed from: b */
        final /* synthetic */ e.a f21365b;

        /* renamed from: c */
        final /* synthetic */ String f21366c;

        public AnonymousClass4(com.ss.android.downloadad.api.a.b bVar, e.a aVar, String str) {
            r2 = bVar;
            r3 = aVar;
            r4 = str;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ e.a f21368a;

        public AnonymousClass5(e.a aVar) {
            r2 = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.a();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d$6 */
    public static class AnonymousClass6 implements com.ss.android.downloadlib.addownload.c.e {
        public AnonymousClass6() {
        }
    }

    public d(Handler handler) {
        this.f21350a = handler;
    }

    public static long b() {
        if (k.n() != null) {
            return k.n().a();
        }
        return 0L;
    }

    public static long d() {
        return com.ss.android.downloadlib.g.m.b(0L);
    }

    private void b(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j10, long j11) {
        bVar.l("1");
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j11 - j10));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        this.f21351b = eVar;
    }

    public boolean a() {
        return this.f21353d.get();
    }

    public void a(boolean z10) {
        this.f21353d.set(z10);
    }

    public void a(int i10, long j10, long j11, e.a aVar) {
        this.f21353d.set(false);
        if (aVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.g.e.f(i10) && com.ss.android.downloadlib.g.e.e(i10)) {
            long c10 = com.ss.android.downloadlib.g.e.c(i10);
            this.f21352c.set(false);
            String downloadUrl = this.f21351b.f21217b.getDownloadUrl();
            com.ss.android.downloadad.api.a.b b10 = com.ss.android.downloadlib.addownload.b.f.a().b(downloadUrl);
            if (b10 == null) {
                com.ss.android.downloadlib.addownload.b.e eVar = this.f21351b;
                b10 = new com.ss.android.downloadad.api.a.b(eVar.f21217b, eVar.f21218c, eVar.f21219d, 0);
                com.ss.android.downloadlib.addownload.b.f.a().a(b10);
            }
            com.ss.android.downloadad.api.a.b bVar = b10;
            bVar.e(false);
            if (k.n() != null) {
                k.n().a(bVar.b());
            }
            com.ss.android.downloadlib.addownload.c.d.a().a(bVar.a());
            boolean d10 = com.ss.android.downloadlib.g.e.d(i10);
            if (j11 > 0) {
                a(i10, downloadUrl, j11, bVar, j10, aVar);
            } else if (d10) {
                a(downloadUrl, bVar, new e.b() { // from class: com.ss.android.downloadlib.addownload.d.1

                    /* renamed from: a */
                    final /* synthetic */ int f21354a;

                    /* renamed from: b */
                    final /* synthetic */ String f21355b;

                    /* renamed from: c */
                    final /* synthetic */ com.ss.android.downloadad.api.a.b f21356c;

                    /* renamed from: d */
                    final /* synthetic */ long f21357d;

                    /* renamed from: e */
                    final /* synthetic */ e.a f21358e;

                    public AnonymousClass1(int i102, String downloadUrl2, com.ss.android.downloadad.api.a.b bVar2, long j102, e.a aVar2) {
                        i10 = i102;
                        downloadUrl = downloadUrl2;
                        bVar = bVar2;
                        j10 = j102;
                        aVar = aVar2;
                    }

                    @Override // com.ss.android.downloadlib.addownload.e.b
                    public void a(long j102) {
                        d.this.a(i10, downloadUrl, j102, bVar, j10, aVar);
                    }
                });
            } else {
                c10 = 0;
            }
            this.f21350a.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.2

                /* renamed from: a */
                final /* synthetic */ e.a f21360a;

                public AnonymousClass2(e.a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f21352c.get()) {
                        return;
                    }
                    d.this.f21352c.set(true);
                    aVar.a();
                }
            }, c10);
            return;
        }
        aVar2.a();
    }

    private void a(String str, com.ss.android.downloadad.api.a.b bVar, e.b bVar2) {
        if (bVar2 == null) {
            return;
        }
        DownloadPreconnecter.asyncFetchHttpHeadInfo(str, new IFetchHttpHeadInfoListener() { // from class: com.ss.android.downloadlib.addownload.d.3

            /* renamed from: a */
            final /* synthetic */ e.b f21362a;

            public AnonymousClass3(e.b bVar22) {
                bVar2 = bVar22;
            }

            @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
            public void onFetchFinished(Map<String, String> map) {
                if (d.this.f21352c.get()) {
                    return;
                }
                d.this.f21352c.set(true);
                long a10 = d.this.a(map);
                if (a10 > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(a10));
                        jSONObject.putOpt("available_space", Long.valueOf(d.d()));
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
                bVar2.a(a10);
            }
        });
    }

    public long a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r18, java.lang.String r19, long r20, com.ss.android.downloadad.api.a.b r22, long r23, com.ss.android.downloadlib.addownload.e.a r25) {
        /*
            r17 = this;
            r8 = r17
            r1 = r20
            r9 = r22
            r10 = r25
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f21352c
            r11 = 1
            r0.set(r11)
            r3 = 0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L8c
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r0 = "apk_size"
            java.lang.Long r3 = java.lang.Long.valueOf(r20)     // Catch: org.json.JSONException -> L23
            r12.putOpt(r0, r3)     // Catch: org.json.JSONException -> L23
            goto L27
        L23:
            r0 = move-exception
            r0.printStackTrace()
        L27:
            double r3 = com.ss.android.downloadlib.g.e.a(r18)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            double r0 = (double) r1
            double r3 = r3 * r0
            java.lang.Double r0 = java.lang.Double.valueOf(r3)
            long r0 = r0.longValue()
            long r2 = com.ss.android.downloadlib.g.e.b(r18)
            long r0 = r0 + r2
            long r13 = r0 - r23
            long r15 = d()
            int r0 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r0 >= 0) goto L8c
            r1 = r17
            r2 = r22
            r3 = r12
            r4 = r13
            r6 = r15
            r1.a(r2, r3, r4, r6)
            a(r22)
            long r6 = d()
            int r0 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r0 >= 0) goto L83
            r9.d(r11)
            java.lang.String r0 = r22.a()
            com.ss.android.downloadlib.addownload.c.d r1 = com.ss.android.downloadlib.addownload.c.d.a()
            com.ss.android.downloadlib.addownload.d$4 r2 = new com.ss.android.downloadlib.addownload.d$4
            r2.<init>()
            r1.a(r0, r2)
            r1 = r17
            r2 = r18
            r3 = r22
            r4 = r19
            r5 = r13
            boolean r0 = r1.a(r2, r3, r4, r5)
            if (r0 == 0) goto L8d
            r9.e(r11)
            goto L8d
        L83:
            r1 = r17
            r2 = r22
            r3 = r12
            r4 = r15
            r1.b(r2, r3, r4, r6)
        L8c:
            r0 = 0
        L8d:
            if (r0 != 0) goto L99
            android.os.Handler r0 = r8.f21350a
            com.ss.android.downloadlib.addownload.d$5 r1 = new com.ss.android.downloadlib.addownload.d$5
            r1.<init>()
            r0.post(r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.d.a(int, java.lang.String, long, com.ss.android.downloadad.api.a.b, long, com.ss.android.downloadlib.addownload.e$a):void");
    }

    private boolean a(int i10, @NonNull com.ss.android.downloadad.api.a.b bVar, String str, long j10) {
        if (!com.ss.android.downloadlib.g.e.f(i10)) {
            return false;
        }
        if (k.n() != null) {
            return k.n().a(i10, str, true, j10);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject, bVar);
        return false;
    }

    public static boolean a(DownloadInfo downloadInfo, long j10) {
        int id2 = downloadInfo.getId();
        boolean z10 = false;
        if (!com.ss.android.downloadlib.g.e.f(id2)) {
            return false;
        }
        if (k.n() != null && (z10 = k.n().a(id2, downloadInfo.getUrl(), false, j10))) {
            com.ss.android.downloadlib.addownload.c.d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.6
                public AnonymousClass6() {
                }
            });
        }
        return z10;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(int i10) {
        if (com.ss.android.downloadlib.g.e.f(i10) && k.n() != null && k.n().b()) {
            k.n().c();
        }
    }

    private static void a(com.ss.android.downloadad.api.a.b bVar) {
        long d10 = d();
        if (k.n() != null) {
            k.n().e();
        }
        com.ss.android.downloadlib.addownload.c.c.a();
        com.ss.android.downloadlib.addownload.c.c.b();
        if (com.ss.android.downloadlib.g.e.g(bVar.s())) {
            com.ss.android.downloadlib.addownload.c.c.a(k.a());
        }
        long d11 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(d11 - d10));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_quite_finish", jSONObject, bVar);
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j10, long j11) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j11));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j10));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
    }
}
