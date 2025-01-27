package com.wbl.ad.yzz.help;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.wbl.ad.yzz.dialog.a;
import com.wbl.ad.yzz.dialog.f;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: c */
    @f.b.a.d
    public static final a f32628c = new a(null);

    /* renamed from: a */
    public int f32629a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.manager.f f32630b;

    public static final class a {
        public a() {
        }

        public final e a(int i2, com.wbl.ad.yzz.manager.f fVar) {
            return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13668, this, Integer.valueOf(i2), fVar);
        }

        public final e a(com.wbl.ad.yzz.manager.f fVar) {
            return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13667, this, fVar);
        }

        public final e b(com.wbl.ad.yzz.manager.f fVar) {
            return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13694, this, fVar);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a */
        public final String f32631a;

        /* renamed from: b */
        public final int f32632b;

        /* renamed from: c */
        public boolean f32633c;

        /* renamed from: d */
        public boolean f32634d;

        /* renamed from: e */
        @f.b.a.d
        public String f32635e = "图文";

        public b(int i2, @f.b.a.e String str) {
            this.f32632b = i2;
            this.f32631a = str == null ? "" : str;
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13693, this, null);
        }

        public final void a(int i2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13696, this, Integer.valueOf(i2), str, str2);
        }

        public final boolean a(int i2, String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13695, this, Integer.valueOf(i2), str);
        }

        public final boolean a(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13690, this, str);
        }

        public final boolean b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13689, this, null);
        }

        public final boolean b(int i2, String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13692, this, Integer.valueOf(i2), str);
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    public static final class d implements NativeResponse.AdDownloadWindowListener {
        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
        public void adDownloadWindowClose() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13691, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
        public void adDownloadWindowShow() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13686, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
        public void onADPermissionClose() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13685, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
        public void onADPermissionShow() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13688, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
        public void onADPrivacyClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13687, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.help.e$e */
    public static final class C0744e implements DownloadConfirmListener {

        /* renamed from: b */
        public final /* synthetic */ c f32637b;

        /* renamed from: c */
        public final /* synthetic */ int f32638c;

        /* renamed from: d */
        public final /* synthetic */ String f32639d;

        /* renamed from: com.wbl.ad.yzz.help.e$e$a */
        public static final class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ Activity f32641b;

            /* renamed from: c */
            public final /* synthetic */ int f32642c;

            /* renamed from: d */
            public final /* synthetic */ String f32643d;

            /* renamed from: e */
            public final /* synthetic */ DownloadConfirmCallBack f32644e;

            public a(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                this.f32641b = activity;
                this.f32642c = i2;
                this.f32643d = str;
                this.f32644e = downloadConfirmCallBack;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13682, this, null);
            }
        }

        public C0744e(c cVar, int i2, String str) {
            this.f32637b = cVar;
            this.f32638c = i2;
            this.f32639d = str;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13681, this, activity, Integer.valueOf(i2), str, downloadConfirmCallBack);
        }
    }

    public static final class f implements DownloadConfirmListener {
        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13684, this, activity, Integer.valueOf(i2), str, downloadConfirmCallBack);
        }
    }

    public static final class g implements DialogInterface.OnDismissListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13683, this, dialogInterface);
        }
    }

    public static final class h implements a.InterfaceC0711a {

        /* renamed from: b */
        public final /* synthetic */ Context f32647b;

        public h(Context context) {
            this.f32647b = context;
        }

        @Override // com.wbl.ad.yzz.dialog.a.InterfaceC0711a
        public void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13646, this, str);
        }

        @Override // com.wbl.ad.yzz.dialog.a.InterfaceC0711a
        public void b(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13645, this, str);
        }
    }

    public static final class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13648, this, dialogInterface);
        }
    }

    public static final class j implements f.a {

        /* renamed from: b */
        public final /* synthetic */ Context f32650b;

        public j(Context context) {
            this.f32650b = context;
        }

        @Override // com.wbl.ad.yzz.dialog.f.a
        public void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13647, this, str);
        }

        @Override // com.wbl.ad.yzz.dialog.f.a
        public void b(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13642, this, str);
        }
    }

    public static final class k implements c {

        /* renamed from: a */
        public final /* synthetic */ c f32651a;

        /* renamed from: b */
        public final /* synthetic */ DownloadConfirmCallBack f32652b;

        public k(c cVar, DownloadConfirmCallBack downloadConfirmCallBack) {
            this.f32651a = cVar;
            this.f32652b = downloadConfirmCallBack;
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13641, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13644, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13643, this, null);
        }
    }

    public static final class l implements DialogInterface.OnDismissListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13638, this, dialogInterface);
        }
    }

    public /* synthetic */ e(int i2, com.wbl.ad.yzz.manager.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, fVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.manager.f a(e eVar) {
        return (com.wbl.ad.yzz.manager.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13637, null, eVar);
    }

    public final NativeResponse.AdDownloadWindowListener a() {
        return (NativeResponse.AdDownloadWindowListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13639, this, null);
    }

    public final DownloadConfirmListener a(NativeUnifiedADData nativeUnifiedADData, int i2) {
        return (DownloadConfirmListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13634, this, nativeUnifiedADData, Integer.valueOf(i2));
    }

    public final DownloadConfirmListener a(NativeUnifiedADData nativeUnifiedADData, int i2, c cVar) {
        return (DownloadConfirmListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13633, this, nativeUnifiedADData, Integer.valueOf(i2), cVar);
    }

    public final b a(int i2, String str) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13636, this, Integer.valueOf(i2), str);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13635, this, Integer.valueOf(i2));
    }

    public final void a(int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13662, this, Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public final void a(Activity activity, int i2, String str, String str2, DownloadConfirmCallBack downloadConfirmCallBack, c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13661, this, activity, Integer.valueOf(i2), str, str2, downloadConfirmCallBack, cVar);
    }

    public final void a(Context context, NativeResponse nativeResponse, c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13664, this, context, nativeResponse, cVar);
    }

    public final void a(Context context, com.wbl.ad.yzz.bean.b bVar, c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13663, this, context, bVar, cVar);
    }

    public final void a(NativeResponse nativeResponse) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13658, this, nativeResponse);
    }

    public final void a(com.wbl.ad.yzz.bean.j jVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13657, this, jVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13660, this, null);
    }

    public final void b(NativeUnifiedADData nativeUnifiedADData, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13659, this, nativeUnifiedADData, Integer.valueOf(i2));
    }

    public final void b(NativeUnifiedADData nativeUnifiedADData, int i2, c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13654, this, nativeUnifiedADData, Integer.valueOf(i2), cVar);
    }

    public final boolean b(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13653, this, Integer.valueOf(i2));
    }

    public final boolean c(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13656, this, Integer.valueOf(i2));
    }

    public final boolean d(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13655, this, Integer.valueOf(i2));
    }

    public final void e(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13650, this, Integer.valueOf(i2));
    }

    public final boolean f(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13649, this, Integer.valueOf(i2));
    }

    public final void g(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13652, this, Integer.valueOf(i2));
    }

    public final void h(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13651, this, Integer.valueOf(i2));
    }

    public e(int i2, com.wbl.ad.yzz.manager.f fVar) {
        this.f32629a = i2;
        this.f32630b = fVar;
    }
}
