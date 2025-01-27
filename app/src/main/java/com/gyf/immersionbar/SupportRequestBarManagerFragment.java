package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import w6.k;

/* loaded from: classes2.dex */
public final class SupportRequestBarManagerFragment extends Fragment {

    /* renamed from: c */
    public k f10628c;

    public d j(Activity activity, Dialog dialog) {
        if (this.f10628c == null) {
            this.f10628c = new k(activity, dialog);
        }
        return this.f10628c.b();
    }

    public d k(Object obj) {
        if (this.f10628c == null) {
            this.f10628c = new k(obj);
        }
        return this.f10628c.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        k kVar = this.f10628c;
        if (kVar != null) {
            kVar.c(getResources().getConfiguration());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k kVar = this.f10628c;
        if (kVar != null) {
            kVar.d(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        k kVar = this.f10628c;
        if (kVar != null) {
            kVar.e();
            this.f10628c = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k kVar = this.f10628c;
        if (kVar != null) {
            kVar.f();
        }
    }
}
