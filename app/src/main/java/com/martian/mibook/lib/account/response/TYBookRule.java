package com.martian.mibook.lib.account.response;

import java.util.List;

/* loaded from: classes3.dex */
public class TYBookRule {
    private String contentPattern;
    private List<String> interceptPatterns;
    private List<String> parsePatterns;
    private String titlePattern;
    private String wrid;

    public String getContentPattern() {
        return this.contentPattern;
    }

    public List<String> getInterceptPatterns() {
        return this.interceptPatterns;
    }

    public List<String> getParsePatterns() {
        return this.parsePatterns;
    }

    public String getTitlePattern() {
        return this.titlePattern;
    }

    public String getWrid() {
        return this.wrid;
    }

    public void setContentPattern(String str) {
        this.contentPattern = str;
    }

    public void setInterceptPatterns(List<String> list) {
        this.interceptPatterns = list;
    }

    public void setParsePatterns(List<String> list) {
        this.parsePatterns = list;
    }

    public void setTitlePattern(String str) {
        this.titlePattern = str;
    }

    public void setWrid(String str) {
        this.wrid = str;
    }
}
