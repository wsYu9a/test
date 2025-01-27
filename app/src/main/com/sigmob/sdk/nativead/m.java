package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes4.dex */
public class m extends View {

    /* renamed from: a */
    public a0 f19976a;

    /* renamed from: b */
    public boolean f19977b;

    /* renamed from: c */
    public boolean f19978c;

    /* renamed from: d */
    public b f19979d;

    /* renamed from: e */
    public int f19980e;

    /* renamed from: f */
    public long f19981f;

    /* renamed from: g */
    public int f19982g;

    /* renamed from: h */
    public int f19983h;

    /* renamed from: i */
    public boolean f19984i;

    /* renamed from: j */
    public boolean f19985j;

    /* renamed from: k */
    public int f19986k;

    public class a extends a0 {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (87108 != message.what || m.this.f19979d == null) {
                return;
            }
            m.this.a();
            b();
        }
    }

    public interface b {
        void a(boolean z10);

        void i();

        void k();

        void l();

        void o();
    }

    public m(Context context) {
        this(context, null);
    }

    public final boolean c() {
        return this.f19977b && this.f19983h == 0 && this.f19978c;
    }

    public boolean d() {
        return getVisibility() == 0 && this.f19986k == 0 && getParent() != null;
    }

    public final void e() {
        a0 a0Var = this.f19976a;
        if (a0Var == null || !a0Var.a()) {
            return;
        }
        SigmobLog.d("-----------startTimer----------");
        this.f19976a.removeCallbacksAndMessages(null);
        this.f19976a.b();
        this.f19976a.a(false);
    }

    public final void f() {
        a();
        a0 a0Var = this.f19976a;
        if (a0Var == null || a0Var.a()) {
            return;
        }
        SigmobLog.d("-----------stopTimer----------");
        this.f19976a.removeCallbacksAndMessages(null);
        this.f19976a.a(true);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f19977b = true;
        SigmobLog.d("---------onAttachedToWindow---------");
        e();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f19977b = false;
        SigmobLog.d("---------onDetachedFromWindow----------");
        f();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        SigmobLog.d("---------onFinishTemporaryDetach-------------");
        e();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        SigmobLog.d("---------onStartTemporaryDetach-----------");
        f();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        SigmobLog.d("---------onVisibilityChanged---------" + i10);
        this.f19986k = i10;
        if (i10 == 0) {
            e();
        } else {
            f();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        SigmobLog.d("---------onWindowFocusChanged: hasWindowFocus: " + z10);
        this.f19978c = z10;
        if (this.f19984i) {
            a();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f19983h = i10;
        SigmobLog.d("---------onWindowVisibilityChanged: visibility: " + i10);
        if (i10 == 0) {
            e();
        } else {
            f();
        }
    }

    public void setAdVisibilityStatusChangeListener(b bVar) {
        this.f19979d = bVar;
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        boolean z10 = false;
        if (d() && c()) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int a10 = a(viewGroup);
            int height = viewGroup.getHeight() * viewGroup.getWidth();
            boolean z11 = height > 0 && ((float) a10) >= (((float) this.f19980e) / 100.0f) * ((float) height);
            if (a10 > 0) {
                this.f19984i = true;
                b bVar = this.f19979d;
                if (bVar != null) {
                    bVar.o();
                }
            } else {
                this.f19984i = false;
                this.f19981f = 0L;
                b bVar2 = this.f19979d;
                if (bVar2 != null) {
                    bVar2.k();
                }
            }
            if (a10 <= 0) {
                b bVar3 = this.f19979d;
                if (bVar3 == null || !this.f19984i) {
                    return;
                }
                bVar3.k();
                return;
            }
            if (z11 && this.f19984i) {
                if (this.f19981f == 0) {
                    this.f19981f = System.currentTimeMillis();
                }
                if (this.f19981f > 0 && System.currentTimeMillis() - this.f19981f >= this.f19982g * 1000) {
                    z10 = true;
                }
                b bVar4 = this.f19979d;
                if (bVar4 != null) {
                    bVar4.l();
                }
                b bVar5 = this.f19979d;
                if (bVar5 != null) {
                    bVar5.a(z10);
                    return;
                }
                return;
            }
            b bVar6 = this.f19979d;
            if (bVar6 != null) {
                bVar6.i();
            }
            b bVar7 = this.f19979d;
            if (bVar7 != null) {
                bVar7.a(false);
            }
        } else {
            b bVar8 = this.f19979d;
            if (bVar8 != null && this.f19984i) {
                bVar8.k();
            }
            this.f19984i = false;
        }
        this.f19981f = 0L;
    }

    public final void b() {
        f();
        this.f19976a = null;
    }

    public m(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19977b = false;
        this.f19978c = true;
        this.f19981f = 0L;
        this.f19982g = 0;
        this.f19983h = -1;
        this.f19984i = false;
        this.f19986k = -1;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public int a(View view) {
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            return rect.height() * rect.width();
        }
        return 0;
    }

    public void a(int i10, int i11) {
        this.f19978c = true;
        if (this.f19976a != null) {
            b();
        }
        this.f19978c = true;
        this.f19980e = i10;
        this.f19982g = i11;
        this.f19976a = new a(Looper.getMainLooper());
        e();
    }
}
