package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeGridView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.ui.FlowLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12901a;

    /* renamed from: b */
    @NonNull
    public final FlowLayout f12902b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12903c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12904d;

    /* renamed from: e */
    @NonNull
    public final FlowLayout f12905e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12906f;

    /* renamed from: g */
    @NonNull
    public final ThemeImageView f12907g;

    /* renamed from: h */
    @NonNull
    public final ThemeGridView f12908h;

    private w6(@NonNull ThemeLinearLayout rootView, @NonNull FlowLayout search, @NonNull ThemeLinearLayout searchHistoryTitle, @NonNull ThemeLinearLayout searchRankView, @NonNull FlowLayout searchTags, @NonNull ThemeLinearLayout searchTagsView, @NonNull ThemeImageView spClear, @NonNull ThemeGridView spSearchRankItem) {
        this.f12901a = rootView;
        this.f12902b = search;
        this.f12903c = searchHistoryTitle;
        this.f12904d = searchRankView;
        this.f12905e = searchTags;
        this.f12906f = searchTagsView;
        this.f12907g = spClear;
        this.f12908h = spSearchRankItem;
    }

    @NonNull
    public static w6 a(@NonNull View rootView) {
        int i2 = R.id.search;
        FlowLayout flowLayout = (FlowLayout) rootView.findViewById(R.id.search);
        if (flowLayout != null) {
            i2 = R.id.search_history_title;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.search_history_title);
            if (themeLinearLayout != null) {
                i2 = R.id.search_rank_view;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.search_rank_view);
                if (themeLinearLayout2 != null) {
                    i2 = R.id.search_tags;
                    FlowLayout flowLayout2 = (FlowLayout) rootView.findViewById(R.id.search_tags);
                    if (flowLayout2 != null) {
                        i2 = R.id.search_tags_view;
                        ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.search_tags_view);
                        if (themeLinearLayout3 != null) {
                            i2 = R.id.sp_clear;
                            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.sp_clear);
                            if (themeImageView != null) {
                                i2 = R.id.sp_search_rank_item;
                                ThemeGridView themeGridView = (ThemeGridView) rootView.findViewById(R.id.sp_search_rank_item);
                                if (themeGridView != null) {
                                    return new w6((ThemeLinearLayout) rootView, flowLayout, themeLinearLayout, themeLinearLayout2, flowLayout2, themeLinearLayout3, themeImageView, themeGridView);
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
    public static w6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.search_header, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12901a;
    }
}
