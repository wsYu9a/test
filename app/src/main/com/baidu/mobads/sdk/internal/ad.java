package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.g;
import java.util.List;

/* loaded from: classes2.dex */
public class ad implements g.a {

    /* renamed from: a */
    private BaiduNativeManager.FeedAdListener f6704a;

    public ad(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f6704a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b(int i10, String str, NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i10, str, nativeResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(int i10, String str, NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i10, str, nativeResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(NativeResponse nativeResponse, int i10) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i10);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f6704a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }
}
