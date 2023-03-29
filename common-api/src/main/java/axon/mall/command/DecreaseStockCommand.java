package axon.mall.command;

import java.util.List;
import lombok.Data;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@ToString
@Data
public class DecreaseStockCommand {

    @TargetAggregateIdentifier
    private String productId;

    private Integer stock;
}
