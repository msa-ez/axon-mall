package axon.mall.command;

import java.util.List;
import lombok.Data;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@ToString
@Data
public class StartDeliveryCommand {

    private String deliveryId; // Please comment here if you want user to enter the id directly
    private String userId;
    private String address;
    private String orderId;
    private String productId;
    private Integer qty;
    private String status;
}
