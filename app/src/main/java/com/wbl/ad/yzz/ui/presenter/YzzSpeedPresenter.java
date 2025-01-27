package com.wbl.ad.yzz.ui.presenter;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.vivo.ic.webview.BridgeUtils;
import com.wbl.ad.yzz.d.d.d;
import com.wbl.ad.yzz.network.b.b.m;
import com.wbl.ad.yzz.network.c.c;
import com.wbl.ad.yzz.util.h;
import com.wbl.ad.yzz.util.t;
import f.b.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u001f\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001aR$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/wbl/ad/yzz/ui/presenter/YzzSpeedPresenter;", "", "Landroid/content/Context;", "context", "", "userId", "", "getDetailAd", "(Landroid/content/Context;I)V", "", "isOnlyBanner", "(Landroid/content/Context;IZ)V", "Lcom/wbl/ad/yzz/network/b/b/m;", BridgeUtils.CALL_JS_RESPONSE, "getAd", "(Lcom/wbl/ad/yzz/network/b/b/m;Z)V", "getConf", "getPopDetailAd", "getNextBannerDetailAd", "Lcom/wbl/ad/yzz/d/d/d;", "viewI", "attach", "(Lcom/wbl/ad/yzz/d/d/d;)V", "detach", "()V", "mIsOnBanner", "Z", "mContext", "Landroid/content/Context;", "mViewI", "Lcom/wbl/ad/yzz/d/d/d;", "Lcom/wbl/ad/yzz/network/c/c;", "mFeedEngine", "Lcom/wbl/ad/yzz/network/c/c;", "mIsPopUpAd", "mIsBannerShowed", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "sceneCache", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "getSceneCache", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "setSceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "<init>", "(Landroid/content/Context;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class YzzSpeedPresenter {
    private final Context mContext;
    private final c mFeedEngine;
    private boolean mIsBannerShowed;
    private boolean mIsOnBanner;
    private boolean mIsPopUpAd;
    private d mViewI;

    @e
    private com.wbl.ad.yzz.innerconfig.d.d sceneCache;

    public YzzSpeedPresenter(@e Context context) {
        this.mContext = context;
        com.wbl.ad.yzz.adrequest.c.c cVar = new com.wbl.ad.yzz.adrequest.c.c(h.b(context, t.c(context)) - 54.0f, 0.0f, 640, 320);
        c cVar2 = new c();
        this.mFeedEngine = cVar2;
        cVar2.a(cVar);
    }

    public static final /* synthetic */ d access$getMViewI$p(YzzSpeedPresenter yzzSpeedPresenter) {
        return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9058, null, yzzSpeedPresenter);
    }

    private final void getAd(m r3, boolean isOnlyBanner) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9085, this, r3, Boolean.valueOf(isOnlyBanner));
    }

    private final void getDetailAd(Context context, int userId) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9088, this, context, Integer.valueOf(userId));
    }

    private final void getDetailAd(Context context, int userId, boolean isOnlyBanner) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9087, this, context, Integer.valueOf(userId), Boolean.valueOf(isOnlyBanner));
    }

    public final void attach(d viewI) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9082, this, viewI);
    }

    public final void detach() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9081, this, null);
    }

    public final void getConf(Context context, int userId) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9084, this, context, Integer.valueOf(userId));
    }

    public final void getNextBannerDetailAd(Context context, int userId) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9083, this, context, Integer.valueOf(userId));
    }

    public final void getPopDetailAd(Context context, int userId) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9078, this, context, Integer.valueOf(userId));
    }

    public final com.wbl.ad.yzz.innerconfig.d.d getSceneCache() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9077, this, null);
    }

    public final void setSceneCache(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9080, this, dVar);
    }
}
