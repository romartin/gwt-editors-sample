package org.roger600.gwt.editorsample.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import org.roger600.gwt.editorsample.client.validation.group.DataSetDefBasicAttributesValidationGroup;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.Validator;
import javax.validation.groups.Default;

public class DataSetDefValidatorFactory extends AbstractGwtValidatorFactory {

    @GwtValidation(value =  DataSetDef.class, groups = {Default.class, DataSetDefBasicAttributesValidationGroup.class})
    public interface GwtValidator extends Validator {
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }
}
