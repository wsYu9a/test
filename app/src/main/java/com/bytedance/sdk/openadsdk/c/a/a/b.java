package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class b implements CSJSplashAd {

    /* renamed from: a */
    private final Bridge f8099a;

    public b(Bridge bridge) {
        this.f8099a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.f8099a.values().intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f8099a.values().objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.f8099a.values().objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return (int[]) this.f8099a.values().objectValue(110006, int[].class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashClickEyeView() {
        return (View) this.f8099a.values().objectValue(110002, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.f8099a.values().objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        this.f8099a.call(110101, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, d10);
        a10.a(1, str);
        a10.a(2, str2);
        this.f8099a.call(210102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f8099a.call(210104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f8099a.call(110102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8099a.call(210103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.b.a.a.a.a(splashAdListener));
        this.f8099a.call(110103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.b.a.a.a.b(splashCardListener));
        this.f8099a.call(110106, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashClickEyeListener(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.b.a.a.a.c(splashClickEyeListener));
        this.f8099a.call(110105, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(2);
        a10.a(0, viewGroup);
        a10.a(1, activity);
        this.f8099a.call(110109, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashClickEyeView(ViewGroup viewGroup) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, viewGroup);
        this.f8099a.call(110107, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, viewGroup);
        this.f8099a.call(110108, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void startClickEye() {
        this.f8099a.call(110104, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8099a.call(210101, a10.b(), Void.class);
    }
}
