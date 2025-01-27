package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class e implements a {

    /* renamed from: a */
    private c f6688a;

    public void a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.f6688a = c.a(iAdInterListener, this);
        }
    }

    public void b(@Nullable Bundle bundle) {
        this.f6688a.a("onActivityCreated", bundle);
    }

    public void c() {
        this.f6688a.a("onPause");
    }

    public void d() {
        this.f6688a.a("onStop");
    }

    public void e() {
        this.f6688a.a("onDestroyView");
    }

    public void f() {
        this.f6688a.a("onDestroy");
    }

    public void g() {
        this.f6688a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f6688a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f6688a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f6688a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f6688a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f6688a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f6688a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f6688a.setTarget(obj);
    }

    public void a(Context context) {
        this.f6688a.a("onAttach", context);
    }

    public void b() {
        this.f6688a.a("onResume");
    }

    public void a(@Nullable Bundle bundle) {
        this.f6688a.a("onCreate", bundle);
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        Object a10 = this.f6688a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (a10 instanceof View) {
            return (View) a10;
        }
        return null;
    }

    public void a() {
        this.f6688a.a("onStart");
    }
}
