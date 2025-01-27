package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams httpParams, HttpParams httpParams2) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.local = httpParams;
        this.defaults = httpParams2;
    }

    @Override // org.apache.http.params.HttpParams
    @Deprecated
    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    @Deprecated
    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    @Override // org.apache.http.params.AbstractHttpParams, org.apache.http.params.HttpParamsNames
    public Set<String> getNames() {
        HashSet hashSet = new HashSet(getNames(this.defaults));
        hashSet.addAll(getNames(this.local));
        return hashSet;
    }

    @Override // org.apache.http.params.HttpParams
    public Object getParameter(String str) {
        HttpParams httpParams;
        Object parameter = this.local.getParameter(str);
        return (parameter != null || (httpParams = this.defaults) == null) ? parameter : httpParams.getParameter(str);
    }

    @Override // org.apache.http.params.HttpParams
    public boolean removeParameter(String str) {
        return this.local.removeParameter(str);
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setParameter(String str, Object obj) {
        return this.local.setParameter(str, obj);
    }

    private Set<String> getNames(HttpParams httpParams) {
        if (httpParams instanceof HttpParamsNames) {
            return ((HttpParamsNames) httpParams).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
