package com.martian.libmars.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.activity.MartianActivity;

/* loaded from: classes3.dex */
public class PageListFragment extends ListFragment {

    /* renamed from: c */
    public String f12353c;

    /* renamed from: d */
    public AdapterView.OnItemClickListener f12354d;

    /* renamed from: e */
    public MartianActivity f12355e;

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (getActivity() != null) {
            return getActivity();
        }
        return null;
    }

    public String j() {
        return this.f12353c;
    }

    public void k(AdapterView.OnItemClickListener onItemClickListener) {
        this.f12354d = onItemClickListener;
    }

    public void l(String str) {
        this.f12353c = str;
    }

    public void m(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).P1(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12355e = (MartianActivity) context;
    }

    @Override // androidx.fragment.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i10, long j10) {
        super.onListItemClick(listView, view, i10, j10);
        AdapterView.OnItemClickListener onItemClickListener = this.f12354d;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(listView, view, i10, j10);
        }
    }
}
