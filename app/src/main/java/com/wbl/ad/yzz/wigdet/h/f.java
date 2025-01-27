package com.wbl.ad.yzz.wigdet.h;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class f extends AlertDialog implements View.OnClickListener {
    public InterfaceC0800f A;
    public CountDownTimer B;
    public Handler C;
    public Runnable D;

    /* renamed from: a */
    public final Context f34509a;

    /* renamed from: b */
    public TextView f34510b;

    /* renamed from: c */
    public TextView f34511c;

    /* renamed from: d */
    public TextView f34512d;

    /* renamed from: e */
    public TextView f34513e;

    /* renamed from: f */
    public TextView f34514f;

    /* renamed from: g */
    public TextView f34515g;

    /* renamed from: h */
    public TextView f34516h;

    /* renamed from: i */
    public Button f34517i;

    /* renamed from: j */
    public Button f34518j;
    public ImageView k;
    public LinearLayout l;
    public TextView m;
    public boolean n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public e y;
    public d z;

    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8606, this, dialogInterface);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8605, this, null);
        }
    }

    public class c extends CountDownTimer {
        public c(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8608, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8607, this, Long.valueOf(j2));
        }
    }

    public interface d {
        void a();
    }

    public interface e {
        void a();
    }

    /* renamed from: com.wbl.ad.yzz.wigdet.h.f$f */
    public interface InterfaceC0800f {
        void a();
    }

    public f(@NonNull Context context) {
        super(context);
        this.n = false;
        this.B = null;
        this.C = new Handler(Looper.getMainLooper());
        this.D = new b();
        this.f34509a = context;
    }

    public static /* synthetic */ e b(f fVar) {
        return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8604, null, fVar);
    }

    public static /* synthetic */ Runnable d(f fVar) {
        return (Runnable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8598, null, fVar);
    }

    public static /* synthetic */ Handler e(f fVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8597, null, fVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8600, this, null);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8599, this, Integer.valueOf(i2));
    }

    public void a(d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8594, this, dVar);
    }

    public void a(e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8593, this, eVar);
    }

    public void a(InterfaceC0800f interfaceC0800f) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8596, this, interfaceC0800f);
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8595, this, str);
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8686, this, Boolean.valueOf(z));
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8685, this, null);
    }

    public final void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8688, this, Integer.valueOf(i2));
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8687, this, str);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8682, this, null);
    }

    public void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8681, this, str);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8684, this, null);
    }

    public void d(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8683, this, str);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8678, this, null);
    }

    public void e(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8677, this, str);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8680, this, null);
    }

    public void f(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8679, this, str);
    }

    public void g(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8674, this, str);
    }

    public void h(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8673, this, str);
    }

    public void i(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8676, this, str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8675, this, view);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8702, this, bundle);
    }

    @Override // android.app.AlertDialog, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8701, this, Integer.valueOf(i2), keyEvent);
    }
}
