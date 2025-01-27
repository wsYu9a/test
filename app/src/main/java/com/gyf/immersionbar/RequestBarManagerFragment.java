package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import w6.k;

/* loaded from: classes2.dex */
public final class RequestBarManagerFragment extends Fragment {

    /* renamed from: b */
    public k f10627b;

    public d a(Activity activity, Dialog dialog) {
        if (this.f10627b == null) {
            this.f10627b = new k(activity, dialog);
        }
        return this.f10627b.b();
    }

    public d b(Object obj) {
        if (this.f10627b == null) {
            this.f10627b = new k(obj);
        }
        return this.f10627b.b();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        k kVar = this.f10627b;
        if (kVar != null) {
            kVar.c(getResources().getConfiguration());
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k kVar = this.f10627b;
        if (kVar != null) {
            kVar.d(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        k kVar = this.f10627b;
        if (kVar != null) {
            kVar.e();
            this.f10627b = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        k kVar = this.f10627b;
        if (kVar != null) {
            kVar.f();
        }
    }
}
