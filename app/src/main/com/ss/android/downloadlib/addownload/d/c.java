package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements g {

    /* renamed from: a */
    private static com.ss.android.downloadlib.addownload.a.d f21387a;

    /* renamed from: b */
    private static com.ss.android.downloadlib.addownload.a.c f21388b;

    /* renamed from: com.ss.android.downloadlib.addownload.d.c$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.a.d {

        /* renamed from: a */
        final /* synthetic */ int f21389a;

        /* renamed from: b */
        final /* synthetic */ int f21390b;

        /* renamed from: c */
        final /* synthetic */ int f21391c;

        /* renamed from: d */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21392d;

        /* renamed from: e */
        final /* synthetic */ h f21393e;

        public AnonymousClass1(int i10, int i11, int i12, com.ss.android.downloadad.api.a.b bVar, h hVar) {
            a10 = i10;
            i11 = i11;
            i11 = i12;
            bVar = bVar;
            hVar = hVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void a() {
            com.ss.android.downloadlib.addownload.a.d unused = c.f21387a = null;
            c.this.a(a10, i11, i11, bVar, "download_percent_cancel", "confirm");
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void b() {
            com.ss.android.downloadlib.addownload.a.d unused = c.f21387a = null;
            c.this.a(a10, i11, i11, bVar, "download_percent_cancel", "cancel");
            hVar.a(bVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d.c$2 */
    public class AnonymousClass2 implements com.ss.android.downloadlib.addownload.a.c {

        /* renamed from: a */
        final /* synthetic */ int f21395a;

        /* renamed from: b */
        final /* synthetic */ int f21396b;

        /* renamed from: c */
        final /* synthetic */ int f21397c;

        /* renamed from: d */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21398d;

        /* renamed from: e */
        final /* synthetic */ com.ss.android.downloadlib.addownload.a.c f21399e;

        public AnonymousClass2(int i10, int i11, int i12, com.ss.android.downloadad.api.a.b bVar, com.ss.android.downloadlib.addownload.a.c cVar) {
            a10 = i10;
            i11 = i11;
            i11 = i12;
            bVar = bVar;
            cVar = cVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.c
        public void a() {
            com.ss.android.downloadlib.addownload.a.d unused = c.f21387a = null;
            c.this.a(a10, i11, i11, bVar, "download_percent_cancel", "delete");
            cVar.a();
        }
    }

    public static com.ss.android.downloadlib.addownload.a.c b() {
        return f21388b;
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return f21387a;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        f21388b = cVar;
    }

    @Override // com.ss.android.downloadlib.addownload.d.g
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar, com.ss.android.downloadlib.addownload.a.c cVar) {
        DownloadInfo b10;
        String format;
        if (bVar == null || !a(bVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b10 = com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true);
        } else {
            b10 = com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a());
        }
        if (b10 == null) {
            return false;
        }
        long curBytes = b10.getCurBytes();
        long totalBytes = b10.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        int a10 = com.ss.android.downloadlib.addownload.j.a(b10.getId(), (int) ((100 * curBytes) / totalBytes));
        int i11 = (int) (curBytes / 1048576);
        boolean z10 = a10 > a(bVar.s());
        f21387a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.c.1

            /* renamed from: a */
            final /* synthetic */ int f21389a;

            /* renamed from: b */
            final /* synthetic */ int f21390b;

            /* renamed from: c */
            final /* synthetic */ int f21391c;

            /* renamed from: d */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21392d;

            /* renamed from: e */
            final /* synthetic */ h f21393e;

            public AnonymousClass1(int a102, int i112, int i1122, com.ss.android.downloadad.api.a.b bVar2, h hVar2) {
                a10 = a102;
                i11 = i1122;
                i11 = i1122;
                bVar = bVar2;
                hVar = hVar2;
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                com.ss.android.downloadlib.addownload.a.d unused = c.f21387a = null;
                c.this.a(a10, i11, i11, bVar, "download_percent_cancel", "confirm");
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                com.ss.android.downloadlib.addownload.a.d unused = c.f21387a = null;
                c.this.a(a10, i11, i11, bVar, "download_percent_cancel", "cancel");
                hVar.a(bVar);
            }
        };
        String a11 = m.a(com.ss.android.downloadlib.addownload.j.a(bVar2.s(), curBytes, totalBytes));
        if (z10) {
            format = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", a11, m.a(totalBytes - curBytes));
        } else {
            format = String.format("该任务已下载%s，即将下载完成，是否继续下载？", a11);
        }
        String str = format;
        if (cVar != null) {
            a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.d.c.2

                /* renamed from: a */
                final /* synthetic */ int f21395a;

                /* renamed from: b */
                final /* synthetic */ int f21396b;

                /* renamed from: c */
                final /* synthetic */ int f21397c;

                /* renamed from: d */
                final /* synthetic */ com.ss.android.downloadad.api.a.b f21398d;

                /* renamed from: e */
                final /* synthetic */ com.ss.android.downloadlib.addownload.a.c f21399e;

                public AnonymousClass2(int a102, int i1122, int i11222, com.ss.android.downloadad.api.a.b bVar2, com.ss.android.downloadlib.addownload.a.c cVar2) {
                    a10 = a102;
                    i11 = i11222;
                    i11 = i11222;
                    bVar = bVar2;
                    cVar = cVar2;
                }

                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    com.ss.android.downloadlib.addownload.a.d unused = c.f21387a = null;
                    c.this.a(a10, i11, i11, bVar, "download_percent_cancel", "delete");
                    cVar.a();
                }
            });
        }
        TTDelegateActivity.b(bVar2, str, "继续", "暂停", "删除");
        return true;
    }

    private int a(int i10) {
        return DownloadSetting.obtain(i10).optInt("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).optInt("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && aVar.q();
    }

    public void a(int i10, int i11, int i12, com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i10));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i11));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i12));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_cancel_optimise", jSONObject, bVar);
    }
}
