package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.lg.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j implements p.j {

    /* renamed from: j */
    private static final String f24169j = "j";
    private static j zx;

    /* renamed from: g */
    private long f24170g;

    /* renamed from: i */
    private p f24171i = new p(Looper.getMainLooper(), this);

    private j() {
    }

    public static j j() {
        if (zx == null) {
            synchronized (j.class) {
                if (zx == null) {
                    zx = new j();
                }
            }
        }
        return zx;
    }

    public void j(@NonNull DownloadInfo downloadInfo, long j2, long j3, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.zx.j jVar = new com.ss.android.downloadlib.addownload.zx.j(downloadInfo.getId(), j2, j3, str, str2, str3, str4);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.gv.q.nt() || com.ss.android.socialbase.appdownloader.gv.q.p()) && SystemUtils.checkServiceExists(pa.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (DownloadUtils.getBoolean(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f24171i.obtainMessage(200, jVar);
                obtainMessage.arg1 = 2;
                this.f24171i.sendMessageDelayed(obtainMessage, r1.optInt("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(jVar.zx);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i2 = 5;
            } catch (Exception unused) {
            }
            pa.gv().j(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.g.j.j().j("embeded_ad", "ah_result", jSONObject, g2);
        }
        if (com.ss.android.downloadlib.lg.q.i()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f24170g;
            long g3 = com.ss.android.downloadlib.lg.q.g();
            if (currentTimeMillis < com.ss.android.downloadlib.lg.q.q()) {
                long q = com.ss.android.downloadlib.lg.q.q() - currentTimeMillis;
                g3 += q;
                this.f24170g = System.currentTimeMillis() + q;
            } else {
                this.f24170g = System.currentTimeMillis();
            }
            p pVar = this.f24171i;
            pVar.sendMessageDelayed(pVar.obtainMessage(200, jVar), g3);
        }
    }

    private void j(com.ss.android.downloadlib.addownload.zx.j jVar, int i2) {
        if (pa.t() == null || pa.t().j() || jVar == null) {
            return;
        }
        if (2 == i2) {
            com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(jVar.zx);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.lg.nt.g(pa.getContext(), jVar.f24230g)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            pa.gv().j(null, new BaseException(i3, jSONObject.toString()), i3);
            com.ss.android.downloadlib.g.j.j().j("embeded_ad", "ah_result", jSONObject, g2);
        }
        if (com.ss.android.downloadlib.lg.nt.g(pa.getContext(), jVar.f24230g)) {
            com.ss.android.downloadlib.g.j.j().j("delayinstall_installed", jVar.zx);
            return;
        }
        if (!com.ss.android.downloadlib.lg.nt.j(jVar.lg)) {
            com.ss.android.downloadlib.g.j.j().j("delayinstall_file_lost", jVar.zx);
        } else if (com.ss.android.downloadlib.addownload.j.j.j().j(jVar.f24230g)) {
            com.ss.android.downloadlib.g.j.j().j("delayinstall_conflict_with_back_dialog", jVar.zx);
        } else {
            com.ss.android.downloadlib.g.j.j().j("delayinstall_install_start", jVar.zx);
            com.ss.android.socialbase.appdownloader.g.j(pa.getContext(), (int) jVar.f24232j);
        }
    }

    @Override // com.ss.android.downloadlib.lg.p.j
    public void j(Message message) {
        if (message.what != 200) {
            return;
        }
        j((com.ss.android.downloadlib.addownload.zx.j) message.obj, message.arg1);
    }
}
