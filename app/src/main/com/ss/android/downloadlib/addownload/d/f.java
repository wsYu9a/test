package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f implements i {

    /* renamed from: a */
    private static com.ss.android.downloadlib.addownload.a.d f21403a;

    /* renamed from: com.ss.android.downloadlib.addownload.d.f$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.a.d {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21404a;

        /* renamed from: b */
        final /* synthetic */ h f21405b;

        public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar, h hVar) {
            bVar = bVar;
            hVar = hVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void a() {
            com.ss.android.downloadlib.addownload.a.d unused = f.f21403a = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "download_percent");
                jSONObject.putOpt("pause_optimise_action", "confirm");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void b() {
            com.ss.android.downloadlib.addownload.a.d unused = f.f21403a = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "download_percent");
                jSONObject.putOpt("pause_optimise_action", "cancel");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
            hVar.a(bVar);
        }
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return f21403a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.i
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar) {
        DownloadInfo b10;
        int a10;
        if (bVar == null || bVar.ad() || !a(bVar)) {
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
        if (curBytes <= 0 || totalBytes <= 0 || (a10 = com.ss.android.downloadlib.addownload.j.a(b10.getId(), (int) ((curBytes * 100) / totalBytes))) <= a(bVar.s())) {
            return false;
        }
        f21403a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.f.1

            /* renamed from: a */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21404a;

            /* renamed from: b */
            final /* synthetic */ h f21405b;

            public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar2, h hVar2) {
                bVar = bVar2;
                hVar = hVar2;
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                com.ss.android.downloadlib.addownload.a.d unused = f.f21403a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "download_percent");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                com.ss.android.downloadlib.addownload.a.d unused = f.f21403a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "download_percent");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                hVar.a(bVar);
            }
        };
        TTDelegateActivity.b(bVar2, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a10)), "继续", "暂停");
        bVar2.o(true);
        return true;
    }

    private int a(int i10) {
        return DownloadSetting.obtain(i10).optInt("pause_optimise_download_percent", 50);
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).optInt("pause_optimise_download_percent_switch", 0) == 1 && aVar.q();
    }
}
