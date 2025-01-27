package com.martian.libmars.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.martian.libmars.activity.BaseActivity;

/* loaded from: classes3.dex */
public class MartianFragment extends Fragment {

    /* renamed from: c */
    public Activity f12352c;

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (getActivity() != null) {
            return getActivity();
        }
        return null;
    }

    public void j(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).P1(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12352c = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12352c = null;
    }

    public void startActivity(Class<? extends Activity> cls) {
        this.f12352c.startActivity(new Intent(this.f12352c, cls));
    }
}
