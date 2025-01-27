package com.martian.mibook.application;

import android.app.SearchableInfo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;

/* loaded from: classes.dex */
public class MiSearchManager {

    /* renamed from: a, reason: collision with root package name */
    static final int f11348a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final SearchRecentSuggestions f11349b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f11350c;

    public MiSearchManager(Context context) {
        this.f11350c = context;
        this.f11349b = new SearchRecentSuggestions(context, "com.martian.ttbookhd.application.KeywordsSuggestionProvider", 1);
    }

    public void a() {
        this.f11349b.clearHistory();
    }

    public String b(Cursor cursor) {
        if (cursor == null || cursor.getColumnIndex("suggest_intent_query") != -1) {
            return "suggest_intent_query";
        }
        if (cursor.getColumnIndex("suggest_intent_data") != -1) {
            return "suggest_intent_data";
        }
        if (cursor.getColumnIndex("suggest_text_1") != -1) {
            return "suggest_text_1";
        }
        return null;
    }

    public SearchRecentSuggestions c() {
        return this.f11349b;
    }

    public Cursor d(SearchableInfo searchable, String query) {
        return e(searchable, query, -1);
    }

    public Cursor e(SearchableInfo searchable, String query, int limit) {
        String suggestAuthority;
        String[] strArr;
        if (searchable == null || (suggestAuthority = searchable.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchable.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchable.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{query};
        } else {
            fragment.appendPath(query);
            strArr = null;
        }
        if (limit > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(limit));
        }
        try {
            return this.f11350c.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Cursor f(SearchableInfo searchable, String query) {
        return e(searchable, query, 12);
    }

    public void g(final String queryString) {
        this.f11349b.saveRecentQuery(queryString, null);
    }

    public void h(final String queryString, final String line2) {
        this.f11349b.saveRecentQuery(queryString, line2);
    }
}
