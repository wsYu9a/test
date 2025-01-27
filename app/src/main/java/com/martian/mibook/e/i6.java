package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12136a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12137b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12138c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12139d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12140e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f12141f;

    private i6(@NonNull LinearLayout rootView, @NonNull LinearLayout readingRecordSyncView, @NonNull ThemeTextView recordSync, @NonNull ThemeImageView recordSyncClose, @NonNull ThemeLinearLayout recordSyncFloatView, @NonNull RelativeLayout recordSyncView) {
        this.f12136a = rootView;
        this.f12137b = readingRecordSyncView;
        this.f12138c = recordSync;
        this.f12139d = recordSyncClose;
        this.f12140e = recordSyncFloatView;
        this.f12141f = recordSyncView;
    }

    @NonNull
    public static i6 a(@NonNull View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i2 = R.id.record_sync;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.record_sync);
        if (themeTextView != null) {
            i2 = R.id.record_sync_close;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.record_sync_close);
            if (themeImageView != null) {
                i2 = R.id.record_sync_float_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.record_sync_float_view);
                if (themeLinearLayout != null) {
                    i2 = R.id.record_sync_view;
                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.record_sync_view);
                    if (relativeLayout != null) {
                        return new i6((LinearLayout) rootView, linearLayout, themeTextView, themeImageView, themeLinearLayout, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_record_sync_bottom, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12136a;
    }
}
