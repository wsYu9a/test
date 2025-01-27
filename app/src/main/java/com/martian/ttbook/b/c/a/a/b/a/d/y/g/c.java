package com.martian.ttbook.b.c.a.a.b.a.d.y.g;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class c implements InvocationHandler {

    /* renamed from: a */
    private a f15534a;

    public interface a {
        void a();

        @Deprecated
        void a(boolean z, int i2, String str, int i3, String str2);

        void b(boolean z, int i2, Bundle bundle);

        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onSkippedVideo();

        void onVideoComplete();
    }

    public c(a aVar) {
        this.f15534a = aVar;
    }

    public TTRewardVideoAd.RewardAdInteractionListener a() {
        return (TTRewardVideoAd.RewardAdInteractionListener) Proxy.newProxyInstance(TTRewardVideoAd.RewardAdInteractionListener.class.getClassLoader(), new Class[]{TTRewardVideoAd.RewardAdInteractionListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f15534a == null) {
            return null;
        }
        if ("onAdShow".equals(name)) {
            this.f15534a.onAdShow();
        } else if ("onAdVideoBarClick".equals(name)) {
            this.f15534a.onAdVideoBarClick();
        } else if ("onAdClose".equals(name)) {
            this.f15534a.onAdClose();
        } else if ("onVideoComplete".equals(name)) {
            this.f15534a.onVideoComplete();
        } else if ("onVideoError".equals(name)) {
            this.f15534a.a();
        } else if ("onSkippedVideo".equals(name)) {
            this.f15534a.onSkippedVideo();
        } else if ("onRewardVerify".equals(name)) {
            this.f15534a.a(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), (String) objArr[4]);
        } else if ("onRewardArrived".equals(name)) {
            this.f15534a.b(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue(), (Bundle) objArr[2]);
        }
        return null;
    }
}
