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

    public void setContentPattern(String contentPattern) {
        this.contentPattern = contentPattern;
    }

    public void setInterceptPatterns(List<String> interceptPatterns) {
        this.interceptPatterns = interceptPatterns;
    }

    public void setParsePatterns(List<String> parsePatterns) {
        this.parsePatterns = parsePatterns;
    }

    public void setTitlePattern(String titlePattern) {
        this.titlePattern = titlePattern;
    }

    public void setWrid(String wrid) {
        this.wrid = wrid;
    }
}
