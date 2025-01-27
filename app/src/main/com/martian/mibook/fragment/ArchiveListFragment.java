package com.martian.mibook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import ba.l;
import ce.g;
import com.martian.libmars.fragment.PageListFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ListWithEmptyViewBinding;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import java.util.List;

/* loaded from: classes3.dex */
public class ArchiveListFragment extends PageListFragment {

    /* renamed from: f */
    public g f13599f;

    /* renamed from: g */
    public String f13600g;

    /* renamed from: h */
    public ListWithEmptyViewBinding f13601h;

    public ArchiveListFragment() {
        l("归档书籍");
    }

    public final List<MiArchiveBookItem> n(String str) {
        return MiConfigSingleton.b2().M1().n0(str);
    }

    public void o(String str) {
        if (!l.q(str)) {
            this.f13600g = str;
        }
        g gVar = this.f13599f;
        if (gVar == null) {
            return;
        }
        gVar.o(n(str));
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.list_with_empty_view, viewGroup, false);
        ListWithEmptyViewBinding bind = ListWithEmptyViewBinding.bind(inflate);
        this.f13601h = bind;
        bind.emptyText.setText("归档记录为空");
        ListWithEmptyViewBinding listWithEmptyViewBinding = this.f13601h;
        listWithEmptyViewBinding.list.setEmptyView(listWithEmptyViewBinding.emptyText);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f13599f == null) {
            g gVar = new g(this.f12355e, n(this.f13600g), this.f13601h.emptyText);
            this.f13599f = gVar;
            setListAdapter(gVar);
            k((AdapterView.OnItemClickListener) getActivity());
        }
        this.f13599f.notifyDataSetChanged();
    }
}
