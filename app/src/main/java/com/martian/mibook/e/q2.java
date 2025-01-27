package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12556a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12557b;

    /* renamed from: c */
    @NonNull
    public final View f12558c;

    /* renamed from: d */
    @NonNull
    public final View f12559d;

    /* renamed from: e */
    @NonNull
    public final ListView f12560e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12561f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12562g;

    private q2(@NonNull RelativeLayout rootView, @NonNull ThemeLinearLayout bookrackCategory, @NonNull View bookrackCategoryTop, @NonNull View storeCategoryView, @NonNull ListView tagCategoryList, @NonNull ThemeTextView tagCategoryNews, @NonNull ThemeTextView tagTitle) {
        this.f12556a = rootView;
        this.f12557b = bookrackCategory;
        this.f12558c = bookrackCategoryTop;
        this.f12559d = storeCategoryView;
        this.f12560e = tagCategoryList;
        this.f12561f = tagCategoryNews;
        this.f12562g = tagTitle;
    }

    @NonNull
    public static q2 a(@NonNull View rootView) {
        int i2 = R.id.bookrack_category;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bookrack_category);
        if (themeLinearLayout != null) {
            i2 = R.id.bookrack_category_top;
            View findViewById = rootView.findViewById(R.id.bookrack_category_top);
            if (findViewById != null) {
                i2 = R.id.store_category_view;
                View findViewById2 = rootView.findViewById(R.id.store_category_view);
                if (findViewById2 != null) {
                    i2 = R.id.tag_category_list;
                    ListView listView = (ListView) rootView.findViewById(R.id.tag_category_list);
                    if (listView != null) {
                        i2 = R.id.tag_category_news;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tag_category_news);
                        if (themeTextView != null) {
                            i2 = R.id.tag_title;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.tag_title);
                            if (themeTextView2 != null) {
                                return new q2((RelativeLayout) rootView, themeLinearLayout, findViewById, findViewById2, listView, themeTextView, themeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_tag, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12556a;
    }
}
