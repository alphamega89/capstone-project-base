package newaccount.infra;

import newaccount.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExternalCheckHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ExternalCheck>> {

    @Override
    public EntityModel<ExternalCheck> process(
        EntityModel<ExternalCheck> model
    ) {
        return model;
    }
}
