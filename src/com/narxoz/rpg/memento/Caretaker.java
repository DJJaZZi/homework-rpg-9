package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;
import java.util.Stack;

public class Caretaker {

    private final Stack<HeroMemento> history = new Stack<>();

    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
        }
    }

    public HeroMemento undo() {

        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public HeroMemento peek() {
        if (!history.isEmpty()) {
            return history.peek();
        }
        return null;
    }

    public int size() {
        return history.size();
    }
}