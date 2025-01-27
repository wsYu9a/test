package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public class h extends KsFragment implements com.kwad.sdk.l.a.b {
    protected ViewGroup Ti;
    private final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();
    protected Context mContext;
    protected ViewGroup mR;

    public final <T extends View> T findViewById(int i10) {
        ViewGroup viewGroup = this.mR;
        if (viewGroup != null) {
            return (T) viewGroup.findViewById(i10);
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public ViewGroup mw() {
        return null;
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = com.kwad.sdk.n.m.wrapContextIfNeed(getActivity());
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.Ti = viewGroup;
        if (this.mR == null) {
            ViewGroup mw = mw();
            this.mR = mw;
            if (mw == null && pR() != 0) {
                this.mR = (ViewGroup) from.inflate(pR(), viewGroup, false);
            }
        }
        return this.mR;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.s.g.destroyFragment(this.mContext, getView());
        }
    }

    public int pR() {
        return 0;
    }
}
