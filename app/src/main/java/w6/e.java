package w6;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.BarHide;

/* loaded from: classes2.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b */
    public com.gyf.immersionbar.d f31643b;

    /* renamed from: c */
    public Window f31644c;

    /* renamed from: d */
    public View f31645d;

    /* renamed from: e */
    public View f31646e;

    /* renamed from: f */
    public View f31647f;

    /* renamed from: g */
    public int f31648g;

    /* renamed from: h */
    public int f31649h;

    /* renamed from: i */
    public int f31650i;

    /* renamed from: j */
    public int f31651j;

    /* renamed from: k */
    public int f31652k;

    /* renamed from: l */
    public boolean f31653l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    public e(com.gyf.immersionbar.d dVar) {
        this.f31648g = 0;
        this.f31649h = 0;
        this.f31650i = 0;
        this.f31651j = 0;
        this.f31643b = dVar;
        Window N0 = dVar.N0();
        this.f31644c = N0;
        View decorView = N0.getDecorView();
        this.f31645d = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (dVar.f1()) {
            Fragment L0 = dVar.L0();
            if (L0 != null) {
                this.f31647f = L0.getView();
            } else {
                android.app.Fragment n02 = dVar.n0();
                if (n02 != null) {
                    this.f31647f = n02.getView();
                }
            }
        } else {
            View childAt = frameLayout.getChildAt(0);
            this.f31647f = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.f31647f = ((DrawerLayout) childAt).getChildAt(0);
            }
        }
        View view = this.f31647f;
        if (view != null) {
            this.f31648g = view.getPaddingLeft();
            this.f31649h = this.f31647f.getPaddingTop();
            this.f31650i = this.f31647f.getPaddingRight();
            this.f31651j = this.f31647f.getPaddingBottom();
        }
        ?? r42 = this.f31647f;
        this.f31646e = r42 != 0 ? r42 : frameLayout;
    }

    public void a() {
        if (this.f31653l) {
            this.f31645d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f31653l = false;
        }
    }

    public void b() {
        if (this.f31653l) {
            if (this.f31647f != null) {
                this.f31646e.setPadding(this.f31648g, this.f31649h, this.f31650i, this.f31651j);
            } else {
                this.f31646e.setPadding(this.f31643b.D0(), this.f31643b.F0(), this.f31643b.E0(), this.f31643b.C0());
            }
        }
    }

    public void c(int i10) {
        this.f31644c.setSoftInputMode(i10);
        if (this.f31653l) {
            return;
        }
        this.f31645d.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f31653l = true;
    }

    public void d() {
        this.f31652k = 0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i10;
        com.gyf.immersionbar.d dVar = this.f31643b;
        if (dVar == null || dVar.m0() == null || !this.f31643b.m0().G) {
            return;
        }
        com.gyf.immersionbar.a l02 = this.f31643b.l0();
        int d10 = l02.n() ? l02.d() : l02.g();
        Rect rect = new Rect();
        this.f31645d.getWindowVisibleDisplayFrame(rect);
        int height = this.f31646e.getHeight() - rect.bottom;
        if (height != this.f31652k) {
            this.f31652k = height;
            boolean z10 = true;
            if (com.gyf.immersionbar.d.G(this.f31644c.getDecorView().findViewById(R.id.content))) {
                height -= d10;
                if (height <= d10) {
                    z10 = false;
                }
            } else if (this.f31647f != null) {
                if (this.f31643b.m0().F) {
                    height += this.f31643b.h0() + l02.k();
                }
                if (this.f31643b.m0().f31625z) {
                    height += l02.k();
                }
                if (height > d10) {
                    i10 = this.f31651j + height;
                } else {
                    i10 = 0;
                    z10 = false;
                }
                this.f31646e.setPadding(this.f31648g, this.f31649h, this.f31650i, i10);
            } else {
                int C0 = this.f31643b.C0();
                height -= d10;
                if (height > d10) {
                    C0 = height + d10;
                } else {
                    z10 = false;
                }
                this.f31646e.setPadding(this.f31643b.D0(), this.f31643b.F0(), this.f31643b.E0(), C0);
            }
            int i11 = height >= 0 ? height : 0;
            if (this.f31643b.m0().M != null) {
                this.f31643b.m0().M.a(z10, i11);
            }
            if (!z10 && this.f31643b.m0().f31610k != BarHide.FLAG_SHOW_BAR) {
                this.f31643b.S1();
            }
            if (z10) {
                return;
            }
            this.f31643b.S();
        }
    }
}
