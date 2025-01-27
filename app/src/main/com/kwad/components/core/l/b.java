package com.kwad.components.core.l;

import androidx.annotation.CallSuper;
import com.kwad.components.core.l.a;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class b<T extends a> extends f {
    public T mCallerContext;
    protected Presenter mPresenter;

    private void notifyOnCreate() {
        T t10 = this.mCallerContext;
        if (t10 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> it = t10.Ov.iterator();
        while (it.hasNext()) {
            it.next().gj();
        }
    }

    private void notifyOnDestroy() {
        T t10 = this.mCallerContext;
        if (t10 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> it = t10.Ov.iterator();
        while (it.hasNext()) {
            it.next().gk();
        }
    }

    private void notifyOnPause() {
        T t10 = this.mCallerContext;
        if (t10 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> it = t10.Ov.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }

    private void notifyOnResume() {
        T t10 = this.mCallerContext;
        if (t10 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> it = t10.Ov.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.I(this.mRootView);
        }
        this.mPresenter.k(this.mCallerContext);
    }

    @Override // com.kwad.components.core.proxy.f
    @CallSuper
    public void onActivityCreate() {
        try {
            super.onActivityCreate();
            initMVP();
            notifyOnCreate();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        try {
            super.onDestroy();
            notifyOnDestroy();
            T t10 = this.mCallerContext;
            if (t10 != null) {
                t10.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        try {
            super.onPause();
            notifyOnPause();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            notifyOnResume();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
