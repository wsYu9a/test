package com.kwad.components.core.j;

import androidx.annotation.CallSuper;
import com.kwad.components.core.j.a;
import com.kwad.components.core.l.d;
import com.kwad.sdk.mvp.Presenter;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class b<T extends a> extends d {
    private final com.kwad.sdk.i.kwai.a mBackPressDelete = new com.kwad.sdk.i.kwai.a();
    public T mCallerContext;
    protected Presenter mPresenter;

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        Iterator<com.kwad.components.core.j.kwai.a> it = t.JT.iterator();
        while (it.hasNext()) {
            it.next().fY();
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        Iterator<com.kwad.components.core.j.kwai.a> it = t.JT.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        Iterator<com.kwad.components.core.j.kwai.a> it = t.JT.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        Iterator<com.kwad.components.core.j.kwai.a> it = t.JT.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public void addBackPressable(com.kwad.sdk.i.kwai.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public void addBackPressable(com.kwad.sdk.i.kwai.b bVar, int i2) {
        this.mBackPressDelete.addBackPressable(bVar, i2);
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.E(this.mRootView);
        }
        this.mPresenter.f(this.mCallerContext);
    }

    @Override // com.kwad.components.core.l.d
    @CallSuper
    public void onActivityCreate() {
        super.onActivityCreate();
        initMVP();
        notifyOnCreate();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onBackPressed() {
        if (this.mBackPressDelete.bX()) {
            return;
        }
        super.onBackPressed();
    }

    protected abstract T onCreateCallerContext();

    protected abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        notifyOnDestroy();
        T t = this.mCallerContext;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        super.onPause();
        notifyOnPause();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        super.onResume();
        notifyOnResume();
    }

    public void removeBackPressable(com.kwad.sdk.i.kwai.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }
}
