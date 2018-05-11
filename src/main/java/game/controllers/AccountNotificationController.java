package game.controllers;

import game.controllers.dto.AccountNotificationDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface AccountNotificationController {
    List<AccountNotificationDto> getListOfAccountNotifications(Integer accountId);
    Response clearAccountNotificationList(Integer accountId);
    Response addShownNotificationToAccount(Integer accountId, Integer notificationId);
}
