package com.martian.mibook.activity.book;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.j1;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.n3;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class AuthorBooksActivity extends com.martian.mibook.lib.model.b.a {
    public static final String F = "book_more_type";
    public static final String G = "TYPE_AUTHOR_BOOK";
    public static final String H = "TYPE_AUTHOR_BOOK_SEARCH";
    public static final String I = "TYPE_SIMILAR_BOOK";
    public static final String J = "TYPE_SIMILAR_BOOK_EXIT_READING";
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private int Q;

    public static void r2(j1 activity, BookInfoActivity.o bookInfo) {
        if (bookInfo == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.L0, bookInfo.c());
        bundle.putString(MiConfigSingleton.D0, bookInfo.o());
        bundle.putString(MiConfigSingleton.F0, bookInfo.n());
        bundle.putString(MiConfigSingleton.G0, bookInfo.p());
        bundle.putString(F, I);
        activity.startActivity(AuthorBooksActivity.class, bundle);
    }

    public static void s2(j1 activity, Book book, String type, int seed) {
        if (book == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.L0, book.getBookName());
        bundle.putString(MiConfigSingleton.D0, book.getSourceName());
        bundle.putString(MiConfigSingleton.F0, book.getSourceId());
        bundle.putString(MiConfigSingleton.G0, book.getSourceString());
        bundle.putString(MiConfigSingleton.N0, book.getAuthor());
        bundle.putString(F, type);
        bundle.putInt(MiConfigSingleton.O0, seed);
        activity.startActivity(AuthorBooksActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        if (savedInstanceState != null) {
            this.K = savedInstanceState.getString(MiConfigSingleton.N0);
            this.L = savedInstanceState.getString(MiConfigSingleton.L0);
            this.N = savedInstanceState.getString(MiConfigSingleton.F0);
            this.M = savedInstanceState.getString(MiConfigSingleton.D0);
            this.O = savedInstanceState.getString(MiConfigSingleton.G0);
            this.P = savedInstanceState.getString(F);
            this.Q = savedInstanceState.getInt(MiConfigSingleton.O0);
        } else {
            this.K = G0(MiConfigSingleton.N0);
            this.L = G0(MiConfigSingleton.L0);
            this.N = G0(MiConfigSingleton.F0);
            this.M = G0(MiConfigSingleton.D0);
            this.O = G0(MiConfigSingleton.G0);
            this.P = G0(F);
            this.Q = v0(MiConfigSingleton.O0, 0);
        }
        if (H.equalsIgnoreCase(this.P)) {
            if (com.martian.libsupport.k.p(this.K)) {
                Z1(getString(R.string.author_books_second));
            } else {
                Z1(this.K + "的作品");
            }
        } else if (!G.equalsIgnoreCase(this.P)) {
            Z1(getString(R.string.same_like_books));
        } else if (com.martian.libsupport.k.p(this.K)) {
            Z1(getString(R.string.author_books_second));
        } else {
            Z1(this.K + "的其他作品");
        }
        if (((n3) getSupportFragmentManager().findFragmentByTag("yw_new_book_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, (G.equalsIgnoreCase(this.P) || H.equalsIgnoreCase(this.P)) ? n3.D(this.K, this.L, this.P) : n3.E(this.L, this.N, this.M, this.O, this.P, this.Q), "yw_new_book_list_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MiConfigSingleton.N0, this.K);
        outState.putString(MiConfigSingleton.L0, this.L);
        outState.putString(MiConfigSingleton.D0, this.M);
        outState.putString(MiConfigSingleton.F0, this.N);
        outState.putString(MiConfigSingleton.G0, this.O);
        outState.putString(F, this.P);
        outState.putInt(MiConfigSingleton.O0, this.Q);
    }
}
