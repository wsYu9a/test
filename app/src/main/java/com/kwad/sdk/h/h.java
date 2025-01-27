package com.kwad.sdk.h;

import android.text.TextUtils;
import com.kwad.sdk.h.e;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class h {
    private static final float arn = new Random().nextFloat();
    private final AtomicBoolean LB;
    private final AtomicBoolean aNG;
    private d aNH;
    private g aNI;
    private List<i> aNJ;
    private f aNK;

    /* renamed from: com.kwad.sdk.h.h$1 */
    public class AnonymousClass1 extends n {
        final /* synthetic */ i aNL;

        public AnonymousClass1(i iVar) {
            iVar = iVar;
        }

        @Override // com.kwad.sdk.h.n
        public final void doTask() {
            h hVar = h.this;
            e a10 = hVar.a(hVar.aNH, iVar);
            if (a10 == null) {
                return;
            }
            iVar.n(a10.arO);
            m.a(iVar, a10.aNu == 2);
        }
    }

    public static final class a {
        private static final h aNN = new h((byte) 0);
    }

    public /* synthetic */ h(byte b10) {
        this();
    }

    public static h KR() {
        return a.aNN;
    }

    private void KY() {
        List<i> list = this.aNJ;
        if (list == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.aNJ.clear();
        this.aNJ = null;
    }

    private void b(i iVar) {
        d dVar = this.aNH;
        if (dVar == null || j.H(dVar.aNt) || this.aNI == null || this.aNK == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.h.h.1
            final /* synthetic */ i aNL;

            public AnonymousClass1(i iVar2) {
                iVar = iVar2;
            }

            @Override // com.kwad.sdk.h.n
            public final void doTask() {
                h hVar = h.this;
                e a10 = hVar.a(hVar.aNH, iVar);
                if (a10 == null) {
                    return;
                }
                iVar.n(a10.arO);
                m.a(iVar, a10.aNu == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aJs;
        if (j.H(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aNI.getSdkVersion(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(e.b bVar) {
        String androidId = this.aNI.getAndroidId();
        String deviceId = this.aNI.getDeviceId();
        String imei = this.aNI.getImei();
        String oaid = this.aNI.getOaid();
        List<String> list = bVar.aNC;
        if (j.H(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    private static d gl(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.Lb();
            return null;
        }
    }

    public final void KS() {
        if (!this.LB.get() || this.aNH == null) {
            return;
        }
        j.Lc();
        m.Le();
    }

    public final synchronized void KT() {
        this.aNG.set(true);
    }

    public final synchronized void KU() {
        this.aNG.set(false);
    }

    public final g KV() {
        return this.aNI;
    }

    public final f KW() {
        return this.aNK;
    }

    public final long KX() {
        return this.aNH.KK();
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aNG.get()) {
                    j.Lc();
                    return;
                }
                i go = i.La().gm(str).gn(str2).go(str3);
                if (this.LB.get()) {
                    b(go);
                } else {
                    j.Lc();
                    a(go);
                }
            }
        } catch (Throwable unused) {
            j.Lb();
        }
    }

    private h() {
        this.LB = new AtomicBoolean(false);
        this.aNG = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aJr;
        if (j.H(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aNI.getAppId(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.LB.get()) {
            return;
        }
        try {
            j.Lc();
            this.aNI = gVar;
            this.aNK = fVar;
            this.aNH = gl(str);
            this.LB.set(true);
            KY();
        } catch (Throwable unused) {
            j.Lb();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aNz;
        if (j.H(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.aNy;
        if (j.H(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.aNJ == null) {
            this.aNJ = new CopyOnWriteArrayList();
        }
        this.aNJ.add(iVar);
    }

    public e a(d dVar, i iVar) {
        List<e> list = dVar.aNt;
        if (j.H(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aNv) && a(eVar.aNw, iVar)) {
                double d10 = eVar.arO;
                if (d10 > l5.c.f27899e && arn <= d10) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aND != e.b.aNA) {
            return bVar.KL();
        }
        bVar.bG(b(bVar) && c(bVar) && d(bVar));
        return bVar.KL();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aNO) && b(aVar, iVar.aNP) && c(aVar, iVar.aNQ);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aNx;
        if (j.H(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }
}
