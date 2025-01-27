package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12856a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12857b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12858c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12859d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12860e;

    /* renamed from: f */
    @NonNull
    public final TextView f12861f;

    /* renamed from: g */
    @NonNull
    public final ListView f12862g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12863h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12864i;

    private w0(@NonNull RelativeLayout rootView, @NonNull ThemeTextView bsFilepath, @NonNull LinearLayout bsImportHint, @NonNull ThemeTextView bsLocalUp, @NonNull LinearLayout emptyLoading, @NonNull TextView emptyText, @NonNull ListView list, @NonNull ThemeTextView tvAddBookRack, @NonNull ThemeTextView tvSelectAll) {
        this.f12856a = rootView;
        this.f12857b = bsFilepath;
        this.f12858c = bsImportHint;
        this.f12859d = bsLocalUp;
        this.f12860e = emptyLoading;
        this.f12861f = emptyText;
        this.f12862g = list;
        this.f12863h = tvAddBookRack;
        this.f12864i = tvSelectAll;
    }

    @NonNull
    public static w0 a(@NonNull View rootView) {
        int i2 = R.id.bs_filepath;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_filepath);
        if (themeTextView != null) {
            i2 = R.id.bs_import_hint;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bs_import_hint);
            if (linearLayout != null) {
                i2 = R.id.bs_local_up;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bs_local_up);
                if (themeTextView2 != null) {
                    i2 = R.id.empty_loading;
                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.empty_loading);
                    if (linearLayout2 != null) {
                        i2 = R.id.empty_text;
                        TextView textView = (TextView) rootView.findViewById(R.id.empty_text);
                        if (textView != null) {
                            i2 = android.R.id.list;
                            ListView listView = (ListView) rootView.findViewById(android.R.id.list);
                            if (listView != null) {
                                i2 = R.id.tv_add_book_rack;
                                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.tv_add_book_rack);
                                if (themeTextView3 != null) {
                                    i2 = R.id.tv_select_all;
                                    ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.tv_select_all);
                                    if (themeTextView4 != null) {
                                        return new w0((RelativeLayout) rootView, themeTextView, linearLayout, themeTextView2, linearLayout2, textView, listView, themeTextView3, themeTextView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_local_directory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12856a;
    }
}
