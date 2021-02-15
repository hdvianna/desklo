
package com.cabanaban.desklo.presentation;

import com.cabanaban.desklo.controller.Action;

public class CloseTicketViewModel extends WindowViewModel {
    public String ticketID;
    public String durationLabel;
    public String durationValue;
    public String durationMask;
    public Action okAction = Action.CLOSE_TICKET;
    public String okLabel;
    public Action cancelAction = Action.CANCEL_CLOSE_TICKET;
    public String cancelLabel;
}
