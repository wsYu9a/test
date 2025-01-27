package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class LoadingDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12314a;

    public LoadingDialogBinding(@NonNull LinearLayout linearLayout) {
        this.f12314a = linearLayout;
    }

    @NonNull
    public static LoadingDialogBinding a(@NonNull View view) {
        if (view != null) {
            return new LoadingDialogBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static LoadingDialogBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LoadingDialogBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.loading_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12314a;
    }
}
