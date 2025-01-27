package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityIncomeBinding implements ViewBinding {

    @NonNull
    private final View rootView;

    private ActivityIncomeBinding(@NonNull View view) {
        this.rootView = view;
    }

    @NonNull
    public static ActivityIncomeBinding bind(@NonNull View view) {
        if (view != null) {
            return new ActivityIncomeBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityIncomeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ActivityIncomeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_income, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
