package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class DialogBottomCustomLayoutBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12129a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f12130b;

    public DialogBottomCustomLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout) {
        this.f12129a = relativeLayout;
        this.f12130b = frameLayout;
    }

    @NonNull
    public static DialogBottomCustomLayoutBinding a(@NonNull View view) {
        int i10 = R.id.custom_content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
        if (frameLayout != null) {
            return new DialogBottomCustomLayoutBinding((RelativeLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogBottomCustomLayoutBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogBottomCustomLayoutBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_bottom_custom_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12129a;
    }
}
