package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowLayout;

/* loaded from: classes3.dex */
public final class BookRankTopBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout bookGrabRankView;

    @NonNull
    public final LinearLayout bookRankTopView;

    @NonNull
    public final FlowLayout categoryBookStatusView;

    @NonNull
    public final FlowLayout categoryBookType;

    @NonNull
    public final TextView categoryRank;

    @NonNull
    public final LinearLayout categoryRankTitleView;

    @NonNull
    public final LinearLayout categoryRankView;

    @NonNull
    public final ThemeImageView categoryStatusIcon;

    @NonNull
    public final ImageView categoryStatusMore;

    @NonNull
    public final RecyclerView categoryTitleIrc;

    @NonNull
    public final ThemeImageView lvAccountImage1;

    @NonNull
    public final ThemeImageView lvAccountImage2;

    @NonNull
    public final ThemeImageView lvAccountImage3;

    @NonNull
    public final ThemeTextView lvAccountMoods1;

    @NonNull
    public final ThemeTextView lvAccountMoods2;

    @NonNull
    public final ThemeTextView lvAccountMoods3;

    @NonNull
    public final ThemeTextView lvAccountNickname1;

    @NonNull
    public final ThemeTextView lvAccountNickname2;

    @NonNull
    public final ThemeTextView lvAccountNickname3;

    @NonNull
    public final LinearLayout lvAccountView1;

    @NonNull
    public final LinearLayout lvAccountView2;

    @NonNull
    public final LinearLayout lvAccountView3;

    @NonNull
    private final LinearLayout rootView;

    private BookRankTopBinding(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull FlowLayout flowLayout, @NonNull FlowLayout flowLayout2, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ThemeImageView themeImageView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeImageView themeImageView3, @NonNull ThemeImageView themeImageView4, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull LinearLayout linearLayout7) {
        this.rootView = linearLayout;
        this.bookGrabRankView = relativeLayout;
        this.bookRankTopView = linearLayout2;
        this.categoryBookStatusView = flowLayout;
        this.categoryBookType = flowLayout2;
        this.categoryRank = textView;
        this.categoryRankTitleView = linearLayout3;
        this.categoryRankView = linearLayout4;
        this.categoryStatusIcon = themeImageView;
        this.categoryStatusMore = imageView;
        this.categoryTitleIrc = recyclerView;
        this.lvAccountImage1 = themeImageView2;
        this.lvAccountImage2 = themeImageView3;
        this.lvAccountImage3 = themeImageView4;
        this.lvAccountMoods1 = themeTextView;
        this.lvAccountMoods2 = themeTextView2;
        this.lvAccountMoods3 = themeTextView3;
        this.lvAccountNickname1 = themeTextView4;
        this.lvAccountNickname2 = themeTextView5;
        this.lvAccountNickname3 = themeTextView6;
        this.lvAccountView1 = linearLayout5;
        this.lvAccountView2 = linearLayout6;
        this.lvAccountView3 = linearLayout7;
    }

    @NonNull
    public static BookRankTopBinding bind(@NonNull View view) {
        int i10 = R.id.book_grab_rank_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.book_rank_top_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.category_book_status_view;
                FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                if (flowLayout != null) {
                    i10 = R.id.category_book_type;
                    FlowLayout flowLayout2 = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                    if (flowLayout2 != null) {
                        i10 = R.id.category_rank;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.category_rank_title_view;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.category_rank_view;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout3 != null) {
                                    i10 = R.id.category_status_icon;
                                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (themeImageView != null) {
                                        i10 = R.id.category_status_more;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                        if (imageView != null) {
                                            i10 = R.id.category_title_irc;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                            if (recyclerView != null) {
                                                i10 = R.id.lv_account_image_1;
                                                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                if (themeImageView2 != null) {
                                                    i10 = R.id.lv_account_image_2;
                                                    ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeImageView3 != null) {
                                                        i10 = R.id.lv_account_image_3;
                                                        ThemeImageView themeImageView4 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeImageView4 != null) {
                                                            i10 = R.id.lv_account_moods_1;
                                                            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeTextView != null) {
                                                                i10 = R.id.lv_account_moods_2;
                                                                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeTextView2 != null) {
                                                                    i10 = R.id.lv_account_moods_3;
                                                                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeTextView3 != null) {
                                                                        i10 = R.id.lv_account_nickname_1;
                                                                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeTextView4 != null) {
                                                                            i10 = R.id.lv_account_nickname_2;
                                                                            ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (themeTextView5 != null) {
                                                                                i10 = R.id.lv_account_nickname_3;
                                                                                ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeTextView6 != null) {
                                                                                    i10 = R.id.lv_account_view1;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (linearLayout4 != null) {
                                                                                        i10 = R.id.lv_account_view2;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                        if (linearLayout5 != null) {
                                                                                            i10 = R.id.lv_account_view3;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                            if (linearLayout6 != null) {
                                                                                                return new BookRankTopBinding((LinearLayout) view, relativeLayout, linearLayout, flowLayout, flowLayout2, textView, linearLayout2, linearLayout3, themeImageView, imageView, recyclerView, themeImageView2, themeImageView3, themeImageView4, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, themeTextView6, linearLayout4, linearLayout5, linearLayout6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookRankTopBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookRankTopBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_rank_top, viewGroup, false);
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
