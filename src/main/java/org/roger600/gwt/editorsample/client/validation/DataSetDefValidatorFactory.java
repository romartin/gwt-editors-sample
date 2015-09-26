package org.roger600.gwt.editorsample.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.Validator;

public class DataSetDefValidatorFactory extends AbstractGwtValidatorFactory {

    @GwtValidation(DataSetDef.class)
    public interface GwtValidator extends Validator {
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }
}
