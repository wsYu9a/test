package com.kwad.components.core.m;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.l.kwai.b;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    private static boolean Oh = false;

    /* renamed from: com.kwad.components.core.m.a$1 */
    final class AnonymousClass1 extends aw {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            q v = a.v(8L);
            v.ajA = f.tG();
            h.a2(v);
        }
    }

    /* renamed from: com.kwad.components.core.m.a$a */
    static final class C0179a {
        private static final a Oj = new a();
    }

    protected a() {
    }

    private static q a(long j2, AdTemplate adTemplate, String str) {
        return new q(j2, adTemplate, str);
    }

    private static q b(long j2, AdTemplate adTemplate) {
        return new q(j2, adTemplate);
    }

    public static a pb() {
        return C0179a.Oj;
    }

    public static q v(long j2) {
        return new q(j2);
    }

    public final void N(@NonNull AdTemplate adTemplate) {
        h.a2(b(10007L, adTemplate));
    }

    public final void O(@NonNull AdTemplate adTemplate) {
        h.a2(b(10208L, adTemplate));
    }

    public final void P(@NonNull AdTemplate adTemplate) {
        h.a2(b(10209L, adTemplate));
    }

    public final void a(int i2, @NonNull AdTemplate adTemplate, String str) {
        h.a2(a(i2, adTemplate, str));
    }

    public final void a(b bVar) {
        q v = v(10215L);
        v.NY = bVar.NY;
        v.Oe = bVar.Oe;
        v.Of = bVar.Of;
        v.Og = bVar.Og;
        h.a2(v);
    }

    public final void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        q b2 = b(12006L, adTemplate);
        b2.Tt = i2;
        b2.aiQ = i3;
        h.a2(b2);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j2, int i2) {
        q b2 = b(104L, adTemplate);
        b2.clickTime = l.cx(adTemplate);
        b2.ajo = j2;
        b2.ajp = i2;
        h.a2(b2);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j2, long j3, int i2) {
        q b2 = b(10203L, adTemplate);
        b2.Vl = j2;
        b2.blockDuration = j3;
        b2.aiP = i2;
        h.a2(b2);
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        q b2 = b(10003L, adTemplate);
        b2.failUrl = str;
        b2.errorMsg = str2;
        h.a2(b2);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        q v = v(10216L);
        v.ajk = z;
        v.ajl = str;
        v.Ow = sceneImpl;
        h.a2(v);
    }

    public final void a(boolean z, List<Integer> list) {
        q v = v(10204L);
        v.ajk = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            v.ajj = jSONArray;
        }
        h.a2(v);
    }

    public final void aB(int i2) {
        q v = v(10104L);
        v.aja = i2;
        h.a2(v);
    }

    public final void aC(int i2) {
        q v = v(10107L);
        v.ajb = i2;
        h.a2(v);
    }

    public final void ag(Context context) {
        q v = v(11L);
        JSONArray[] c2 = InstalledAppInfoManager.c(context, d.sD());
        v.aiT = c2[0];
        v.aiU = c2[1];
        h.a2(v);
    }

    public final void b(long j2, int i2) {
        if (d.uP()) {
            q v = v(20000L);
            v.timestamp = System.currentTimeMillis();
            v.ajJ = i2;
            v.posId = j2;
            v.ajK = 3034000;
            h.a2(v);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, int i2, int i3) {
        q b2 = b(10002L, adTemplate);
        b2.xc();
        b2.failUrl = com.kwad.sdk.core.response.a.d.bT(adTemplate) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : com.kwad.sdk.core.response.a.d.cd(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i2);
            jSONObject.put("extra", i3);
            b2.errorMsg = jSONObject.toString();
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        h.a2(b2);
    }

    public final void b(AdTemplate adTemplate, int i2, String str) {
        q b2 = b(adTemplate.isPlayAgainData ? com.heytap.mcssdk.n.b.h0 : 10109, adTemplate);
        b2.ajb = 1;
        b2.ajc = str;
        h.a2(b2);
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        q b2 = b(10005L, adTemplate);
        b2.failUrl = com.kwad.sdk.core.response.a.d.bT(adTemplate) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : com.kwad.sdk.core.response.a.d.cd(adTemplate);
        b2.failUrl = str;
        b2.errorMsg = str2;
        h.a2(b2);
    }

    public final void c(@NonNull AdTemplate adTemplate, int i2, String str) {
        q b2 = b(107L, adTemplate);
        b2.errorCode = i2;
        b2.errorMsg = str;
        h.a2(b2);
    }

    public final void c(@NonNull AdTemplate adTemplate, long j2) {
        q b2 = b(10202L, adTemplate);
        b2.aji = j2;
        h.a2(b2);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        q v = v(10200L);
        v.aje = jSONArray;
        h.a2(v);
    }

    public final void d(AdTemplate adTemplate, long j2) {
        q b2 = b(10206L, adTemplate);
        b2.ajy = j2;
        h.a2(b2);
    }

    public final void e(AdTemplate adTemplate, long j2) {
        q b2 = b(10207L, adTemplate);
        b2.ajz = j2;
        h.a2(b2);
    }

    public final void e(String str, String str2, boolean z) {
        q v = v(12200L);
        v.ajH = str;
        v.ajI = str2;
        h.a(v, z);
    }

    public final void e(@NonNull JSONObject jSONObject, int i2) {
        q v = v(10201L);
        t.putValue(jSONObject, "appChangeType", i2);
        v.ajd = jSONObject;
        h.a2(v);
    }

    public final void f(AdTemplate adTemplate, int i2) {
        q b2 = b(10108L, adTemplate);
        b2.ajb = i2;
        h.a2(b2);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i2) {
        if (d.uP()) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            q v = v(20000L);
            v.timestamp = System.currentTimeMillis();
            v.ajJ = i2;
            v.trace = cb.trace;
            v.ajK = 3034000;
            v.posId = com.kwad.sdk.core.response.a.d.bU(adTemplate);
            h.a2(v);
        }
    }

    public final void pc() {
        if (Oh) {
            return;
        }
        Oh = true;
        g.execute(new aw() { // from class: com.kwad.components.core.m.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                q v = a.v(8L);
                v.ajA = f.tG();
                h.a2(v);
            }
        });
    }

    public final void pd() {
        h.a2(v(10101L));
    }

    public final void pe() {
        h.a2(v(10106L));
    }
}
