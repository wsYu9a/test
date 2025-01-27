package com.wbl.ad.yzz.ms.d.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.d.c;
import com.wbl.ad.yzz.ms.data.view.MuVideoTextureView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class g extends FrameLayout implements com.wbl.ad.yzz.ms.d.c {
    public com.wbl.ad.yzz.ms.d.e.e A;
    public MediaPlayer.OnInfoListener B;
    public com.wbl.ad.yzz.ms.d.e.a C;
    public com.wbl.ad.yzz.ms.d.d.b D;
    public volatile boolean E;
    public volatile boolean F;
    public volatile boolean G;
    public volatile boolean H;

    @SuppressLint({"HandlerLeak"})
    public Handler I;
    public List<c.a> J;
    public com.wbl.ad.yzz.ms.d.d.c K;
    public BroadcastReceiver L;

    /* renamed from: a */
    public final String f33074a;

    /* renamed from: b */
    public MuVideoTextureView f33075b;

    /* renamed from: c */
    public com.wbl.ad.yzz.ms.c.a f33076c;

    /* renamed from: d */
    public TextView f33077d;

    /* renamed from: e */
    public TextView f33078e;

    /* renamed from: f */
    public ProgressBar f33079f;

    /* renamed from: g */
    public MediaPlayer f33080g;

    /* renamed from: h */
    public int f33081h;

    /* renamed from: i */
    public int f33082i;

    /* renamed from: j */
    public long f33083j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public com.wbl.ad.yzz.ms.d.e.b q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public float w;
    public float x;
    public c.InterfaceC0761c y;
    public c.b z;

    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11941, this, mediaPlayer);
        }
    }

    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11944, this, mediaPlayer);
        }
    }

    public class c implements MediaPlayer.OnInfoListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11943, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11938, this, message);
        }
    }

    public class e implements com.wbl.ad.yzz.ms.d.d.c {
        public e() {
        }

        @Override // com.wbl.ad.yzz.ms.d.d.c
        public void onDestroy() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11937, this, null);
        }

        @Override // com.wbl.ad.yzz.ms.d.d.c
        public void onPause() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11940, this, null);
        }

        @Override // com.wbl.ad.yzz.ms.d.d.c
        public void onResume() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11939, this, null);
        }

        @Override // com.wbl.ad.yzz.ms.d.d.c
        public void onStart() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11966, this, null);
        }

        @Override // com.wbl.ad.yzz.ms.d.d.c
        public void onStop() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11965, this, null);
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11968, this, context, intent);
        }
    }

    /* renamed from: com.wbl.ad.yzz.ms.d.e.g$g */
    public class ViewOnClickListenerC0762g implements View.OnClickListener {
        public ViewOnClickListenerC0762g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11967, this, view);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11962, this, view);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11961, this, view);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11964, this, view);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11963, this, view);
        }
    }

    public class l implements MediaPlayer.OnErrorListener {
        public l() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11958, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public g(@NonNull Context context) {
        super(context);
        this.f33074a = getClass().getSimpleName();
        this.f33083j = -1L;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.I = new d();
        this.J = new ArrayList();
        this.K = new e();
        this.L = new f();
        a(context);
    }

    public static /* synthetic */ MuVideoTextureView a(g gVar) {
        return (MuVideoTextureView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11957, null, gVar);
    }

    public static /* synthetic */ TextView b(g gVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11954, null, gVar);
    }

    public static /* synthetic */ Handler d(g gVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11918, null, gVar);
    }

    public static /* synthetic */ String e(g gVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11920, null, gVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ms.d.e.b i(g gVar) {
        return (com.wbl.ad.yzz.ms.d.e.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11915, null, gVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ms.c.a m(g gVar) {
        return (com.wbl.ad.yzz.ms.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11911, null, gVar);
    }

    public static /* synthetic */ MediaPlayer.OnInfoListener o(g gVar) {
        return (MediaPlayer.OnInfoListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11905, null, gVar);
    }

    public static /* synthetic */ ProgressBar p(g gVar) {
        return (ProgressBar) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11908, null, gVar);
    }

    public static /* synthetic */ c.b s(g gVar) {
        return (c.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11933, null, gVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ms.d.e.e u(g gVar) {
        return (com.wbl.ad.yzz.ms.d.e.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11935, null, gVar);
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11929, this, null);
    }

    public final void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11932, this, context);
    }

    public final void a(TextView textView, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11931, this, textView, Integer.valueOf(i2));
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11926, this, null);
    }

    public final void b(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11925, this, context);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11928, this, null);
    }

    public void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11927, this, null);
    }

    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11922, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11921, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11924, this, null);
    }

    public int getCurrentPosition() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11923, this, null);
    }

    public int getDuration() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12014, this, null);
    }

    public MuVideoTextureView getMVideoView() {
        return (MuVideoTextureView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12013, this, null);
    }

    @Override // com.wbl.ad.yzz.ms.d.c
    public View getVideoView() {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12016, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12015, this, null);
    }

    public void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12010, this, null);
    }

    public void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12009, this, null);
    }

    public void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12012, this, null);
    }

    public void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12011, this, null);
    }

    public void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12006, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12005, this, null);
    }

    public void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12008, this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12007, this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12002, this, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12001, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void setActivityForLifecycle(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12004, this, activity);
    }

    public void setAdListener(com.wbl.ad.yzz.ms.d.e.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12003, this, aVar);
    }

    public void setAutoStart(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12030, this, Boolean.valueOf(z));
    }

    public void setConfigHeight(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12029, this, Integer.valueOf(i2));
    }

    public void setConfigWidth(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12032, this, Integer.valueOf(i2));
    }

    public void setContainerHeight(float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12031, this, Float.valueOf(f2));
    }

    public void setContainerWidth(float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12026, this, Float.valueOf(f2));
    }

    public void setDisplayMode(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12025, this, Integer.valueOf(i2));
    }

    public void setFromLogo(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12028, this, str);
    }

    public void setFromLogoVisibility(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12027, this, Integer.valueOf(i2));
    }

    public void setInitMute(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12022, this, Boolean.valueOf(z));
    }

    public void setMsAd(com.wbl.ad.yzz.ms.d.e.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12021, this, bVar);
    }

    @Override // com.wbl.ad.yzz.ms.d.c
    public void setNativeAdMediaListener(com.wbl.ad.yzz.ms.d.e.e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12024, this, eVar);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12023, this, onInfoListener);
    }

    public void setOnVideoLoadedListener(c.InterfaceC0761c interfaceC0761c) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12018, this, interfaceC0761c);
    }

    public void setPlayOnce(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12017, this, Boolean.valueOf(z));
    }

    public void setRecycler(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12020, this, Boolean.valueOf(z));
    }

    public void setUseTransform(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12019, this, Boolean.valueOf(z));
    }

    public void setVideoCover(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11982, this, str);
    }

    public void setVideoEndCover(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11981, this, str);
    }

    public void setVideoPath(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11984, this, str);
    }
}
