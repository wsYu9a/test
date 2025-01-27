package com.kwad.components.core.o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.o;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.x;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private static boolean TR = false;

    /* renamed from: com.kwad.components.core.o.a$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            n H = a.H(8L);
            H.aCN = f.BV();
            g.a2(H);
        }
    }

    /* renamed from: com.kwad.components.core.o.a$a */
    public static final class C0437a {
        private static final a TT = new a();
    }

    public static n H(long j10) {
        return new n(j10);
    }

    private static n a(long j10, AdTemplate adTemplate, String str) {
        return new n(j10, adTemplate, str);
    }

    private static n b(long j10, AdTemplate adTemplate) {
        return new n(j10, adTemplate);
    }

    public static a ri() {
        return C0437a.TT;
    }

    public final void aB(@NonNull AdTemplate adTemplate) {
        g.a2(b(10007L, adTemplate));
    }

    public final void aC(@NonNull AdTemplate adTemplate) {
        g.a2(b(10208L, adTemplate));
    }

    public final void aD(@NonNull AdTemplate adTemplate) {
        g.a2(b(10209L, adTemplate));
    }

    public final void aE(int i10) {
        n H = H(10104L);
        H.aCn = i10;
        g.a2(H);
    }

    public final void aF(int i10) {
        n H = H(10107L);
        H.aCo = i10;
        g.a2(H);
    }

    public final void as(Context context) {
        n H = H(11L);
        o oVar = (o) d.f(o.class);
        if (oVar != null) {
            JSONArray[] b10 = oVar.b(context, com.kwad.sdk.core.config.d.zS());
            H.aCf = b10[0];
            H.aCg = b10[1];
            g.a2(H);
        }
    }

    public final void c(@NonNull AdTemplate adTemplate, int i10, int i11) {
        n b10 = b(12006L, adTemplate);
        b10.aag = i10;
        b10.atE = i11;
        g.a2(b10);
    }

    public final void d(@NonNull AdTemplate adTemplate, int i10, int i11) {
        n b10 = b(10002L, adTemplate);
        b10.Gt();
        if (e.dT(adTemplate)) {
            b10.aCm = com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate));
        } else {
            b10.aCm = e.ed(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i10);
            jSONObject.put("extra", i11);
            b10.errorMsg = jSONObject.toString();
        } catch (JSONException e10) {
            c.printStackTraceOnly(e10);
        }
        g.a2(b10);
    }

    public final void e(@NonNull JSONObject jSONObject, int i10) {
        n H = H(10201L);
        x.putValue(jSONObject, "appChangeType", i10);
        H.aCq = jSONObject;
        g.a2(H);
    }

    public final void f(AdTemplate adTemplate, int i10, String str) {
        n b10 = b(10109L, adTemplate);
        b10.aCo = 1;
        b10.aCp = str;
        g.a2(b10);
    }

    public final void g(@NonNull AdTemplate adTemplate, long j10) {
        n b10 = b(10202L, adTemplate);
        b10.aCv = j10;
        g.a2(b10);
    }

    public final void h(AdTemplate adTemplate, long j10) {
        n b10 = b(10206L, adTemplate);
        b10.aCL = j10;
        g.a2(b10);
    }

    public final void i(AdTemplate adTemplate, long j10) {
        n b10 = b(10207L, adTemplate);
        b10.aCM = j10;
        g.a2(b10);
    }

    public final n m(String str, String str2) {
        n H = H(12200L);
        H.aCU = str;
        H.aCV = str2;
        return H;
    }

    public final void rj() {
        if (TR) {
            return;
        }
        TR = true;
        h.execute(new bd() { // from class: com.kwad.components.core.o.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                n H = a.H(8L);
                H.aCN = f.BV();
                g.a2(H);
            }
        });
    }

    public final void rk() {
        g.a2(H(10101L));
    }

    public final void rl() {
        g.a2(H(10106L));
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b10 = b(10003L, adTemplate);
        b10.aCm = str;
        b10.errorMsg = str2;
        g.a2(b10);
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b10 = b(10005L, adTemplate);
        if (e.dT(adTemplate)) {
            b10.aCm = com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate));
        } else {
            b10.aCm = e.ed(adTemplate);
        }
        b10.aCm = str;
        b10.errorMsg = str2;
        g.a2(b10);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i10, String str) {
        n b10 = b(107L, adTemplate);
        b10.errorCode = i10;
        b10.errorMsg = str;
        g.a2(b10);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        n H = H(10200L);
        H.aCr = jSONArray;
        g.a2(H);
    }

    public final void e(AdTemplate adTemplate, int i10) {
        n b10 = b(10108L, adTemplate);
        b10.aCo = i10;
        g.a2(b10);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i10) {
        if (com.kwad.sdk.core.config.d.DX()) {
            AdInfo eb2 = e.eb(adTemplate);
            n H = H(20000L);
            H.timestamp = System.currentTimeMillis();
            H.aCW = i10;
            H.trace = eb2.trace;
            H.aCX = BuildConfig.VERSION_CODE;
            H.posId = e.dU(adTemplate);
            g.a2(H);
        }
    }

    public final void a(int i10, @NonNull AdTemplate adTemplate, String str) {
        g.a2(a(i10, adTemplate, str));
    }

    public final void a(@NonNull AdTemplate adTemplate, long j10, long j11, int i10) {
        n b10 = b(10203L, adTemplate);
        b10.YF = j10;
        b10.blockDuration = j11;
        b10.aCc = i10;
        g.a2(b10);
    }

    public final void e(String str, String str2, boolean z10) {
        g.a(m(str, str2), z10);
    }

    public final void b(@NonNull AdTemplate adTemplate, long j10, int i10) {
        n b10 = b(104L, adTemplate);
        b10.clickTime = m.eB(adTemplate);
        b10.aCB = j10;
        b10.aCC = i10;
        g.a2(b10);
    }

    public final void a(boolean z10, List<Integer> list) {
        n H = H(10204L);
        H.aCx = z10;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            H.aCw = jSONArray;
        }
        g.a2(H);
    }

    public final void a(SceneImpl sceneImpl, boolean z10, String str) {
        n H = H(10216L);
        H.aCx = z10;
        H.aCy = str;
        H.adScene = sceneImpl;
        g.a2(H);
    }

    public final void a(b bVar) {
        n H = H(10215L);
        H.TH = bVar.TH;
        H.TO = bVar.TO;
        H.TP = bVar.TP;
        H.TQ = bVar.TQ;
        g.a2(H);
    }

    public final void a(long j10, int i10) {
        if (com.kwad.sdk.core.config.d.DX()) {
            n H = H(20000L);
            H.timestamp = System.currentTimeMillis();
            H.aCW = i10;
            H.posId = j10;
            H.aCX = BuildConfig.VERSION_CODE;
            g.a2(H);
        }
    }
}
