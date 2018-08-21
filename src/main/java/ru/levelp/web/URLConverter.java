package ru.levelp.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.net.MalformedURLException;
import java.net.URL;

@FacesConverter(value = "urlConverter", forClass = URL.class)
public class URLConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return new URL(value);
        } catch (MalformedURLException e) {
            throw new ConverterException(
                    new FacesMessage("Invalid url: " + value)
            );
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }
}
