package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.wbl.ad.yzz.network.c.e.k;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class p implements com.wbl.ad.yzz.network.c.e.b {

    /* renamed from: b */
    @f.b.a.d
    public static final a f33725b = new a(null);

    /* renamed from: a */
    public final String f33726a = "ks loader";

    public static final class a {
        public a() {
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10512, this, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends com.wbl.ad.yzz.bean.b {
        public final String F;
        public View G;
        public k H;
        public KsNativeAd I;

        public static final class a implements KsNativeAd.VideoPlayListener {
            public a() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10511, this, null);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i2, int i3) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10506, this, Integer.valueOf(i2), Integer.valueOf(i3));
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10505, this, null);
            }
        }

        /* renamed from: com.wbl.ad.yzz.network.c.e.p$b$b */
        public static final class C0774b implements KsAppDownloadListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.help.n.f f33729b;

            /* renamed from: c */
            public final /* synthetic */ int f33730c;

            public C0774b(com.wbl.ad.yzz.help.n.f fVar, int i2) {
                this.f33729b = fVar;
                this.f33730c = i2;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10508, this, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10507, this, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10502, this, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10501, this, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10504, this, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10503, this, Integer.valueOf(i2));
            }
        }

        public static final class c implements KsNativeAd.AdInteractionListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.help.n.f f33732b;

            /* renamed from: c */
            public final /* synthetic */ int f33733c;

            public static final class a implements k.a {

                /* renamed from: a */
                public final /* synthetic */ DialogInterface.OnClickListener f33734a;

                public a(DialogInterface.OnClickListener onClickListener) {
                    this.f33734a = onClickListener;
                }

                @Override // com.wbl.ad.yzz.network.c.e.k.a
                public void a() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10498, this, null);
                }

                @Override // com.wbl.ad.yzz.network.c.e.k.a
                public void b() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10497, this, null);
                }
            }

            public c(com.wbl.ad.yzz.help.n.f fVar, int i2) {
                this.f33732b = fVar;
                this.f33733c = i2;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10500, this, onClickListener);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10499, this, view, ksNativeAd);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10526, this, ksNativeAd);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10525, this, null);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10528, this, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@f.b.a.d com.wbl.ad.yzz.network.b.b.b bean, @f.b.a.d KsNativeAd feedAd) {
            super(bean);
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(feedAd, "feedAd");
            this.I = feedAd;
            this.F = "ks loader KsAd";
        }

        public static final /* synthetic */ k a(b bVar) {
            return (k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10527, null, bVar);
        }

        public static final /* synthetic */ String b(b bVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10522, null, bVar);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public boolean R() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10521, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public boolean T() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10524, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public boolean V() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10523, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public View a(Context context) {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10518, this, context);
        }

        public final void a(Context context, FrameLayout frameLayout, int i2, List<View> list, com.wbl.ad.yzz.help.n.f fVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10517, this, context, frameLayout, Integer.valueOf(i2), list, fVar);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public void b(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10520, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String e() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10519, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String g() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10514, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String h() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10513, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String i() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10516, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String j() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10515, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String l() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10606, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public int m() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10605, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public String u() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10608, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.b
        public k w() {
            return (k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10607, this, null);
        }
    }

    public static final class c implements KsLoadManager.NativeAdListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.network.c.e.c f33736b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33737c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f33738d;

        public c(com.wbl.ad.yzz.network.c.e.c cVar, com.wbl.ad.yzz.network.b.b.b bVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f33736b = cVar;
            this.f33737c = bVar;
            this.f33738d = dVar;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10602, this, Integer.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(List<KsNativeAd> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10601, this, list);
        }
    }

    public static final /* synthetic */ String a(p pVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10604, null, pVar);
    }

    @Override // com.wbl.ad.yzz.network.c.e.b
    public void a(com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, com.wbl.ad.yzz.network.c.e.c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10603, this, dVar, context, bVar, str, cVar, cVar2);
    }
}
