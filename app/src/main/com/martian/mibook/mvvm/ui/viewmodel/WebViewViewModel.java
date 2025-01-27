package com.martian.mibook.mvvm.ui.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.repository.WebViewRepository;
import com.umeng.analytics.pro.bt;
import kotlin.Metadata;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010&\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR$\u0010-\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.8\u0006¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b4\u00105R\u001c\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00101R\u001f\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070.8\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b:\u00105R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00101R\u001f\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0.8\u0006¢\u0006\f\n\u0004\b$\u00101\u001a\u0004\b>\u00105R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00101R\u001f\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070.8\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\bA\u00105¨\u0006C"}, d2 = {"Lcom/martian/mibook/mvvm/ui/viewmodel/WebViewViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/ui/repository/WebViewRepository;", "<init>", "()V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/martian/mibook/mvvm/ui/repository/WebViewRepository;", "", "money", "", "productId", "extra", "", "p", "(ILjava/lang/String;Ljava/lang/String;)V", "q", "h", "Ljava/lang/String;", IAdInterListener.AdReqParam.WIDTH, "()Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;)V", "mUrl", "", "i", "Z", "u", "()Z", "C", "(Z)V", "mDownloadHint", "j", "v", "D", "mReferer", "k", t.f11211k, "B", "fullscreen", t.f11204d, "Ljava/lang/Integer;", bt.aJ, "()Ljava/lang/Integer;", "F", "(Ljava/lang/Integer;)V", "webHeight", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lcom/martian/mibook/lib/account/response/AliRechargeOrder;", "m", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mAliPrepayLiveData", "n", bt.aO, "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mAliPrepayLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "o", "_mAliPrepayErrorLiveData", "s", "mAliPrepayErrorLiveData", "Lcom/martian/mibook/lib/account/response/WXRechargeOrder;", "_mWxPrepayLiveData", "y", "mWxPrepayLiveData", "_mWxPrepayErrorLiveData", "x", "mWxPrepayErrorLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class WebViewViewModel extends BaseViewModel<WebViewRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public String mUrl;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean mDownloadHint;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public String mReferer;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean fullscreen;

    /* renamed from: l */
    @l
    public Integer webHeight;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<AliRechargeOrder> _mAliPrepayLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<AliRechargeOrder> mAliPrepayLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mAliPrepayErrorLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> mAliPrepayErrorLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<WXRechargeOrder> _mWxPrepayLiveData;

    /* renamed from: r */
    @k
    public final NonStickyLiveData<WXRechargeOrder> mWxPrepayLiveData;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mWxPrepayErrorLiveData;

    /* renamed from: t */
    @k
    public final NonStickyLiveData<ErrorResult> mWxPrepayErrorLiveData;

    public WebViewViewModel() {
        NonStickyLiveData<AliRechargeOrder> nonStickyLiveData = new NonStickyLiveData<>();
        this._mAliPrepayLiveData = nonStickyLiveData;
        this.mAliPrepayLiveData = nonStickyLiveData;
        NonStickyLiveData<ErrorResult> nonStickyLiveData2 = new NonStickyLiveData<>();
        this._mAliPrepayErrorLiveData = nonStickyLiveData2;
        this.mAliPrepayErrorLiveData = nonStickyLiveData2;
        NonStickyLiveData<WXRechargeOrder> nonStickyLiveData3 = new NonStickyLiveData<>();
        this._mWxPrepayLiveData = nonStickyLiveData3;
        this.mWxPrepayLiveData = nonStickyLiveData3;
        NonStickyLiveData<ErrorResult> nonStickyLiveData4 = new NonStickyLiveData<>();
        this._mWxPrepayErrorLiveData = nonStickyLiveData4;
        this.mWxPrepayErrorLiveData = nonStickyLiveData4;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: A */
    public WebViewRepository i() {
        return new WebViewRepository();
    }

    public final void B(boolean z10) {
        this.fullscreen = z10;
    }

    public final void C(boolean z10) {
        this.mDownloadHint = z10;
    }

    public final void D(@l String str) {
        this.mReferer = str;
    }

    public final void E(@l String str) {
        this.mUrl = str;
    }

    public final void F(@l Integer num) {
        this.webHeight = num;
    }

    public final void p(int money, @l String productId, @l String extra) {
        j(new WebViewViewModel$createAliPrepayTask$1(money, productId, extra, this, null), new WebViewViewModel$createAliPrepayTask$2(this, null), false);
    }

    public final void q(int money, @l String productId, @l String extra) {
        j(new WebViewViewModel$createWxPrepayTask$1(money, productId, extra, this, null), new WebViewViewModel$createWxPrepayTask$2(this, null), false);
    }

    /* renamed from: r, reason: from getter */
    public final boolean getFullscreen() {
        return this.fullscreen;
    }

    @k
    public final NonStickyLiveData<ErrorResult> s() {
        return this.mAliPrepayErrorLiveData;
    }

    @k
    public final NonStickyLiveData<AliRechargeOrder> t() {
        return this.mAliPrepayLiveData;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getMDownloadHint() {
        return this.mDownloadHint;
    }

    @l
    /* renamed from: v, reason: from getter */
    public final String getMReferer() {
        return this.mReferer;
    }

    @l
    /* renamed from: w, reason: from getter */
    public final String getMUrl() {
        return this.mUrl;
    }

    @k
    public final NonStickyLiveData<ErrorResult> x() {
        return this.mWxPrepayErrorLiveData;
    }

    @k
    public final NonStickyLiveData<WXRechargeOrder> y() {
        return this.mWxPrepayLiveData;
    }

    @l
    /* renamed from: z, reason: from getter */
    public final Integer getWebHeight() {
        return this.webHeight;
    }
}
