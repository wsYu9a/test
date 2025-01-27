package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class w5 implements c {

    /* renamed from: a */
    public final /* synthetic */ VlionRewardVideoActivity f3483a;

    public w5(VlionRewardVideoActivity vlionRewardVideoActivity) {
        this.f3483a = vlionRewardVideoActivity;
    }

    public final void a() {
        try {
            g1 g1Var = this.f3483a.f2323a;
            if (g1Var != null) {
                g1Var.onAdVideoPlayComplete();
            }
            g1 g1Var2 = this.f3483a.f2323a;
            if (g1Var2 != null) {
                g1Var2.onAdReward();
            }
            VlionCustomParseAdData vlionCustomParseAdData = this.f3483a.f2327e;
            if (vlionCustomParseAdData == null || TextUtils.isEmpty(vlionCustomParseAdData.getImageUrl())) {
                this.f3483a.finish();
                return;
            }
            this.f3483a.f2330h.setVisibility(8);
            this.f3483a.f2330h.removeAllViews();
            this.f3483a.f2333k.destroy();
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3483a;
            vlionRewardVideoActivity.f2333k = null;
            try {
                t5 t5Var = vlionRewardVideoActivity.G;
                if (t5Var != null) {
                    t5Var.a();
                    vlionRewardVideoActivity.G = null;
                }
                vlionRewardVideoActivity.f2335m.a(vlionRewardVideoActivity.f2327e, vlionRewardVideoActivity.f2328f, new z5(vlionRewardVideoActivity));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #0 {all -> 0x0011, blocks: (B:2:0x0000, B:6:0x0009, B:7:0x0019, B:9:0x002f, B:10:0x0032, B:12:0x0060, B:17:0x0013), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[Catch: all -> 0x0011, TryCatch #0 {all -> 0x0011, blocks: (B:2:0x0000, B:6:0x0009, B:7:0x0019, B:9:0x002f, B:10:0x0032, B:12:0x0060, B:17:0x0013), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r3, int r4) {
        /*
            r2 = this;
            cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity r0 = r2.f3483a     // Catch: java.lang.Throwable -> L11
            int r1 = r0.C     // Catch: java.lang.Throwable -> L11
            if (r1 <= 0) goto L13
            if (r3 < r1) goto L9
            goto L13
        L9:
            cn.vlion.ad.inland.ad.view.active.VlionAdClosedView r0 = r0.f2334l     // Catch: java.lang.Throwable -> L11
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L11
            goto L19
        L11:
            r3 = move-exception
            goto L64
        L13:
            cn.vlion.ad.inland.ad.view.active.VlionAdClosedView r0 = r0.f2334l     // Catch: java.lang.Throwable -> L11
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L11
        L19:
            cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity r0 = r2.f3483a     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.ad.view.video.VlionTimeView r0 = r0.f2332j     // Catch: java.lang.Throwable -> L11
            r0.setMaxProgress(r4)     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity r0 = r2.f3483a     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.ad.view.video.VlionTimeView r0 = r0.f2332j     // Catch: java.lang.Throwable -> L11
            r0.setProgress(r3)     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity r0 = r2.f3483a     // Catch: java.lang.Throwable -> L11
            r0.f2347y = r3     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.base.h4 r0 = r0.f2339q     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L32
            r0.a(r3)     // Catch: java.lang.Throwable -> L11
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L11
            r0.<init>()     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = "VlionRewardVideoActivity onAdVideoPlaying current="
            r0.append(r1)     // Catch: java.lang.Throwable -> L11
            r0.append(r3)     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = " total="
            r0.append(r1)     // Catch: java.lang.Throwable -> L11
            r0.append(r4)     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = " Sec"
            r0.append(r1)     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity r1 = r2.f3483a     // Catch: java.lang.Throwable -> L11
            int r1 = r1.C     // Catch: java.lang.Throwable -> L11
            r0.append(r1)     // Catch: java.lang.Throwable -> L11
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity r0 = r2.f3483a     // Catch: java.lang.Throwable -> L11
            cn.vlion.ad.inland.base.g1 r0 = r0.f2323a     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L6b
            r0.onAdVideoPlaying(r3, r4)     // Catch: java.lang.Throwable -> L11
            goto L6b
        L64:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r4 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r4.upLoadCatchException(r3)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.w5.a(int, int):void");
    }
}
