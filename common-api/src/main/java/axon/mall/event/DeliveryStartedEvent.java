package axon.mall.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeliveryStartedEvent {

    private String deliveryId;
    private String userId;
    private String address;
    private String orderId;
    private String productId;
    private Integer qty;
    private String status;
}
