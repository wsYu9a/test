package com.kwad.components.core.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes3.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Ox;
    public Presenter mPresenter;
    protected ViewGroup mR;

    public c(Context context) {
        this(context, null);
    }

    private void initMVP() {
        this.Ox = ak();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.I(this.mR);
        }
        this.mPresenter.k(this.Ox);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void Z() {
        super.Z();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void aa() {
        super.aa();
        T t10 = this.Ox;
        if (t10 != null) {
            t10.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public boolean ah() {
        return false;
    }

    public abstract void aj();

    public abstract T ak();

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initData();

    @NonNull
    public abstract Presenter onCreatePresenter();

    public final void py() {
        initData();
        this.mR = (ViewGroup) m.inflate(getContext(), getLayoutId(), this);
        aj();
    }

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        if (ah()) {
            return;
        }
        py();
    }
}
