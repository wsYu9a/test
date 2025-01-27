package com.aggmoread.sdk.z.d.a.a.d.a.d.u.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.j;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends com.aggmoread.sdk.z.d.a.a.d.a.d.d {

    /* renamed from: y */
    protected static String f5708y = "AMUTAGGDT";

    /* renamed from: w */
    public NativeUnifiedADData f5709w;

    /* renamed from: x */
    public int f5710x;

    public class a implements NativeADEventListener {

        /* renamed from: a */
        final /* synthetic */ WeakReference f5711a;

        /* renamed from: b */
        final /* synthetic */ f.a f5712b;

        public a(WeakReference weakReference, f.a aVar) {
            this.f5711a = weakReference;
            this.f5712b = aVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(e.f5708y, "onADClicked");
            e eVar = e.this;
            eVar.f5277j++;
            k kVar = new k(eVar.f5275h, eVar.f5276i);
            k a10 = kVar.a(k.b.f6046n, e.this.f5273f);
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar2 = e.this.f5276i;
            WeakReference weakReference = this.f5711a;
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = weakReference == null ? null : (com.aggmoread.sdk.z.d.a.a.d.b.m.a) weakReference.get();
            e eVar3 = e.this;
            boolean a11 = a10.a(eVar2, aVar, eVar3.f5278k, eVar3.f5281n);
            kVar.b();
            l.a((Object) e.this.f5281n, false, true);
            if (a11) {
                this.f5712b.onAdClicked();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            com.aggmoread.sdk.z.d.a.a.e.e.a(e.f5708y, "onADError %s", adError);
            e.this.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(e.f5708y, "onADExposed ");
            new HashMap();
            e.this.f5278k = System.currentTimeMillis();
            l.a((Object) e.this.f5281n, true, true);
            e.this.a(this.f5712b);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(e.f5708y, "onADStatusChanged");
            f.a aVar = this.f5712b;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onADStatusChanged(e.this.f5709w.getAppStatus());
                if (e.this.f5709w.getAppStatus() == 4) {
                    ((f.b) this.f5712b).onLoadApkProgress(e.this.f5709w.getProgress());
                }
            }
        }
    }

    public class b implements NativeADMediaListener {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.t.a f5714a;

        public b(e eVar, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
            this.f5714a = aVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            this.f5714a.onVideoClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            this.f5714a.onVideoCompleted();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            this.f5714a.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            this.f5714a.onVideoInit();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i10) {
            this.f5714a.onVideoLoaded(i10);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
            this.f5714a.onVideoLoading();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            this.f5714a.onVideoPause();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            this.f5714a.onVideoReady();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            this.f5714a.onVideoResume();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            this.f5714a.onVideoStart();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            this.f5714a.onVideoStop();
        }
    }

    public e(NativeUnifiedADData nativeUnifiedADData, NativeUnifiedAD nativeUnifiedAD, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map, int i10) {
        super(dVar, eVar, map);
        this.f5709w = nativeUnifiedADData;
        this.f5710x = i10;
        if (nativeUnifiedADData != null) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5319p, nativeUnifiedADData, eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[Catch: Exception -> 0x0021, TryCatch #0 {Exception -> 0x0021, blocks: (B:3:0x0002, B:6:0x0012, B:9:0x0028, B:11:0x0032, B:12:0x003a, B:20:0x00d8, B:22:0x00e0, B:27:0x003f, B:30:0x004a, B:33:0x0055, B:36:0x0060, B:39:0x006a, B:42:0x0074, B:45:0x007e, B:48:0x0088, B:51:0x0092, B:54:0x009d, B:57:0x00a8, B:60:0x00b3, B:63:0x00be, B:67:0x0024), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject e() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.e.e():org.json.JSONObject");
    }

    private com.aggmoread.sdk.z.d.a.a.c.c i() {
        try {
            Object invoke = this.f5709w.getClass().getMethod("getAppMiitInfo", null).invoke(this.f5709w, null);
            Object b10 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getAppName");
            Object b11 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getAuthorName");
            Object b12 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getPackageSizeBytes");
            Object b13 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getPermissionsUrl");
            Object b14 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getPrivacyAgreement");
            Object b15 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getVersionName");
            Object b16 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getDescriptionUrl");
            Object b17 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getIcpNumber");
            Object b18 = j.b(NativeUnifiedADAppMiitInfo.class, invoke, "getSuitableAge");
            String str = b10 instanceof String ? (String) b10 : null;
            String str2 = b11 instanceof String ? (String) b11 : null;
            long longValue = b12 instanceof Long ? ((Long) b12).longValue() : 0L;
            String str3 = b13 instanceof String ? (String) b13 : null;
            String str4 = b14 instanceof String ? (String) b14 : null;
            String str5 = b15 instanceof String ? (String) b15 : null;
            String str6 = b16 instanceof String ? (String) b16 : null;
            String str7 = b17 instanceof String ? (String) b17 : null;
            String str8 = b18 instanceof String ? (String) b18 : null;
            String j10 = j();
            com.aggmoread.sdk.z.d.a.a.c.c a10 = com.aggmoread.sdk.z.d.a.a.c.c.a(str, str2, longValue, str3, str4, str5);
            a10.c(j10);
            a10.a(str6);
            a10.b(str7);
            a10.d(str8);
            return a10;
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5708y, "err " + e10);
            return null;
        }
    }

    private String j() {
        JSONObject optJSONObject;
        JSONObject e10 = e();
        String optString = (e10 == null || (optJSONObject = e10.optJSONObject("ext")) == null) ? "" : optJSONObject.optString("packagename");
        try {
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
            String a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5709w);
            return (TextUtils.isEmpty(a10) || !a10.contains(PushClientConstants.TAG_PKG_NAME)) ? optString : Uri.parse(a10).getQueryParameter(PushClientConstants.TAG_PKG_NAME);
        } catch (Exception e11) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5708y, "gdt pkg err:  " + e11.getMessage());
            return optString;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        String str;
        String str2;
        NativeAdContainer nativeAdContainer;
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5708y, "enter " + view);
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar2 = null;
        if (this.f5710x == 91) {
            a(new i(1001006001, "GDT ad blocked"));
            return null;
        }
        List<View> arrayList = list == null ? new ArrayList<>() : list;
        View view4 = view3 != null ? view3 : view;
        if (arrayList.contains(view4)) {
            str = f5708y;
            str2 = "ovov + true";
        } else {
            str = f5708y;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !arrayList.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5708y, "ovov ");
            arrayList.add(view4);
        }
        this.f5274g = aVar;
        if ((view instanceof com.aggmoread.sdk.z.d.a.a.d.b.m.a) && this.f5323t) {
            aVar2 = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) view;
            nativeAdContainer = (NativeAdContainer) aVar2.findViewWithTag(com.aggmoread.sdk.z.d.a.a.d.a.d.d.f5317u);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5708y, "f n " + nativeAdContainer);
        } else {
            nativeAdContainer = null;
        }
        if (aVar2 == null || nativeAdContainer == null) {
            nativeAdContainer = (NativeAdContainer) a(context);
            aVar2 = a(view, view3, nativeAdContainer);
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar3 = aVar2;
        a(context, nativeAdContainer, layoutParams, arrayList, list2, this.f5282o, aVar);
        a(this.f5282o.get(), view2 != null ? new View[]{view2} : new View[0]);
        return aVar3;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup b(Context context) {
        return new MediaView(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void bindCTAViews(List<View> list) {
        this.f5709w.bindCTAViews(list);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void destroy() {
        this.f5709w.destroy();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int f() {
        return this.f5709w.getVideoDuration();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public com.aggmoread.sdk.z.d.a.a.c.c g() {
        return m.a("4.380") ? i() : super.g();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAdPatternType() {
        return this.f5709w.getAdPatternType();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public double getAppPrice() {
        return this.f5709w.getAppPrice();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppScore() {
        return this.f5709w.getAppScore();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppStatus() {
        return this.f5709w.getAppStatus();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getCTAText() {
        return this.f5709w.getCTAText();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getDesc() {
        return this.f5709w.getDesc();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public long getDownloadCount() {
        return this.f5709w.getDownloadCount();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getIconUrl() {
        return this.f5709w.getIconUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getImageUrl() {
        return this.f5709w.getImgUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public List<String> getImageUrlList() {
        return this.f5709w.getImgList();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureHeight() {
        return this.f5709w.getPictureHeight();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureWidth() {
        return this.f5709w.getPictureWidth();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getProgress() {
        return this.f5709w.getProgress();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getTitle() {
        return this.f5709w.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getVideoCurrentPosition() {
        return this.f5709w.getVideoCurrentPosition();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isAppAd() {
        return this.f5709w.isAppAd();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isVideoAd() {
        return this.f5709w.getAdPatternType() == 2;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void pauseVideo() {
        this.f5709w.pauseVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resume() {
        this.f5709w.resume();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resumeVideo() {
        this.f5709w.resumeVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void setVideoMute(boolean z10) {
        this.f5709w.setVideoMute(z10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void startVideo() {
        this.f5709w.startVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void stopVideo() {
        this.f5709w.stopVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup a(Context context) {
        return new NativeAdContainer(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5709w, i10);
    }

    public void a(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2, WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference, f.a aVar) {
        NativeUnifiedADData nativeUnifiedADData = this.f5709w;
        if (nativeUnifiedADData == null || nativeAdContainer == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(nativeUnifiedADData, c());
        this.f5709w.setNativeAdEventListener(new a(weakReference, aVar));
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            for (View view : list) {
                com.aggmoread.sdk.z.d.a.a.e.e.b(f5708y, "clickView " + view);
            }
        }
        this.f5709w.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5709w, i11, i10, str);
    }

    public void a(View view, View[] viewArr) {
        l.a(this.f5275h.f5856b, this.f5281n, com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW, view, viewArr, this.f5322s, this.f5320q);
        l.b(this.f5275h.f5856b, this.f5276i.e(), this.f5276i.b());
        byte[] b10 = this.f5275h.f5872r.b();
        if (b10 != null) {
            l.a(this.f5275h.f5856b, b10);
        }
        l.a(this.f5281n, this.f5276i);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
        if (viewGroup instanceof MediaView) {
            com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5275h.f5873s;
            VideoOption.Builder builder = new VideoOption.Builder();
            if (bVar != null) {
                builder.setAutoPlayMuted(bVar.d());
                builder.setAutoPlayPolicy(bVar.a());
                builder.setEnableDetailPage(bVar.f());
                builder.setNeedCoverImage(bVar.g());
                builder.setNeedProgressBar(bVar.h());
            }
            this.f5709w.bindMediaView((MediaView) viewGroup, builder.build(), new b(this, aVar));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public boolean a(View view) {
        return view instanceof MediaView;
    }
}
