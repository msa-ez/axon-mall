package axon.mall.command;

import java.util.List;
import lombok.Data;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@ToString
@Data
public class UpdateStatusCommand {

    @TargetAggregateIdentifier
    private String orderId;
}
