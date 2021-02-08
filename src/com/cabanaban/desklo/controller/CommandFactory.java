package com.cabanaban.desklo.controller;

import com.cabanaban.common.Command;
import com.cabanaban.desklo.Services;

public interface CommandFactory {

    public abstract Command createMainAction(Services services, java.lang.Object request);
    public abstract Command createNotImplementedAction(Services services, java.lang.Object request);
}
