package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class ImmersionFragment extends Fragment implements ImmersionOwner {
    private ImmersionProxy mImmersionProxy = new ImmersionProxy(this);

    @Override // com.gyf.barlibrary.ImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mImmersionProxy.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mImmersionProxy.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mImmersionProxy.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mImmersionProxy.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.mImmersionProxy.onHiddenChanged(z);
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onInvisible() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onLazyAfterView() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onLazyBeforeView() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mImmersionProxy.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mImmersionProxy.onResume();
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onVisible() {
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mImmersionProxy.setUserVisibleHint(z);
    }
}
