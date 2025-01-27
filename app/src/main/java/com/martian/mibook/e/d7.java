package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11868a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11869b;

    /* renamed from: c */
    @NonNull
    public final TextView f11870c;

    private d7(@NonNull LinearLayout rootView, @NonNull ImageView clockIcon, @NonNull TextView clockName) {
        this.f11868a = rootView;
        this.f11869b = clockIcon;
        this.f11870c = clockName;
    }

    @NonNull
    public static d7 a(@NonNull View rootView) {
        int i2 = R.id.clock_icon;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.clock_icon);
        if (imageView != null) {
            i2 = R.id.clock_name;
            TextView textView = (TextView) rootView.findViewById(R.id.clock_name);
            if (textView != null) {
                return new d7((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tingshu_clock_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11868a;
    }
}
