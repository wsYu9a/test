package com.ss.android.downloadlib.addownload.zx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q implements com.ss.android.downloadad.api.j.j {

    /* renamed from: g */
    public DownloadController f24238g;

    /* renamed from: i */
    public DownloadEventConfig f24239i;

    /* renamed from: j */
    public long f24240j;
    public DownloadModel zx;

    public q() {
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject e() {
        return this.zx.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public boolean ei() {
        return this.f24238g.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public DownloadEventConfig f() {
        return this.f24239i;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String g() {
        return this.zx.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public int gm() {
        return this.f24239i.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String gv() {
        if (this.zx.getDeepLink() != null) {
            return this.zx.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public DownloadModel hm() {
        return this.zx;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public boolean i() {
        return this.zx.isAd();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String j() {
        return this.zx.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String k() {
        return this.f24239i.getRefer();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject lg() {
        return this.zx.getExtra();
    }

    public boolean mx() {
        DownloadModel downloadModel;
        if (this.f24240j == 0 || (downloadModel = this.zx) == null || this.f24239i == null || this.f24238g == null) {
            return true;
        }
        return downloadModel.isAd() && this.f24240j <= 0;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public long nt() {
        return this.zx.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public boolean p() {
        return this.f24239i.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String pa() {
        return this.f24239i.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String q() {
        return this.zx.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public List<String> r() {
        return this.zx.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject s() {
        return this.f24239i.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject t() {
        return this.f24239i.getParamsJson();
    }

    public boolean tf() {
        if (mx()) {
            return false;
        }
        if (!this.zx.isAd()) {
            return this.zx instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.zx;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f24239i instanceof AdDownloadEventConfig) && (this.f24238g instanceof AdDownloadController);
    }

    @Override // com.ss.android.downloadad.api.j.j
    public int v() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public Object w() {
        return this.f24239i.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public int y() {
        if (this.f24238g.getDownloadMode() == 2) {
            return 2;
        }
        return this.zx.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.j.j
    public DownloadController z() {
        return this.f24238g;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public long zx() {
        return this.zx.getId();
    }

    public q(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.f24240j = j2;
        this.zx = downloadModel;
        this.f24239i = downloadEventConfig;
        this.f24238g = downloadController;
    }
}
