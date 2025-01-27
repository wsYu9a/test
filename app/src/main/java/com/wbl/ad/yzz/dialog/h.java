package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public final Context f31905a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.innerconfig.d.d f31906b;

    /* renamed from: c */
    public final com.wbl.ad.yzz.network.b.b.k f31907c;

    /* renamed from: d */
    public final String f31908d;

    /* renamed from: e */
    @f.b.a.e
    public a f31909e;

    /* renamed from: f */
    public TextView f31910f;

    /* renamed from: g */
    public TextView f31911g;

    /* renamed from: h */
    public ImageView f31912h;

    /* renamed from: i */
    public View f31913i;

    /* renamed from: j */
    public TextView f31914j;
    public TextView k;
    public CountDownTimer l;
    public final long m;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a */
        public static final b f31915a = new b();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14492, this, view);
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14491, this, view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ boolean f31918b;

        public d(boolean z) {
            this.f31918b = z;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14486, this, view);
        }
    }

    public static final class e extends CountDownTimer {
        public e(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14485, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14488, this, Long.valueOf(j2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@f.b.a.d Context context, @f.b.a.e com.wbl.ad.yzz.innerconfig.d.d dVar, @f.b.a.d com.wbl.ad.yzz.network.b.b.k conf, @f.b.a.d String traceId) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.m = TTAdConstant.AD_MAX_EVENT_TIME;
        this.f31905a = context;
        this.f31906b = dVar;
        this.f31907c = conf;
        this.f31908d = traceId;
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d a(h hVar) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14487, null, hVar);
    }

    public static final /* synthetic */ TextView b(h hVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14482, null, hVar);
    }

    public static final /* synthetic */ String c(h hVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14481, null, hVar);
    }

    public final a a() {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14483, this, null);
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14574, this, aVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14573, this, null);
    }

    public final boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14576, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14575, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14570, this, null);
    }

    public final boolean e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14569, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14572, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14571, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14566, this, bundle);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14565, this, Integer.valueOf(i2), keyEvent);
    }
}
