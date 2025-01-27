package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.widget.ClassicRefreshHeaderView;

/* loaded from: classes2.dex */
public final class k implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ClassicRefreshHeaderView f10014a;

    private k(@NonNull ClassicRefreshHeaderView rootView) {
        this.f10014a = rootView;
    }

    @NonNull
    public static k a(@NonNull View rootView) {
        if (rootView != null) {
            return new k((ClassicRefreshHeaderView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static k c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_irecyclerview_classic_refresh_header, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ClassicRefreshHeaderView getRoot() {
        return this.f10014a;
    }
}
