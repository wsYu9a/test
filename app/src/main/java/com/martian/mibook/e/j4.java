package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12184a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12185b;

    /* renamed from: c */
    @NonNull
    public final TextView f12186c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12187d;

    private j4(@NonNull LinearLayout rootView, @NonNull ThemeTextView missionTitle, @NonNull TextView missionTitleIcon, @NonNull LinearLayout missionTitleView) {
        this.f12184a = rootView;
        this.f12185b = missionTitle;
        this.f12186c = missionTitleIcon;
        this.f12187d = missionTitleView;
    }

    @NonNull
    public static j4 a(@NonNull View rootView) {
        int i2 = R.id.mission_title;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.mission_title);
        if (themeTextView != null) {
            i2 = R.id.mission_title_icon;
            TextView textView = (TextView) rootView.findViewById(R.id.mission_title_icon);
            if (textView != null) {
                i2 = R.id.mission_title_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.mission_title_view);
                if (linearLayout != null) {
                    return new j4((LinearLayout) rootView, themeTextView, textView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.mission_section_title, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12184a;
    }
}
