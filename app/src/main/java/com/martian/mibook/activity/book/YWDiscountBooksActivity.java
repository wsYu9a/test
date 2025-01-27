package com.martian.mibook.activity.book;

import android.os.Bundle;
import com.martian.mibook.f.f4.c0;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class YWDiscountBooksActivity extends com.martian.mibook.lib.model.b.a {
    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yw_new_books);
        if (((c0) getSupportFragmentManager().findFragmentByTag("yw_discount_book_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new c0(), "yw_discount_book_list_fragment").commit();
        }
    }
}
