package service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import model.Koffieautomaat;

import java.util.Collections;
import java.util.List;

@Path("/koffieautomaten")
public class CityResource {
    @GET
    @Produces("application/json")
    public String getKoffieautomaten() {
        CityService service = ServiceProvider.getCityService();
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Koffieautomaat koffieautomaat : service.getAlleKoffieautomaten()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", koffieautomaat.getCode());
            job.add("brand", koffieautomaat.getBrand());
            job.add("model", koffieautomaat.getModel());
            job.add("price", koffieautomaat.getPrice());

            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();
    }

    @GET
    @Path("{code}")
    @Produces("application/json")
    public String getKoffieautomaatInfo(@PathParam("code") String code) {
        CityService service = ServiceProvider.getCityService();
        Koffieautomaat koffieautomaat = service.getKoffieByCode(code);

        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("code", koffieautomaat.getCode());
        job.add("brand", koffieautomaat.getBrand());
        job.add("prijs", koffieautomaat.getPrice());

        return job.build().toString();
    }

    @GET
    @Path("/prijzigste")
    @Produces("application/json")
    public String getByPriciest() {
        CityService service = ServiceProvider.getCityService();

        List<Koffieautomaat> koffieautomaten = service.getAlleKoffieautomaten();
        Collections.sort(koffieautomaten, Koffieautomaat.ASCENDING_PRICE);

        JsonArrayBuilder jab = Json.createArrayBuilder();
        JsonObjectBuilder job = Json.createObjectBuilder();

        for (Koffieautomaat k : service.getAlleKoffieautomaten().subList(0, 3)) {
            job.add("brand", k.getBrand());
            job.add("model", k.getModel());
            job.add("prijs", k.getPrice());
            jab.add(job);
        }

        JsonArray array = jab.build();

        return array.toString();
    }
}
