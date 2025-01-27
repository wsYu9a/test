package com.martian.mibook.activity.book;

import android.os.Bundle;
import com.martian.mibook.R;
import com.martian.mibook.fragment.yuewen.YWBookDiscountFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;

/* loaded from: classes3.dex */
public class YWDiscountBooksActivity extends MiBackableActivity {
    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_yw_new_books);
        if (((YWBookDiscountFragment) getSupportFragmentManager().findFragmentByTag("yw_discount_book_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new YWBookDiscountFragment(), "yw_discount_book_list_fragment").commit();
        }
    }
}
