package com.martian.mibook.databinding;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class FragmentRestoreBookStoreBinding implements ViewBinding {

    @NonNull
    public final ListView list;

    @NonNull
    public final LinearLayout lyEmptyHint;

    @NonNull
    public final ProgressBar pbLoading;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final TextView tvBackupFilepath;

    @NonNull
    public final ThemeTextView tvCreateBackup;

    @NonNull
    public final ThemeTextView tvDeleteBackup;

    @NonNull
    public final ThemeTextView tvRestoreBookStore;

    private FragmentRestoreBookStoreBinding(@NonNull LinearLayout linearLayout, @NonNull ListView listView, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = linearLayout;
        this.list = listView;
        this.lyEmptyHint = linearLayout2;
        this.pbLoading = progressBar;
        this.tvBackupFilepath = textView;
        this.tvCreateBackup = themeTextView;
        this.tvDeleteBackup = themeTextView2;
        this.tvRestoreBookStore = themeTextView3;
    }

    @NonNull
    public static FragmentRestoreBookStoreBinding bind(@NonNull View view) {
        int i10 = R.id.list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.list);
        if (listView != null) {
            i10 = com.martian.mibook.R.id.ly_empty_hint;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = com.martian.mibook.R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                if (progressBar != null) {
                    i10 = com.martian.mibook.R.id.tv_backup_filepath;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = com.martian.mibook.R.id.tv_create_backup;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = com.martian.mibook.R.id.tv_delete_backup;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = com.martian.mibook.R.id.tv_restore_book_store;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    return new FragmentRestoreBookStoreBinding((LinearLayout) view, listView, linearLayout, progressBar, textView, themeTextView, themeTextView2, themeTextView3);
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
    public static FragmentRestoreBookStoreBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentRestoreBookStoreBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(com.martian.mibook.R.layout.fragment_restore_book_store, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
