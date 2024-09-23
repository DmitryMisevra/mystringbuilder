package ru.javacode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStringBuilder {
    private StringBuilder builder;
    private final Deque<Memento> history;

    public MyStringBuilder() {
        this.builder = new StringBuilder();
        this.history = new ArrayDeque<>();
    }

    private static class Memento {
        private final String state;

        private Memento(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }
    }

    private void saveState() {
        history.push(new Memento(builder.toString()));
    }

    public MyStringBuilder append(String str) {
        saveState();
        builder.append(str);
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        saveState();
        builder.delete(start, end);
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            builder = new StringBuilder(memento.getState());
        } else {
            System.out.println("No actions to undo.");
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
