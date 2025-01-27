package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.m0;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.Map;

/* loaded from: classes4.dex */
public class k extends m0 {

    /* renamed from: d */
    public RewardVideoAdBroadcastReceiver f20473d;

    /* renamed from: e */
    public boolean f20474e;

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f20475a;

        public a(String str) {
            this.f20475a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            Map<String, String> options;
            if (!(obj instanceof PointEntitySigmob) || (options = ((PointEntitySigmob) obj).getOptions()) == null) {
                return;
            }
            options.put("show_count", String.valueOf(com.sigmob.sdk.base.common.h.g(this.f20475a)));
            com.sigmob.sdk.base.common.h.b(this.f20475a);
        }
    }

    public interface b extends o.b {
        void c(BaseAdUnit baseAdUnit);

        void c(BaseAdUnit baseAdUnit, String str);

        void e(BaseAdUnit baseAdUnit);

        void f(BaseAdUnit baseAdUnit);

        void k(BaseAdUnit baseAdUnit);
    }

    public k(o.b bVar, boolean z10) {
        super(bVar);
        this.f20474e = z10;
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.m0, com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        RewardVideoAdBroadcastReceiver rewardVideoAdBroadcastReceiver = this.f20473d;
        if (rewardVideoAdBroadcastReceiver != null) {
            rewardVideoAdBroadcastReceiver.b(rewardVideoAdBroadcastReceiver);
            this.f20473d = null;
        }
        super.b(baseAdUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    @Override // com.sigmob.sdk.base.common.m0, com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.sigmob.sdk.base.models.BaseAdUnit r11, android.os.Bundle r12) {
        /*
            r10 = this;
            super.a(r11, r12)
            com.sigmob.sdk.base.common.o$b r0 = r10.f18041a
            boolean r0 = r0 instanceof com.sigmob.sdk.videoAd.k.b
            if (r0 == 0) goto L1b
            com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver r0 = new com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver
            com.sigmob.sdk.base.common.o$b r1 = r10.f18041a
            com.sigmob.sdk.videoAd.k$b r1 = (com.sigmob.sdk.videoAd.k.b) r1
            java.lang.String r2 = r11.getUuid()
            r0.<init>(r11, r1, r2)
            r10.f20473d = r0
            r0.a(r0)
        L1b:
            int r0 = r11.getAd_type()
            r1 = 4
            r2 = 1
            if (r0 == r2) goto L29
            int r0 = r11.getAd_type()
            if (r0 != r1) goto L47
        L29:
            int r0 = r11.getCreativeType()
            com.sigmob.sdk.base.common.m r3 = com.sigmob.sdk.base.common.m.CreativeTypeMRAID
            int r3 = r3.b()
            if (r0 != r3) goto L38
            java.lang.String r0 = "mraid"
            goto L49
        L38:
            int r0 = r11.getCreativeType()
            com.sigmob.sdk.base.common.m r3 = com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO
            int r3 = r3.b()
            if (r0 != r3) goto L47
            java.lang.String r0 = "mraid_two"
            goto L49
        L47:
            java.lang.String r0 = "reward"
        L49:
            if (r12 == 0) goto L52
            boolean r3 = r10.f20474e
            java.lang.String r4 = "isHalfInterstitial"
            r12.putBoolean(r4, r3)
        L52:
            java.lang.String r3 = r11.getAdslot_id()
            com.sigmob.sdk.videoAd.k$a r9 = new com.sigmob.sdk.videoAd.k$a
            r9.<init>(r3)
            r7 = 0
            r8 = 0
            java.lang.String r4 = "vopen"
            r5 = 0
            r6 = r11
            com.sigmob.sdk.base.common.b0.a(r4, r5, r6, r7, r8, r9)
            int r3 = r11.getAd_type()
            if (r3 != r1) goto L7a
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = r11.getMaterial()
            java.lang.Integer r1 = r1.theme_data
            int r1 = r1.intValue()
            if (r1 == r2) goto L98
            boolean r1 = r10.f20474e
            if (r1 != 0) goto L98
        L7a:
            int r1 = r11.getCreativeType()
            com.sigmob.sdk.base.common.m r3 = com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO
            int r3 = r3.b()
            if (r1 != r3) goto La6
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = r11.getMaterial()
            java.lang.Integer r1 = r1.theme_data
            int r1 = r1.intValue()
            if (r1 == r2) goto L98
            int r1 = r11.getTemplateType()
            if (r1 != r2) goto La6
        L98:
            android.content.Context r1 = com.sigmob.sdk.a.d()
            java.lang.String r11 = r11.getUuid()
            java.lang.Class<com.sigmob.sdk.base.common.TransparentAdActivity> r2 = com.sigmob.sdk.base.common.TransparentAdActivity.class
        La2:
            com.sigmob.sdk.videoAd.BaseAdActivity.a(r1, r2, r11, r12, r0)
            goto Lb1
        La6:
            android.content.Context r1 = com.sigmob.sdk.a.d()
            java.lang.String r11 = r11.getUuid()
            java.lang.Class<com.sigmob.sdk.base.common.AdActivity> r2 = com.sigmob.sdk.base.common.AdActivity.class
            goto La2
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.k.a(com.sigmob.sdk.base.models.BaseAdUnit, android.os.Bundle):void");
    }
}
