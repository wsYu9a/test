package com.martian.libmars.f;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import com.martian.libmars.activity.h1;
import com.martian.libmars.activity.j1;

/* loaded from: classes2.dex */
public class g extends ListFragment {
    private String o;
    private AdapterView.OnItemClickListener p;
    protected j1 q;

    public j1 c() {
        FragmentActivity activity = getActivity();
        if (activity instanceof j1) {
            return (j1) activity;
        }
        return null;
    }

    public String d() {
        return this.o;
    }

    public void e(AdapterView.OnItemClickListener listener) {
        this.p = listener;
    }

    public void f(String title) {
        this.o = title;
    }

    public void g(String msg) {
        FragmentActivity activity = getActivity();
        if (activity instanceof h1) {
            ((h1) activity).k1(msg);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (getActivity() != null) {
            return getActivity();
        }
        return null;
    }

    public void h(String msg) {
        FragmentActivity activity = getActivity();
        if (activity instanceof h1) {
            ((h1) activity).l1(msg);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.q = (j1) context;
    }

    @Override // androidx.fragment.app.ListFragment
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        AdapterView.OnItemClickListener onItemClickListener = this.p;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(l, v, position, id);
        }
    }
}
