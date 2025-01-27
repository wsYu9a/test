package cn.vlion.ad.inland.base;

import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class h0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ViewGroup f2841a;

    /* renamed from: b */
    public final /* synthetic */ i6 f2842b;

    /* renamed from: c */
    public final /* synthetic */ i0 f2843c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (h0.this.f2843c.f2898k != null) {
                    i0 i0Var = h0.this.f2843c;
                    i0Var.f2908u = "click";
                    i0Var.f2898k.a("click", h0.this.f2843c.f2901n);
                    LogVlion.e("端策略 : ViewOnTouchDataUtils-= 点击==");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public h0(i0 i0Var, ViewGroup viewGroup, i6 i6Var) {
        this.f2843c = i0Var;
        this.f2841a = viewGroup;
        this.f2842b = i6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i6 i6Var;
        try {
            if (this.f2841a == null || this.f2842b == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            j0.a(this.f2842b);
            if (this.f2843c.f2907t && (i6Var = this.f2842b) != null && i6Var.getBaseSwipeView() != null) {
                this.f2842b.getBaseSwipeView().setOnTouchListener(this.f2843c);
                this.f2842b.getBaseSwipeView().setOnClickListener(new a());
            }
            this.f2841a.addView(this.f2842b, layoutParams);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
