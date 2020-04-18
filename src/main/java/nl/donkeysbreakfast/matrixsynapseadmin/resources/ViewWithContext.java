package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.views.View;

/**
 * Erweiterung für Dropwizard View.<br>
 * 
 * Enthält basePath (applicationBasePath) um die Links/Referenzen im Template korrekt 
 * bilden zu können
 * 
 * @author Telegraphenbauanstalt
 */
public class ViewWithContext extends View {

    private String basePath;

    public ViewWithContext(String templateName) {
        super(templateName);
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

}
