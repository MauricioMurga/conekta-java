package io.conekta;


import java.util.HashMap;
import locales.Lang;
import org.json.JSONObject;

/**
 *
 * @author mauricio
 */
public class Card extends Resource {
    public Customer customer;
    public String name;
    public String last4;
    public String exp_month;
    public String exp_year;
    public Boolean deleted;

    @Override
    public String instanceUrl() throws Error {
        if (id == null || id.length() == 0) {
            HashMap parameters = new HashMap();
            parameters.put("RESOURCE", this.getClass().getSimpleName());
            throw new Error(Lang.translate("error.resource.id", parameters, Lang.EN),
                    Lang.translate("error.resource.id_purchaser", parameters, Conekta.locale), null, null, null);
        }
        String base = this.customer.instanceUrl();
        return base + "/cards/" + id;
    }

    @Override
    public void update(JSONObject params) throws Error, ErrorList {
        super.update(params);
    }

    public void delete() throws Error, ErrorList {
        this.delete("customer", "cards");
    }
}
