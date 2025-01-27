package com.kwad.sdk.e;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b implements a {
    private static volatile b aMu;
    private static c aMv;

    private b() {
    }

    public static synchronized b Kh() {
        b bVar;
        synchronized (b.class) {
            try {
                if (aMu == null) {
                    synchronized (b.class) {
                        try {
                            if (aMu == null) {
                                aMu = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = aMu;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    private static String Ki() {
        return a(false, "", 2);
    }

    public static void a(c cVar) {
        aMv = cVar;
    }

    @Override // com.kwad.sdk.e.a
    public final String JV() {
        c cVar = aMv;
        return cVar != null ? cVar.JV() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String JW() {
        c cVar = aMv;
        return cVar != null ? cVar.JW() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String JX() {
        c cVar = aMv;
        return cVar != null ? cVar.JX() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String JY() {
        c cVar = aMv;
        return cVar != null ? cVar.JY() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String JZ() {
        c cVar = aMv;
        return cVar != null ? cVar.JZ() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Ka() {
        c cVar = aMv;
        return cVar != null ? cVar.Ka() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Kb() {
        c cVar = aMv;
        return cVar != null ? cVar.Kb() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Kc() {
        c cVar = aMv;
        return cVar != null ? cVar.Kc() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Kd() {
        c cVar = aMv;
        return cVar != null ? cVar.Kd() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Ke() {
        c cVar = aMv;
        return cVar != null ? cVar.Ke() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Kf() {
        c cVar = aMv;
        return cVar != null ? cVar.Kf() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String Kg() {
        c cVar = aMv;
        return cVar != null ? cVar.Kg() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = aMv;
        return cVar != null ? cVar.getAppId() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = aMv;
        return cVar != null ? cVar.getDeviceId() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = aMv;
        return cVar != null ? cVar.getIccId() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = aMv;
        return cVar != null ? cVar.getIp() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = aMv;
        return cVar != null ? cVar.getLocation() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = aMv;
        return cVar != null ? cVar.getOaid() : Ki();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = aMv;
        return cVar != null ? cVar.getSdkVersion() : Ki();
    }

    public static String a(boolean z10, Object obj, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z10));
        hashMap.put("value", obj);
        hashMap.put(MediationConstant.KEY_ERROR_CODE, String.valueOf(i10));
        return new JSONObject(hashMap).toString();
    }
}
