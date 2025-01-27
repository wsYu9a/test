package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookListBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bsFileScan;

    @NonNull
    public final LinearLayout bsImport;

    @NonNull
    public final ThemeTextView bsStopScan;

    @NonNull
    public final ListView list;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView tvAddBookRack;

    @NonNull
    public final ThemeTextView tvSelectAll;

    private BookListBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView2, @NonNull ListView listView, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.rootView = relativeLayout;
        this.bsFileScan = themeTextView;
        this.bsImport = linearLayout;
        this.bsStopScan = themeTextView2;
        this.list = listView;
        this.tvAddBookRack = themeTextView3;
        this.tvSelectAll = themeTextView4;
    }

    @NonNull
    public static BookListBinding bind(@NonNull View view) {
        int i10 = R.id.bs_file_scan;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bs_import;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.bs_stop_scan;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = android.R.id.list;
                    ListView listView = (ListView) ViewBindings.findChildViewById(view, android.R.id.list);
                    if (listView != null) {
                        i10 = R.id.tv_add_book_rack;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            i10 = R.id.tv_select_all;
                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView4 != null) {
                                return new BookListBinding((RelativeLayout) view, themeTextView, linearLayout, themeTextView2, listView, themeTextView3, themeTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_list, viewGroup, false);
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
