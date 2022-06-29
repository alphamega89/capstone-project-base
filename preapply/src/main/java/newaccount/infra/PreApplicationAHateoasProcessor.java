package newaccount.infra;

import newaccount.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PreApplicationAHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PreApplicationA>> {

    @Override
    public EntityModel<PreApplicationA> process(
        EntityModel<PreApplicationA> model
    ) {
        return model;
    }
}
