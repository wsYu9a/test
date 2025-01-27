package com.czhj.volley.toolbox;

import com.czhj.volley.Cache;

/* loaded from: classes2.dex */
public class NoCache implements Cache {
    @Override // com.czhj.volley.Cache
    public void clear() {
    }

    @Override // com.czhj.volley.Cache
    public Cache.Entry get(String str) {
        return null;
    }

    @Override // com.czhj.volley.Cache
    public void initialize() {
    }

    @Override // com.czhj.volley.Cache
    public void invalidate(String str, boolean z10) {
    }

    @Override // com.czhj.volley.Cache
    public void put(String str, Cache.Entry entry) {
    }

    @Override // com.czhj.volley.Cache
    public void remove(String str) {
    }
}
