package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: i */
    public static boolean f31873i;

    /* renamed from: j */
    @f.b.a.d
    public static final a f31874j = new a(null);

    /* renamed from: a */
    public final Context f31875a;

    /* renamed from: b */
    public int f31876b;

    /* renamed from: c */
    public ImageView f31877c;

    /* renamed from: d */
    public TextView f31878d;

    /* renamed from: e */
    public final long f31879e;

    /* renamed from: f */
    public b f31880f;

    /* renamed from: g */
    public CountDownTimer f31881g;

    /* renamed from: h */
    public com.wbl.ad.yzz.innerconfig.d.d f31882h;

    public static final class a {
        public a() {
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14505, this, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a();
    }

    public static final class c extends CountDownTimer {
        public c(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14508, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14507, this, Long.valueOf(j2));
        }
    }

    /* renamed from: com.wbl.ad.yzz.dialog.d$d */
    public static final class ViewOnClickListenerC0712d implements View.OnClickListener {
        public ViewOnClickListenerC0712d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14502, this, view);
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14501, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@f.b.a.d Context context, int i2, @f.b.a.e com.wbl.ad.yzz.innerconfig.d.d dVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new Handler(Looper.getMainLooper());
        this.f31879e = 4000L;
        this.f31875a = context;
        this.f31876b = i2;
        this.f31882h = dVar;
    }

    public static final /* synthetic */ TextView b(d dVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14498, null, dVar);
    }

    public final void a(b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14497, this, bVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14500, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14499, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14526, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14525, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14528, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14527, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14522, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14521, this, bundle);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14524, this, Integer.valueOf(i2), keyEvent);
    }
}
