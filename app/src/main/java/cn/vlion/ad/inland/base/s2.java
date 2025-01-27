package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.i0;

/* loaded from: classes.dex */
public final class s2 implements i0.b {

    /* renamed from: a */
    public final /* synthetic */ y2 f3360a;

    public s2(y2 y2Var) {
        this.f3360a = y2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b9 A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:2:0x0000, B:4:0x0006, B:7:0x0058, B:10:0x0061, B:12:0x0094, B:14:0x00b9, B:15:0x00dd, B:19:0x008f), top: B:1:0x0000 }] */
    @Override // cn.vlion.ad.inland.base.i0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r9, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r10) {
        /*
            r8 = this;
            cn.vlion.ad.inland.base.y2 r0 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = r0.A     // Catch: java.lang.Throwable -> L8d
            if (r0 == 0) goto Lea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r0.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = "端策略 : VlionCustomFeedAdLayout onSwipeClick ---------： "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2 r1 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r1 = r1.A     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = r1.getAdxTagId()     // Catch: java.lang.Throwable -> L8d
            r0.append(r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r0.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = "端策略 : VlionCustomFeedAdLayout getStrategyBean ---------： "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.util.VlionAdStrategyUtils r1 = cn.vlion.ad.inland.base.util.VlionAdStrategyUtils.getInstance()     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2 r2 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r2 = r2.A     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = r2.getAdxTagId()     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean r1 = r1.getStrategyBean(r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8d
            r0.append(r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.javabean.VlionADClickType r0 = new cn.vlion.ad.inland.base.javabean.VlionADClickType     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2 r1 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.i0 r1 = r1.f3523v     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = r1.f2908u     // Catch: java.lang.Throwable -> L8d
            java.lang.String r7 = ","
            if (r2 == 0) goto L8f
            java.lang.String r3 = "click"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L61
            goto L8f
        L61:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L8d
            float r3 = r1.f2892e     // Catch: java.lang.Throwable -> L8d
            r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            r2.append(r7)     // Catch: java.lang.Throwable -> L8d
            float r1 = r1.f2893f     // Catch: java.lang.Throwable -> L8d
            r2.append(r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "ViewOnTouchDataUtils getDistanceXY="
            r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            r2.append(r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L8d
        L8b:
            r3 = r1
            goto L94
        L8d:
            r9 = move-exception
            goto Le3
        L8f:
            java.lang.String r1 = r1.b()     // Catch: java.lang.Throwable -> L8d
            goto L8b
        L94:
            java.lang.String r4 = "main"
            java.lang.String r5 = "hotsplot"
            java.lang.String r6 = ""
            r1 = r0
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace r9 = new cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2 r1 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r1 = r1.f3527z     // Catch: java.lang.Throwable -> L8d
            r9.<init>(r1)     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2 r1 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            r9.handleBaseParameter(r1)     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2 r1 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.i0 r1 = r1.f3523v     // Catch: java.lang.Throwable -> L8d
            r9.handleSwipeParameter(r1, r0)     // Catch: java.lang.Throwable -> L8d
            r0.setVlionBaseParameterReplace(r9)     // Catch: java.lang.Throwable -> L8d
            if (r10 == 0) goto Ldd
            boolean r9 = r10.isD()     // Catch: java.lang.Throwable -> L8d
            r0.setDefaultAdStrategy(r9)     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r9.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = r0.getTriggerParam()     // Catch: java.lang.Throwable -> L8d
            r9.append(r1)     // Catch: java.lang.Throwable -> L8d
            r9.append(r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r10 = r10.getTriggerParam()     // Catch: java.lang.Throwable -> L8d
            r9.append(r10)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L8d
            r0.setTriggerParam(r9)     // Catch: java.lang.Throwable -> L8d
        Ldd:
            cn.vlion.ad.inland.base.y2 r9 = r8.f3360a     // Catch: java.lang.Throwable -> L8d
            cn.vlion.ad.inland.base.y2.a(r9, r0)     // Catch: java.lang.Throwable -> L8d
            goto Lea
        Le3:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r10 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r10.upLoadCatchException(r9)
        Lea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.s2.a(java.lang.String, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean):void");
    }
}
