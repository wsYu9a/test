package com.martian.mibook.e;

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
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class k3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12241a;

    /* renamed from: b */
    @NonNull
    public final ListView f12242b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12243c;

    /* renamed from: d */
    @NonNull
    public final ProgressBar f12244d;

    /* renamed from: e */
    @NonNull
    public final TextView f12245e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12246f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12247g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12248h;

    private k3(@NonNull LinearLayout rootView, @NonNull ListView list, @NonNull LinearLayout lyEmptyHint, @NonNull ProgressBar pbLoading, @NonNull TextView tvBackupFilepath, @NonNull ThemeTextView tvCreateBackup, @NonNull ThemeTextView tvDeleteBackup, @NonNull ThemeTextView tvRestoreBookStore) {
        this.f12241a = rootView;
        this.f12242b = list;
        this.f12243c = lyEmptyHint;
        this.f12244d = pbLoading;
        this.f12245e = tvBackupFilepath;
        this.f12246f = tvCreateBackup;
        this.f12247g = tvDeleteBackup;
        this.f12248h = tvRestoreBookStore;
    }

    @NonNull
    public static k3 a(@NonNull View rootView) {
        int i2 = R.id.list;
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        if (listView != null) {
            i2 = com.martian.ttbookhd.R.id.ly_empty_hint;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(com.martian.ttbookhd.R.id.ly_empty_hint);
            if (linearLayout != null) {
                i2 = com.martian.ttbookhd.R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) rootView.findViewById(com.martian.ttbookhd.R.id.pb_loading);
                if (progressBar != null) {
                    i2 = com.martian.ttbookhd.R.id.tv_backup_filepath;
                    TextView textView = (TextView) rootView.findViewById(com.martian.ttbookhd.R.id.tv_backup_filepath);
                    if (textView != null) {
                        i2 = com.martian.ttbookhd.R.id.tv_create_backup;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(com.martian.ttbookhd.R.id.tv_create_backup);
                        if (themeTextView != null) {
                            i2 = com.martian.ttbookhd.R.id.tv_delete_backup;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(com.martian.ttbookhd.R.id.tv_delete_backup);
                            if (themeTextView2 != null) {
                                i2 = com.martian.ttbookhd.R.id.tv_restore_book_store;
                                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(com.martian.ttbookhd.R.id.tv_restore_book_store);
                                if (themeTextView3 != null) {
                                    return new k3((LinearLayout) rootView, listView, linearLayout, progressBar, textView, themeTextView, themeTextView2, themeTextView3);
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
    public static k3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(com.martian.ttbookhd.R.layout.fragment_restore_book_store, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12241a;
    }
}
