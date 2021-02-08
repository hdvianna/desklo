package com.cabanaban.desklo.controller;

import com.cabanaban.common.Command;

public interface CommandFactory {

    public abstract Command createMainAction(java.lang.Object request);

}
