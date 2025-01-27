package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12584a;

    /* renamed from: b */
    @NonNull
    public final ThemeIRecyclerView f12585b;

    /* renamed from: c */
    @NonNull
    public final ThemeIRecyclerView f12586c;

    /* renamed from: d */
    @NonNull
    public final LoadingTip f12587d;

    /* renamed from: e */
    @NonNull
    public final RelativeLayout f12588e;

    /* renamed from: f */
    @NonNull
    public final ListView f12589f;

    private r(@NonNull ThemeLinearLayout rootView, @NonNull ThemeIRecyclerView hotBooksIrc, @NonNull ThemeIRecyclerView lvSearchBooks, @NonNull LoadingTip lvSearchBooksTip, @NonNull RelativeLayout lvSearchBooksView, @NonNull ListView svSearchBooks) {
        this.f12584a = rootView;
        this.f12585b = hotBooksIrc;
        this.f12586c = lvSearchBooks;
        this.f12587d = lvSearchBooksTip;
        this.f12588e = lvSearchBooksView;
        this.f12589f = svSearchBooks;
    }

    @NonNull
    public static r a(@NonNull View rootView) {
        int i2 = R.id.hot_books_irc;
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.hot_books_irc);
        if (themeIRecyclerView != null) {
            i2 = R.id.lv_search_books;
            ThemeIRecyclerView themeIRecyclerView2 = (ThemeIRecyclerView) rootView.findViewById(R.id.lv_search_books);
            if (themeIRecyclerView2 != null) {
                i2 = R.id.lv_search_books_tip;
                LoadingTip loadingTip = (LoadingTip) rootView.findViewById(R.id.lv_search_books_tip);
                if (loadingTip != null) {
                    i2 = R.id.lv_search_books_view;
                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.lv_search_books_view);
                    if (relativeLayout != null) {
                        i2 = R.id.sv_search_books;
                        ListView listView = (ListView) rootView.findViewById(R.id.sv_search_books);
                        if (listView != null) {
                            return new r((ThemeLinearLayout) rootView, themeIRecyclerView, themeIRecyclerView2, loadingTip, relativeLayout, listView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static r c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_search_book_main, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12584a;
    }
}
