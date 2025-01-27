package com.martian.libmars.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.b;
import com.martian.libmars.activity.MartianActivity;
import l9.t0;

/* loaded from: classes3.dex */
public abstract class LazyFragment extends Fragment {

    /* renamed from: c */
    public Activity f12349c;

    /* renamed from: d */
    public boolean f12350d;

    /* renamed from: e */
    public boolean f12351e;

    public Activity j() {
        return this.f12349c;
    }

    public int k() {
        int identifier = getResources().getIdentifier(b.f10638c, "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public boolean l() {
        return this.f12351e;
    }

    public abstract void m();

    public void n(boolean z10) {
        Activity activity = this.f12349c;
        if (activity instanceof MartianActivity) {
            ((MartianActivity) activity).v2(z10);
        }
    }

    public void o(String str) {
        t0.b(getActivity(), str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.f12349c = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f12349c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12349c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f12351e = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f12351e = true;
        p();
    }

    public final void p() {
        if (this.f12350d) {
            return;
        }
        this.f12350d = true;
        m();
    }

    public void setResult(int i10) {
        if (getActivity() != null) {
            getActivity().setResult(i10);
        }
    }

    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(getActivity(), cls));
    }

    public void startActivityForResult(Class<? extends Activity> cls, int i10) {
        startActivityForResult(new Intent(getActivity(), cls), i10);
    }

    public void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        startActivity(new Intent(getActivity(), cls), bundle);
    }
}
