package ru.levelp.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ru.levelp.web.HostPortValidator")
public class HostPortValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext,
                         UIComponent uiComponent,
                         Object o) throws ValidatorException {
        String hostPort = (String) o;

        if (hostPort == null || hostPort.isEmpty()) {
            throw new ValidatorException(
                    new FacesMessage("Host/port shouldn't be empty"));
        }

        int colonIndex = hostPort.indexOf(':');
        if (colonIndex == -1) return;

        String portString = hostPort.substring(colonIndex + 1);
        try {
            int port = Integer.parseInt(portString);
            if (port < 1000 || port > 50000) {
                throw new ValidatorException(
                        new FacesMessage("port should be in range 1000..50000")
                );
            }
        } catch (NumberFormatException e) {
            throw new ValidatorException(
                    new FacesMessage("port should be a number")
            );
        }
    }
}
