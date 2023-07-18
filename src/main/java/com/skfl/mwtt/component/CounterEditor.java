package com.skfl.mwtt.component;

import com.skfl.mwtt.model.entity.Counter;
import com.skfl.mwtt.service.CounterService;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;


@SpringComponent
@UIScope
public class CounterEditor extends VerticalLayout implements KeyNotifier {

    private static final long ID = 1L;
    private final CounterService counterService;
    Binder<Counter> binder = new BeanValidationBinder<>(Counter.class);
    TextField val = new TextField();
    Button button = new Button("Click");
    H1 header = new H1("Counter");

    @Autowired
    public CounterEditor(CounterService counterService) {
        this.counterService = counterService;
        setSpacing(true);

        add(header,val, button);

        binder.bindInstanceFields(this);

        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.getStyle().setCursor("pointer");

        val.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        val.setAllowedCharPattern("^[0-9]*$");
        val.setValue(String.valueOf(counterService.getCounterValue(ID)));

        button.addClickListener(event -> increment());
        val.addValueChangeListener(event -> setValue(Integer.parseInt(event.getValue())));

        setAlignItems(Alignment.CENTER);
        setVisible(true);
    }

    private void setValue(int value) {
        counterService.setValue(ID, value);
        val.setValue(String.valueOf(counterService.getCounterValue(ID)));
    }

    private void increment() {
        counterService.increment(ID);
        val.setValue(String.valueOf(counterService.getCounterValue(ID)));
    }
}
