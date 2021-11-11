package com.daudo.storeo.shop.adapter.web;

import com.daudo.storeo.lib.web.response.ListData;
import com.daudo.storeo.lib.web.response.SuccessResponse;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.domain.shop.domains.ShopDetail;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Tag(name = "Shop")
@Path("/shop")
@Produces(MediaType.APPLICATION_JSON)
public interface ShopResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<SuccessResponse<Shop>> createShop(Shop shop);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/detail")
    Uni<SuccessResponse<Shop>> updateShopDetail(@PathParam("id") String id, ShopDetail shop);

    @DELETE
    @Path("{id}")
    Uni<SuccessResponse<String>> deleteShop(@PathParam("id") String id);

    @GET
    @Path("{id}")
    Uni<SuccessResponse<Shop>> getShop(@PathParam("id") String id);

    @GET
    @Path("list")
    Uni<SuccessResponse<ListData<Shop>>> getShopList(@QueryParam("page") int page, @QueryParam("size") int size);
}
