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
public final class p0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12511a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12512b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12513c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12514d;

    private p0(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout archiveSetting, @NonNull ThemeImageView brTagMore, @NonNull ThemeTextView brTagName) {
        this.f12511a = rootView;
        this.f12512b = archiveSetting;
        this.f12513c = brTagMore;
        this.f12514d = brTagName;
    }

    @NonNull
    public static p0 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        int i2 = R.id.br_tag_more;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.br_tag_more);
        if (themeImageView != null) {
            i2 = R.id.br_tag_name;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.br_tag_name);
            if (themeTextView != null) {
                return new p0((ThemeLinearLayout) rootView, themeLinearLayout, themeImageView, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_archive_header, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12511a;
    }
}
