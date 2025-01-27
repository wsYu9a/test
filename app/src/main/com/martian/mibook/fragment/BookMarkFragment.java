package com.martian.mibook.fragment;

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
import com.martian.libmars.activity.MartianActivity;
import com.martian.libmars.fragment.PageListFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentBookmarkBinding;
import com.martian.mibook.fragment.BookMarkFragment;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.ui.adapter.BookMarkAdapter;
import gb.c;
import ya.e0;

/* loaded from: classes3.dex */
public class BookMarkFragment extends PageListFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, LoaderManager.LoaderCallbacks<Cursor> {

    /* renamed from: i */
    public static final int f13618i = 199;

    /* renamed from: f */
    public BookMarkAdapter f13619f;

    /* renamed from: g */
    public String f13620g;

    /* renamed from: h */
    public FragmentBookmarkBinding f13621h;

    public static class BookMarkCursorLoader extends CursorLoader {

        /* renamed from: a */
        public final String f13622a;

        public BookMarkCursorLoader(@NonNull Context context, String str) {
            super(context);
            this.f13622a = str;
        }

        @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
        public Cursor loadInBackground() {
            return MiConfigSingleton.b2().M1().u0(this.f13622a);
        }
    }

    public static BookMarkFragment p(String str) {
        BookMarkFragment bookMarkFragment = new BookMarkFragment();
        Bundle bundle = new Bundle();
        bundle.putString(e0.f33177t0, str);
        bookMarkFragment.setArguments(bundle);
        return bookMarkFragment;
    }

    @Override // androidx.fragment.app.ListFragment
    @NonNull
    public ListView getListView() {
        return this.f13621h.list;
    }

    public final /* synthetic */ void o(int i10, DialogInterface dialogInterface, int i11) {
        if (!MiConfigSingleton.b2().M1().v(this.f13619f.b(i10))) {
            m("删除书签失败");
        } else {
            m("成功删除书签");
            LoaderManager.getInstance(this.f12355e).restartLoader(this.f12355e.hashCode() + f13618i, null, this);
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    @NonNull
    public Loader<Cursor> onCreateLoader(int i10, Bundle bundle) {
        return new BookMarkCursorLoader(this.f12355e, this.f13620g);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bookmark, viewGroup, false);
        FragmentBookmarkBinding bind = FragmentBookmarkBinding.bind(inflate);
        this.f13621h = bind;
        bind.emptyText.setText("暂无书签");
        FragmentBookmarkBinding fragmentBookmarkBinding = this.f13621h;
        fragmentBookmarkBinding.list.setEmptyView(fragmentBookmarkBinding.emptyText);
        l(getString(R.string.bookmark_or_underline));
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof c) {
            MiBookMark b10 = this.f13619f.b(i10);
            ((c) activity).a(b10.getChapterIndex().intValue(), b10.getContentPos().intValue(), b10.getContentEnd().intValue());
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        new AlertDialog.Builder(this.f12355e).setTitle("书签操作").setItems(new String[]{"删除书签"}, new DialogInterface.OnClickListener() { // from class: db.b

            /* renamed from: c */
            public final /* synthetic */ int f25422c;

            public /* synthetic */ b(int i102) {
                i10 = i102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                BookMarkFragment.this.o(i10, dialogInterface, i11);
            }
        }).show();
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        BookMarkAdapter bookMarkAdapter = this.f13619f;
        if (bookMarkAdapter != null) {
            try {
                bookMarkAdapter.swapCursor(null);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(e0.f33177t0, this.f13620g);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f13621h.list.setChoiceMode(1);
        this.f13621h.list.setFastScrollEnabled(true);
        this.f13621h.list.setOnItemClickListener(this);
        this.f13621h.list.setOnItemLongClickListener(this);
        if (bundle != null) {
            this.f13620g = bundle.getString(e0.f33177t0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13620g = arguments.getString(e0.f33177t0);
            }
        }
        BookMarkAdapter bookMarkAdapter = new BookMarkAdapter(getActivity(), null);
        this.f13619f = bookMarkAdapter;
        this.f13621h.list.setAdapter((ListAdapter) bookMarkAdapter);
        MartianActivity martianActivity = this.f12355e;
        if (martianActivity != null) {
            LoaderManager.getInstance(martianActivity).initLoader(this.f12355e.hashCode() + f13618i, null, this);
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* renamed from: q */
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        BookMarkAdapter bookMarkAdapter = this.f13619f;
        if (bookMarkAdapter != null) {
            try {
                bookMarkAdapter.swapCursor(cursor);
            } catch (Exception unused) {
            }
        }
    }

    public void r() {
        MartianActivity martianActivity = this.f12355e;
        if (martianActivity != null) {
            LoaderManager.getInstance(martianActivity).restartLoader(this.f12355e.hashCode() + f13618i, null, this);
        }
    }
}
