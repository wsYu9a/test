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
import com.martian.libsupport.j;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.l1;
import com.martian.mibook.f.m3;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.ui.o.h3;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes3.dex */
public class ArchiveListActivity extends com.martian.mibook.lib.model.b.a implements AdapterView.OnItemClickListener {
    private TextView F;
    private m3 G;
    private h3 H;

    class a implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ MiArchiveBookItem f10955a;

        /* renamed from: b */
        final /* synthetic */ MiBook f10956b;

        a(final MiArchiveBookItem val$mibook, final MiBook val$item) {
            this.f10955a = val$mibook;
            this.f10956b = val$item;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            if (book == null) {
                ArchiveListActivity.this.k1("获取书籍信息失败");
            } else {
                ArchiveListActivity.this.x2(this.f10955a, book, this.f10956b);
            }
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
            if (loading) {
                ArchiveListActivity.this.k1("加载书籍信息中，请稍等");
            }
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            ArchiveListActivity.this.k1("网络通信失败");
        }
    }

    /* renamed from: s2 */
    public /* synthetic */ void t2(View view) {
        w2();
    }

    /* renamed from: u2 */
    public /* synthetic */ void v2(final PopupWindow categoryPopupWindow, AdapterView parent, View view, int position, long id) {
        m3 m3Var = this.G;
        if (m3Var != null) {
            m3Var.j(this.H.c(position).f10608a);
            this.H.d(position);
            this.F.setText(this.H.c(position).f10608a + "(" + this.H.c(position).f10609b + ")");
        }
        categoryPopupWindow.dismiss();
    }

    public void x2(MiArchiveBookItem item, Book book, MiBook mibook) {
        if (mibook == null) {
            mibook = book.buildMibook();
            MiConfigSingleton.V3().l3().T0(mibook);
            item.setBookId(mibook.getBookId());
        }
        s2.f0(this, mibook, book);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        Z1("");
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.book_archive_header);
        viewStub.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.archive_setting);
        this.F = (TextView) findViewById(R.id.br_tag_name);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArchiveListActivity.this.t2(view);
            }
        });
        List<j.d> C0 = MiConfigSingleton.V3().l3().C0();
        this.H = new h3(this, C0);
        m3 m3Var = (m3) getSupportFragmentManager().findFragmentByTag("FRAGMENT_TAG_ARCHIVE");
        this.G = m3Var;
        if (m3Var == null) {
            m3 m3Var2 = new m3();
            this.G = m3Var2;
            m3Var2.j(C0.get(0).f10608a);
            this.F.setText(this.H.c(0).f10608a + "(" + this.H.c(0).f10609b + ")");
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, this.G, "FRAGMENT_TAG_ARCHIVE").commit();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MiArchiveBookItem miArchiveBookItem = (MiArchiveBookItem) parent.getItemAtPosition(position);
        Book S = MiConfigSingleton.V3().l3().S(miArchiveBookItem);
        MiBook Q = MiConfigSingleton.V3().l3().Q(miArchiveBookItem.getBookId());
        if (S != null) {
            x2(miArchiveBookItem, S, Q);
        } else {
            MiConfigSingleton.V3().l3().m(miArchiveBookItem, new a(miArchiveBookItem, Q));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void w2() {
        View inflate = getLayoutInflater().inflate(R.layout.bookrack_class, (ViewGroup) null);
        l1 a2 = l1.a(inflate);
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(this.F, 0, 0);
        a2.f12286b.setAdapter((ListAdapter) this.H);
        a2.f12286b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.activity.book.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                ArchiveListActivity.this.v2(popupWindow, adapterView, view, i2, j2);
            }
        });
    }
}
