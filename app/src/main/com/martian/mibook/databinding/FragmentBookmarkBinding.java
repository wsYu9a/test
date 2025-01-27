package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class FragmentBookmarkBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView emptyText;

    @NonNull
    public final ListView list;

    @NonNull
    private final RelativeLayout rootView;

    private FragmentBookmarkBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ListView listView) {
        this.rootView = relativeLayout;
        this.emptyText = readerThemeTextView;
        this.list = listView;
    }

    @NonNull
    public static FragmentBookmarkBinding bind(@NonNull View view) {
        int i10 = R.id.empty_text;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = android.R.id.list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, android.R.id.list);
            if (listView != null) {
                return new FragmentBookmarkBinding((RelativeLayout) view, readerThemeTextView, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentBookmarkBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookmarkBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bookmark, viewGroup, false);
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
