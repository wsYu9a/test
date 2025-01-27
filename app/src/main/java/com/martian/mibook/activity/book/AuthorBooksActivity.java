package com.martian.mibook.activity.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.libsupport.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.fragment.AuthorBookListFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import ya.e0;

/* loaded from: classes3.dex */
public class AuthorBooksActivity extends MiBackableActivity {
    public static final String H = "book_more_type";
    public static final String I = "TYPE_AUTHOR_BOOK";
    public static final String J = "TYPE_AUTHOR_BOOK_SEARCH";
    public static final String K = "TYPE_SIMILAR_BOOK";
    public static final String L = "TYPE_SIMILAR_BOOK_EXIT_READING";
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public int G;

    public static void L2(Activity activity, Book book, String str, int i10) {
        if (book == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.U0, book.getBookName());
        bundle.putString(e0.f33173r0, book.getSourceName());
        bundle.putString(e0.f33175s0, book.getSourceId());
        bundle.putString(e0.f33177t0, book.getSourceString());
        bundle.putString(MiConfigSingleton.V0, book.getAuthor());
        bundle.putString(H, str);
        bundle.putInt(MiConfigSingleton.W0, i10);
        Intent intent = new Intent(activity, (Class<?>) AuthorBooksActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void M2(Activity activity, BookInfo bookInfo) {
        if (bookInfo == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.U0, bookInfo.getBookName());
        bundle.putString(e0.f33173r0, bookInfo.getSourceName());
        bundle.putString(e0.f33175s0, bookInfo.getSourceId());
        bundle.putString(e0.f33177t0, bookInfo.getSourceString());
        bundle.putString(H, K);
        Intent intent = new Intent(activity, (Class<?>) AuthorBooksActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_load_fragment);
        if (bundle != null) {
            this.A = bundle.getString(MiConfigSingleton.V0);
            this.B = bundle.getString(MiConfigSingleton.U0);
            this.D = bundle.getString(e0.f33175s0);
            this.C = bundle.getString(e0.f33173r0);
            this.E = bundle.getString(e0.f33177t0);
            this.F = bundle.getString(H);
            this.G = bundle.getInt(MiConfigSingleton.W0);
        } else {
            this.A = q1(MiConfigSingleton.V0);
            this.B = q1(MiConfigSingleton.U0);
            this.D = q1(e0.f33175s0);
            this.C = q1(e0.f33173r0);
            this.E = q1(e0.f33177t0);
            this.F = q1(H);
            this.G = g1(MiConfigSingleton.W0, 0);
        }
        if (J.equalsIgnoreCase(this.F)) {
            if (l.q(this.A)) {
                t2(getString(com.martian.mibook.R.string.author_books_second));
            } else {
                t2(this.A + "的作品");
            }
        } else if (!I.equalsIgnoreCase(this.F)) {
            t2(getString(com.martian.mibook.R.string.same_like_books));
        } else if (l.q(this.A)) {
            t2(getString(com.martian.mibook.R.string.author_books_second));
        } else {
            t2(this.A + "的其他作品");
        }
        if (((AuthorBookListFragment) getSupportFragmentManager().findFragmentByTag("yw_new_book_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(com.martian.mibook.R.id.fragmentContainer, (I.equalsIgnoreCase(this.F) || J.equalsIgnoreCase(this.F)) ? AuthorBookListFragment.Z(this.A, this.B, this.F) : AuthorBookListFragment.a0(this.B, this.D, this.C, this.E, this.F, this.G), "yw_new_book_list_fragment").commit();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(MiConfigSingleton.V0, this.A);
        bundle.putString(MiConfigSingleton.U0, this.B);
        bundle.putString(e0.f33173r0, this.C);
        bundle.putString(e0.f33175s0, this.D);
        bundle.putString(e0.f33177t0, this.E);
        bundle.putString(H, this.F);
        bundle.putInt(MiConfigSingleton.W0, this.G);
    }
}
