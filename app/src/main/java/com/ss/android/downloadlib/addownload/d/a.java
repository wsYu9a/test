package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a implements i {

    /* renamed from: a */
    private static com.ss.android.downloadlib.addownload.a.d f21371a;

    /* renamed from: com.ss.android.downloadlib.addownload.d.a$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.a.d {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21372a;

        /* renamed from: b */
        final /* synthetic */ h f21373b;

        public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar, h hVar) {
            bVar = bVar;
            hVar = hVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void a() {
            com.ss.android.downloadlib.addownload.a.d unused = a.f21371a = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "apk_size");
                jSONObject.putOpt("pause_optimise_action", "confirm");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void b() {
            com.ss.android.downloadlib.addownload.a.d unused = a.f21371a = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "apk_size");
                jSONObject.putOpt("pause_optimise_action", "cancel");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
            hVar.a(bVar);
        }
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return f21371a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.i
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar) {
        DownloadInfo b10;
        if (bVar == null || bVar.ac() || !a(bVar)) {
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
        if (a10 <= 0 || totalBytes <= 0 || totalBytes > a(bVar.s())) {
            return false;
        }
        f21371a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.a.1

            /* renamed from: a */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21372a;

            /* renamed from: b */
            final /* synthetic */ h f21373b;

            public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar2, h hVar2) {
                bVar = bVar2;
                hVar = hVar2;
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                com.ss.android.downloadlib.addownload.a.d unused = a.f21371a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                com.ss.android.downloadlib.addownload.a.d unused = a.f21371a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                hVar.a(bVar);
            }
        };
        TTDelegateActivity.a(bVar2, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", m.a(totalBytes - a10)), "继续", "暂停");
        bVar2.n(true);
        return true;
    }

    private int a(int i10) {
        return DownloadSetting.obtain(i10).optInt("pause_optimise_apk_size", 100) * 1048576;
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).optInt("pause_optimise_apk_size_switch", 0) == 1 && aVar.q();
    }
}
