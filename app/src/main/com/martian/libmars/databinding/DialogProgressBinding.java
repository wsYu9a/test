package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class DialogProgressBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12168a;

    /* renamed from: b */
    @NonNull
    public final ProgressBar f12169b;

    /* renamed from: c */
    @NonNull
    public final TextView f12170c;

    public DialogProgressBinding(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView) {
        this.f12168a = linearLayout;
        this.f12169b = progressBar;
        this.f12170c = textView;
    }

    @NonNull
    public static DialogProgressBinding a(@NonNull View view) {
        int i10 = R.id.progressBar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
        if (progressBar != null) {
            i10 = R.id.tv_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                return new DialogProgressBinding((LinearLayout) view, progressBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogProgressBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogProgressBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_progress, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12168a;
    }
}
