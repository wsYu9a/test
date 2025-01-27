package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class LibmarsActivityBackableBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12271a;

    /* renamed from: b */
    @NonNull
    public final LibmarsActionBarBinding f12272b;

    /* renamed from: c */
    @NonNull
    public final ViewStub f12273c;

    public LibmarsActivityBackableBinding(@NonNull LinearLayout linearLayout, @NonNull LibmarsActionBarBinding libmarsActionBarBinding, @NonNull ViewStub viewStub) {
        this.f12271a = linearLayout;
        this.f12272b = libmarsActionBarBinding;
        this.f12273c = viewStub;
    }

    @NonNull
    public static LibmarsActivityBackableBinding a(@NonNull View view) {
        int i10 = R.id.libmars_action_bar;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            LibmarsActionBarBinding a10 = LibmarsActionBarBinding.a(findChildViewById);
            int i11 = R.id.libmars_main_container;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i11);
            if (viewStub != null) {
                return new LibmarsActivityBackableBinding((LinearLayout) view, a10, viewStub);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsActivityBackableBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsActivityBackableBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_activity_backable, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12271a;
    }
}
