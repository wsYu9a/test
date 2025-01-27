package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class t3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12729a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12730b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12731c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12732d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12733e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12734f;

    /* renamed from: g */
    @NonNull
    public final RelativeLayout f12735g;

    private t3(@NonNull RelativeLayout rootView, @NonNull ThemeTextView recordBookname, @NonNull ThemeImageView recordCover, @NonNull ThemeImageView recordIconClose, @NonNull ThemeTextView recordReading, @NonNull ThemeTextView recordStatus, @NonNull RelativeLayout recordView) {
        this.f12729a = rootView;
        this.f12730b = recordBookname;
        this.f12731c = recordCover;
        this.f12732d = recordIconClose;
        this.f12733e = recordReading;
        this.f12734f = recordStatus;
        this.f12735g = recordView;
    }

    @NonNull
    public static t3 a(@NonNull View rootView) {
        int i2 = R.id.record_bookname;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.record_bookname);
        if (themeTextView != null) {
            i2 = R.id.record_cover;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.record_cover);
            if (themeImageView != null) {
                i2 = R.id.record_icon_close;
                ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.record_icon_close);
                if (themeImageView2 != null) {
                    i2 = R.id.record_reading;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.record_reading);
                    if (themeTextView2 != null) {
                        i2 = R.id.record_status;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.record_status);
                        if (themeTextView3 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) rootView;
                            return new t3(relativeLayout, themeTextView, themeImageView, themeImageView2, themeTextView2, themeTextView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_reading_record, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12729a;
    }
}
