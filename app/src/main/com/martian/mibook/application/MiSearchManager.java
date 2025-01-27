package com.martian.mibook.application;

import android.app.SearchableInfo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;

/* loaded from: classes3.dex */
public class MiSearchManager {

    /* renamed from: c */
    public static final int f13341c = -1;

    /* renamed from: a */
    public final SearchRecentSuggestions f13342a;

    /* renamed from: b */
    public final Context f13343b;

    public MiSearchManager(Context context) {
        this.f13343b = context;
        this.f13342a = new SearchRecentSuggestions(context, "com.martian.ttbookhd.application.KeywordsSuggestionProvider", 1);
    }

    public void a() {
        this.f13342a.clearHistory();
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
        return this.f13342a;
    }

    public Cursor d(SearchableInfo searchableInfo, String str) {
        return e(searchableInfo, str, -1);
    }

    public Cursor e(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        try {
            return this.f13343b.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
        } catch (SQLiteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public Cursor f(SearchableInfo searchableInfo, String str) {
        return e(searchableInfo, str, 12);
    }

    public void g(String str) {
        this.f13342a.saveRecentQuery(str, null);
    }

    public void h(String str, String str2) {
        this.f13342a.saveRecentQuery(str, str2);
    }
}
