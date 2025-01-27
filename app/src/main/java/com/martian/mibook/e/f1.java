package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class f1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11932a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11933b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f11934c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f11935d;

    private f1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout bookAdderListContainer, @NonNull RelativeLayout ivBookListMoreView, @NonNull ThemeTextView tvReadingRecord) {
        this.f11932a = rootView;
        this.f11933b = bookAdderListContainer;
        this.f11934c = ivBookListMoreView;
        this.f11935d = tvReadingRecord;
    }

    @NonNull
    public static f1 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        int i2 = R.id.iv_book_list_more_view;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.iv_book_list_more_view);
        if (relativeLayout != null) {
            i2 = R.id.tv_reading_record;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tv_reading_record);
            if (themeTextView != null) {
                return new f1((ThemeLinearLayout) rootView, themeLinearLayout, relativeLayout, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_list_book_more_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11932a;
    }
}
