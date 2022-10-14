package com.github.spiceh2020.thematicreasonerexplorer.model;

public class Theme {
    private String uri, label;

    public Theme(String uri, String label) {
        this.uri = uri;
        this.label = label;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUri() {
        return uri;
    }

    public String getLabel() {
        return label;
    }
}
