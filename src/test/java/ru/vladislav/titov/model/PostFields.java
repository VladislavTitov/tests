package ru.vladislav.titov.model;

import java.util.Objects;

public class PostFields {

    private String title;
    private String message;

    public PostFields() {
    }

    public PostFields(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostFields that = (PostFields) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, message);
    }
}
