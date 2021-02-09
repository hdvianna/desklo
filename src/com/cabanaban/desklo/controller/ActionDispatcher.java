
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;

public interface ActionDispatcher {
    public void dispatch(Services services, Action action, Object request);
}
