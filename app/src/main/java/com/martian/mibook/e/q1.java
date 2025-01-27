package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12552a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12553b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12554c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12555d;

    private q1(@NonNull ThemeLinearLayout rootView, @NonNull ImageView bookListItemCover, @NonNull ThemeTextView bookListItemTitle, @NonNull LinearLayout bookListItemView) {
        this.f12552a = rootView;
        this.f12553b = bookListItemCover;
        this.f12554c = bookListItemTitle;
        this.f12555d = bookListItemView;
    }

    @NonNull
    public static q1 a(@NonNull View rootView) {
        int i2 = R.id.book_list_item_cover;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.book_list_item_cover);
        if (imageView != null) {
            i2 = R.id.book_list_item_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.book_list_item_title);
            if (themeTextView != null) {
                i2 = R.id.book_list_item_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.book_list_item_view);
                if (linearLayout != null) {
                    return new q1((ThemeLinearLayout) rootView, imageView, themeTextView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_book_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12552a;
    }
}
