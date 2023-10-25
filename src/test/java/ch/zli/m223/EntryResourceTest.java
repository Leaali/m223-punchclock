package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Entry;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

@QuarkusTest
public class EntryResourceTest {

    @Test
    public void testIndexEndpoint() {
        given()
                .when().get("/entries")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    public void testUpdateEndpoint() {
        Entry newEntry = new Entry();
        newEntry.setCheckIn(LocalDateTime.now());
        newEntry.setCheckOut(LocalDateTime.now().plusHours(1));

        Entry createdEntry = given()
                .contentType(ContentType.JSON)
                .body(newEntry)
                .when().post("/entries")
                .then()
                .statusCode(200)
                .extract().as(Entry.class);

        createdEntry.setCheckOut(LocalDateTime.now().plusHours(2));

        given()
                .contentType(ContentType.JSON)
                .body(createdEntry)
                .when().put("/entries/" + createdEntry.getId())
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteEndpoint() {
        Entry newEntry = new Entry();
        newEntry.setCheckIn(LocalDateTime.now());
        newEntry.setCheckOut(LocalDateTime.now().plusHours(1));

        Entry createdEntry = given()
                .contentType(ContentType.JSON)
                .body(newEntry)
                .when().post("/entries")
                .then()
                .statusCode(200)
                .extract().as(Entry.class);

        given()
                .when().delete("/entries/" + createdEntry.getId())
                .then()
                .statusCode(204);

        // // Falls es einen Endpunkt gäbe, wo man GET entries/id machen könnte, würde man testen können ob er wirklich nicht mehr vorhanden ist.
        // given()
        //         .when().get("/entries/" + createdEntry.getId())
        //         .then()
        //         .statusCode(404);
    }
}