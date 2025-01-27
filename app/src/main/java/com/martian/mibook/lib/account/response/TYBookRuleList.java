package com.martian.mibook.lib.account.response;

import java.util.List;

/* loaded from: classes3.dex */
public class TYBookRuleList {
    private String injs;
    private List<TYBookRule> rules;
    private List<String> whiteDomains;

    public String getInjs() {
        return this.injs;
    }

    public List<TYBookRule> getRules() {
        return this.rules;
    }

    public List<String> getWhiteDomains() {
        return this.whiteDomains;
    }

    public void setInjs(String injs) {
        this.injs = injs;
    }

    public void setRules(List<TYBookRule> rules) {
        this.rules = rules;
    }

    public void setWhiteDomains(List<String> whiteDomains) {
        this.whiteDomains = whiteDomains;
    }
}
