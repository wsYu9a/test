package com.kwad.components.core.l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.core.r.j;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public abstract class a extends IFragmentActivityProxy {
    public Context mContext;
    private final com.kwad.components.core.l.kwai.a mPageMonitor = new com.kwad.components.core.l.kwai.a();
    private final com.kwad.sdk.i.kwai.a mBackPressDelete = new com.kwad.sdk.i.kwai.a();
    private boolean enableDestroyer = true;

    public void addBackPressable(com.kwad.sdk.i.kwai.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public void addBackPressable(com.kwad.sdk.i.kwai.b bVar, int i2) {
        this.mBackPressDelete.addBackPressable(bVar, i2);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        j.e(intent);
        return intent;
    }

    protected abstract String getPageName();

    public boolean isEnableDestroyer() {
        return this.enableDestroyer;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mBackPressDelete.bX()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            if (!KsAdSDKImpl.get().hasInitFinish()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            this.mContext = k.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
            this.mPageMonitor.ax(getClass().getSimpleName());
            this.mPageMonitor.u(longExtra);
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
        if (this.enableDestroyer) {
            com.kwad.components.core.r.f.destroyActivity(getActivity(), getWindow());
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.core.l.kwai.a aVar = this.mPageMonitor;
        getActivity();
        aVar.pa();
    }

    public void removeBackPressable(com.kwad.sdk.i.kwai.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        super.setContentView(k.inflate(this.mContext, i2, null));
    }

    public void setEnableDestroyer(boolean z) {
        this.enableDestroyer = z;
    }
}
