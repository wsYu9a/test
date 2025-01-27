package com.kwad.components.core.j;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T JV;
    protected ViewGroup lW;
    protected Presenter mPresenter;

    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        if (kl()) {
            return;
        }
        nF();
    }

    private void initMVP() {
        this.JV = kp();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.E(this.lW);
        }
        this.mPresenter.f(this.JV);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initData();

    protected boolean kl() {
        return false;
    }

    protected abstract void kn();

    protected abstract T kp();

    protected final void nF() {
        initData();
        this.lW = (ViewGroup) k.inflate(getContext(), getLayoutId(), this);
        kn();
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        T t = this.JV;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
