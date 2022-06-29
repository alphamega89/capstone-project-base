package newaccount.infra;

import newaccount.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AccountAHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AccountA>> {

    @Override
    public EntityModel<AccountA> process(EntityModel<AccountA> model) {
        return model;
    }
}
