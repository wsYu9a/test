package com.vivo.ic.spmanager;

import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public class VivoPreference {
    private SharedPreferences mSharePreferences;

    protected VivoPreference(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            throw new RuntimeException("VivoPreference cannot create without SharedPreferences");
        }
        this.mSharePreferences = sharedPreferences;
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mSharePreferences.getBoolean(str, z);
    }

    public int getInt(String str, int i2) {
        return this.mSharePreferences.getInt(str, i2);
    }

    public long getLong(String str, long j2) {
        return this.mSharePreferences.getLong(str, j2);
    }

    public String getString(String str, String str2) {
        return this.mSharePreferences.getString(str, str2);
    }

    public boolean isKeyExist(String str) {
        return this.mSharePreferences.contains(str);
    }

    public boolean putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public void putBooleanAsync(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean putInt(String str, int i2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putInt(str, i2);
        return edit.commit();
    }

    public void putIntAsync(String str, int i2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putInt(str, i2);
        edit.apply();
    }

    public boolean putLong(String str, long j2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putLong(str, j2);
        return edit.commit();
    }

    public void putLongAsync(String str, long j2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putLong(str, j2);
        edit.apply();
    }

    public boolean putString(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public void putStringAsync(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public boolean remove(String str) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        if (!this.mSharePreferences.contains(str)) {
            return false;
        }
        edit.remove(str);
        return edit.commit();
    }

    public void removeAsync(String str) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        if (this.mSharePreferences.contains(str)) {
            edit.remove(str);
            edit.apply();
        }
    }
}
