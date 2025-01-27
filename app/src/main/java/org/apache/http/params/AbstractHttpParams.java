package org.apache.http.params;

import java.util.Set;

/* loaded from: classes5.dex */
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
    protected AbstractHttpParams() {
    }

    @Override // org.apache.http.params.HttpParams
    public boolean getBooleanParameter(String str, boolean z) {
        Object parameter = getParameter(str);
        return parameter == null ? z : ((Boolean) parameter).booleanValue();
    }

    @Override // org.apache.http.params.HttpParams
    public double getDoubleParameter(String str, double d2) {
        Object parameter = getParameter(str);
        return parameter == null ? d2 : ((Double) parameter).doubleValue();
    }

    @Override // org.apache.http.params.HttpParams
    public int getIntParameter(String str, int i2) {
        Object parameter = getParameter(str);
        return parameter == null ? i2 : ((Integer) parameter).intValue();
    }

    @Override // org.apache.http.params.HttpParams
    public long getLongParameter(String str, long j2) {
        Object parameter = getParameter(str);
        return parameter == null ? j2 : ((Long) parameter).longValue();
    }

    @Override // org.apache.http.params.HttpParamsNames
    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.params.HttpParams
    public boolean isParameterFalse(String str) {
        return !getBooleanParameter(str, false);
    }

    @Override // org.apache.http.params.HttpParams
    public boolean isParameterTrue(String str) {
        return getBooleanParameter(str, false);
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setBooleanParameter(String str, boolean z) {
        setParameter(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setDoubleParameter(String str, double d2) {
        setParameter(str, new Double(d2));
        return this;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setIntParameter(String str, int i2) {
        setParameter(str, new Integer(i2));
        return this;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setLongParameter(String str, long j2) {
        setParameter(str, new Long(j2));
        return this;
    }
}
