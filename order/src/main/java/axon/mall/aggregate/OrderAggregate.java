package axon.mall.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.*;

import axon.mall.command.*;
import axon.mall.event.*;
import axon.mall.query.*;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.ToString;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Data
@ToString
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private String productName;
    private String productId;
    private String status;
    private Integer qty;
    private String userId;

    public OrderAggregate() {}

    @CommandHandler
    public OrderAggregate(OrderCommand command) {
        OrderPlacedEvent event = new OrderPlacedEvent();
        BeanUtils.copyProperties(command, event);

        //TODO: check key generation is properly done
        if (event.getOrderId() == null) event.setOrderId(createUUID());

        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStatusCommand command) {
        OrderCompletedEvent event = new OrderCompletedEvent();
        BeanUtils.copyProperties(command, event);

        apply(event);
    }

    private String createUUID() {
        return UUID.randomUUID().toString();
    }

    @EventSourcingHandler
    public void on(OrderPlacedEvent event) {
        BeanUtils.copyProperties(event, this);
        //TODO: business logic here

    }

    @EventSourcingHandler
    public void on(OrderCompletedEvent event) {
        //TODO: business logic here

    }
}
