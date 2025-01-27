package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemRecommendBookFriendBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout accountReadingRecordView;

    @NonNull
    public final ThemeImageView ivArrowRight;

    @NonNull
    public final CircleImageView ivAvatar;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final RecyclerView rvReadBooks;

    @NonNull
    public final ThemeTextView tvBookShelf;

    @NonNull
    public final TextView tvIndex;

    @NonNull
    public final ThemeTextView tvName;

    @NonNull
    public final ThemeTextView tvReadTime;

    private ItemRecommendBookFriendBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeImageView themeImageView, @NonNull CircleImageView circleImageView, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = themeLinearLayout;
        this.accountReadingRecordView = themeLinearLayout2;
        this.ivArrowRight = themeImageView;
        this.ivAvatar = circleImageView;
        this.rvReadBooks = recyclerView;
        this.tvBookShelf = themeTextView;
        this.tvIndex = textView;
        this.tvName = themeTextView2;
        this.tvReadTime = themeTextView3;
    }

    @NonNull
    public static ItemRecommendBookFriendBinding bind(@NonNull View view) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.iv_arrow_right;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.iv_avatar;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
            if (circleImageView != null) {
                i10 = R.id.rv_read_books;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.tv_book_shelf;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.tv_index;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_name;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.tv_read_time;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    return new ItemRecommendBookFriendBinding(themeLinearLayout, themeLinearLayout, themeImageView, circleImageView, recyclerView, themeTextView, textView, themeTextView2, themeTextView3);
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
    public static ItemRecommendBookFriendBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemRecommendBookFriendBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_recommend_book_friend, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
