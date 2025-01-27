package com.martian.ttbook.sdk.client;

import android.os.Bundle;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class AdParameters {
    private final Bundle bundle;
    private final LinkedHashMap<String, Object> objectMapping;

    public AdParameters() {
        this.bundle = new Bundle();
        this.objectMapping = new LinkedHashMap<>();
    }

    public AdParameters(AdParameters adParameters) {
        Bundle bundle = new Bundle();
        this.bundle = bundle;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        this.objectMapping = linkedHashMap;
        bundle.putAll(adParameters.bundle);
        linkedHashMap.putAll(adParameters.objectMapping);
    }

    public void clear() {
        this.bundle.clear();
        this.objectMapping.clear();
    }

    public boolean containsKey(String str) {
        return this.bundle.containsKey(str) || this.objectMapping.containsKey(str);
    }

    public boolean getBoolean(String str) {
        return this.bundle.getBoolean(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.bundle.getBoolean(str, z);
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public int getInt(String str) {
        return this.bundle.getInt(str);
    }

    public int getInt(String str, int i2) {
        return this.bundle.getInt(str, i2);
    }

    public long getLong(String str) {
        return this.bundle.getLong(str);
    }

    public long getLong(String str, long j2) {
        return this.bundle.getLong(str, j2);
    }

    public <T> T getObject(String str) {
        return (T) this.objectMapping.get(str);
    }

    public <T> T getObject(String str, T t) {
        return (T) this.objectMapping.get(str);
    }

    public LinkedHashMap<String, Object> getObjectMapping() {
        return this.objectMapping;
    }

    public String getString(String str) {
        return this.bundle.getString(str);
    }

    public String getString(String str, String str2) {
        return this.bundle.getString(str, str2);
    }

    public void putAll(Bundle bundle) {
        bundle.putAll(bundle);
    }

    public void putBoolean(String str, boolean z) {
        this.bundle.putBoolean(str, z);
    }

    public void putInt(String str, int i2) {
        this.bundle.putInt(str, i2);
    }

    public void putLong(String str, long j2) {
        this.bundle.putLong(str, j2);
    }

    public void putObject(String str, Object obj) {
        this.objectMapping.put(str, obj);
    }

    public void putString(String str, String str2) {
        this.bundle.putString(str, str2);
    }

    public void remove(String str) {
        if (this.bundle.containsKey(str)) {
            this.bundle.remove(str);
        } else if (this.objectMapping.containsKey(str)) {
            this.objectMapping.remove(str);
        }
    }

    public int size() {
        return this.bundle.size() + this.objectMapping.size();
    }
}
