package com.skfl.mwtt.view;

import com.skfl.mwtt.component.CounterEditor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
class MainView extends VerticalLayout {

    private final CounterEditor counterEditor;

    public MainView(CounterEditor counterEditor) {
        this.counterEditor = counterEditor;
        add(counterEditor);
        setAlignItems(Alignment.CENTER);
    }
}