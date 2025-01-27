package com.martian.libmars.f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class d extends g {
    private ProgressBar r;
    private TextView s;
    private ListView t;
    private int u = 0;

    /* renamed from: j */
    public /* synthetic */ void k(View v) {
        l();
    }

    private void o(boolean show) {
        int i2 = this.u + (show ? 1 : -1);
        this.u = i2;
        if (i2 > 0) {
            if (i2 == 1) {
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                return;
            }
            return;
        }
        this.u = 0;
        this.r.setVisibility(8);
        ListView listView = this.t;
        if (listView != null) {
            if (listView.getAdapter() == null || this.t.getAdapter().isEmpty()) {
                this.s.setVisibility(0);
            }
        }
    }

    @Override // androidx.fragment.app.ListFragment
    public ListView getListView() {
        return this.t;
    }

    protected String i() {
        return "列表为空，点击刷新";
    }

    protected void l() {
        p();
    }

    protected void m() {
        o(false);
    }

    protected void n() {
        o(true);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.libmars_list_with_empty_view, container, false);
        this.r = (ProgressBar) inflate.findViewById(R.id.pb_loading);
        TextView textView = (TextView) inflate.findViewById(R.id.libmars_empty_text);
        this.s = textView;
        textView.setText(i());
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.f.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.k(view);
            }
        });
        this.t = (ListView) inflate.findViewById(android.R.id.list);
        return inflate;
    }

    public void p() {
        n();
    }
}
