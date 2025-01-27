package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12104a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12105b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12106c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12107d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12108e;

    private i1(@NonNull LinearLayout rootView, @NonNull ThemeTextView batchMore, @NonNull ThemeTextView bpCategory, @NonNull ThemeTextView bpDelete, @NonNull ThemeTextView bpFlagTop) {
        this.f12104a = rootView;
        this.f12105b = batchMore;
        this.f12106c = bpCategory;
        this.f12107d = bpDelete;
        this.f12108e = bpFlagTop;
    }

    @NonNull
    public static i1 a(@NonNull View rootView) {
        int i2 = R.id.batch_more;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.batch_more);
        if (themeTextView != null) {
            i2 = R.id.bp_category;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bp_category);
            if (themeTextView2 != null) {
                i2 = R.id.bp_delete;
                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.bp_delete);
                if (themeTextView3 != null) {
                    i2 = R.id.bp_flag_top;
                    ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.bp_flag_top);
                    if (themeTextView4 != null) {
                        return new i1((LinearLayout) rootView, themeTextView, themeTextView2, themeTextView3, themeTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_batch_bottom_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12104a;
    }
}
