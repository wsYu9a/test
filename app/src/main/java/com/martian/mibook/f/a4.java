package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.martian.libmars.utils.k0;
import com.martian.mibook.activity.ReadingRecordActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.g6;
import com.martian.mibook.e.i6;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.ui.o.d4;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes3.dex */
public class a4 extends com.martian.libmars.f.g {
    private com.martian.mibook.ui.o.d4 r;
    private com.martian.mibook.e.v3 s;
    private g6 t;
    private i6 u;
    private ProgressDialog v;

    class a implements d4.b {
        a() {
        }

        @Override // com.martian.mibook.ui.o.d4.b
        public void a(MiReadingRecord miReadingRecord) {
            if (!a4.this.r.h()) {
                a4.this.r.w(miReadingRecord);
            } else {
                a4.this.r.p(miReadingRecord);
                a4.this.W();
            }
        }

        @Override // com.martian.mibook.ui.o.d4.b
        public void b(MiReadingRecord miReadingRecord) {
            if (a4.this.r.h()) {
                return;
            }
            a4.this.T(true);
            a4.this.r.p(miReadingRecord);
            a4.this.W();
        }
    }

    class b implements d4.a {
        b() {
        }

        @Override // com.martian.mibook.ui.o.d4.a
        public void a() {
            a4.this.O(false, "", "删除失败，请重试");
        }

        @Override // com.martian.mibook.ui.o.d4.a
        public void b() {
            a4.this.O(false, "批量删除中", "删除成功");
        }
    }

    public a4() {
        f(MiConfigSingleton.V3().getString(R.string.novel_history));
    }

    /* renamed from: A */
    public /* synthetic */ void B(View v) {
        this.u.getRoot().setVisibility(8);
    }

    /* renamed from: C */
    public /* synthetic */ void D(View v) {
        MiConfigSingleton.V3().o2(this.q, 200);
    }

    /* renamed from: E */
    public /* synthetic */ void F() {
        l(q());
    }

    /* renamed from: G */
    public /* synthetic */ void H() {
        T(false);
    }

    /* renamed from: I */
    public /* synthetic */ void J() {
        R(true, "批量删除中");
        this.r.f(new b());
    }

    /* renamed from: K */
    public /* synthetic */ void L() {
        U(49);
    }

    private void M() {
        if (this.r.g() <= 0) {
            g("至少选中1条记录");
        } else {
            Q();
        }
    }

    public void O(boolean loading, String loadingMsg, String showMsg) {
        R(loading, loadingMsg);
        g(showMsg);
        P();
    }

    private void P() {
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.f.b3
            @Override // java.lang.Runnable
            public final void run() {
                a4.this.H();
            }
        }, 100L);
    }

    private void Q() {
        com.martian.libmars.utils.k0.P(this.q, getString(R.string.delete_hint), "是否删除选中的" + this.r.g() + "条记录?", new k0.l() { // from class: com.martian.mibook.f.v2
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                a4.this.J();
            }
        });
    }

    private void V(boolean selectAll) {
        this.t.f12021c.setText(getString(selectAll ? R.string.cancel_select_all : R.string.select_all));
    }

    @SuppressLint({"SetTextI18n"})
    public void W() {
        String str;
        int g2 = this.r.g();
        this.t.f12020b.setAlpha(g2 > 0 ? 1.0f : 0.6f);
        TextView textView = this.t.f12020b;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.cd_delete));
        if (g2 > 0) {
            str = "(" + g2 + ")";
        } else {
            str = "";
        }
        sb.append(str);
        textView.setText(sb.toString());
        V(g2 >= this.r.getCount());
    }

    private void l(List<MiReadingRecord> readingRecords) {
        com.martian.mibook.ui.o.d4 d4Var = this.r;
        if (d4Var == null) {
            com.martian.mibook.ui.o.d4 d4Var2 = new com.martian.mibook.ui.o.d4(c(), readingRecords);
            this.r = d4Var2;
            setListAdapter(d4Var2);
            this.r.v(new a());
        } else {
            d4Var.q(readingRecords);
        }
        if (MiConfigSingleton.V3().l6()) {
            r();
        } else {
            o();
        }
    }

    private void m() {
        this.r.d();
        W();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void n() {
        if (this.t == null) {
            this.t = g6.a(View.inflate(this.q, R.layout.reading_record_batch_bottom, null));
            this.q.getWindow().addContentView(this.t.getRoot(), new FrameLayout.LayoutParams(-1, -2, 80));
            this.t.f12021c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.w2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a4.this.v(view);
                }
            });
            this.t.f12020b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.t2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a4.this.x(view);
                }
            });
            this.t.f12020b.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.f.x2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return a4.this.z(view, motionEvent);
                }
            });
        }
        m();
    }

    private void o() {
        if (this.u == null) {
            this.u = i6.a(View.inflate(this.q, R.layout.reading_record_sync_bottom, null));
            this.q.getWindow().addContentView(this.u.getRoot(), new FrameLayout.LayoutParams(-1, -2, 80));
            this.u.f12139d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.y2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a4.this.B(view);
                }
            });
            this.u.f12138c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.a3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a4.this.D(view);
                }
            });
        }
    }

    private List<MiReadingRecord> q() {
        return MiConfigSingleton.V3().l3().l0().getMiReadingRecords();
    }

    private void r() {
        i6 i6Var = this.u;
        if (i6Var != null) {
            i6Var.f12139d.performClick();
        }
    }

    /* renamed from: u */
    public /* synthetic */ void v(View view13) {
        N();
    }

    /* renamed from: w */
    public /* synthetic */ void x(View view12) {
        M();
    }

    /* renamed from: y */
    public /* synthetic */ boolean z(View view1, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.r.g() <= 0) {
                return false;
            }
            this.t.f12020b.setAlpha(0.6f);
            return false;
        }
        if ((action != 1 && action != 3) || this.r.g() <= 0) {
            return false;
        }
        this.t.f12020b.setAlpha(1.0f);
        return false;
    }

    public void N() {
        this.r.s();
        W();
    }

    public void R(boolean loading, String msg) {
        if (this.v == null) {
            this.v = new ProgressDialog(this.q);
        }
        this.v.setMessage(msg);
        if (loading) {
            this.v.show();
        } else {
            this.v.dismiss();
        }
    }

    public void S() {
        com.martian.mibook.ui.o.d4 d4Var = this.r;
        if (d4Var != null) {
            d4Var.notifyDataSetChanged();
        }
    }

    public void T(final boolean batch) {
        if (getActivity() instanceof ReadingRecordActivity) {
            ((ReadingRecordActivity) getActivity()).k2(this.q.getString(batch ? R.string.search_close : R.string.batch_delete));
        }
        this.r.t(batch);
        n();
        com.martian.libmars.utils.h0.a(this.q, this.t.f12022d, batch, com.martian.libmars.utils.h0.f10144a);
        if (!batch) {
            U(0);
        } else {
            r();
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.f.u2
                @Override // java.lang.Runnable
                public final void run() {
                    a4.this.L();
                }
            }, 360L);
        }
    }

    public void U(int paddingBottom) {
        this.s.f12826c.setPadding(0, 0, 0, com.martian.libmars.d.h.b(paddingBottom));
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        com.martian.mibook.e.v3 d2 = com.martian.mibook.e.v3.d(inflater, container, false);
        this.s = d2;
        d2.f12825b.setText(MiConfigSingleton.V3().getString(R.string.empty_history_hint));
        com.martian.mibook.e.v3 v3Var = this.s;
        v3Var.f12826c.setEmptyView(v3Var.f12825b);
        return this.s.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        s();
    }

    public int p() {
        return this.s.f12826c.getChildCount();
    }

    public void s() {
        MiConfigSingleton.V3().l3().o3(this.q, new MiBookManager.h0() { // from class: com.martian.mibook.f.z2
            @Override // com.martian.mibook.application.MiBookManager.h0
            public final void a() {
                a4.this.F();
            }
        });
    }

    public boolean t() {
        com.martian.mibook.ui.o.d4 d4Var = this.r;
        return d4Var != null && d4Var.h();
    }
}
