package com.martian.mibook.databinding;

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
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookLocalDirectoryBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bsFilepath;

    @NonNull
    public final LinearLayout bsImportHint;

    @NonNull
    public final ThemeTextView bsLocalUp;

    @NonNull
    public final LinearLayout emptyLoading;

    @NonNull
    public final TextView emptyText;

    @NonNull
    public final ListView list;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView tvAddBookRack;

    @NonNull
    public final ThemeTextView tvSelectAll;

    private BookLocalDirectoryBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ListView listView, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.rootView = relativeLayout;
        this.bsFilepath = themeTextView;
        this.bsImportHint = linearLayout;
        this.bsLocalUp = themeTextView2;
        this.emptyLoading = linearLayout2;
        this.emptyText = textView;
        this.list = listView;
        this.tvAddBookRack = themeTextView3;
        this.tvSelectAll = themeTextView4;
    }

    @NonNull
    public static BookLocalDirectoryBinding bind(@NonNull View view) {
        int i10 = R.id.bs_filepath;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bs_import_hint;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.bs_local_up;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.empty_loading;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.empty_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = android.R.id.list;
                            ListView listView = (ListView) ViewBindings.findChildViewById(view, android.R.id.list);
                            if (listView != null) {
                                i10 = R.id.tv_add_book_rack;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.tv_select_all;
                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView4 != null) {
                                        return new BookLocalDirectoryBinding((RelativeLayout) view, themeTextView, linearLayout, themeTextView2, linearLayout2, textView, listView, themeTextView3, themeTextView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookLocalDirectoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookLocalDirectoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_local_directory, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
