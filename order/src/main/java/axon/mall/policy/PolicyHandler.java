package axon.mall.policy;

import axon.mall.aggregate.*;
import axon.mall.command.*;
import axon.mall.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.DisallowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("order")
public class PolicyHandler {

    @Autowired
    CommandGateway commandGateway;

    @EventHandler
    //@DisallowReplay
    public void wheneverDeliveryStarted_UpdateStatus(
        DeliveryStartedEvent deliveryStarted
    ) {
        System.out.println(deliveryStarted.toString());

        UpdateStatusCommand command = new UpdateStatusCommand();
        //TODO: mapping attributes (anti-corruption)
        commandGateway.send(command);
    }
}
