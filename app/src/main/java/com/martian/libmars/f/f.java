package com.martian.libmars.f;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.martian.libmars.activity.h1;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.q0;

/* loaded from: classes2.dex */
public class f extends Fragment {

    /* renamed from: a */
    protected j1 f10086a;

    public j1 a() {
        return this.f10086a;
    }

    public void b(String msg) {
        FragmentActivity activity = getActivity();
        if (activity instanceof h1) {
            ((h1) activity).k1(msg);
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
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f10086a = (j1) context;
        q0.f("fragment_attach", "attach:" + getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10086a = null;
        q0.f("fragment_attach", "dettach:" + getClass().getSimpleName());
    }

    public void startActivity(Class<? extends Activity> activity) {
        this.f10086a.startActivity(activity);
    }
}
