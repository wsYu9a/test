package com.vivo.mobilead.m;

import android.text.TextUtils;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private ConcurrentHashMap<String, UnifiedVivoInterstitialAdListener> f29496a;

    /* renamed from: b */
    private ConcurrentHashMap<String, MediaListener> f29497b;

    /* renamed from: c */
    private ConcurrentHashMap<String, UnifiedVivoRewardVideoAdListener> f29498c;

    private static class b {

        /* renamed from: a */
        private static final a f29499a = new a();
    }

    /* synthetic */ a(C0599a c0599a) {
        this();
    }

    public static a a() {
        return b.f29499a;
    }

    public UnifiedVivoInterstitialAdListener b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f29496a.get(str);
    }

    public MediaListener c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f29497b.get(str);
    }

    public UnifiedVivoRewardVideoAdListener d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f29498c.get(str);
    }

    private a() {
        this.f29496a = new ConcurrentHashMap<>();
        this.f29497b = new ConcurrentHashMap<>();
        this.f29498c = new ConcurrentHashMap<>();
    }

    public void a(String str, UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener) {
        if (TextUtils.isEmpty(str) || unifiedVivoInterstitialAdListener == null) {
            return;
        }
        this.f29496a.put(str, unifiedVivoInterstitialAdListener);
    }

    public void a(String str, UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        if (TextUtils.isEmpty(str) || unifiedVivoRewardVideoAdListener == null) {
            return;
        }
        this.f29498c.put(str, unifiedVivoRewardVideoAdListener);
    }

    public void a(String str, MediaListener mediaListener) {
        if (TextUtils.isEmpty(str) || mediaListener == null) {
            return;
        }
        this.f29497b.put(str, mediaListener);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f29496a.remove(str);
        this.f29497b.remove(str);
        this.f29498c.remove(str);
    }
}
