package com.martian.libmars.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.martian.libmars.R;
import com.martian.libmars.fragment.EmptyViewPageListFragment;

/* loaded from: classes3.dex */
public class EmptyViewPageListFragment extends PageListFragment {

    /* renamed from: f */
    public ProgressBar f12345f;

    /* renamed from: g */
    public TextView f12346g;

    /* renamed from: h */
    public ListView f12347h;

    /* renamed from: i */
    public int f12348i = 0;

    private void t(boolean z10) {
        int i10 = this.f12348i + (z10 ? 1 : -1);
        this.f12348i = i10;
        if (i10 > 0) {
            if (i10 == 1) {
                this.f12345f.setVisibility(0);
                this.f12346g.setVisibility(8);
                return;
            }
            return;
        }
        this.f12348i = 0;
        this.f12345f.setVisibility(8);
        ListView listView = this.f12347h;
        if (listView != null) {
            if (listView.getAdapter() == null || this.f12347h.getAdapter().isEmpty()) {
                this.f12346g.setVisibility(0);
            }
        }
    }

    @Override // androidx.fragment.app.ListFragment
    @NonNull
    public ListView getListView() {
        return this.f12347h;
    }

    public String o() {
        return "列表为空，点击刷新";
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.libmars_list_with_empty_view, viewGroup, false);
        this.f12345f = (ProgressBar) inflate.findViewById(R.id.pb_loading);
        TextView textView = (TextView) inflate.findViewById(R.id.libmars_empty_text);
        this.f12346g = textView;
        textView.setText(o());
        this.f12346g.setOnClickListener(new View.OnClickListener() { // from class: h9.a
            public /* synthetic */ a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmptyViewPageListFragment.this.p(view);
            }
        });
        this.f12347h = (ListView) inflate.findViewById(android.R.id.list);
        return inflate;
    }

    public final /* synthetic */ void p(View view) {
        q();
    }

    public void q() {
        u();
    }

    public void r() {
        t(false);
    }

    public void s() {
        t(true);
    }

    public void u() {
        s();
    }
}
