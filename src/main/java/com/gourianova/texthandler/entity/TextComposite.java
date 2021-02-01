package com.gourianova.texthandler.entity;

import java.util.ArrayList;


public class TextComposite implements TextComponent {

    private ComponentType componentType;
    private ArrayList<TextComponent> components = new ArrayList<>();

    //public ArrayList<TextComponent> getComponents(){

    //}

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    public TextComposite() {

    }

    @Override
    public void addComponent(TextComponent component) {
        components.add(component);
    }



    public ArrayList<TextComponent> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : components) {
            stringBuilder.append(component);
        }
        return stringBuilder.toString();
    }
}
