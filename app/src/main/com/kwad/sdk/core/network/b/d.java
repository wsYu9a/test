package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: classes3.dex */
public final class d implements b {
    private static boolean aAQ = true;
    public static double aAR = 1.0d;
    private static volatile boolean aAV = false;
    private static String aAW = "";
    private long aAS = -1;
    private long aAT = -1;
    private long aAU = -1;
    private j aAX = new j();

    public d() {
        aAR = new Random().nextDouble();
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: FP */
    public d FH() {
        this.aAX.aAb = SystemClock.elapsedRealtime();
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: FQ */
    public d FI() {
        this.aAT = SystemClock.elapsedRealtime();
        eo("this.responseReceiveTime:" + this.aAT);
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: FR */
    public d FJ() {
        if (au(this.aAS) && au(this.aAT)) {
            this.aAX.aAi = this.aAT - this.aAS;
            eo("info.waiting_response_cost:" + this.aAX.aAi);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: FS */
    public d FK() {
        if (au(this.aAX.aAb)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aAS = elapsedRealtime;
            j jVar = this.aAX;
            jVar.azV = elapsedRealtime - jVar.aAb;
            if (au(jVar.azT)) {
                j jVar2 = this.aAX;
                jVar2.azU = jVar2.azV - jVar2.azT;
            }
            eo("info.request_create_cost:" + this.aAX.azV);
            eo("info.requestAddParamsCost:" + this.aAX.azU);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: FT */
    public d FM() {
        if (au(this.aAT)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aAU = elapsedRealtime;
            this.aAX.aAg = elapsedRealtime - this.aAT;
            eo("info.response_parse_cost:" + this.aAX.aAg);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: FU */
    public d FN() {
        if (au(this.aAU)) {
            this.aAX.aAn = SystemClock.elapsedRealtime() - this.aAU;
            FV();
            eo("info.response_done_cost:" + this.aAX.aAn);
        }
        return this;
    }

    private void FV() {
        j jVar = this.aAX;
        if (jVar == null || jVar.aAm != 1 || ax(jVar.aAn)) {
            return;
        }
        this.aAX.aAn = -1L;
    }

    private d FW() {
        this.aAX.aAq = (int) com.kwad.sdk.ip.direct.a.Km();
        this.aAX.aAr = (int) com.kwad.sdk.ip.direct.a.Kn();
        this.aAX.aAs = (int) com.kwad.sdk.ip.direct.a.Ko();
        return this;
    }

    private void FX() {
        i c10 = c(this.aAX);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c10);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + c10.toJson().toString());
    }

    private static boolean au(long j10) {
        return j10 != -1;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: av */
    public d at(long j10) {
        this.aAX.aAh = j10;
        eo("responseSize:" + j10);
        return this;
    }

    private d aw(long j10) {
        this.aAX.aAj = j10;
        eo("totalCost:" + j10);
        return this;
    }

    private static boolean ax(long j10) {
        return j10 >= 50;
    }

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dk */
    public d dg(int i10) {
        this.aAX.httpCode = i10;
        eo("http_code:" + i10);
        return this;
    }

    private d dl(int i10) {
        this.aAX.aAm = i10;
        eo("hasData:" + i10);
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dm */
    public d di(int i10) {
        this.aAX.result = i10;
        eo("result:" + i10);
        return this;
    }

    private static void eo(String str) {
        if (aAQ) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ep */
    public d ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.aAX.url = str;
        if (str.contains("?")) {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                str = split[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            eo("url:" + str);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eq */
    public d ek(String str) {
        try {
            this.aAX.host = Uri.parse(str).getHost();
            eo("host:" + this.aAX.host);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e10));
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: er */
    public d el(String str) {
        this.aAX.errorMsg = str;
        eo(str);
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: es */
    public d em(String str) {
        this.aAX.azR = str;
        eo("reqType:" + str);
        eu(com.kwad.sdk.ip.direct.a.Kl());
        FW();
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: et */
    public d en(String str) {
        this.aAX.aAl = str;
        eo("requestId:" + str);
        return this;
    }

    private d eu(String str) {
        this.aAX.aAo = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b FL() {
        if (au(this.aAX.aAb)) {
            this.aAX.azT = SystemClock.elapsedRealtime() - this.aAX.aAb;
            eo("info.request_prepare_cost:" + this.aAX.azT);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dh(int i10) {
        return dl(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b dj(int i10) {
        j jVar = this.aAX;
        jVar.aAp = i10;
        if (i10 != 0) {
            jVar.azS = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.aAX)) {
            return;
        }
        if (this.aAX.httpCode != 200) {
            FX();
            return;
        }
        long elapsedRealtime = au(this.aAX.aAb) ? SystemClock.elapsedRealtime() - this.aAX.aAb : -1L;
        aw(elapsedRealtime);
        if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.aAX);
        }
        eo("report normal" + this.aAX.toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.azR = jVar.azR;
        iVar.url = jVar.url;
        iVar.azS = jVar.azS;
        return iVar;
    }
}
