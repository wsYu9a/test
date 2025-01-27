package com.wbl.ad.yzz.informationad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.wbl.ad.yzz.bean.j;
import com.wbl.ad.yzz.bean.r;
import com.wbl.ad.yzz.help.e;
import com.wbl.ad.yzz.help.l;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    @f.b.a.e
    public final InterfaceC0750a f32745a;

    /* renamed from: b */
    @f.b.a.e
    public final Activity f32746b;

    /* renamed from: c */
    @f.b.a.d
    public final l f32747c = new l();

    /* renamed from: d */
    @f.b.a.d
    public final com.wbl.ad.yzz.manager.f f32748d = new com.wbl.ad.yzz.manager.f();

    /* renamed from: e */
    @f.b.a.d
    public final Map<View, TTAppDownloadListener> f32749e = new WeakHashMap();

    /* renamed from: com.wbl.ad.yzz.informationad.a$a */
    public interface InterfaceC0750a {
        void a();

        void b();
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ View f32750a;

        public b(View view) {
            this.f32750a = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12884, this, view);
        }
    }

    public static final class c implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        public boolean f32751a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32753c;

        /* renamed from: d */
        public final /* synthetic */ NativeResponse f32754d;

        public c(com.wbl.ad.yzz.bean.b bVar, NativeResponse nativeResponse) {
            this.f32753c = bVar;
            this.f32754d = nativeResponse;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12883, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12974, this, Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12973, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12976, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12975, this, null);
        }
    }

    public static final class d implements TTNativeAd.AdInteractionListener {
        public d() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12970, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12969, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12972, this, tTNativeAd);
        }
    }

    public static final class e implements TTAppDownloadListener {

        /* renamed from: a */
        public boolean f32756a;

        /* renamed from: c */
        public final /* synthetic */ String f32758c;

        /* renamed from: d */
        public final /* synthetic */ View f32759d;

        public e(String str, View view) {
            this.f32758c = str;
            this.f32759d = view;
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12971, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12966, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12965, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12968, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12967, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12962, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12961, this, str, str2);
        }
    }

    public static final class f implements com.wbl.ad.yzz.adapter.c.b {
        public f() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12964, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12963, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12990, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12989, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12992, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12991, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12986, this, str, str2, bVar);
        }
    }

    public static final class g implements e.c {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f32761a;

        /* renamed from: b */
        public final /* synthetic */ int f32762b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32763c;

        public g(com.wbl.ad.yzz.help.e eVar, int i2, com.wbl.ad.yzz.bean.b bVar) {
            this.f32761a = eVar;
            this.f32762b = i2;
            this.f32763c = bVar;
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12985, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12988, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12987, this, null);
        }
    }

    public static final class h implements NativeADEventListener {

        /* renamed from: a */
        public boolean f32764a;

        /* renamed from: c */
        public final /* synthetic */ NativeUnifiedADData f32766c;

        public h(NativeUnifiedADData nativeUnifiedADData) {
            this.f32766c = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12982, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12981, this, adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12984, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12983, this, null);
        }
    }

    public a(@f.b.a.e Activity activity, @f.b.a.e InterfaceC0750a interfaceC0750a) {
        this.f32746b = activity;
        this.f32745a = interfaceC0750a;
    }

    public final Activity a() {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12978, this, null);
    }

    public final void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, View view2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12977, this, context, bVar, view, view2, Boolean.valueOf(z));
    }

    public final void a(View view, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12980, this, view, Integer.valueOf(i2));
    }

    public final void a(View view, int i2, float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12979, this, view, Integer.valueOf(i2), Float.valueOf(f2));
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, View view, View view2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12942, this, bVar, view, view2, Boolean.valueOf(z));
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, View view, j jVar, com.wbl.ad.yzz.help.e eVar, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12941, this, bVar, view, jVar, eVar, str);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, NativeAdContainer nativeAdContainer, View view, View view2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12944, this, bVar, nativeAdContainer, view, view2, Boolean.valueOf(z));
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, r rVar, String str, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12943, this, bVar, rVar, str, Boolean.valueOf(z));
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12938, this, bVar, Boolean.valueOf(z));
    }

    public final InterfaceC0750a b() {
        return (InterfaceC0750a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12937, this, null);
    }

    public final void b(com.wbl.ad.yzz.bean.b bVar, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12940, this, bVar, Boolean.valueOf(z));
    }

    public final Map<View, TTAppDownloadListener> c() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12939, this, null);
    }
}
