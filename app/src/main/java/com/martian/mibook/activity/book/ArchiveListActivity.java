package com.martian.mibook.activity.book;

import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import ba.k;
import ce.h;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.ArchiveListActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookrackClassBinding;
import com.martian.mibook.fragment.ArchiveListFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.List;
import je.i;
import x8.c;
import xb.b;

/* loaded from: classes3.dex */
public class ArchiveListActivity extends MiBackableActivity implements AdapterView.OnItemClickListener {
    public TextView A;
    public ArchiveListFragment B;
    public h C;

    public class a implements b {

        /* renamed from: a */
        public final /* synthetic */ MiArchiveBookItem f13181a;

        public a(MiArchiveBookItem miArchiveBookItem) {
            this.f13181a = miArchiveBookItem;
        }

        @Override // xb.b
        public void a(Book book) {
            if (book == null) {
                ArchiveListActivity.this.P1("获取书籍信息失败");
            } else {
                ArchiveListActivity.this.R2(this.f13181a, book);
            }
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
            if (z10) {
                ArchiveListActivity.this.P1("加载书籍信息中，请稍等");
            }
        }

        @Override // xb.b
        public void onResultError(c cVar) {
            ArchiveListActivity.this.P1("网络通信失败");
        }
    }

    public final /* synthetic */ void O2(View view) {
        Q2();
    }

    public final /* synthetic */ void P2(PopupWindow popupWindow, AdapterView adapterView, View view, int i10, long j10) {
        ArchiveListFragment archiveListFragment = this.B;
        if (archiveListFragment != null) {
            archiveListFragment.o(this.C.c(i10).f1490a);
            this.C.d(i10);
            this.A.setText(this.C.c(i10).f1490a + "(" + this.C.c(i10).f1491b + ")");
        }
        popupWindow.dismiss();
    }

    @SuppressLint({"SetTextI18n"})
    public void Q2() {
        View inflate = getLayoutInflater().inflate(R.layout.bookrack_class, (ViewGroup) null);
        BookrackClassBinding bind = BookrackClassBinding.bind(inflate);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(this.A, 0, 0);
        bind.brClassList.setAdapter((ListAdapter) this.C);
        bind.brClassList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ua.a

            /* renamed from: c */
            public final /* synthetic */ PopupWindow f30964c;

            public /* synthetic */ a(PopupWindow popupWindow2) {
                popupWindow = popupWindow2;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                ArchiveListActivity.this.P2(popupWindow, adapterView, view, i10, j10);
            }
        });
    }

    public final void R2(MiArchiveBookItem miArchiveBookItem, Book book) {
        i.R(this, book);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.martian.libsupport.R.layout.activity_load_fragment);
        t2("");
        ViewStub B2 = B2();
        B2.setLayoutResource(R.layout.book_archive_header);
        B2.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) B2.findViewById(R.id.archive_setting);
        this.A = (TextView) B2.findViewById(R.id.br_tag_name);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ua.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArchiveListActivity.this.O2(view);
                }
            });
        }
        List<k.d> o02 = MiConfigSingleton.b2().M1().o0();
        this.C = new h(this, o02);
        ArchiveListFragment archiveListFragment = (ArchiveListFragment) getSupportFragmentManager().findFragmentByTag("FRAGMENT_TAG_ARCHIVE");
        this.B = archiveListFragment;
        if (archiveListFragment == null) {
            ArchiveListFragment archiveListFragment2 = new ArchiveListFragment();
            this.B = archiveListFragment2;
            archiveListFragment2.o(o02.get(0).f1490a);
            TextView textView = this.A;
            if (textView != null) {
                textView.setText(this.C.c(0).f1490a + "(" + this.C.c(0).f1491b + ")");
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, this.B, "FRAGMENT_TAG_ARCHIVE").commit();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        MiArchiveBookItem miArchiveBookItem = (MiArchiveBookItem) adapterView.getItemAtPosition(i10);
        Book I = MiConfigSingleton.b2().M1().I(miArchiveBookItem);
        if (I != null) {
            R2(miArchiveBookItem, I);
        } else {
            MiConfigSingleton.b2().M1().k(miArchiveBookItem, new a(miArchiveBookItem));
        }
    }
}
