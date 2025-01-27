package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12091a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12092b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12093c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12094d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12095e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12096f;

    private h7(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView ttsSettingDesc, @NonNull ThemeTextView ttsSettingStatus, @NonNull ThemeImageView ttsSettingStatusMore, @NonNull ThemeTextView ttsSettingTitle, @NonNull ThemeLinearLayout ttsSettingView) {
        this.f12091a = rootView;
        this.f12092b = ttsSettingDesc;
        this.f12093c = ttsSettingStatus;
        this.f12094d = ttsSettingStatusMore;
        this.f12095e = ttsSettingTitle;
        this.f12096f = ttsSettingView;
    }

    @NonNull
    public static h7 a(@NonNull View rootView) {
        int i2 = R.id.tts_setting_desc;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tts_setting_desc);
        if (themeTextView != null) {
            i2 = R.id.tts_setting_status;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.tts_setting_status);
            if (themeTextView2 != null) {
                i2 = R.id.tts_setting_status_more;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.tts_setting_status_more);
                if (themeImageView != null) {
                    i2 = R.id.tts_setting_title;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.tts_setting_title);
                    if (themeTextView3 != null) {
                        i2 = R.id.tts_setting_view;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.tts_setting_view);
                        if (themeLinearLayout != null) {
                            return new h7((ThemeLinearLayout) rootView, themeTextView, themeTextView2, themeImageView, themeTextView3, themeLinearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tts_setting_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12091a;
    }
}
