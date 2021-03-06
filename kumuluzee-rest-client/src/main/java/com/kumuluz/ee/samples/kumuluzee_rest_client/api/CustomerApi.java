/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.kumuluz.ee.samples.kumuluzee_rest_client.api;

import com.kumuluz.ee.rest.client.mp.integrations.KeeRestParameters;
import com.kumuluz.ee.samples.kumuluzee_rest_client.entities.Customer;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Urban Malc
 * @since 3.1.0
 */
@Path("/customers")
@RegisterRestClient
@RegisterProvider(SensitiveDataResponseMapper.class)
@RegisterClientHeaders
@Dependent
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CustomerApi {

    @GET
    List<Customer> getAllCustomers(@BeanParam KeeRestParameters restParameters);

    @GET
    @Path("{customerId}")
    Customer getCustomer(@PathParam("customerId") String id);

    @POST
    void createCustomer(Customer customer);

    @POST
    CompletionStage<Void> createCustomerAsynch(Customer customer);

    @DELETE
    @Path("{customerId}")
    void deleteCustomer(@PathParam("customerId") String id);
}
