package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;

/* loaded from: classes.dex */
public final class m implements i0.b {

    /* renamed from: a */
    public final /* synthetic */ VlionAdapterADConfig f3085a;

    /* renamed from: b */
    public final /* synthetic */ j f3086b;

    public m(j jVar, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3086b = jVar;
        this.f3085a = vlionAdapterADConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c6 A[Catch: all -> 0x009c, TryCatch #0 {all -> 0x009c, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x004c, B:11:0x00a1, B:13:0x00c6, B:14:0x00ea, B:30:0x0094, B:19:0x0054, B:21:0x0058, B:24:0x0061, B:27:0x008f), top: B:1:0x0000, inners: #1 }] */
    @Override // cn.vlion.ad.inland.base.i0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r10, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r11) {
        /*
            r9 = this;
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = r9.f3085a     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto Lf7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r0.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = "端策略 : CustomVlionSplashView onSwipeClick ---------： "
            r0.append(r1)     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r1 = r9.f3085a     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = r1.getAdxTagId()     // Catch: java.lang.Throwable -> L9c
            r0.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r0.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = "端策略 : CustomVlionSplashView getStrategyBean ---------： "
            r0.append(r1)     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.util.VlionAdStrategyUtils r1 = cn.vlion.ad.inland.base.util.VlionAdStrategyUtils.getInstance()     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r2 = r9.f3085a     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = r2.getAdxTagId()     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean r1 = r1.getStrategyBean(r2)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9c
            r0.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.j r0 = r9.f3086b     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.k1 r1 = r0.f2953b     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto Lf7
            cn.vlion.ad.inland.base.javabean.VlionADClickType r1 = new cn.vlion.ad.inland.base.javabean.VlionADClickType     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.i0 r0 = r0.f2970s     // Catch: java.lang.Throwable -> L9c
            java.lang.String r8 = ","
            if (r0 == 0) goto L9e
            java.lang.String r2 = r0.f2908u     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L8f
            java.lang.String r3 = "click"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L61
            goto L8f
        L61:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L8d
            float r3 = r0.f2892e     // Catch: java.lang.Throwable -> L8d
            r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            r2.append(r8)     // Catch: java.lang.Throwable -> L8d
            float r0 = r0.f2893f     // Catch: java.lang.Throwable -> L8d
            r2.append(r0)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "ViewOnTouchDataUtils getDistanceXY="
            r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            r2.append(r0)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L8d
        L8b:
            r4 = r0
            goto La1
        L8d:
            r0 = move-exception
            goto L94
        L8f:
            java.lang.String r0 = r0.b()     // Catch: java.lang.Throwable -> L8d
            goto L8b
        L94:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L9c
            r2.upLoadCatchException(r0)     // Catch: java.lang.Throwable -> L9c
            goto L9e
        L9c:
            r10 = move-exception
            goto Lf0
        L9e:
            java.lang.String r0 = ""
            goto L8b
        La1:
            java.lang.String r5 = "main"
            java.lang.String r6 = "hotsplot"
            java.lang.String r7 = ""
            r2 = r1
            r3 = r10
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace r10 = new cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.j r0 = r9.f3086b     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r0 = r0.f2973v     // Catch: java.lang.Throwable -> L9c
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.j r0 = r9.f3086b     // Catch: java.lang.Throwable -> L9c
            r10.handleBaseParameter(r0)     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.j r0 = r9.f3086b     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.i0 r0 = r0.f2970s     // Catch: java.lang.Throwable -> L9c
            r10.handleSwipeParameter(r0, r1)     // Catch: java.lang.Throwable -> L9c
            r1.setVlionBaseParameterReplace(r10)     // Catch: java.lang.Throwable -> L9c
            if (r11 == 0) goto Lea
            boolean r10 = r11.isD()     // Catch: java.lang.Throwable -> L9c
            r1.setDefaultAdStrategy(r10)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r10.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r1.getTriggerParam()     // Catch: java.lang.Throwable -> L9c
            r10.append(r0)     // Catch: java.lang.Throwable -> L9c
            r10.append(r8)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = r11.getTriggerParam()     // Catch: java.lang.Throwable -> L9c
            r10.append(r11)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L9c
            r1.setTriggerParam(r10)     // Catch: java.lang.Throwable -> L9c
        Lea:
            cn.vlion.ad.inland.base.j r10 = r9.f3086b     // Catch: java.lang.Throwable -> L9c
            cn.vlion.ad.inland.base.j.b(r10, r1)     // Catch: java.lang.Throwable -> L9c
            goto Lf7
        Lf0:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r11 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r11.upLoadCatchException(r10)
        Lf7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.m.a(java.lang.String, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean):void");
    }
}
