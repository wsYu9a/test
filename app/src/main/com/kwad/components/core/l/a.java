package com.kwad.components.core.l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.l.a.a> Ov = new ArrayList();

    @NonNull
    private final b<?> Ow;

    @NonNull
    public final Context mContext;

    @NonNull
    public final View mRootView;

    public a(b<?> bVar) {
        this.Ow = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.Ow.getActivity();
    }

    public final void hK() {
        this.Ow.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Ov.clear();
    }
}
