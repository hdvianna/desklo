package com.cabanaban.desklo.ui;

import com.cabanaban.ui.UIComponent;
import com.cabanaban.desklo.presentation.MenuViewModel;
import com.cabanaban.desklo.controller.Controller;

public interface UIComponentFactory {

    public abstract UIComponent createMainWindow(MenuViewModel menu, Controller controller);

}
