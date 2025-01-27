package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookrackMenuBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout brMenuArchive;

    @NonNull
    public final ThemeLinearLayout brMenuBatchProcess;

    @NonNull
    public final ThemeLinearLayout brMenuBookImport;

    @NonNull
    public final ThemeImageView brMenuBookImportLine;

    @NonNull
    public final ThemeLinearLayout brMenuBookSync;

    @NonNull
    public final ThemeImageView brMenuBookSyncLine;

    @NonNull
    public final ThemeLinearLayout brMenuCoverMode;

    @NonNull
    public final ThemeImageView brMenuCoverModeLine;

    @NonNull
    public final ThemeLinearLayout brMenuSearch;

    @NonNull
    public final ThemeImageView brMenuSearchLine;

    @NonNull
    public final ThemeImageView findSimilarBook;

    @NonNull
    public final ThemeLinearLayout findSimilarBookCover;

    @NonNull
    public final ThemeTextView findSimilarBookTitle;

    @NonNull
    public final ThemeImageView menuBackup;

    @NonNull
    public final ThemeImageView menuBatch;

    @NonNull
    public final ThemeImageView menuCoverMode;

    @NonNull
    public final ThemeTextView menuCoverModeTitle;

    @NonNull
    public final ThemeImageView menuIconBookImport;

    @NonNull
    public final ThemeImageView menuIconBookSearch;

    @NonNull
    private final LinearLayout rootView;

    private BookrackMenuBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull ThemeImageView themeImageView2, @NonNull ThemeLinearLayout themeLinearLayout5, @NonNull ThemeImageView themeImageView3, @NonNull ThemeLinearLayout themeLinearLayout6, @NonNull ThemeImageView themeImageView4, @NonNull ThemeImageView themeImageView5, @NonNull ThemeLinearLayout themeLinearLayout7, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView6, @NonNull ThemeImageView themeImageView7, @NonNull ThemeImageView themeImageView8, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView9, @NonNull ThemeImageView themeImageView10) {
        this.rootView = linearLayout;
        this.brMenuArchive = themeLinearLayout;
        this.brMenuBatchProcess = themeLinearLayout2;
        this.brMenuBookImport = themeLinearLayout3;
        this.brMenuBookImportLine = themeImageView;
        this.brMenuBookSync = themeLinearLayout4;
        this.brMenuBookSyncLine = themeImageView2;
        this.brMenuCoverMode = themeLinearLayout5;
        this.brMenuCoverModeLine = themeImageView3;
        this.brMenuSearch = themeLinearLayout6;
        this.brMenuSearchLine = themeImageView4;
        this.findSimilarBook = themeImageView5;
        this.findSimilarBookCover = themeLinearLayout7;
        this.findSimilarBookTitle = themeTextView;
        this.menuBackup = themeImageView6;
        this.menuBatch = themeImageView7;
        this.menuCoverMode = themeImageView8;
        this.menuCoverModeTitle = themeTextView2;
        this.menuIconBookImport = themeImageView9;
        this.menuIconBookSearch = themeImageView10;
    }

    @NonNull
    public static BookrackMenuBinding bind(@NonNull View view) {
        int i10 = R.id.br_menu_archive;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.br_menu_batch_process;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout2 != null) {
                i10 = R.id.br_menu_book_import;
                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout3 != null) {
                    i10 = R.id.br_menu_book_import_line;
                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView != null) {
                        i10 = R.id.br_menu_book_sync;
                        ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout4 != null) {
                            i10 = R.id.br_menu_book_sync_line;
                            ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView2 != null) {
                                i10 = R.id.br_menu_cover_mode;
                                ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout5 != null) {
                                    i10 = R.id.br_menu_cover_mode_line;
                                    ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (themeImageView3 != null) {
                                        i10 = R.id.br_menu_search;
                                        ThemeLinearLayout themeLinearLayout6 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (themeLinearLayout6 != null) {
                                            i10 = R.id.br_menu_search_line;
                                            ThemeImageView themeImageView4 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                            if (themeImageView4 != null) {
                                                i10 = R.id.find_similar_book;
                                                ThemeImageView themeImageView5 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                if (themeImageView5 != null) {
                                                    i10 = R.id.find_similar_book_cover;
                                                    ThemeLinearLayout themeLinearLayout7 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (themeLinearLayout7 != null) {
                                                        i10 = R.id.find_similar_book_title;
                                                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeTextView != null) {
                                                            i10 = R.id.menu_backup;
                                                            ThemeImageView themeImageView6 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeImageView6 != null) {
                                                                i10 = R.id.menu_batch;
                                                                ThemeImageView themeImageView7 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeImageView7 != null) {
                                                                    i10 = R.id.menu_cover_mode;
                                                                    ThemeImageView themeImageView8 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeImageView8 != null) {
                                                                        i10 = R.id.menu_cover_mode_title;
                                                                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeTextView2 != null) {
                                                                            i10 = R.id.menu_icon_book_import;
                                                                            ThemeImageView themeImageView9 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                            if (themeImageView9 != null) {
                                                                                i10 = R.id.menu_icon_book_search;
                                                                                ThemeImageView themeImageView10 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeImageView10 != null) {
                                                                                    return new BookrackMenuBinding((LinearLayout) view, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeImageView, themeLinearLayout4, themeImageView2, themeLinearLayout5, themeImageView3, themeLinearLayout6, themeImageView4, themeImageView5, themeLinearLayout7, themeTextView, themeImageView6, themeImageView7, themeImageView8, themeTextView2, themeImageView9, themeImageView10);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookrackMenuBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookrackMenuBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bookrack_menu, viewGroup, false);
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
