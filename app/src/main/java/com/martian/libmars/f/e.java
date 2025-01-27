package com.martian.libmars.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.n0;

/* loaded from: classes2.dex */
public abstract class e extends Fragment {

    /* renamed from: a */
    protected j1 f10082a;

    /* renamed from: b */
    private boolean f10083b = false;

    /* renamed from: c */
    private boolean f10084c = false;

    /* renamed from: d */
    protected boolean f10085d = false;

    private void e() {
        if (this.f10083b && this.f10084c && !this.f10085d) {
            c();
            this.f10085d = true;
        }
    }

    public j1 a() {
        return this.f10082a;
    }

    public boolean b() {
        return this.f10084c;
    }

    protected abstract void c();

    public void d(String msg) {
        if (n0.C(this.f10082a)) {
            this.f10082a.k1(msg);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (getActivity() != null) {
            return getActivity();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        e();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f10082a = (j1) context;
        this.f10083b = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10082a = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.f10084c = isVisibleToUser;
        e();
    }

    public void startActivity(Class<? extends Activity> activity) {
        this.f10082a.startActivity(activity);
    }
}
