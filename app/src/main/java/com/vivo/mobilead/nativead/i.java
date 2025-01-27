package com.vivo.mobilead.nativead;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.s0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class i extends com.vivo.mobilead.nativead.a {

    /* renamed from: j */
    private List<NativeResponse> f29642j;
    private TTAdNative.FeedAdListener k;

    class a implements TTAdNative.FeedAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            i.this.a(new l0().a(c.a.f28913b).a(false).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(str));
            k0.a(((com.vivo.mobilead.a) i.this).f28642c, ((com.vivo.mobilead.a) i.this).f28644e, "4", ((com.vivo.mobilead.a) i.this).f28643d, 0, 1, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            if (list == null || list.isEmpty() || list.get(0).getImageMode() == 5) {
                i.this.a(new l0().a(c.a.f28913b).a(false).b(402114).a("暂无广告，请重试"));
                k0.a(((com.vivo.mobilead.a) i.this).f28642c, ((com.vivo.mobilead.a) i.this).f28644e, "4", ((com.vivo.mobilead.a) i.this).f28643d, 0, 1, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
                return;
            }
            i.this.f29642j.clear();
            Iterator<TTFeedAd> it = list.iterator();
            while (it.hasNext()) {
                i.this.f29642j.add(new j(it.next(), i.this.f29600h));
            }
            i.this.a(new l0().a(c.a.f28913b).a(true).a(list.size()));
            k0.a(((com.vivo.mobilead.a) i.this).f28642c, ((com.vivo.mobilead.a) i.this).f28644e, "4", ((com.vivo.mobilead.a) i.this).f28643d, 0, 1, 1, -10000, "", c.a.f28913b.intValue());
            i.this.b(list);
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ List f29644a;

        b(List list) {
            this.f29644a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[SYNTHETIC] */
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
                java.util.List r1 = r8.f29644a
                java.util.Iterator r1 = r1.iterator()
            Lb:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L9c
                java.lang.Object r2 = r1.next()
                com.bytedance.sdk.openadsdk.TTFeedAd r2 = (com.bytedance.sdk.openadsdk.TTFeedAd) r2
                if (r2 != 0) goto L1a
                goto Lb
            L1a:
                java.util.List r3 = r2.getImageList()
                if (r3 == 0) goto L66
                int r4 = r3.size()
                if (r4 <= 0) goto L66
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.util.Iterator r3 = r3.iterator()
            L2f:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L54
                java.lang.Object r5 = r3.next()
                com.bytedance.sdk.openadsdk.TTImage r5 = (com.bytedance.sdk.openadsdk.TTImage) r5
                if (r5 == 0) goto L2f
                java.lang.String r6 = r5.getImageUrl()
                boolean r6 = android.text.TextUtils.isEmpty(r6)
                if (r6 != 0) goto L2f
                java.lang.String r5 = r5.getImageUrl()
                r4.append(r5)
                java.lang.String r5 = ","
                r4.append(r5)
                goto L2f
            L54:
                int r3 = r4.length()
                if (r3 <= 0) goto L66
                int r3 = r4.length()
                int r3 = r3 + (-1)
                r5 = 0
                java.lang.String r3 = r4.substring(r5, r3)
                goto L68
            L66:
                java.lang.String r3 = ""
            L68:
                org.json.JSONObject r4 = new org.json.JSONObject
                r4.<init>()
                java.lang.String r5 = r2.getDescription()
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
            L9c:
                com.vivo.mobilead.nativead.i r1 = com.vivo.mobilead.nativead.i.this
                java.lang.String r3 = com.vivo.mobilead.nativead.i.e(r1)
                java.lang.Integer r1 = com.vivo.mobilead.j.c.a.f28913b
                java.lang.String r4 = java.lang.String.valueOf(r1)
                com.vivo.mobilead.nativead.i r1 = com.vivo.mobilead.nativead.i.this
                java.lang.String r5 = com.vivo.mobilead.nativead.i.f(r1)
                com.vivo.mobilead.nativead.i r1 = com.vivo.mobilead.nativead.i.this
                java.lang.String r6 = com.vivo.mobilead.nativead.i.g(r1)
                java.lang.String r7 = r0.toString()
                java.lang.String r2 = "4"
                com.vivo.mobilead.util.k0.a(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.nativead.i.b.safelyRun():void");
        }
    }

    public i(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams, nativeAdListener);
        this.f29642j = new ArrayList();
        this.k = new a();
    }

    public void b(List<TTFeedAd> list) {
        a1.c(new b(list));
    }

    @Override // com.vivo.mobilead.a
    public void c(String str) {
        super.c(str);
        List<NativeResponse> list = this.f29642j;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (NativeResponse nativeResponse : this.f29642j) {
            if (nativeResponse instanceof j) {
                ((j) nativeResponse).a(str, this.f28644e, this.f28645f);
            }
        }
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a() {
        if (!s0.b()) {
            a(new l0().a("暂无广告，请重试").b(402114).a(false).a(c.a.f28913b));
            return;
        }
        AdSlot.Builder imageAcceptedSize = new AdSlot.Builder().setCodeId(this.f28642c).setSupportDeepLink(true).setImageAcceptedSize(690, 388);
        NativeAdParams nativeAdParams = this.f29601i;
        AdSlot build = imageAcceptedSize.setAdCount(nativeAdParams != null ? Math.max(1, nativeAdParams.getAdCount()) : 1).build();
        k0.a(this.f28642c, this.f28644e, "4", 1, 0, 2, c.a.f28913b.intValue(), 1);
        s0.a().createAdNative(this.f28640a).loadFeedAd(build, this.k);
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a(List<NativeResponse> list) {
        super.a(this.f29642j);
    }
}
