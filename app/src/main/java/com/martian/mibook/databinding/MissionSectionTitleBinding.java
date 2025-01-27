package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class MissionSectionTitleBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView missionTitle;

    @NonNull
    public final TextView missionTitleIcon;

    @NonNull
    public final LinearLayout missionTitleView;

    @NonNull
    private final LinearLayout rootView;

    private MissionSectionTitleBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.missionTitle = themeTextView;
        this.missionTitleIcon = textView;
        this.missionTitleView = linearLayout2;
    }

    @NonNull
    public static MissionSectionTitleBinding bind(@NonNull View view) {
        int i10 = R.id.mission_title;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.mission_title_icon;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.mission_title_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    return new MissionSectionTitleBinding((LinearLayout) view, themeTextView, textView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MissionSectionTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MissionSectionTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.mission_section_title, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
