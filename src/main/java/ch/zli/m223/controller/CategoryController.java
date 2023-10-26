package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Category;
import ch.zli.m223.service.CategoryService;

@Path("/categories")
@Tag(name = "Categories", description = "Handling of categories")
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Categories.", description = "Returns a list of all categories.")
    public List<Category> index() {
        return categoryService.findAll();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an category", description = "Updates an category with the specified ID and returns the updated category.")
    public Category update(@PathParam("id") Long id, Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete an category", description = "Deletes an category with the specified ID.")
    public Response delete(@PathParam("id") Long id) {
        categoryService.deleteCategory(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new category.", description = "Creates a new category and returns the newly added category.")
    public Category create(Category category) {
        return categoryService.createCategory(category);
    }

}
