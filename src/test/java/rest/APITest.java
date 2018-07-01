package rest;

import domain.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class APITest {


    @BeforeMethod
    public void setUp(){
        baseURI = "http://localhost";
        port = 4567;
        basePath = "/api/v1/";

        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void inserirPessoa(){
        given()
                .contentType(ContentType.JSON)
                .body(new Person("Guilherme", "Rio do Oeste", "Jogar futebol")).
            when()
                .post("person").
            then().
                body("name", equalTo("Guilherme")).and().
                body("address", equalTo("Rio do Oeste")).and().
                body("hobbies", equalTo("Jogar futebol")).and().
                statusCode(201);
    }

    @Test
    public void getPersonById(){
        when().
                get("person/{id}", "101").
            then().
                contentType("application/json").and().
                body("name", equalTo("Guilherme")).and().
                body("address", equalTo("Rio do Oeste")).and().
                body("hobbies", equalTo("Jogar futebol")).and().
                statusCode(200);
    }

    @Test
    public void removerPessoa(){
        int id =
                given()
                        .contentType(ContentType.JSON)
                        .body(new Person("Guilherme", "Rio do Oeste", "Jogar futebol")).
                    when().
                        post("person").
                        then().
                            extract().
                                path("id");
        when().
                delete("person/{id}", id).
            then().
                body("statusMessage", equalTo("success")).and().
                body("message", equalTo("Person removed!")).and().
                statusCode(202);

    }

//    @Test
//    public void alterarPessoa(){
//        int id =
//                given()
//                        .contentType(ContentType.JSON)
//                        .body(new Person("Guilherme", "Rio do Oeste", "Jogar futebol")).
//                    when().
//                        post("person").
//                        then().
//                            extract().
//                                path("id");
//        given()
//                .contentType(ContentType.JSON)
//                .body(new Person("Guilherme Alterado", "Rio do Sul", "Jogar futebol")).
//            when().
//                put("person/{id}", id).
//            then().
//                body("")
//    }
}
