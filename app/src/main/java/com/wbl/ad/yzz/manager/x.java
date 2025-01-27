package com.wbl.ad.yzz.manager;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public final class x {

    /* renamed from: a */
    public WeakReference<WebView> f33005a;

    /* renamed from: b */
    public WeakReference<WebView> f33006b;

    public static final class a<T> implements ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback f33007a;

        public a(ValueCallback valueCallback) {
            this.f33007a = valueCallback;
        }

        public final void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12613, this, str);
        }

        @Override // android.webkit.ValueCallback
        public /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12616, this, str);
        }
    }

    public static final class b<T> implements ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback f33008a;

        public b(ValueCallback valueCallback) {
            this.f33008a = valueCallback;
        }

        public final void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12615, this, str);
        }

        @Override // android.webkit.ValueCallback
        public /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12610, this, str);
        }
    }

    public x(@f.b.a.e WebView webView) {
        if (webView == null) {
            this.f33005a = null;
        } else {
            this.f33005a = new WeakReference<>(webView);
        }
    }

    public final void a(Object obj, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12609, this, obj, str);
    }

    public final void a(String str, ValueCallback<String> valueCallback) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12612, this, str, valueCallback);
    }

    public final boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12611, this, null);
    }

    public final String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12638, this, null);
    }

    public final boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12637, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12640, this, null);
    }

    public final String e() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12639, this, null);
    }

    public final String f() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12634, this, null);
    }
}
