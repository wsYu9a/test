package com.martian.mibook.activity.book.orbook;

import android.os.Bundle;
import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.model.b.a;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class ORBooksListActivity extends a {
    private int F;

    public static void r2(j1 activity, int cType) {
        Bundle bundle = new Bundle();
        bundle.putInt("book_rank_ctype", cType);
        activity.startActivity(ORBooksListActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        if (savedInstanceState != null) {
            this.F = savedInstanceState.getInt("book_rank_ctype");
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.F = extras.getInt("book_rank_ctype");
            }
        }
        if (((com.martian.mibook.f.e4.a) getSupportFragmentManager().findFragmentByTag("orBook_fragment")) == null) {
            com.martian.mibook.f.e4.a aVar = new com.martian.mibook.f.e4.a();
            Bundle bundle = new Bundle();
            bundle.putInt("book_rank_ctype", this.F);
            aVar.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, aVar, "orBook_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("book_rank_ctype", this.F);
        super.onSaveInstanceState(outState);
    }
}
