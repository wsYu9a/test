package com.wbl.ad.yzz.wigdet.h;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.util.a;

/* loaded from: classes5.dex */
public class b extends Dialog {

    /* renamed from: a */
    public Context f34432a;

    /* renamed from: b */
    public h f34433b;

    /* renamed from: c */
    public TextView f34434c;

    /* renamed from: d */
    public TextView f34435d;

    /* renamed from: e */
    public TextView f34436e;

    /* renamed from: f */
    public TextView f34437f;

    /* renamed from: g */
    public TextView f34438g;

    /* renamed from: h */
    public TextView f34439h;

    /* renamed from: i */
    public LinearLayout f34440i;

    /* renamed from: j */
    public RelativeLayout f34441j;
    public CountDownTimer k;
    public int l;
    public RelativeLayout m;
    public RelativeLayout n;
    public ImageView o;
    public ImageView p;
    public RelativeLayout q;
    public k0.b r;
    public int s;
    public TextView t;

    public class a implements a.j {
        public a() {
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8557, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.wigdet.h.b$b */
    public class ViewOnClickListenerC0797b implements View.OnClickListener {
        public ViewOnClickListenerC0797b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8560, this, view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8559, this, view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8554, this, view);
        }
    }

    public class e extends CountDownTimer {
        public e(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8553, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8556, this, Long.valueOf(j2));
        }
    }

    public class f implements Runnable {

        public class a implements a.j {
            public a() {
            }

            @Override // com.wbl.ad.yzz.util.a.j
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8555, this, null);
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8550, this, null);
        }
    }

    public class g implements ViewTreeObserver.OnGlobalLayoutListener {

        public class a implements a.j {
            public a() {
            }

            @Override // com.wbl.ad.yzz.util.a.j
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8549, this, null);
            }
        }

        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8552, this, null);
        }
    }

    public interface h {
        void dismiss();
    }

    public b(@NonNull Context context, k0.b bVar, h hVar) {
        super(context);
        this.l = 6;
        this.s = 0;
        this.f34432a = context;
        this.f34433b = hVar;
        this.r = bVar;
    }

    public static /* synthetic */ TextView d(b bVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8548, null, bVar);
    }

    public static /* synthetic */ ImageView e(b bVar) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8547, null, bVar);
    }

    public static /* synthetic */ RelativeLayout g(b bVar) {
        return (RelativeLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8573, null, bVar);
    }

    public static /* synthetic */ ImageView h(b bVar) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8576, null, bVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8575, this, null);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8570, this, str, str2, str3, str4, str5);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8569, this, null);
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8572, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8571, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8566, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8565, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8568, this, null);
    }

    public void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8567, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8562, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8561, this, bundle);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8564, this, Integer.valueOf(i2), keyEvent);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8563, this, onDismissListener);
    }
}
