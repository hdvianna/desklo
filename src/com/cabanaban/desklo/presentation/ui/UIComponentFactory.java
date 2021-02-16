package com.cabanaban.desklo.presentation.ui;

import com.cabanaban.ui.UIComponent;
import com.cabanaban.desklo.presentation.viewmodel.MenuViewModel;
import com.cabanaban.desklo.controller.Controller;

public interface UIComponentFactory {

    public abstract UIComponent createMainWindow(MenuViewModel menu, Controller controller);

}
