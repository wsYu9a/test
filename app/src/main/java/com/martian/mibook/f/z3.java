package com.martian.mibook.f;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.KeyEventDispatcher;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.ui.o.h4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class z3 extends com.martian.libmars.f.g implements AdapterView.OnItemClickListener, LoaderManager.LoaderCallbacks<Cursor> {
    private static final String r = "INTENT_STATUS";
    private h4 s;
    private String t;
    private String u;
    private Source v;
    private String w;
    private int x;
    private com.martian.mibook.e.j3 y;

    private static class a extends CursorLoader {
        private MiChapterList A;
        private final Source z;

        a(@NonNull Context context, Source source) {
            super(context);
            this.z = source;
        }

        @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
        public Cursor loadInBackground() {
            MiChapterList p = MiConfigSingleton.V3().l3().b0(this.z.getSourceName()).p(this.z);
            this.A = p;
            if (p == null) {
                return null;
            }
            return p.getCursor();
        }
    }

    public z3() {
        f("目录");
    }

    private com.martian.mibook.g.c i() {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof com.martian.mibook.g.c) {
            return (com.martian.mibook.g.c) activity;
        }
        return null;
    }

    private boolean j() {
        h4 h4Var = this.s;
        return h4Var != null && h4Var.n();
    }

    /* renamed from: k */
    public /* synthetic */ void l(View view1) {
        o();
    }

    public static z3 m(String status, String sourceName, String sourceId, int chapterIndex) {
        z3 z3Var = new z3();
        Bundle bundle = new Bundle();
        bundle.putString(r, status);
        bundle.putString(MiConfigSingleton.F0, sourceId);
        bundle.putString(MiConfigSingleton.D0, sourceName);
        bundle.putInt(MiConfigSingleton.M0, chapterIndex);
        z3Var.setArguments(bundle);
        return z3Var;
    }

    private void o() {
        h4 h4Var = this.s;
        if (h4Var != null) {
            h4Var.o();
            if (j()) {
                this.y.f12178b.setText(getString(R.string.sequence_positive));
                this.y.f12179c.setImageResource(R.drawable.reader_icon_order_up);
            } else {
                this.y.f12178b.setText(getString(R.string.sequence_negative));
                this.y.f12179c.setImageResource(R.drawable.reader_icon_order_down);
            }
        }
    }

    @Override // androidx.fragment.app.ListFragment
    @NonNull
    public ListView getListView() {
        return this.y.f12183g;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* renamed from: n */
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        MiChapterList miChapterList = ((a) loader).A;
        if (miChapterList == null) {
            return;
        }
        this.s.swapCursor(data);
        this.s.q(miChapterList);
        this.y.f12183g.setSelection(this.s.k());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    @NonNull
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new a(this.q, this.v);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_reading_dir, container, false);
        this.y = com.martian.mibook.e.j3.a(inflate);
        if (savedInstanceState != null) {
            this.w = savedInstanceState.getString(r);
            this.t = savedInstanceState.getString(MiConfigSingleton.F0);
            this.u = savedInstanceState.getString(MiConfigSingleton.D0);
            this.x = savedInstanceState.getInt(MiConfigSingleton.M0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.w = arguments.getString(r);
                this.t = arguments.getString(MiConfigSingleton.F0);
                this.u = arguments.getString(MiConfigSingleton.D0);
                this.x = arguments.getInt(MiConfigSingleton.M0);
            }
        }
        this.v = new Source(this.u, this.t);
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        com.martian.mibook.g.c i2 = i();
        if (i2 == null) {
            return;
        }
        i2.k0(this.s.i(position), 0, 0, 201);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        this.s.swapCursor(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(r, this.w);
        outState.putString(MiConfigSingleton.F0, this.t);
        outState.putString(MiConfigSingleton.D0, this.u);
        outState.putInt(MiConfigSingleton.M0, this.x);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        com.martian.mibook.e.j3 j3Var = this.y;
        j3Var.f12183g.setEmptyView(j3Var.f12182f);
        this.y.f12183g.setDividerHeight(0);
        this.y.f12183g.setChoiceMode(1);
        this.y.f12183g.setFastScrollEnabled(true);
        this.y.f12183g.setOnItemClickListener(this);
        h4 h4Var = new h4(getActivity(), null, this.x, this.v, this.y.f12183g, true);
        this.s = h4Var;
        this.y.f12183g.setAdapter((ListAdapter) h4Var);
        if (!com.martian.libsupport.k.p(this.w)) {
            this.y.f12181e.setVisibility(0);
            this.y.f12181e.setText(this.w);
        }
        this.y.f12180d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z3.this.l(view2);
            }
        });
        LoaderManager.getInstance(this.q).initLoader(this.q.hashCode(), null, this);
    }

    public void p(int index) {
        h4 h4Var = this.s;
        if (h4Var != null) {
            h4Var.p(index);
            this.y.f12183g.setSelection(this.s.k());
        }
    }
}
