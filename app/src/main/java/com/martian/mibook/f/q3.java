package com.martian.mibook.f;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.core.view.KeyEventDispatcher;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class q3 extends com.martian.libmars.f.g implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, LoaderManager.LoaderCallbacks<Cursor> {
    private static final int r = 199;
    private com.martian.mibook.ui.o.q3 s;
    private String t;
    private com.martian.mibook.e.z2 u;

    class a extends CursorLoader {
        a(Context arg0) {
            super(arg0);
        }

        @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
        public Cursor loadInBackground() {
            return MiConfigSingleton.V3().l3().K0(q3.this.t);
        }
    }

    public q3() {
        f("书签");
    }

    /* renamed from: j */
    public /* synthetic */ void k(final int position, DialogInterface dialog, int i2) {
        if (!MiConfigSingleton.V3().l3().C(this.s.e(position))) {
            g("删除书签失败");
        } else {
            g("成功删除书签");
            LoaderManager.getInstance(this.q).restartLoader(this.q.hashCode() + 199, null, this);
        }
    }

    public static q3 l(String sourceString) {
        q3 q3Var = new q3();
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.G0, sourceString);
        q3Var.setArguments(bundle);
        return q3Var;
    }

    @Override // androidx.fragment.app.ListFragment
    @NonNull
    public ListView getListView() {
        return this.u.f13015c;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* renamed from: m */
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        com.martian.mibook.ui.o.q3 q3Var = this.s;
        if (q3Var != null) {
            try {
                q3Var.swapCursor(data);
            } catch (Exception unused) {
            }
        }
    }

    public void n() {
        com.martian.libmars.activity.j1 j1Var = this.q;
        if (j1Var != null) {
            LoaderManager.getInstance(j1Var).restartLoader(this.q.hashCode() + 199, null, this);
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    @NonNull
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new a(this.q);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_bookmark, container, false);
        com.martian.mibook.e.z2 a2 = com.martian.mibook.e.z2.a(inflate);
        this.u = a2;
        a2.f13014b.setText("暂无书签");
        com.martian.mibook.e.z2 z2Var = this.u;
        z2Var.f13015c.setEmptyView(z2Var.f13014b);
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof com.martian.mibook.g.c) {
            MiBookMark e2 = this.s.e(position);
            ((com.martian.mibook.g.c) activity).k0(e2.getChapterIndex().intValue(), e2.getContentPos().intValue(), e2.getContentSize().intValue(), 202);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        new AlertDialog.Builder(this.q).setTitle("书签操作").setItems(new String[]{"删除书签"}, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.f.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                q3.this.k(position, dialogInterface, i2);
            }
        }).show();
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        com.martian.mibook.ui.o.q3 q3Var = this.s;
        if (q3Var != null) {
            try {
                q3Var.swapCursor(null);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MiConfigSingleton.G0, this.t);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.u.f13015c.setChoiceMode(1);
        this.u.f13015c.setFastScrollEnabled(true);
        this.u.f13015c.setOnItemClickListener(this);
        this.u.f13015c.setOnItemLongClickListener(this);
        if (savedInstanceState != null) {
            this.t = savedInstanceState.getString(MiConfigSingleton.G0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.t = arguments.getString(MiConfigSingleton.G0);
            }
        }
        com.martian.mibook.ui.o.q3 q3Var = new com.martian.mibook.ui.o.q3(getActivity(), null);
        this.s = q3Var;
        this.u.f13015c.setAdapter((ListAdapter) q3Var);
        com.martian.libmars.activity.j1 j1Var = this.q;
        if (j1Var != null) {
            LoaderManager.getInstance(j1Var).initLoader(this.q.hashCode() + 199, null, this);
        }
    }
}
