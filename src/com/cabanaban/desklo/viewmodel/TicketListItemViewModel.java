
package com.cabanaban.desklo.viewmodel;

import com.cabanaban.desklo.controller.Action;

public class TicketListItemViewModel {
    public String ticketID;
    public String affectUserName;
    public String supporterName = "";
    public String elapsedTimeInHours;
    public String elapsedTimeLabelColor;
    public String problemDescription;
    public String attendActionText;
    public String transferActionText;
    public String closeActionText;
    public Action attendAction = Action.ATTEND_TICKET;
    public Action transferAction = Action.TRANSFER_TICKET;
    public Action closeAction = Action.CLOSE_TICKET;
}
