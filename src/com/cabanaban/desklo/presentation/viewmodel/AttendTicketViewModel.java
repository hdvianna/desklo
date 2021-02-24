package com.cabanaban.desklo.presentation.viewmodel;

import com.cabanaban.desklo.controller.Action;

public class AttendTicketViewModel extends WindowViewModel {
    public String ticketID;
    public String message;
    public Action okAction = Action.ATTEND_TICKET;
    public String okLabel = "";
    public Action cancelAction = Action.CANCEL_ATTEND_TICKET;
    public String canceLabel = "";
}
