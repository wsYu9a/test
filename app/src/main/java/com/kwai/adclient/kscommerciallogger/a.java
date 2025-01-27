package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.kwai.a aDQ;
    private com.kwai.adclient.kscommerciallogger.kwai.b aDR;
    private JSONObject aDS;
    private boolean aDT;
    private boolean isDebug;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a */
    static final class C0235a {
        private static a aDU;

        public static a FS() {
            if (aDU == null) {
                aDU = new a((byte) 0);
            }
            return aDU;
        }
    }

    private a() {
        this.isDebug = false;
        this.aDT = false;
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a FS() {
        return C0235a.FS();
    }

    private void d(@NonNull c cVar) {
        com.kwai.adclient.kscommerciallogger.kwai.a aVar = this.aDQ;
        if (aVar != null) {
            String tag = cVar.getTag();
            String str = cVar.FW() == null ? "" : cVar.FW().value;
            if (cVar.FX() != null) {
                String str2 = cVar.FX().value;
            }
            if (cVar.FY() != null) {
                cVar.FY().getValue();
            }
            cVar.Gb();
            b.O(cVar.FZ());
            b.O(cVar.Ga());
            aVar.F(tag, str);
        }
    }

    public final JSONObject FT() {
        return this.aDS;
    }

    public final boolean FU() {
        return this.aDT;
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.kwai.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z, boolean z2) {
        this.aDQ = aVar;
        this.aDR = bVar;
        this.aDS = null;
        this.isDebug = z;
        this.aDT = z2;
    }

    public final void c(c cVar) {
        if (cVar == null) {
            this.aDQ.G("KSCommercialLogger", "rl rtLog is null please check it");
            return;
        }
        d(cVar);
        com.kwai.adclient.kscommerciallogger.kwai.b bVar = this.aDR;
        if (bVar != null) {
            bVar.H(cVar.FV(), cVar.toString());
        }
    }

    public final boolean isDebug() {
        return this.isDebug;
    }
}
