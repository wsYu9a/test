package tf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import pf.d;
import pf.e;
import pf.f;

/* loaded from: classes3.dex */
public abstract class b extends RelativeLayout implements pf.a {

    /* renamed from: b */
    public View f30865b;

    /* renamed from: c */
    public qf.b f30866c;

    /* renamed from: d */
    public pf.a f30867d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NonNull View view) {
        this(view, view instanceof pf.a ? (pf.a) view : null);
    }

    @SuppressLint({"RestrictedApi"})
    public boolean a(boolean z10) {
        pf.a aVar = this.f30867d;
        return (aVar instanceof pf.c) && ((pf.c) aVar).a(z10);
    }

    public void c(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return;
        }
        if ((this instanceof pf.c) && (aVar instanceof d)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof d) && (aVar instanceof pf.c)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        pf.a aVar2 = this.f30867d;
        if (aVar2 != null) {
            aVar2.c(fVar, refreshState, refreshState2);
        }
    }

    public void d(@NonNull e eVar, int i10, int i11) {
        pf.a aVar = this.f30867d;
        if (aVar != null && aVar != this) {
            aVar.d(eVar, i10, i11);
            return;
        }
        View view = this.f30865b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                eVar.c(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f16739a);
            }
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof pf.a) && getView() == ((pf.a) obj).getView();
    }

    @Override // pf.a
    @NonNull
    public qf.b getSpinnerStyle() {
        int i10;
        qf.b bVar = this.f30866c;
        if (bVar != null) {
            return bVar;
        }
        pf.a aVar = this.f30867d;
        if (aVar != null && aVar != this) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f30865b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                qf.b bVar2 = ((SmartRefreshLayout.LayoutParams) layoutParams).f16740b;
                this.f30866c = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i10 = layoutParams.height) == 0 || i10 == -1)) {
                for (qf.b bVar3 : qf.b.f30071i) {
                    if (bVar3.f30074c) {
                        this.f30866c = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        qf.b bVar4 = qf.b.f30066d;
        this.f30866c = bVar4;
        return bVar4;
    }

    @Override // pf.a
    @NonNull
    public View getView() {
        View view = this.f30865b;
        return view == null ? this : view;
    }

    @Override // pf.a
    public void k(float f10, int i10, int i11) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.k(f10, i10, i11);
    }

    public void l(@NonNull f fVar, int i10, int i11) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.l(fVar, i10, i11);
    }

    public boolean m(int i10, float f10, boolean z10) {
        return false;
    }

    @Override // pf.a
    public boolean n() {
        pf.a aVar = this.f30867d;
        return (aVar == null || aVar == this || !aVar.n()) ? false : true;
    }

    public int o(@NonNull f fVar, boolean z10) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return 0;
        }
        return aVar.o(fVar, z10);
    }

    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.r(z10, f10, i10, i11, i12);
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.setPrimaryColors(iArr);
    }

    public void t(@NonNull f fVar, int i10, int i11) {
        pf.a aVar = this.f30867d;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.t(fVar, i10, i11);
    }

    public b(@NonNull View view, @Nullable pf.a aVar) {
        super(view.getContext(), null, 0);
        this.f30865b = view;
        this.f30867d = aVar;
        if ((this instanceof pf.c) && (aVar instanceof d) && aVar.getSpinnerStyle() == qf.b.f30070h) {
            aVar.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof d) {
            pf.a aVar2 = this.f30867d;
            if ((aVar2 instanceof pf.c) && aVar2.getSpinnerStyle() == qf.b.f30070h) {
                aVar.getView().setScaleY(-1.0f);
            }
        }
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
