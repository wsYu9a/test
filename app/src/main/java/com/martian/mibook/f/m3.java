package com.martian.mibook.f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes3.dex */
public class m3 extends com.martian.libmars.f.g {
    private com.martian.mibook.ui.o.g3 r;
    private String s;
    private com.martian.mibook.e.v3 t;

    public m3() {
        f("归档书籍");
    }

    private List<MiArchiveBookItem> i(String tagName) {
        return MiConfigSingleton.V3().l3().B0(tagName);
    }

    public void j(String tag) {
        if (!com.martian.libsupport.k.p(tag)) {
            this.s = tag;
        }
        com.martian.mibook.ui.o.g3 g3Var = this.r;
        if (g3Var == null) {
            return;
        }
        g3Var.n(i(tag));
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.list_with_empty_view, container, false);
        com.martian.mibook.e.v3 a2 = com.martian.mibook.e.v3.a(inflate);
        this.t = a2;
        a2.f12825b.setText("归档记录为空");
        com.martian.mibook.e.v3 v3Var = this.t;
        v3Var.f12826c.setEmptyView(v3Var.f12825b);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.r == null) {
            com.martian.mibook.ui.o.g3 g3Var = new com.martian.mibook.ui.o.g3(this.q, i(this.s), this.t.f12825b);
            this.r = g3Var;
            setListAdapter(g3Var);
            e((AdapterView.OnItemClickListener) getActivity());
        }
        this.r.notifyDataSetChanged();
    }
}
