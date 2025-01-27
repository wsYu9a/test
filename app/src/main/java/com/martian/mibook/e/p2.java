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
public final class p2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12517a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12518b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12519c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12520d;

    private p2(@NonNull LinearLayout rootView, @NonNull ThemeTextView dialogItemShift, @NonNull ThemeTextView dialogItemTitle, @NonNull LinearLayout tagView) {
        this.f12517a = rootView;
        this.f12518b = dialogItemShift;
        this.f12519c = dialogItemTitle;
        this.f12520d = tagView;
    }

    @NonNull
    public static p2 a(@NonNull View rootView) {
        int i2 = R.id.dialog_item_shift;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.dialog_item_shift);
        if (themeTextView != null) {
            i2 = R.id.dialog_item_title;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.dialog_item_title);
            if (themeTextView2 != null) {
                i2 = R.id.tag_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.tag_view);
                if (linearLayout != null) {
                    return new p2((LinearLayout) rootView, themeTextView, themeTextView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_store_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12517a;
    }
}
