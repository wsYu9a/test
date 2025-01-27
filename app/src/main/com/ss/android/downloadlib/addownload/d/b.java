package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements g {

    /* renamed from: a */
    private static com.ss.android.downloadlib.addownload.a.d f21375a;

    /* renamed from: b */
    private static com.ss.android.downloadlib.addownload.a.c f21376b;

    /* renamed from: com.ss.android.downloadlib.addownload.d.b$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.a.d {

        /* renamed from: a */
        final /* synthetic */ int f21377a;

        /* renamed from: b */
        final /* synthetic */ int f21378b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21379c;

        /* renamed from: d */
        final /* synthetic */ h f21380d;

        public AnonymousClass1(int i10, int i11, com.ss.android.downloadad.api.a.b bVar, h hVar) {
            i11 = i10;
            i11 = i11;
            bVar = bVar;
            hVar = hVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void a() {
            com.ss.android.downloadlib.addownload.a.d unused = b.f21375a = null;
            b.this.a(i11, i11, bVar, "apk_size_cancel", "confirm");
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void b() {
            com.ss.android.downloadlib.addownload.a.d unused = b.f21375a = null;
            b.this.a(i11, i11, bVar, "apk_size_cancel", "cancel");
            hVar.a(bVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d.b$2 */
    public class AnonymousClass2 implements com.ss.android.downloadlib.addownload.a.c {

        /* renamed from: a */
        final /* synthetic */ int f21382a;

        /* renamed from: b */
        final /* synthetic */ int f21383b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21384c;

        /* renamed from: d */
        final /* synthetic */ com.ss.android.downloadlib.addownload.a.c f21385d;

        public AnonymousClass2(int i10, int i11, com.ss.android.downloadad.api.a.b bVar, com.ss.android.downloadlib.addownload.a.c cVar) {
            i11 = i10;
            i11 = i11;
            bVar = bVar;
            cVar = cVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.c
        public void a() {
            com.ss.android.downloadlib.addownload.a.d unused = b.f21375a = null;
            b.this.a(i11, i11, bVar, "apk_size_cancel", "delete");
            cVar.a();
        }
    }

    public static com.ss.android.downloadlib.addownload.a.c b() {
        return f21376b;
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return f21375a;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        f21376b = cVar;
    }

    @Override // com.ss.android.downloadlib.addownload.d.g
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar, com.ss.android.downloadlib.addownload.a.c cVar) {
        DownloadInfo b10;
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
        long a10 = com.ss.android.downloadlib.addownload.j.a(b10.getId(), b10.getCurBytes(), b10.getTotalBytes());
        long totalBytes = b10.getTotalBytes();
        if (a10 >= 0 && totalBytes > 0) {
            if (totalBytes <= a(bVar.s())) {
                int i11 = (int) (a10 / 1048576);
                f21375a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.b.1

                    /* renamed from: a */
                    final /* synthetic */ int f21377a;

                    /* renamed from: b */
                    final /* synthetic */ int f21378b;

                    /* renamed from: c */
                    final /* synthetic */ com.ss.android.downloadad.api.a.b f21379c;

                    /* renamed from: d */
                    final /* synthetic */ h f21380d;

                    public AnonymousClass1(int i112, int i1122, com.ss.android.downloadad.api.a.b bVar2, h hVar2) {
                        i11 = i1122;
                        i11 = i1122;
                        bVar = bVar2;
                        hVar = hVar2;
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.d
                    public void a() {
                        com.ss.android.downloadlib.addownload.a.d unused = b.f21375a = null;
                        b.this.a(i11, i11, bVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.d
                    public void b() {
                        com.ss.android.downloadlib.addownload.a.d unused = b.f21375a = null;
                        b.this.a(i11, i11, bVar, "apk_size_cancel", "cancel");
                        hVar.a(bVar);
                    }
                };
                String format = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", m.a(totalBytes - a10));
                if (cVar != null) {
                    a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.d.b.2

                        /* renamed from: a */
                        final /* synthetic */ int f21382a;

                        /* renamed from: b */
                        final /* synthetic */ int f21383b;

                        /* renamed from: c */
                        final /* synthetic */ com.ss.android.downloadad.api.a.b f21384c;

                        /* renamed from: d */
                        final /* synthetic */ com.ss.android.downloadlib.addownload.a.c f21385d;

                        public AnonymousClass2(int i1122, int i11222, com.ss.android.downloadad.api.a.b bVar2, com.ss.android.downloadlib.addownload.a.c cVar2) {
                            i11 = i11222;
                            i11 = i11222;
                            bVar = bVar2;
                            cVar = cVar2;
                        }

                        @Override // com.ss.android.downloadlib.addownload.a.c
                        public void a() {
                            com.ss.android.downloadlib.addownload.a.d unused = b.f21375a = null;
                            b.this.a(i11, i11, bVar, "apk_size_cancel", "delete");
                            cVar.a();
                        }
                    });
                }
                TTDelegateActivity.a(bVar2, format, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int a(int i10) {
        return DownloadSetting.obtain(i10).optInt("cancel_pause_optimise_apk_size", 100) * 1048576;
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).optInt("cancel_pause_optimise_apk_retain_switch", 0) == 1 && aVar.q();
    }

    public void a(int i10, int i11, com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i10));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i11));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_cancel_optimise", jSONObject, bVar);
    }
}
