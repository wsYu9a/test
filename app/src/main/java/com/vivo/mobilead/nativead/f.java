package com.vivo.mobilead.nativead;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends com.vivo.mobilead.nativead.a {

    /* renamed from: j */
    private List<NativeResponse> f29628j;
    private KsLoadManager.NativeAdListener k;

    class a implements KsLoadManager.NativeAdListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i2, String str) {
            f.this.a(new l0().a(c.a.f28915d).a(false).b(com.vivo.mobilead.unified.base.f.a.b(i2)).a(str));
            k0.a(((com.vivo.mobilead.a) f.this).f28642c, ((com.vivo.mobilead.a) f.this).f28644e, "4", ((com.vivo.mobilead.a) f.this).f28643d, 0, 1, 2, i2, str, c.a.f28915d.intValue());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            if (list == null || list.isEmpty() || list.get(0) == null) {
                f.this.a(new l0().a(c.a.f28915d).a(false).b(402130).a("暂无广告，请重试"));
                k0.a(((com.vivo.mobilead.a) f.this).f28642c, ((com.vivo.mobilead.a) f.this).f28644e, "4", ((com.vivo.mobilead.a) f.this).f28643d, 0, 1, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
                return;
            }
            if (list.get(0).getMaterialType() == 1) {
                f.this.a(new l0().a(c.a.f28915d).a(false).b(402130).a("暂无广告，请重试"));
                k0.a(((com.vivo.mobilead.a) f.this).f28642c, ((com.vivo.mobilead.a) f.this).f28644e, "4", ((com.vivo.mobilead.a) f.this).f28643d, 0, 1, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
                return;
            }
            f.this.f29628j.clear();
            Iterator<KsNativeAd> it = list.iterator();
            while (it.hasNext()) {
                f.this.f29628j.add(new g(it.next(), f.this.f29600h));
            }
            f.this.a(new l0().a(c.a.f28915d).a(true).a(list.size()));
            k0.a(((com.vivo.mobilead.a) f.this).f28642c, ((com.vivo.mobilead.a) f.this).f28644e, "4", ((com.vivo.mobilead.a) f.this).f28643d, 0, 1, 1, -10000, "", c.a.f28915d.intValue());
            f.this.b(list);
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ List f29630a;

        b(List list) {
            this.f29630a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x000b A[SYNTHETIC] */
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
                java.util.List r1 = r8.f29630a
                java.util.Iterator r1 = r1.iterator()
            Lb:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L99
                java.lang.Object r2 = r1.next()
                com.kwad.sdk.api.KsNativeAd r2 = (com.kwad.sdk.api.KsNativeAd) r2
                if (r2 != 0) goto L1a
                goto Lb
            L1a:
                java.util.List r3 = r2.getImageList()
                java.lang.String r4 = ""
                if (r3 == 0) goto L68
                int r5 = r3.size()
                if (r5 <= 0) goto L68
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.util.Iterator r3 = r3.iterator()
            L31:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L56
                java.lang.Object r6 = r3.next()
                com.kwad.sdk.api.KsImage r6 = (com.kwad.sdk.api.KsImage) r6
                if (r6 == 0) goto L31
                java.lang.String r7 = r6.getImageUrl()
                boolean r7 = android.text.TextUtils.isEmpty(r7)
                if (r7 != 0) goto L31
                java.lang.String r6 = r6.getImageUrl()
                r5.append(r6)
                java.lang.String r6 = ","
                r5.append(r6)
                goto L31
            L56:
                int r3 = r5.length()
                if (r3 <= 0) goto L68
                int r3 = r5.length()
                int r3 = r3 + (-1)
                r6 = 0
                java.lang.String r3 = r5.substring(r6, r3)
                goto L69
            L68:
                r3 = r4
            L69:
                org.json.JSONObject r5 = new org.json.JSONObject
                r5.<init>()
                java.lang.String r6 = r2.getAdDescription()
                java.lang.String r7 = "desc"
                com.vivo.mobilead.util.t.a(r5, r7, r6)
                java.lang.String r6 = "title"
                com.vivo.mobilead.util.t.a(r5, r6, r4)
                java.lang.String r4 = "m_url"
                com.vivo.mobilead.util.t.a(r5, r4, r3)
                int r2 = com.vivo.mobilead.util.b0.a(r2)
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.String r3 = "display_mode"
                com.vivo.mobilead.util.t.a(r5, r3, r2)
                int r2 = r5.length()
                if (r2 <= 0) goto Lb
                r0.put(r5)
                goto Lb
            L99:
                com.vivo.mobilead.nativead.f r1 = com.vivo.mobilead.nativead.f.this
                java.lang.String r3 = com.vivo.mobilead.nativead.f.h(r1)
                java.lang.Integer r1 = com.vivo.mobilead.j.c.a.f28915d
                java.lang.String r4 = java.lang.String.valueOf(r1)
                com.vivo.mobilead.nativead.f r1 = com.vivo.mobilead.nativead.f.this
                java.lang.String r5 = com.vivo.mobilead.nativead.f.i(r1)
                com.vivo.mobilead.nativead.f r1 = com.vivo.mobilead.nativead.f.this
                java.lang.String r6 = com.vivo.mobilead.nativead.f.k(r1)
                java.lang.String r7 = r0.toString()
                java.lang.String r2 = "4"
                com.vivo.mobilead.util.k0.a(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.nativead.f.b.safelyRun():void");
        }
    }

    public f(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams, nativeAdListener);
        this.f29628j = new ArrayList();
        this.k = new a();
    }

    public void b(List<KsNativeAd> list) {
        a1.c(new b(list));
    }

    @Override // com.vivo.mobilead.a
    public void c(String str) {
        super.c(str);
        List<NativeResponse> list = this.f29628j;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (NativeResponse nativeResponse : this.f29628j) {
            if (nativeResponse instanceof g) {
                ((g) nativeResponse).a(str, this.f28644e, this.f28645f);
            }
        }
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a() {
        if (!v.a()) {
            a(new l0().a(c.a.f28915d).a(false).b(402130).a("暂无广告，请重试"));
            return;
        }
        try {
            KsScene build = new KsScene.Builder(Long.parseLong(this.f28642c)).build();
            NativeAdParams nativeAdParams = this.f29601i;
            int i2 = 1;
            if (nativeAdParams != null) {
                i2 = Math.max(1, nativeAdParams.getAdCount());
            }
            build.setAdNum(i2);
            KsAdSDK.getLoadManager().loadNativeAd(build, this.k);
            k0.a(this.f28642c, this.f28644e, "4", 1, 0, 2, c.a.f28915d.intValue(), 1);
        } catch (Exception unused) {
            a(new l0().a(c.a.f28915d).a(false).b(402130).a("暂无广告，请重试"));
        }
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a(List<NativeResponse> list) {
        super.a(this.f29628j);
    }
}
