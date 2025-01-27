package com.vivo.mobilead.nativead;

import android.app.Activity;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends com.vivo.mobilead.nativead.a {

    /* renamed from: j */
    private NativeUnifiedAD f29604j;
    private NativeUnifiedADData k;
    private NativeAdListener l;
    private List<NativeUnifiedADData> m;
    private List<NativeResponse> n;
    private NativeADUnifiedListener o;

    class a implements NativeADUnifiedListener {
        a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list == null || list.isEmpty()) {
                c.this.a(new l0().a(c.a.f28914c).a(false).b(402116).a("暂无广告，请重试"));
                k0.a(((com.vivo.mobilead.a) c.this).f28642c, ((com.vivo.mobilead.a) c.this).f28644e, "4", ((com.vivo.mobilead.a) c.this).f28643d, 0, 1, 2, 402116, "暂无广告，请重试", c.a.f28914c.intValue());
            } else {
                c.this.m = list;
                c.this.a(new l0().a(c.a.f28914c).a(true).a(list.size()));
                k0.a(((com.vivo.mobilead.a) c.this).f28642c, ((com.vivo.mobilead.a) c.this).f28644e, "4", ((com.vivo.mobilead.a) c.this).f28643d, 0, 1, 1, -10000, "", c.a.f28914c.intValue());
                c.this.b(list);
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError == null) {
                adError = new AdError();
            }
            c.this.a(new l0().a(c.a.f28914c).a(false).b(com.vivo.mobilead.unified.base.f.a.a(adError.getErrorCode())).a(adError.getErrorMsg()));
            k0.a(((com.vivo.mobilead.a) c.this).f28642c, ((com.vivo.mobilead.a) c.this).f28644e, "4", ((com.vivo.mobilead.a) c.this).f28643d, 0, 1, 2, adError.getErrorCode(), adError.getErrorMsg(), c.a.f28914c.intValue());
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ List f29606a;

        b(List list) {
            this.f29606a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x009a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x000b A[SYNTHETIC] */
        @Override // com.vivo.mobilead.util.f1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void safelyRun() {
            /*
                r8 = this;
                org.json.JSONArray r0 = new org.json.JSONArray
                r0.<init>()
                java.util.List r1 = r8.f29606a
                java.util.Iterator r1 = r1.iterator()
            Lb:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L9f
                java.lang.Object r2 = r1.next()
                com.qq.e.ads.nativ.NativeUnifiedADData r2 = (com.qq.e.ads.nativ.NativeUnifiedADData) r2
                if (r2 != 0) goto L1a
                goto Lb
            L1a:
                java.util.List r3 = r2.getImgList()
                java.lang.String r4 = r2.getImgUrl()
                boolean r5 = android.text.TextUtils.isEmpty(r4)
                if (r5 != 0) goto L2b
                r3.add(r4)
            L2b:
                if (r3 == 0) goto L69
                int r4 = r3.size()
                if (r4 <= 0) goto L69
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.util.Iterator r3 = r3.iterator()
            L3c:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L57
                java.lang.Object r5 = r3.next()
                java.lang.String r5 = (java.lang.String) r5
                boolean r6 = android.text.TextUtils.isEmpty(r5)
                if (r6 != 0) goto L3c
                r4.append(r5)
                java.lang.String r5 = ","
                r4.append(r5)
                goto L3c
            L57:
                int r3 = r4.length()
                if (r3 <= 0) goto L69
                int r3 = r4.length()
                int r3 = r3 + (-1)
                r5 = 0
                java.lang.String r3 = r4.substring(r5, r3)
                goto L6b
            L69:
                java.lang.String r3 = ""
            L6b:
                org.json.JSONObject r4 = new org.json.JSONObject
                r4.<init>()
                java.lang.String r5 = r2.getDesc()
                java.lang.String r6 = "desc"
                com.vivo.mobilead.util.t.a(r4, r6, r5)
                java.lang.String r5 = r2.getTitle()
                java.lang.String r6 = "title"
                com.vivo.mobilead.util.t.a(r4, r6, r5)
                java.lang.String r5 = "m_url"
                com.vivo.mobilead.util.t.a(r4, r5, r3)
                int r2 = com.vivo.mobilead.util.b0.a(r2)
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.String r3 = "display_mode"
                com.vivo.mobilead.util.t.a(r4, r3, r2)
                int r2 = r4.length()
                if (r2 <= 0) goto Lb
                r0.put(r4)
                goto Lb
            L9f:
                com.vivo.mobilead.nativead.c r1 = com.vivo.mobilead.nativead.c.this
                java.lang.String r3 = com.vivo.mobilead.nativead.c.e(r1)
                java.lang.Integer r1 = com.vivo.mobilead.j.c.a.f28914c
                java.lang.String r4 = java.lang.String.valueOf(r1)
                com.vivo.mobilead.nativead.c r1 = com.vivo.mobilead.nativead.c.this
                java.lang.String r5 = com.vivo.mobilead.nativead.c.f(r1)
                com.vivo.mobilead.nativead.c r1 = com.vivo.mobilead.nativead.c.this
                java.lang.String r6 = com.vivo.mobilead.nativead.c.g(r1)
                java.lang.String r7 = r0.toString()
                java.lang.String r2 = "4"
                com.vivo.mobilead.util.k0.a(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.nativead.c.b.safelyRun():void");
        }
    }

    public c(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams, nativeAdListener);
        this.n = new ArrayList();
        this.o = new a();
        this.l = nativeAdListener;
    }

    @Override // com.vivo.mobilead.a
    public void c(String str) {
        super.c(str);
        List<NativeResponse> list = this.n;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (NativeResponse nativeResponse : this.n) {
            if (nativeResponse instanceof d) {
                ((d) nativeResponse).a(str, this.f28644e, this.f28645f);
            }
        }
    }

    public void b(List<NativeUnifiedADData> list) {
        a1.c(new b(list));
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a() {
        NativeUnifiedADData nativeUnifiedADData = this.k;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.k = null;
        }
        if (GDTADManager.getInstance().isInitialized()) {
            NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(this.f28640a, this.f28642c, this.o);
            this.f29604j = nativeUnifiedAD;
            nativeUnifiedAD.setVideoPlayPolicy(2);
            this.f29604j.setVideoADContainerRender(1);
            k0.a(this.f28642c, this.f28644e, "4", 1, 0, 2, c.a.f28914c.intValue(), 1);
            NativeUnifiedAD nativeUnifiedAD2 = this.f29604j;
            NativeAdParams nativeAdParams = this.f29601i;
            nativeUnifiedAD2.loadData(nativeAdParams != null ? Math.max(1, nativeAdParams.getAdCount()) : 1);
        }
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a(List<NativeResponse> list) {
        Iterator<NativeUnifiedADData> it = this.m.iterator();
        while (it.hasNext()) {
            this.n.add(new d(it.next(), this.f29600h));
        }
        NativeAdListener nativeAdListener = this.l;
        if (nativeAdListener != null) {
            nativeAdListener.onADLoaded(this.n);
        }
    }
}
