package com.cabanaban.desklo.viewmodel;

public interface Presenter {

    public abstract MenuViewModel getUserMenuViewModelInstance();
    public abstract MenuViewModel getSupportMenuViewModelInstance();
    public abstract MainViewModel getMainViewModelInstance();

}
