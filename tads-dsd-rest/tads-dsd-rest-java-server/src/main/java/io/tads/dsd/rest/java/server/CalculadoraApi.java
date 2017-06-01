package io.tads.dsd.rest.java.server;

import io.tads.dsd.rest.java.model.Resultado;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/calculadora")

@Api(description = "the calculadora API")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-06-01T02:04:33.870-03:00")


public class CalculadoraApi  {

    @GET
    @Path("/somar")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "", response = Resultado.class, tags={ "Calculadora" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "", response = Resultado.class) })
    public Response somar(@QueryParam("parcela1") @NotNull  Double parcela1,@QueryParam("parcela2") @NotNull  Double parcela2) {
        Resultado resultado = new Resultado();
        resultado.setValor(parcela1 + parcela2);
    	return Response.ok().entity(resultado).build();
    }
}

