
package com.cabanaban.desklo.viewmodel;

import com.cabanaban.desklo.controller.Action;

public class TicketListItemViewModel {
    public String ticketID;
    public String affectUserName;
    public String supporterName = "";
    public String elapsedTimeInHours;
    public String elapsedTimeLabelColor;
    public String problemDescription;
    public String actionText;
    public Action action = Action.SHOW_MANAGE_TICKET;
}
