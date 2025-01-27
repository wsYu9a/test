package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.n;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a implements n.a {

    /* renamed from: a */
    private static final String f21138a = "a";

    /* renamed from: b */
    private static a f21139b;

    /* renamed from: c */
    private com.ss.android.downloadlib.g.n f21140c = new com.ss.android.downloadlib.g.n(Looper.getMainLooper(), this);

    /* renamed from: d */
    private long f21141d;

    private a() {
    }

    public static a a() {
        if (f21139b == null) {
            synchronized (a.class) {
                try {
                    if (f21139b == null) {
                        f21139b = new a();
                    }
                } finally {
                }
            }
        }
        return f21139b;
    }

    public void a(@NonNull DownloadInfo downloadInfo, long j10, long j11, String str, String str2, String str3, String str4) {
        int i10;
        com.ss.android.downloadlib.addownload.b.a aVar = new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), j10, j11, str, str2, str3, str4);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.f.e.m() || com.ss.android.socialbase.appdownloader.f.e.n()) && SystemUtils.checkServiceExists(k.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (DownloadUtils.getBoolean(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f21140c.obtainMessage(200, aVar);
                obtainMessage.arg1 = 2;
                this.f21140c.sendMessageDelayed(obtainMessage, r1.optInt("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.f21182b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i10 = 5;
            } catch (Exception unused) {
                i10 = -1;
            }
            k.g().a(null, new BaseException(i10, jSONObject.toString()), i10);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, d10);
        }
        if (com.ss.android.downloadlib.g.e.c()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f21141d;
            long d11 = com.ss.android.downloadlib.g.e.d();
            if (currentTimeMillis < com.ss.android.downloadlib.g.e.e()) {
                long e10 = com.ss.android.downloadlib.g.e.e() - currentTimeMillis;
                d11 += e10;
                this.f21141d = System.currentTimeMillis() + e10;
            } else {
                this.f21141d = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.g.n nVar = this.f21140c;
            nVar.sendMessageDelayed(nVar.obtainMessage(200, aVar), d11);
        }
    }

    private void a(com.ss.android.downloadlib.addownload.b.a aVar, int i10) {
        int i11;
        if (k.m() == null || k.m().a() || aVar == null) {
            return;
        }
        if (2 == i10) {
            com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.f21182b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.g.m.e(k.a(), aVar.f21184d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i11 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i11 = 5;
                }
            } catch (Exception unused) {
                i11 = -1;
            }
            k.g().a(null, new BaseException(i11, jSONObject.toString()), i11);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, d10);
        }
        if (com.ss.android.downloadlib.g.m.e(k.a(), aVar.f21184d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_installed", aVar.f21182b);
            return;
        }
        if (!com.ss.android.downloadlib.g.m.a(aVar.f21187g)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_file_lost", aVar.f21182b);
        } else if (com.ss.android.downloadlib.addownload.a.a.a().a(aVar.f21184d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_conflict_with_back_dialog", aVar.f21182b);
        } else {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_install_start", aVar.f21182b);
            com.ss.android.socialbase.appdownloader.d.a(k.a(), (int) aVar.f21181a);
        }
    }

    @Override // com.ss.android.downloadlib.g.n.a
    public void a(Message message) {
        if (message.what != 200) {
            return;
        }
        a((com.ss.android.downloadlib.addownload.b.a) message.obj, message.arg1);
    }
}
