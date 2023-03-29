package axon.mall.query;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.hateoas.server.core.Relation;

@Entity
@Table(name = "Delivery_table")
@Data
@Relation(collectionRelation = "deliveries")
public class DeliveryReadModel {

    @Id
    private String deliveryId;

    private String userId;

    private String address;

    private String orderId;

    private String productId;

    private Integer qty;

    private String status;
}
