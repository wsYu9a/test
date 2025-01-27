package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12402a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12403b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12404c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12405d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12406e;

    /* renamed from: f */
    @NonNull
    public final ThemeImageView f12407f;

    /* renamed from: g */
    @NonNull
    public final ThemeLinearLayout f12408g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12409h;

    /* renamed from: i */
    @NonNull
    public final ThemeLinearLayout f12410i;

    /* renamed from: j */
    @NonNull
    public final ThemeImageView f12411j;

    @NonNull
    public final ThemeLinearLayout k;

    @NonNull
    public final ThemeTextView l;

    @NonNull
    public final ThemeImageView m;

    @NonNull
    public final ThemeImageView n;

    @NonNull
    public final ThemeImageView o;

    @NonNull
    public final ThemeTextView p;

    @NonNull
    public final ThemeImageView q;

    @NonNull
    public final ThemeImageView r;

    @NonNull
    public final ThemeImageView s;

    private n1(@NonNull LinearLayout rootView, @NonNull ThemeLinearLayout brMenuBatchProcess, @NonNull ThemeLinearLayout brMenuBookImport, @NonNull ThemeLinearLayout brMenuBookSync, @NonNull ThemeLinearLayout brMenuCover, @NonNull ThemeImageView brMenuCoverLine, @NonNull ThemeLinearLayout brMenuCoverMode, @NonNull ThemeTextView brMenuCoverTitle, @NonNull ThemeLinearLayout brMenuSearch, @NonNull ThemeImageView findSimilarBook, @NonNull ThemeLinearLayout findSimilarBookCover, @NonNull ThemeTextView findSimilarBookTitle, @NonNull ThemeImageView menuBackup, @NonNull ThemeImageView menuBatch, @NonNull ThemeImageView menuCoverMode, @NonNull ThemeTextView menuCoverModeTitle, @NonNull ThemeImageView menuFiling, @NonNull ThemeImageView menuIconBookImport, @NonNull ThemeImageView menuIconBookSearch) {
        this.f12402a = rootView;
        this.f12403b = brMenuBatchProcess;
        this.f12404c = brMenuBookImport;
        this.f12405d = brMenuBookSync;
        this.f12406e = brMenuCover;
        this.f12407f = brMenuCoverLine;
        this.f12408g = brMenuCoverMode;
        this.f12409h = brMenuCoverTitle;
        this.f12410i = brMenuSearch;
        this.f12411j = findSimilarBook;
        this.k = findSimilarBookCover;
        this.l = findSimilarBookTitle;
        this.m = menuBackup;
        this.n = menuBatch;
        this.o = menuCoverMode;
        this.p = menuCoverModeTitle;
        this.q = menuFiling;
        this.r = menuIconBookImport;
        this.s = menuIconBookSearch;
    }

    @NonNull
    public static n1 a(@NonNull View rootView) {
        int i2 = R.id.br_menu_batch_process;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.br_menu_batch_process);
        if (themeLinearLayout != null) {
            i2 = R.id.br_menu_book_import;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.br_menu_book_import);
            if (themeLinearLayout2 != null) {
                i2 = R.id.br_menu_book_sync;
                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.br_menu_book_sync);
                if (themeLinearLayout3 != null) {
                    i2 = R.id.br_menu_cover;
                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) rootView.findViewById(R.id.br_menu_cover);
                    if (themeLinearLayout4 != null) {
                        i2 = R.id.br_menu_cover_line;
                        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.br_menu_cover_line);
                        if (themeImageView != null) {
                            i2 = R.id.br_menu_cover_mode;
                            ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) rootView.findViewById(R.id.br_menu_cover_mode);
                            if (themeLinearLayout5 != null) {
                                i2 = R.id.br_menu_cover_title;
                                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.br_menu_cover_title);
                                if (themeTextView != null) {
                                    i2 = R.id.br_menu_search;
                                    ThemeLinearLayout themeLinearLayout6 = (ThemeLinearLayout) rootView.findViewById(R.id.br_menu_search);
                                    if (themeLinearLayout6 != null) {
                                        i2 = R.id.find_similar_book;
                                        ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.find_similar_book);
                                        if (themeImageView2 != null) {
                                            i2 = R.id.find_similar_book_cover;
                                            ThemeLinearLayout themeLinearLayout7 = (ThemeLinearLayout) rootView.findViewById(R.id.find_similar_book_cover);
                                            if (themeLinearLayout7 != null) {
                                                i2 = R.id.find_similar_book_title;
                                                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.find_similar_book_title);
                                                if (themeTextView2 != null) {
                                                    i2 = R.id.menu_backup;
                                                    ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(R.id.menu_backup);
                                                    if (themeImageView3 != null) {
                                                        i2 = R.id.menu_batch;
                                                        ThemeImageView themeImageView4 = (ThemeImageView) rootView.findViewById(R.id.menu_batch);
                                                        if (themeImageView4 != null) {
                                                            i2 = R.id.menu_cover_mode;
                                                            ThemeImageView themeImageView5 = (ThemeImageView) rootView.findViewById(R.id.menu_cover_mode);
                                                            if (themeImageView5 != null) {
                                                                i2 = R.id.menu_cover_mode_title;
                                                                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.menu_cover_mode_title);
                                                                if (themeTextView3 != null) {
                                                                    i2 = R.id.menu_filing;
                                                                    ThemeImageView themeImageView6 = (ThemeImageView) rootView.findViewById(R.id.menu_filing);
                                                                    if (themeImageView6 != null) {
                                                                        i2 = R.id.menu_icon_book_import;
                                                                        ThemeImageView themeImageView7 = (ThemeImageView) rootView.findViewById(R.id.menu_icon_book_import);
                                                                        if (themeImageView7 != null) {
                                                                            i2 = R.id.menu_icon_book_search;
                                                                            ThemeImageView themeImageView8 = (ThemeImageView) rootView.findViewById(R.id.menu_icon_book_search);
                                                                            if (themeImageView8 != null) {
                                                                                return new n1((LinearLayout) rootView, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeLinearLayout4, themeImageView, themeLinearLayout5, themeTextView, themeLinearLayout6, themeImageView2, themeLinearLayout7, themeTextView2, themeImageView3, themeImageView4, themeImageView5, themeTextView3, themeImageView6, themeImageView7, themeImageView8);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    public static n1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12402a;
    }
}
