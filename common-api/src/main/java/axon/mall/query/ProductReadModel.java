package axon.mall.query;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.hateoas.server.core.Relation;

@Entity
@Table(name = "Product_table")
@Data
@Relation(collectionRelation = "products")
public class ProductReadModel {

    @Id
    private String productId;

    private String productName;

    private Integer stock;
}
