package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class SimpleImmersionProxy {
    private Fragment mFragment;
    private boolean mIsActivityCreated;
    private SimpleImmersionOwner mSimpleImmersionOwner;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleImmersionProxy(Fragment fragment) {
        this.mFragment = fragment;
        if (!(fragment instanceof SimpleImmersionOwner)) {
            throw new IllegalArgumentException("Fragment请实现SimpleImmersionOwner接口");
        }
        this.mSimpleImmersionOwner = (SimpleImmersionOwner) fragment;
    }

    private void setImmersionBar() {
        Fragment fragment = this.mFragment;
        if (fragment != null && this.mIsActivityCreated && fragment.getUserVisibleHint() && this.mSimpleImmersionOwner.immersionBarEnabled()) {
            this.mSimpleImmersionOwner.initImmersionBar();
        }
    }

    public boolean isUserVisibleHint() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.getUserVisibleHint();
        }
        return false;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        this.mIsActivityCreated = true;
        setImmersionBar();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setImmersionBar();
    }

    public void onDestroy() {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.getActivity() != null && this.mSimpleImmersionOwner.immersionBarEnabled()) {
            ImmersionBar.with(this.mFragment).destroy();
        }
        this.mFragment = null;
        this.mSimpleImmersionOwner = null;
    }

    public void onHiddenChanged(boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public void setUserVisibleHint(boolean z) {
        setImmersionBar();
    }
}
