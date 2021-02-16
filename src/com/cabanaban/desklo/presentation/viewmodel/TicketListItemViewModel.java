
package com.cabanaban.desklo.presentation.viewmodel;

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
    public Action attendAction = Action.SHOW_ATTEND_TICKET;
    public Action transferAction = Action.SHOW_TRANSFER_TICKET;
    public Action closeAction = Action.SHOW_CLOSE_TICKET;
    public boolean attendActionEnabled;
    public boolean closeActionEnabled;
    public boolean transferActionEnabled;
}
