package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class SimpleImmersionFragment extends Fragment implements SimpleImmersionOwner {
    private SimpleImmersionProxy mSimpleImmersionProxy = new SimpleImmersionProxy(this);

    @Override // com.gyf.barlibrary.SimpleImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mSimpleImmersionProxy.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mSimpleImmersionProxy.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSimpleImmersionProxy.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.mSimpleImmersionProxy.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mSimpleImmersionProxy.setUserVisibleHint(z);
    }
}
