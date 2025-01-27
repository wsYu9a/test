package com.kwad.sdk.core.g;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private static C0496a aFk;
    private static boolean aFl;
    private static final AtomicBoolean LB = new AtomicBoolean(false);
    private static boolean aFm = true;

    /* renamed from: com.kwad.sdk.core.g.a$1 */
    public class AnonymousClass1 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (a.LB.getAndSet(true)) {
                return;
            }
            try {
                C0496a unused = a.aFk = new C0496a();
                boolean unused2 = a.aFl = ((h) ServiceProvider.get(h.class)).Ak();
                String Al = ((h) ServiceProvider.get(h.class)).Al();
                if (a.aFl && !TextUtils.isEmpty(Al)) {
                    a.aFk.parseJson(new JSONObject(Al));
                    a.HG();
                    return;
                }
                boolean unused3 = a.aFm = a.aFl;
            } catch (Throwable unused4) {
            }
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.core.g.a$a */
    public static class C0496a extends com.kwad.sdk.core.response.a.a {
        public List<String> aFn;
        public int aFo;
        public List<String> aFp;
        public List<String> aFq;
    }

    public static void HF() {
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.core.g.a.1
            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (a.LB.getAndSet(true)) {
                    return;
                }
                try {
                    C0496a unused = a.aFk = new C0496a();
                    boolean unused2 = a.aFl = ((h) ServiceProvider.get(h.class)).Ak();
                    String Al = ((h) ServiceProvider.get(h.class)).Al();
                    if (a.aFl && !TextUtils.isEmpty(Al)) {
                        a.aFk.parseJson(new JSONObject(Al));
                        a.HG();
                        return;
                    }
                    boolean unused3 = a.aFm = a.aFl;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    public static void HG() {
        aFm = true;
        if (aFk == null) {
            return;
        }
        dr(HH());
        ad.l("ksadsdk_tk_switch", "tk_config", aFm);
    }

    private static int HH() {
        int i10 = !aFk.aFp.isEmpty() ? 1 : 0;
        C0496a c0496a = aFk;
        int i11 = c0496a.aFo != 0 ? 2 : 0;
        return ((i10 ^ i11) ^ (!c0496a.aFn.isEmpty() ? 4 : 0)) ^ (aFk.aFq.isEmpty() ? 0 : 8);
    }

    public static boolean HI() {
        return LB.get() ? aFm : ad.m("ksadsdk_tk_switch", "tk_config", true);
    }

    private static void dr(int i10) {
        for (int i11 = 0; i11 < Integer.toBinaryString(i10).length(); i11++) {
            if (((1 << i11) & i10) != 0) {
                aFm = false;
                ds(i11);
                if (aFm) {
                    return;
                }
            }
        }
    }

    private static void ds(int i10) {
        if (i10 == 0) {
            if (aFk.aFp.contains(bo.OY())) {
                return;
            }
            aFm = true;
        } else if (i10 == 1) {
            if (aFk.aFo < bo.Pi()) {
                aFm = true;
            }
        } else if (i10 == 2) {
            if (aFk.aFn.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            aFm = true;
        } else if (i10 == 3 && !aFk.aFq.contains(bo.OX())) {
            aFm = true;
        }
    }
}
