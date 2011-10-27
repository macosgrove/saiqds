package models;
import java.util.UUID;

import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertNotNull(response.contentType);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    @Test
    public void testThatProfilePageWorks() {
        Response response = GET("/region34/profile/"+UUID.randomUUID().toString());
        assertStatus(302,response);
     }
    
}