package com.kwad.sdk.core.network.a;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import java.util.Random;
import okhttp3.internal.Version;

/* loaded from: classes2.dex */
public final class d implements b {
    private static boolean ahs = true;
    public static double aht = 1.0d;
    private static volatile boolean ahx = false;
    private static String ahy = "";
    private long ahu = -1;
    private long ahv = -1;
    private long ahw = -1;
    private k ahz = new k();

    public d() {
        aht = new Random().nextDouble();
    }

    private static boolean M(long j2) {
        return j2 != -1;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: N */
    public d L(long j2) {
        this.ahz.agQ = j2;
        cp("responseSize:" + j2);
        return this;
    }

    private d O(long j2) {
        this.ahz.agS = j2;
        cp("totalCost:" + j2);
        return this;
    }

    private static boolean P(long j2) {
        return j2 >= 50;
    }

    private static j b(k kVar) {
        j jVar = new j();
        jVar.errorMsg = kVar.errorMsg;
        jVar.host = kVar.host;
        jVar.httpCode = kVar.httpCode;
        jVar.agz = kVar.agz;
        jVar.url = kVar.url;
        jVar.agA = kVar.agA;
        jVar.agB = kVar.agB;
        return jVar;
    }

    private static boolean b(@NonNull j jVar) {
        if (TextUtils.isEmpty(jVar.url)) {
            return true;
        }
        String lowerCase = jVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: bg */
    public d bc(int i2) {
        this.ahz.httpCode = i2;
        cp("http_code:" + i2);
        return this;
    }

    private d bh(int i2) {
        this.ahz.agV = i2;
        cp("hasData:" + i2);
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: bi */
    public d be(int i2) {
        this.ahz.result = i2;
        cp("result:" + i2);
        return this;
    }

    private static void cp(String str) {
        if (ahs) {
            com.kwad.sdk.core.d.b.d("NetworkMonitorRecorder", str);
        }
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cq */
    public d ck(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.ahz.url = str;
        if (str.contains("?")) {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                str = split[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            cp("url:" + str);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cr */
    public d cl(String str) {
        try {
            this.ahz.host = Uri.parse(str).getHost();
            cp("host:" + this.ahz.host);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("NetworkMonitorRecorder", Log.getStackTraceString(e2));
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cs */
    public d cm(String str) {
        this.ahz.errorMsg = str;
        cp(str);
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: ct */
    public d cn(String str) {
        this.ahz.agz = str;
        cp("reqType:" + str);
        cv(com.kwad.sdk.ip.direct.a.AD());
        wH();
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cu */
    public d co(String str) {
        this.ahz.agU = str;
        cp("requestId:" + str);
        return this;
    }

    private d cv(String str) {
        this.ahz.agX = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: wA */
    public d wr() {
        this.ahz.agK = SystemClock.elapsedRealtime();
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: wB */
    public d ws() {
        this.ahv = SystemClock.elapsedRealtime();
        cp("this.responseReceiveTime:" + this.ahv);
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: wC */
    public d wt() {
        if (M(this.ahu) && M(this.ahv)) {
            this.ahz.agR = this.ahv - this.ahu;
            cp("info.waiting_response_cost:" + this.ahz.agR);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: wD */
    public d wu() {
        if (M(this.ahz.agK)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.ahu = elapsedRealtime;
            k kVar = this.ahz;
            kVar.agE = elapsedRealtime - kVar.agK;
            if (M(kVar.agC)) {
                k kVar2 = this.ahz;
                kVar2.agD = kVar2.agE - kVar2.agC;
            }
            cp("info.request_create_cost:" + this.ahz.agE);
            cp("info.requestAddParamsCost:" + this.ahz.agD);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: wE */
    public d ww() {
        if (M(this.ahv)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.ahw = elapsedRealtime;
            this.ahz.agP = elapsedRealtime - this.ahv;
            cp("info.response_parse_cost:" + this.ahz.agP);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: wF */
    public d wx() {
        if (M(this.ahw)) {
            this.ahz.agW = SystemClock.elapsedRealtime() - this.ahw;
            wG();
            cp("info.response_done_cost:" + this.ahz.agW);
        }
        return this;
    }

    private void wG() {
        k kVar = this.ahz;
        if (kVar == null || kVar.agV != 1 || P(kVar.agW)) {
            return;
        }
        this.ahz.agW = -1L;
    }

    private d wH() {
        this.ahz.agZ = (int) com.kwad.sdk.ip.direct.a.AE();
        this.ahz.aha = (int) com.kwad.sdk.ip.direct.a.AF();
        this.ahz.ahb = (int) com.kwad.sdk.ip.direct.a.AG();
        return this;
    }

    private void wI() {
        j b2 = b(this.ahz);
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            lVar.a(b2);
        }
        cp("reportError" + b2.toString());
    }

    private static String wz() {
        if (ahx) {
            return ahy;
        }
        try {
            try {
                ahy = Version.userAgent();
            } catch (Throwable unused) {
                ahy = (String) s.c((Class<?>) Version.class, TTDownloadField.TT_USERAGENT);
            }
        } catch (Exception unused2) {
        }
        ahx = true;
        return ahy;
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final /* synthetic */ b bd(int i2) {
        return bh(1);
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b bf(int i2) {
        k kVar = this.ahz;
        kVar.agY = i2;
        if (i2 != 0) {
            kVar.agA = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final void report() {
        if (b((j) this.ahz)) {
            return;
        }
        this.ahz.agB = wz();
        if (this.ahz.httpCode != 200) {
            wI();
            return;
        }
        long elapsedRealtime = M(this.ahz.agK) ? SystemClock.elapsedRealtime() - this.ahz.agK : -1L;
        O(elapsedRealtime);
        if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
            return;
        }
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            lVar.a(this.ahz);
        }
        cp("report normal" + this.ahz.toString());
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b wv() {
        if (M(this.ahz.agK)) {
            this.ahz.agC = SystemClock.elapsedRealtime() - this.ahz.agK;
            cp("info.request_prepare_cost:" + this.ahz.agC);
        }
        return this;
    }
}
