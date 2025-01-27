package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a aYe;
    private com.kwai.adclient.kscommerciallogger.a.b aYf;
    private JSONObject aYg;
    private boolean aYh;
    private boolean isDebug;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a */
    public static final class C0519a {
        private static a aYi;

        public static a Qd() {
            if (aYi == null) {
                aYi = new a((byte) 0);
            }
            return aYi;
        }
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a Qd() {
        return C0519a.Qd();
    }

    private void b(@NonNull c cVar) {
        if (this.aYe != null) {
            if (cVar.Qh() != null) {
                String str = cVar.Qh().value;
            }
            if (cVar.Qi() != null) {
                cVar.Qi().getValue();
            }
            cVar.Ql();
            b.z(cVar.Qj());
            b.z(cVar.Qk());
        }
    }

    public final JSONObject Qe() {
        return this.aYg;
    }

    public final boolean Qf() {
        return this.aYh;
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.a.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.a.b bVar, @Nullable JSONObject jSONObject, boolean z10, boolean z11) {
        this.aYe = aVar;
        this.aYf = bVar;
        this.aYg = jSONObject;
        this.isDebug = z10;
        this.aYh = z11;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private a() {
        this.isDebug = false;
        this.aYh = false;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.aYf;
        if (bVar != null) {
            bVar.L(cVar.Qg(), cVar.toString());
        }
    }
}
