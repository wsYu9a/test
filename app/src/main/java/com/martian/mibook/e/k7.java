package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12267a;

    /* renamed from: b */
    @NonNull
    public final View f12268b;

    /* renamed from: c */
    @NonNull
    public final TextView f12269c;

    private k7(@NonNull LinearLayout rootView, @NonNull View withdrawLine, @NonNull TextView withdrawTitle) {
        this.f12267a = rootView;
        this.f12268b = withdrawLine;
        this.f12269c = withdrawTitle;
    }

    @NonNull
    public static k7 a(@NonNull View rootView) {
        int i2 = R.id.withdraw_line;
        View findViewById = rootView.findViewById(R.id.withdraw_line);
        if (findViewById != null) {
            i2 = R.id.withdraw_title;
            TextView textView = (TextView) rootView.findViewById(R.id.withdraw_title);
            if (textView != null) {
                return new k7((LinearLayout) rootView, findViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.withdraw_title_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12267a;
    }
}
