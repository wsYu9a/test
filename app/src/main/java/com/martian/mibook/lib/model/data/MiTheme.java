package com.martian.mibook.lib.model.data;

/* loaded from: classes.dex */
public class MiTheme {
    public int alertDialog;
    public int colorPrimary;
    public int dotBackground;
    public int selectableBackground;
    public int themeBackable;
    public int themeFullScreen;
    public String themeName;
    public int themeNoActionBar;
    public int themeNormal;

    public MiTheme setAlertDialogTheme(int theme) {
        this.alertDialog = theme;
        return this;
    }

    public MiTheme setBackableTheme(int theme) {
        this.themeBackable = theme;
        return this;
    }

    public MiTheme setColorPrimary(int colorPrimary) {
        this.colorPrimary = colorPrimary;
        return this;
    }

    public MiTheme setDotBackground(int dotBackground) {
        this.dotBackground = dotBackground;
        return this;
    }

    public MiTheme setFullScreenTheme(int theme) {
        this.themeFullScreen = theme;
        return this;
    }

    public MiTheme setNoActionBarTheme(int theme) {
        this.themeNoActionBar = theme;
        return this;
    }

    public MiTheme setNormalTheme(int theme) {
        this.themeNormal = theme;
        return this;
    }

    public MiTheme setSelectableBackground(int selectableBackground) {
        this.selectableBackground = selectableBackground;
        return this;
    }

    public MiTheme setThemeName(String name) {
        this.themeName = name;
        return this;
    }
}
