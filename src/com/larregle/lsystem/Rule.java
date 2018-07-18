package com.larregle.lsystem;

public class Rule {
    private final Character having;
    private final String results;

    public Rule(Character having, String results) {
        this.having = having;
        this.results = results;
    }

    public Character getHaving() {
        return having;
    }

    public String getResults() { return results; }
}
