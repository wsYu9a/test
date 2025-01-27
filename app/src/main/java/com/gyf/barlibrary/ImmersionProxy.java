package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class ImmersionProxy {
    private Fragment mFragment;
    private ImmersionOwner mImmersionOwner;
    private boolean mIsActivityCreated;
    private boolean mIsLazyAfterView;
    private boolean mIsLazyBeforeView;

    /* JADX WARN: Multi-variable type inference failed */
    public ImmersionProxy(Fragment fragment) {
        this.mFragment = fragment;
        if (!(fragment instanceof ImmersionOwner)) {
            throw new IllegalArgumentException("Fragment请实现ImmersionOwner接口");
        }
        this.mImmersionOwner = (ImmersionOwner) fragment;
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
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.mImmersionOwner.immersionBarEnabled()) {
            this.mImmersionOwner.initImmersionBar();
        }
        if (this.mIsLazyAfterView) {
            return;
        }
        this.mImmersionOwner.onLazyAfterView();
        this.mIsLazyAfterView = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.mImmersionOwner.immersionBarEnabled()) {
            this.mImmersionOwner.initImmersionBar();
        }
        this.mImmersionOwner.onVisible();
    }

    public void onCreate(@Nullable Bundle bundle) {
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint() || this.mIsLazyBeforeView) {
            return;
        }
        this.mImmersionOwner.onLazyBeforeView();
        this.mIsLazyBeforeView = true;
    }

    public void onDestroy() {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.getActivity() != null && this.mImmersionOwner.immersionBarEnabled()) {
            ImmersionBar.with(this.mFragment).destroy();
        }
        this.mFragment = null;
        this.mImmersionOwner = null;
    }

    public void onHiddenChanged(boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public void onPause() {
        if (this.mFragment != null) {
            this.mImmersionOwner.onInvisible();
        }
    }

    public void onResume() {
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        this.mImmersionOwner.onVisible();
    }

    public void setUserVisibleHint(boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            if (!fragment.getUserVisibleHint()) {
                if (this.mIsActivityCreated) {
                    this.mImmersionOwner.onInvisible();
                    return;
                }
                return;
            }
            if (!this.mIsLazyBeforeView) {
                this.mImmersionOwner.onLazyBeforeView();
                this.mIsLazyBeforeView = true;
            }
            if (this.mIsActivityCreated && this.mFragment.getUserVisibleHint()) {
                if (this.mImmersionOwner.immersionBarEnabled()) {
                    this.mImmersionOwner.initImmersionBar();
                }
                if (!this.mIsLazyAfterView) {
                    this.mImmersionOwner.onLazyAfterView();
                    this.mIsLazyAfterView = true;
                }
                this.mImmersionOwner.onVisible();
            }
        }
    }
}
