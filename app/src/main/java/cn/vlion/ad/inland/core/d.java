package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.config.VlionTimeConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;

/* loaded from: classes.dex */
public final class d {
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x0002, B:8:0x0008, B:10:0x000e, B:26:0x007f, B:27:0x0082, B:29:0x0085, B:31:0x0088, B:33:0x008b, B:35:0x008e, B:37:0x0091, B:39:0x0094, B:41:0x0097, B:43:0x0036, B:46:0x0042, B:49:0x004c, B:52:0x0056, B:55:0x0060, B:58:0x006a, B:61:0x0074), top: B:5:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.vlion.ad.inland.base.adapter.VlionBidderSource a(cn.vlion.ad.inland.core.a r2) {
        /*
            if (r2 == 0) goto La1
            cn.vlion.ad.inland.core.b r2 = r2.b()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto La1
            cn.vlion.ad.inland.base.javabean.VlionServiceConfig$DataBean$AdBean$PlacementBean$SourcesBean r2 = r2.m()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto La1
            java.lang.String r2 = r2.getPlatformName()     // Catch: java.lang.Throwable -> L40
            int r0 = r2.hashCode()     // Catch: java.lang.Throwable -> L40
            r1 = 2371(0x943, float:3.322E-42)
            if (r0 == r1) goto L74
            r1 = 2732(0xaac, float:3.828E-42)
            if (r0 == r1) goto L6a
            r1 = 2741(0xab5, float:3.841E-42)
            if (r0 == r1) goto L60
            r1 = 2749(0xabd, float:3.852E-42)
            if (r0 == r1) goto L56
            r1 = 84915(0x14bb3, float:1.18991E-40)
            if (r0 == r1) goto L4c
            r1 = 84924(0x14bbc, float:1.19004E-40)
            if (r0 == r1) goto L42
            r1 = 85315(0x14d43, float:1.19552E-40)
            if (r0 == r1) goto L36
            goto L7e
        L36:
            java.lang.String r0 = "VTA"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 3
            goto L7f
        L40:
            r2 = move-exception
            goto L9a
        L42:
            java.lang.String r0 = "VGM"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 4
            goto L7f
        L4c:
            java.lang.String r0 = "VGD"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 5
            goto L7f
        L56:
            java.lang.String r0 = "VS"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 1
            goto L7f
        L60:
            java.lang.String r0 = "VK"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 6
            goto L7f
        L6a:
            java.lang.String r0 = "VB"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 2
            goto L7f
        L74:
            java.lang.String r0 = "JM"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L7e
            r2 = 0
            goto L7f
        L7e:
            r2 = -1
        L7f:
            switch(r2) {
                case 0: goto L97;
                case 1: goto L94;
                case 2: goto L91;
                case 3: goto L8e;
                case 4: goto L8b;
                case 5: goto L88;
                case 6: goto L85;
                default: goto L82;
            }     // Catch: java.lang.Throwable -> L40
        L82:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.SelfSale     // Catch: java.lang.Throwable -> L40
            return r2
        L85:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.KuaiShou     // Catch: java.lang.Throwable -> L40
            return r2
        L88:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.YouLiangHui     // Catch: java.lang.Throwable -> L40
            return r2
        L8b:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.ChuanShanJia     // Catch: java.lang.Throwable -> L40
            return r2
        L8e:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.Tanx     // Catch: java.lang.Throwable -> L40
            return r2
        L91:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.BaiDu     // Catch: java.lang.Throwable -> L40
            return r2
        L94:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.Sigmob     // Catch: java.lang.Throwable -> L40
            return r2
        L97:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.Jd     // Catch: java.lang.Throwable -> L40
            return r2
        L9a:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r0.upLoadCatchException(r2)
        La1:
            cn.vlion.ad.inland.base.adapter.VlionBidderSource r2 = cn.vlion.ad.inland.base.adapter.VlionBidderSource.SelfSale
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.core.d.a(cn.vlion.ad.inland.core.a):cn.vlion.ad.inland.base.adapter.VlionBidderSource");
    }

    public static j0 a(VlionSlotConfig vlionSlotConfig, int i10) {
        j0 j0Var = new j0();
        if (vlionSlotConfig == null) {
            return j0Var;
        }
        try {
            j0Var.a(vlionSlotConfig.getSlotID());
            j0Var.c(vlionSlotConfig.getWidth());
            j0Var.a(vlionSlotConfig.getHeight());
            j0Var.b(vlionSlotConfig.getImageScale());
            j0Var.a(vlionSlotConfig.isHideSkip());
            j0Var.a(i10);
            j0Var.c(vlionSlotConfig.getInterstitialCloseTime());
            j0Var.b(VlionTimeConfig.getMaxTolerateTime(vlionSlotConfig.getTolerateTime()));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return j0Var;
    }
}
