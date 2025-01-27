package com.kwad.components.core.l;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.core.r.j;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public abstract class d extends IActivityProxy {
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public Context mContext;
    private boolean mHasCallFinish;
    private final com.kwad.components.core.l.kwai.a mPageMonitor = new com.kwad.components.core.l.kwai.a();
    public View mRootView;

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle == null || !KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    protected boolean checkIntentData(@Nullable Intent intent) {
        return true;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i2) {
        T t = (T) this.mRootView.findViewById(i2);
        return t != null ? t : (T) super.findViewById(i2);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void finish() {
        if (this.mHasCallFinish) {
            return;
        }
        this.mHasCallFinish = true;
        super.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public Intent getIntent() {
        Intent intent = super.getIntent();
        j.e(intent);
        return intent;
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract String getPageName();

    protected abstract void initData();

    protected abstract void initView();

    protected boolean needAdaptionScreen() {
        return false;
    }

    @CallSuper
    protected void onActivityCreate() {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        try {
            if (!KsAdSDKImpl.get().hasInitFinish()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            this.mContext = k.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            if (!checkIntentData(intent)) {
                finish();
                return;
            }
            getWindow().setFlags(16777216, 16777216);
            getActivity().setTheme(R.style.Theme.Light.NoTitleBar.Fullscreen);
            long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
            this.mPageMonitor.ax(getPageName());
            this.mPageMonitor.u(longExtra);
            int layoutId = getLayoutId();
            if (layoutId != 0) {
                setContentView(layoutId);
            }
            initData();
            initView();
            h.oZ().a(this, bundle);
            onActivityCreate();
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
            finish();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        h.oZ().f(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        h.oZ().e(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            if (!KsAdSDKImpl.get().getIsExternal() && needAdaptionScreen() && Build.VERSION.SDK_INT <= 27) {
                com.kwad.components.core.r.d.a(getActivity(), 0, true, false);
            }
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
        disableFragmentRestore(bundle);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        super.onResume();
        com.kwad.components.core.l.kwai.a aVar = this.mPageMonitor;
        getActivity();
        aVar.pa();
        h.oZ().d(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        disableFragmentRestore(bundle);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void setContentView(int i2) {
        View inflate = k.inflate(this.mContext, i2, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }
}
