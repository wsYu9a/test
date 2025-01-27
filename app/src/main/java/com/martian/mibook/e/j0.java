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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12153a;

    /* renamed from: b */
    @NonNull
    public final TextView f12154b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12155c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12156d;

    private j0(@NonNull LinearLayout rootView, @NonNull TextView activityDesc, @NonNull ImageView activityIcon, @NonNull ThemeTextView activityTitle) {
        this.f12153a = rootView;
        this.f12154b = activityDesc;
        this.f12155c = activityIcon;
        this.f12156d = activityTitle;
    }

    @NonNull
    public static j0 a(@NonNull View rootView) {
        int i2 = R.id.activity_desc;
        TextView textView = (TextView) rootView.findViewById(R.id.activity_desc);
        if (textView != null) {
            i2 = R.id.activity_icon;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.activity_icon);
            if (imageView != null) {
                i2 = R.id.activity_title;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.activity_title);
                if (themeTextView != null) {
                    return new j0((LinearLayout) rootView, textView, imageView, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bonus_activity_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12153a;
    }
}
